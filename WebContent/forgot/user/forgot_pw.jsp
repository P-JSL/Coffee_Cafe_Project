<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String p = request.getContextPath();
%>
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
<script src="<%=p%>/js/com.js"></script>
<section class="section bg-light bottom-slant-gray">

	<div class="container">
		<form action="#" method="post" name="log" class="log">
			<input type="hidden" value="1" name="user">
			<div class="col-lg-6" style="margin: 0 auto;">
				<div class="container">
					<h2>Password Search Page</h2>
					<p>登録したメールを書いてください。</p>
					<p>NAVER / GMAIL しかできません。</p>
					<div class="row ">
						<div class="col-md-6 form-group">
							<label for="userid">ID</label> <input type="text" id="userid"
								class="form-control" name="userid">
						</div>
						<div class="col-md-6 form-group">
							<label for="email">メール</label> <input type="email" id="email"
								class="form-control" name="email">
						</div>
					</div>

					<div class="col-md-6 form-group">
						<div class="row">
							<input type="submit" value="探す" class="btn btn-primary"
								id="search">
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</section>
<script type="text/javascript">
	$("#search").on(
			"click",
			function(e) {
				e.preventDefault();
				var id = log.userid.value; // 확인용 
				var email = log.email.value; // 확인용
				var URL = "../../forgot?command=pw_search&id=" + id + "&email="
						+ email; // pw_check.jsp로 이동할  servlet command

				$.ajax({
					url : "../../ajax?command=pw_send",
					type : "post",
					data : {
						id : id,
						email : email
					},
					datatype : "json",
					success : function(response) {
						console.log("성공");
						if (response.msg == 'conf') {
							alert("メールに認証番号が送りました。");
							window.open(URL, "id_auth_email",
									"width=200px,heigth=150px");
						}
					},
					error : function(request, status, error) {
						error();
					}
				})

			})
</script>
<%@include file="../../footer.jsp"%>