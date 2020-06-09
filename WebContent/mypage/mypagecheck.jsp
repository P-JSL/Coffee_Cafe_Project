<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	href="../fonts/fontawesome/css/font-awesome.min.css">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/animate.css">
</head>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	background-image: url("../img/homes.jpg");
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
			<small><b>安全のため暗証番号を入力お願いいたします。</b></small>
			<form action="../user?command=mypage" method="post" name="mypage"
				onsubmit="return confirming();">
				<input type="password" placeholder="Check Your PassWord"
					name="userpw" class="btn-control"> <input type="submit"
					value="確認" class="btn btn-outline-info">
			</form>
		</div>
	</div>
	<script type="text/javascript">
	function confirming() {
		var id = '${sessionScope.id}';
		var inpw = mypage.userpw.value;
		console.log(id);
		$.ajax({
			url:"../ajax?command=MypagePassConfirm",
			type:"post",
			data:{
				userid : id,
				userpw : inpw
			},
			success:function(response){
				if(response.ok ==1){
					alert("성공");
					return true;
				}else{
					alert("실패");
					history.go(-1);
					return false;
				}
			},
			error:function(request,status,error){
				alert("에러");
			}
		})
	}
	</script>
</body>
</html>