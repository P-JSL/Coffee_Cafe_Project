<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${sessionScope.user  == 0 }">
		<c:import url="../../../header_0.jsp"></c:import>
	</c:when>
	<c:when test="${sessionScope.user == 1 }">
		<c:import url="../../../header.jsp"></c:import>
	</c:when>
	<c:when test="${sessionScope.user==2 }">
		<c:import url="../../../header_2.jsp"></c:import>
	</c:when>
</c:choose>
<style>
a {
	color: #fff !important;
}

a:nth-child(2), a:nth-child(3) {
	margin-left: 10px !important;
}
</style>
<section class="section pt-4 bg-light">
	<div class="container">
		<div class="row">
			<div class="col-lg-8 blog-content"
				style="margin: 0 auto; text-align: center;">
				<h3 style="border-bottom: 1px solid #555;" class="mb-4">${hvo.title }</h3>
				<p class="lead">${hvo.content }</p>
			</div>
		</div>
	</div>
	<div class="container" style="margin: 0 auto; position: relative;">
		<div class="btn-group"
			style="position: absolute; left: 50%; transform: translateX(-50%);">
			<c:if test="${sessionScope.id !=null and sessionScope.user == 2 }">
			<a class="btn btn-danger"
				href="hmc?command=HmcDelete&num=${hvo.num }" onclick="return confirm('消しますか？')">삭제</a> <a
				class="btn btn-info" href="hmc?command=HmcModify&num=${hvo.num }">수정</a>
			</c:if>
			<a class="btn btn-warning" href="header?command=HMC">돌아가기</a>
		</div>
	</div>
</section>


<%@include file="../../../footer.jsp"%>
</body>
</html>