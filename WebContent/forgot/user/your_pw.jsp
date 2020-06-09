<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String p = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>이메일 인증을 위한 창</title>
<link href="<%=p%>/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=p%>/css/email.css">

</head>
<body>
	<div class="container">
		<div class="col-md-6  form-group m0"
			style="text-align: center; margin: 100px auto;">
			<h4 style="padding-bottom: 30px;">変更する暗証番号を記入してください。</h4>
			<b style="font-size: 1.5rem;">パスワード</b> <input type="password" id="pw"
				class="form-control"><br /> <b style="font-size: 1.5rem;">パスワード確認</b><input
				type="password" id="pw2" class="form-control"><br /> <input
				type="submit" name="update" value="変更"
				class="btn btn-info form-control" id="update">
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="<%=p%>/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$("#update").on("click", function() {
			var pw = $("#pw").val();
			var pw2 = $("#pw2").val();
			var id = "<%=request.getAttribute("id")%>";
			var email = "<%=request.getAttribute("email")%>";
			console.log(pw);
			if (pw != pw2) {
				alert("暗証番号を正しくお書きください。");
				return false;
			} else if (pw == pw2) {
				$.ajax({
					url:"ajax?command=pw_update", //바꿀 서블릿 커멘드
					type:"post",
					data:{
						pw:pw,
						id:id,
						email:email
					},
					datatype:"json",
					success:function(response){
						if(response.update == 1){
							alert("暗証番号が変更されました。");
							window.opener.location.href="user?command=loginmove";
							self.close();
						}
						
					},
					error:function(request,status,error){
						alert("エーラー")
					}
				});
			}
		})
	</script>
</body>
</html>