<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:choose>
	<c:when test="${sessionScope.user  == 0 }">
		<c:import url="../header_0.jsp"></c:import>
	</c:when>
	<c:when test="${sessionScope.user == 1 }">
		<c:import url="../header.jsp"></c:import>
	</c:when>
	<c:when test="${sessionScope.user==2 }">
		<c:import url="../header_2.jsp"></c:import>
	</c:when>
</c:choose>
<%
	String p = request.getContextPath();
%>
<style>
section {
	background-image: url('img/newss.jpg');
	background-repeat: no-repeat;
	background-size: cover cover;
	background-attachment: fixed;
	background-clip: border-box;
	background-origin: border-box;
}
</style>
<link rel="stylesheet" href="<%=p%>/css/table.css">
<section class="section bg-light pt-0 bottom-slant-gray">
	<h3 style="font-size: 2rem; padding: 1rem; text-align: center;">News
		section</h3>
	<div class="container padtop-10">
		<div class="row">
			<c:forEach var="list" items="${list }">
				<div class="col-md-6" data-aos="fade-up" data-aos-delay="100"
					id="divs">
					<div class="blog d-block">
						<a class="bg-image d-block" href="<%=p%>/newsAction/newsview.jsp"
							style="background-image: url('news_upload/${list.photo}');"
							id="photo"></a>
						<div class="text" style="overflow: hidden;">
							<h3>
								<a href="news?command=newsview&num=${list.num }" id="title">${fn:substring(list.title,0,15) }...</a>
							</h3>
							<p class="sched-time">
								<span id="calender"><span class="fa fa-calendar"></span>
									${list.news_date }</span> <br>
							</p>
							<div id="content">
								<p>${list.content }</p>
							</div>
							<p>
								<a href="news?command=newsview&num=${list.num }"
									class="btn btn-primary btn-sm">もっと読む</a>
							</p>
						</div>
					</div>
				</div>
			</c:forEach>

		</div>

		<div class="row mt-5" data-aos="fade-up">
			<div class="col-12 text-center">
				<form action="header?command=News" name="paging" method="post">
					<input style="padding: 10px !important; background: #9980FA;"
						type="button" value="もっと見る" class="p-3 btn btn-info" id="more"><input
						style="padding: 10px !important; margin-left: 20px; background: #9980FA;"
						type="button" value="減らす" class="p-3 btn btn-info" id="nomore"><input
						type="hidden" value="${nowpage }" name="page" id="page">
				</form>
			</div>

			<c:if test="${sessionScope.user ==2}">
				<a href="news?command=newswrite"
					class="bg-image d-block  btn btn-primary btn-sm">ニュース作成</a>
				<!-- 로그인 한 userid의 session으로 변경 할 것 -->
			</c:if>

		</div>
	</div>
</section>
<script type="text/javascript">
	$("#content").next().css({
		"display" : "-webkit-box",
		"text-overflow" : "ellipsis;",
		"white-space" : "nowrap",
		"width" : "390px",
		"overflow" : "hidden",
		"-webkit-line-clamp" : "3",
		"-webkit-box-orient" : "vertical ",
		"word-wrap" : "break-word",
		"line-height" : "1.2em",
		"heigth" : "3.6em"

	});
</script>
<script type="text/javascript">
	var page = $("#page").val();
	$("#more").on("click", function() {
		var totpage = ${totalpage};
		page++;
		if (page > totpage) {
			page = totpage;
		}
		$("#page").val(page);

		paging.submit();

	})
</script>
<script type="text/javascript">
	var page = $("#page").val();
	$("#nomore").on("click", function() {
		page--;
		if (page == 0) {
			page = 1;
		}
		$("#page").val(page);

		paging.submit();
	})
</script>
<%@include file="../footer.jsp"%>

