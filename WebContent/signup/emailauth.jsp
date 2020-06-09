<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>이메일 인증을 위한 창</title>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/email.css">

</head>
<body>
	<div class="container">
		<div class="col-md-6  form-group m0"
			style="text-align: center; margin: 100px auto;">
			<h2>認証番号をお書きください。</h2>
			<input type="text" name="auth" placeholder="認証番号を書いてください。" id="auth"
				class="form-control"> <input type="button"
				class="btn btn-info form-control" value="確認" id="btn">
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>

	<script type="text/javascript">
		$("#btn").on(
				"click",
				function() {
					$.ajax({
						url : "../header?command=authOk&auth="
								+ $("#auth").val(),
						type : "post",
						dataType : "Json",
						data : {
							auth : $("#auth").val()
						},
						success : function(data) {
							console.log(data);
							console.log(data.OK);
							if (data.OK == 1) {
								alert("メールが確認されました。");
								opener.sign.mail_confirm.value = "1";
								var E = opener.sign.email;
								$(E).attr("readonly", "readonly");
								var aok = opener.sign.authOk;
								$(aok).remove();
								var txt = opener.sign.text;
								$(txt).css({
									"visibility" : "visible"
								});
								self.close();
							}
						},
						error : function(request, status, error) {
							console.log("요청 : " + request + " 상태 :" + status
									+ " 에러:" + error);
							alert("認証番号の入力が間違えました。　正しく入力してください。");

						}
					});
				})
	</script>
</body>
</html>