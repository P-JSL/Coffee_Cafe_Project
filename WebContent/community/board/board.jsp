<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String p = request.getContextPath();
%>
<c:choose>
	<c:when test="${sessionScope.user == 1 }">
		<c:import url="../../header.jsp"></c:import>
	</c:when>
	<c:when test="${sessionScope.user==2 }">
		<c:import url="../../header_2.jsp"></c:import>
	</c:when>
</c:choose>
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.1/build/pure-min.css"
	integrity="sha384-oAOxQR6DkCoMliIh8yFnu25d7Eq/PHS21PClpwjOTeU2jRSq11vu66rf90/cZr47"
	crossorigin="anonymous">
<link rel="stylesheet" href="<%=p%>/css/table.css">
<section
	class="section  pt-5 top-slant-white2 relative-higher bottom-slant-gray">
	<div class="container">
		<section class="form-group"
			style="text-align: right; margin-bottom: 30px;">
			<h3>掲示板</h3>
			<form action="header?command=Board" method="post" name="bs">
				<!-- 검색 -->
				<select name="sel">
					<option value="b_title">제목</option>
					<option value="b_content">내용</option>
					<option value="b_id">작성자</option>
				</select> <input type="search" name="search" class="search"> <a
					href="javascript:void(0);"><i class="fa fa-search fa-lg"
					id="searching"></i></a>
			</form>
		</section>
		<form action="" method="post" name="com">
			<table class="table">
				<thead>
					<tr>
						<th>番号</th>
						<th>タイトル</th>
						<th>内容</th>
						<th>作成者</th>
						<th>作成日時</th>
						<th>ヒット数</th>
					</tr>
				</thead>
				<tbody>
					<c:set var="bno" value="${count-(nowpage-1)*5 }"></c:set>
					<c:forEach var="i" items="${list}">
						<tr id="boarder">
							<td>${bno }</td>

							<c:choose>
								<c:when test="${i.onoff eq 'on' }">
									<td style="position: relative;"><i class="fa fa-lock"
										style="margin-right: 10px; font-size: 20px;"></i><a
										href="<%=p %>/board?command=boardView&num=${i.num }&onoff=${i.onoff}"
										class="${i.num }" id="b">${fn:substring(i.b_title,0,10) }</a></td>
								</c:when>
								<c:otherwise>
									<td><a
										href="<%=p %>/board?command=boardView&num=${i.num }"
										class="${i.num }" id="b">${fn:substring(i.b_title,0,10) }</a></td>
								</c:otherwise>
							</c:choose>

							<td id="is">${i.b_content}</td>
							<td>${i.b_id }</td>
							<td><fmt:formatDate value="${i.b_date }"
									pattern="yyyy-MM-dd" /></td>
							<td id="count">${i.b_count }</td>
						</tr>
						<c:set var="bno" value="${bno-1 }"></c:set>
					</c:forEach>
				</tbody>
			</table>
		</form>
		<c:if test="${sessionScope.user >= 1 }">

			<div class="button-8">
				<div class="eff-8"></div>
				<a href="board?command=boardWrite" id="btns"> 書く </a>
			</div>
		</c:if>
		<!-- Start Pagination -->
		<ul class="pagination">${pages }
		</ul>
		<!-- <li><a href="#0">&lt;</a></li>
			<li><a href="#0">1</a></li>
			<li><a href="#0">2</a></li>
			<li><a href="#0">3</a></li>
			<li><a href="#0">4</a></li>
			<li><a href="#0">5</a></li>
			<li><a href="#0">&gt;</a></li> -->
		<!-- End Pagination -->
	</div>
</section>
<script type="text/javascript">
	var id = '${sessionScope.id}';
	$("#btns").on("click", function() {
		if (id == null || id == "") {
			$("#btns").attr("href", "javascript:void(0);")
			alert("ログインしてください。");
			location.href = "user?command=loginmove";
		} else {
			return true;
		}
	})
</script>
<script type="text/javascript">
	$(window).on("load", function() {
		var img = $("#is").find('img');
		var p = $("#is").find('p');
		img.css({
			"max-height" : "55px",
			"width" : "75px"
		});
		p.css({
			"text-align" : "inherit"
		});
	})
</script>
<script type="text/javascript">
	$("#searching").on("click", function() {
		bs.submit();
	})
</script>
<script type="text/javascript">
	$(".table tr td > #b").on("click", function() {
		var num = $(this).attr("class");
		$.ajax({
			url : "ajax",
			type : "post",
			data:{
				command : "count",
				num : num
			},
			success : function(response) {
				if (response.hit == 1) {
					console.log("성공");
					
				} else {
					console.log("DB에러");
				}
			},
			error : function(request, status, error) {
				console.log("에러");
			}
		})
	});
</script>
<%@include file="../../footer.jsp"%>