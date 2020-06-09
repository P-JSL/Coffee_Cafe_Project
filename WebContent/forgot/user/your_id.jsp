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
			<p>貴方様のIDは${yourid }でございます。</p>
			<input type="button" value="閉める" onclick="return closing();">
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="<%=p%>/js/bootstrap.min.js"></script>
<script type="text/javascript">
function closing() {
	window.opener.location.href="user?command=loginmove";
	self.close();
}
</script>
</body>
</html>