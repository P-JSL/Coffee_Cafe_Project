<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String p = request.getContextPath();
%>
<c:choose>
	<c:when test="${sessionScope.user  == 0 }">
		<c:import url="../../header_0.jsp"></c:import>
	</c:when>
	<c:when test="${sessionScope.user == 1 }">
		<c:import url="../../header.jsp"></c:import>
	</c:when>
</c:choose>
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.1/build/pure-min.css"
	integrity="sha384-oAOxQR6DkCoMliIh8yFnu25d7Eq/PHS21PClpwjOTeU2jRSq11vu66rf90/cZr47"
	crossorigin="anonymous">
<link rel="stylesheet" href="<%=p%>/css/table.css">
<style>
.table tbody tr:nth-child(2)>td:nth-child(3)>p:nth-child(1) {
	margin-right: 20px;
	display: inline-block;
}

.table tbody tr:nth-child(2)>td:nth-child(3)>p:nth-child(2) {
	display: inline-block;
}

.table tbody tr:nth-child(2)>td:nth-child(3)>p:nth-child(2)>img {
	max-height: 130px;
	max-width: 170px;
}
</style>
<section
	class="section  pt-5 top-slant-white2 relative-higher bottom-slant-gray">
	<div class="container">
		<section class="form-group"
			style="text-align: right; margin-bottom: 30px;">
			<h3>お知らせ</h3>
			<form action="header?command=Notice" method="post" name="S">
				<!-- 검색 -->
				<select name="sel">
					<option value="n_title">제목</option>
					<option value="n_content">내용</option>
					<option value="userid">작성자</option>
				</select> <input type="search" name="search"
					class="search well well-lg col-xs-2"> <i
					class="fa fa-search fa-lg" id="glass"></i>
			</form>
		</section>
		<p>${count }件</p>
		<form action="" method="post" name="com">
			<table class="table">
				<tr>
					<th>番号</th>
					<th>タイトル</th>
					<th>内容</th>
					<th>作成者</th>
					<th>作成日時</th>
					<th>ヒット数</th>
				</tr>
				<c:set var="no" value="${count - (nowpage-1)*5 }"></c:set>
				<c:forEach var="n" items="${list }">
					<tr>
						<td>${no }</td>
						<td><a href="<%=p %>/notice?command=noticeView&num=${n.num}">${n.n_title }</a></td>
						<td>${n.n_content }</td>
						<td>${n.userid }</td>
						<td><fmt:formatDate value="${n.n_date }" pattern="yyyy-MM-dd HH:MM" /></td>
						<td>${n.n_count }</td>
					</tr>
					<c:set var="no" value="${no-1 }"></c:set>
				</c:forEach>
				<!-- Heading -->
			</table>
		</form>
		<!-- Start Pagination -->
		<ul class="pagination">${pages }
		</ul>
		<!-- End Pagination -->
	</div>
</section><script type="text/javascript">
	$("#glass").css({
		"color" : "blue",
		"cursor":"pointer"
	});
	$("#glass").on("click", function() {
		S.submit();
	})
</script>
<script type="text/javascript">
	$(".table tr td:nth-child(2) > a").on("click", function() {
		var h = $(this).attr("href");
		var num = h.substring(h.indexOf("&") + 5);
		console.log(num);
		$.ajax({
			url:"ajax?command=Notice_hit",
			type:"post",
			data:{
				num : num
			},
		dataType:"json"
		}).done(function(data){
			if(data.o == 1){
				console.log("hit +1");
			}else{
				console.log("error")
			}
		}).fail(function(request){
			error();
		})
	})
</script>
<%@include file="../../footer.jsp"%>