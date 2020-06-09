<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<script src="<%=p%>/js/validity.js"></script>
<section class="section bg-light bottom-slant-gray">

	<div class="container">
		<form action="../user?command=signup" method="post" name="sign"
			id="sign">
			<input type="hidden" name="oking" id="os">
			<div class="row">
				<div class="col-lg-6" style="margin: 0 auto;">
					<h2>アカウント登録</h2>
					<div class="row">
						<div class="col-md-6 form-group">
							<label for="userid" style="width: 100%; position: relative;">ID
								<input type="button" id="idcheck" class="btn btn-dark"
								value="重複チェック"
								style="text-align: right; border-color: transparent; position: absolute; right: 0;">
							</label> <input type="text" id="userid" class="form-control"
								name="userid">

						</div>
						<div class="col-md-6 form-group">
							<label for="name">お名前</label> <input type="text" id="name"
								class="form-control" name="name">
						</div>
					</div>
					<div class="row">
						<div class="col-md-6 form-group">
							<label for="password">暗証番号</label> <input type="password"
								id="userpw" class="form-control" name="userpw">
						</div>
						<div class="col-md-6 form-group">
							<label for="password-confirm">暗証番号確認</label> <input
								type="password" id="password-confirm" class="form-control"
								name="userpwf">
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<label for="gender">性別</label>&nbsp;&nbsp;&nbsp;<select
								name="gender" class="form-control">
								<option value="1">男性</option>
								<option value="2">女性</option>
							</select>
						</div>
						<div class="col-md-6 form-group">
							<label for="email">メール認証</label> <input type="email" id="email"
								name="email" class="form-control"> <input type="button"
								name="authOk" id="authbutton" value="認証" class="btn btn-outline-success"
								style="margin-top: 10px;"> <input type="hidden"
								name="mail_confirm"> <input type="text" name="text"
								style="visibility: hidden; border: none; background: #f8f9fa;"
								value="確認しました。" readonly>
						</div>
					</div>
					<div class="col-md-6 form-group">
						<div class="row">
							<input type="submit" value="登録" class="btn btn-outline-secondary"
								onclick="return SignUpVaild();">
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</section>
<script type="text/javascript">
	$("#idcheck")
			.on(
					"click",
					function() {
						var id = sign.userid.value;
						var point = $("#idcheck").parent();
						console.log(point);
						var p = point.next();
						console.log(p);
						var intx = p.innerText = "<span style='color:green;'> 重複IDがありません</span>";
						console.log(intx);
						var form = document.getElementById('sign');
						$
								.ajax({
									url : "../ajax?command=idcheck",
									type : "post",
									data : {
										id : id
									},
									datatype : "json",
									success : function(response) {
										if (response.ok == 1) {

											sign.userid.value = '';
											alert("重複するIDがございます。");
										} else {
											point.innerText = "<span style='color:green;'> 重複IDがありません</span>";
											$(point).next().attr({
												"readonly" : "readonly"
											});
											sign.oking.value = "1";
											$(point).children().remove();

											alert("重複するIDがございません。");

										}
									},
									error : function(request, status, error) {

									}
								})
					})
</script>
<script type="text/javascript">
	$("#authbutton").on(
			"click",
			function() {

				var m = sign.email.value.substring(
						sign.email.value.indexOf("@") + 1).toLowerCase();

				if (Object.is("gmail.com", m) || Object.is("naver.com", m)) {

					$.ajax({
						url : "../header?command=authMove",
						type : "post",
						data : {
							email : $("#email").val()
						},
						datatype : "json",
						success : function(data) {
							alert("メールに認証番号を送りましたのでご確認お願い致します。")
							window.open("emailauth.jsp", "emailAuth",
									"width=300,heigth=150");
						},
						error : function(request, status, error) {
							console.log(request + "-" + status + "," + error);
						}
					});

				} else {
					alert("에러");
				}
			})
</script>

<%@include file="../footer.jsp"%>