<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${sessionScope.user == 0 }">
		<c:import url="../../header_0.jsp"></c:import>
	</c:when>
	<c:when test="${sessionScope.user == 1 }">
		<c:import url="../../header.jsp"></c:import>
	</c:when>
</c:choose>
<%
	String p = request.getContextPath();
%><script src="<%=p%>/js/validity.js"></script>
<style type="text/css">
.backgrounds {
background-image: url("<%=p%>/img/hpc.jpg");
}
.backgrounds{
background-attachment: fixed;
background-clip: border-box;
background-position: center;
background-repeat: no-repeat;
background-size: cover;	
}

h2 {
	color: #fff;
}
</style>
<section class="section bg-light bottom-slant-gray backgrounds">

	<div class="container">
		<form action="<%=p%>/user?command=userlogin" method="post" name="log"
			class="log" onsubmit="return login_check();">
			<input type="hidden" value="1" name="user">
			<div class="col-lg-6"
				style="margin: 0 auto; color: #fff; font-weight: bold;">
				<div class="container">
					<h2>ユーザーログインページ</h2>
					<div class="row ">
						<div class="col-md-6 form-group ">
							<label for="userid">ユーザーID</label> <input type="text" id="userid"
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

						<!--
							<div class="col-md-6 form-group">
							<label for="admin"
								style="display: flex; text-align: center; border-bottom: 1px solid #ced4da;">admin</label>
							<div class="form-group">
								<div class="form-group"
									style="display: inline-block; text-align: center;">
									<input type="radio" id="admin" class="form-control" value="1"
										style="width: 85px; height: 20px; display: flex;" name="admin">管理者
								</div>
								<div class="form-group"
									style="display: inline-block; text-align: center;">
									<input type="radio" id="admin" class="form-control" value="0"
										style="width: 85px; height: 20px; display: flex;" name="admin">
									一般の方
								</div>
							</div>
							 </div> -->


					</div>
					<div class="alert   alert-light" role="alert">
						<b><a href="<%=p%>/forgot?command=forgotid" id="forgot-id">IDが覚えられませんか？</a></b>
						<br /> <b><a href="<%=p%>/forgot?command=forgotpw"
							id="forgot-pw">パスワードが覚えられませんか？</a></b>
					</div>



					<div class="col-md-6 form-group">
						<div class="row">
							<input type="submit" value="ログイン" class="btn btn-success"
								id="logon">
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</section>
<%@include file="../../footer.jsp"%>