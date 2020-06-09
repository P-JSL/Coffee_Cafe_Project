<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
	<c:when test="${sessionScope.user  == 0 }">
		<c:import url=".././header_0.jsp"></c:import>
	</c:when>
	<c:when test="${sessionScope.user == 1 }">
		<c:import url="../../header.jsp"></c:import>
	</c:when>
	<c:when test="${sessionScope.user==2 }">
		<c:import url="../../header_2.jsp"></c:import>
	</c:when>
</c:choose>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="../js/com.js"></script>
<section class="section bg-light bottom-slant-gray">

	<div class="container">
		<form action="#" method="post" name="log" class="log">
			<input type="hidden" value="1" name="user">
			<div class="col-lg-6" style="margin: 0 auto;">
				<div class="container">
					<h2>ID Search Page</h2>
					<p>登録したメールを書いてください。</p>
					<div class="row ">
						<div class="col-md-6 form-group">
							<label for="email">メール</label> <input type="email" id="email"
								class="form-control">
						</div>
					</div>

					<div class="col-md-6 form-group">
						<div class="row">
							<input type="submit" value="探す" class="btn btn-primary">
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</section>
<%@include file="../../footer.jsp"%>