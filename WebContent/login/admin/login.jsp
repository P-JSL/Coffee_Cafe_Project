<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../header_2.jsp"%>
<%
	String p = request.getContextPath();
%>
<script src="<%=p%>/js/validity.js"></script>
<style type="text/css">
.backgrounds {
background-image: url("img/hpc.jpg");
background-attachment: fixed;
background-clip: border-box;
background-position: center;
background-repeat: no-repeat;
background-size: cover;	
}
</style>
<section class="section bg-light bottom-slant-gray backgrounds">

	<div class="container">
		<form action="admin?command=login" method="post" name="log"
			class="log" onsubmit="return login_check();">
			<input type="hidden" value="2" name="admin">
			<div class="col-lg-6"
				style="margin: 0 auto; color: #fff; font-weight: bolder; font-size: medium;">
				<div class="container">
					<h2 style="color: #fff;">管理者ログインページ</h2>
					<div class="row ">
						<div class="col-md-6 form-group ">
							<label for="userid">ID</label> <input type="text" id="userid"
								class="form-control " name="userid">
						</div>
						<div class="col-md-6 form-group">
							<label for="password">暗証番号</label> <input type="password"
								id="password" class="form-control" name="userpw">
						</div>
						<div class="col-md-6 form-group">
							<label for="email">メール</label> <input type="email" id="email"
								class="form-control" name="useremail">
						</div>
					</div>
					<div class="alert  alert-light" role="alert">
						<b><a href="<%=p%>/forgot?command=forgotid" id="forgot-id">IDが覚えられませんか？</a></b>
						<br /> <b><a href="<%=p%>/forgot?command=forgotpw"
							id="forgot-pw">パスワードが覚えられませんか？</a></b>
					</div>
					<div class="col-md-6 form-group">
						<div class="row">
							<input type="submit" value="ログインする"
								class="btn btn-success">
						</div>
					</div>
				</div>
			</div>
		</form>


	</div>

</section>

<%@include file="../../footer.jsp"%>