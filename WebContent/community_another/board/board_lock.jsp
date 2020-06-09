<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%String p = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700,800"
	rel="stylesheet">
<link rel="stylesheet"
	href="<%=p %>/fonts/fontawesome/css/font-awesome.min.css">
<link rel="stylesheet" href="<%=p %>/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=p %>/css/animate.css">
</head>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	background-image: url("<%=p %>/img/jallyfish.jpg");
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
	background-clip: content-box;
	background-attachment: fixed;
}

h3 {
	text-align: center;
}

.p0 {
	margin: 0 auto;
	padding: 10px;
	text-align: center;
	border: 5px double #666;
	width: 350px;
	background: rgba(255, 255, 255, 0.5);
	filter: alpha(opacity = 50);
}

.container.auto {
	position: fixed;
	left: 50%;
	top: 50%;
	transform: translate(-50%, -50%);
}
</style>
<body>
	<div class="container auto">
		<div class="p0">
			<h5>
				<i class="fa fa-lock fa-3x"></i><br />PASSWORD

			</h5>
			<form action="board" method="post" name="mypage"
				onsubmit="return confirming();">
				<input type="hidden" name="command" value="board_unlock_view">
				<input type="hidden" name="num" value="<%=request.getParameter("num")%>">
				<input type="password" placeholder="PassWord"
					name="b_pw" class="btn-control"> <input type="submit"
					value="確認" class="btn btn-info">
			</form>
		</div>
	</div>
</body>
</html>