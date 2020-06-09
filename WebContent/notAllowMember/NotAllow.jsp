<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String p = request.getContextPath();
%>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/table.css">
<link rel="stylesheet" href="css/index.css">
</head>
<style>
body {
	background-image: url("img/cofbac.jpg");
	background-repeat: no-repeat;
	background-size: 100% 100%;
	background-color: inherit;
}
</style>
<div class="container pd0 back_op7">
	<form action="index" method="post" name="user"
		onsubmit="return check();">
		<input type="hidden" value="indexAuth" name="command">
		<div class="container center2 shadow">
			<h2>
				非会員　LOGIN PAGE
			</h2>
			<p style="text-align: center";>メールは GMAILとNAVERしかできません。<br/>
			メール認証をすれば会員登録の時、追加の認証はございません。</p>
			<table class="table" style="width: 50%;">
				<tr>
					<td><label for="name">お名前</label> <input type="text" id="name"
						class="form-control " name="name"></td>
				<tr>
					<td><label for="email">メール</label> <input type="email"
						id="email" class="form-control" name="email"></td>
				</tr>
				<tr>
					<td>
						<div class="input-group" style="justify-content: center;">
							<select name="user">
								<option value="0">非会員</option>
							</select>
							<div class="input-group-append">
								<input type="submit" value="確認" class="btn btn-outline-success">
								<a type="button" href="index?command=index"
									class="btn btn-outline-danger">戻り</a>
							</div>
						</div>




					</td>

				</tr>
			</table>
		</div>
	</form>
</div>
<script type="text/javascript">
	function check() {
		if (!user.name.value) {
			alert("お名前の記入は必須でございます。");
			return false;
		}
		if (!user.email.value) {
			alert("Eメールをご記入ください。")
			return false;
		}
		return true
	}
</script>
<!-- 처음 시작시 메인화면
	
	비회원 / 회원 / 관리자 인지 선택하기
	
	여기에서 선택에 따라 
	
	각각 로그인창 혹은 비회원 선택인 경우 View 밖에 하는 권한이 없는 홈페이지만 가능하다.
	(비 회원 시, 인증번호 확인 절차에 들어감)
	
	회원인 경우, 일반 게시판 및 마이페이지 이외는 볼 수 없는 홈페이지.
	관리자(매니저/관리자) 인 경우, 모든 권한을 다 가지는 홈페이지이다.
	(매니저는 일반 회원에서 신청하여 매니저로 올라갈 수 있다.)
	
	비회원 DB TABLE : N_User  >>  가지는 레코드  : 이름, 이메일, 접속 회수, 댓글
	회원   DB TABLE : Y_User  >>  가지는 레코드  : 1) 이름, 아이디, 접속 회수, 가입 일자, 등 // 2) U_comment :
	관리자 DB TABLE : __Admin >>  가지는 레코드  : 1)  // 2) A_comment / 3)

 -->