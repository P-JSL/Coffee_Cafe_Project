/**
 * 
 */

/* Sign Up vaild check */

function SignUpVaild() {
	var re = /^[a-zA-Z0-9]{4,12}$/ // 아이디와 패스워드가 적합한지 검사할 정규식
	var re2 = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	// 이메일이 적합한지 검사할 정규식

	var id = document.getElementById("userid");
	var pw = document.getElementById("userpw");

	if (!check(re, id, "IDは　4~12字の英文と数字で入力してください。")) {
		return false;
	}
	if (!sign.name.value) {
		alert("お名前は必須です。");
		sign.name.focus();
		return false;
	}
	if (!check(re, pw, "暗証番号は 4~12字の英文と数字で入力してください。")) {
		return false;
	}

	if (sign.userpw.value != sign.userpwf.value) {
		alert("暗証番号を確認してください。");
		sign.userpwf.focus();
		return false;
	}

	if (!sign.email.value) {
		alert("メールは必須です。");
		sign.email.focus();
		return false;
	}
	if (!sign.mail_confirm.value || sign.mail_confirm.value == "") {
		alert("認証をしてください。");
		return false;
	}

	function check(re, what, message) {
		if (re.test(what.value)) {
			return true;
		}
		alert(message);
		what.value = "";
		what.focus();
	}
	if(sign.oking.value != 1){
		alert("IDの重複を確認してください。")
		return false;
	}
	return true;
}

function login_check() {
	if (!log.userid.value) {
		alert("IDは必須でございます。");
		log.userid.focus();
		return false;
	}
	if (!log.password.value) {
		alert("暗証番号は必須でございます。");
		log.password.focus();
		return false;
	}
	if (!log.email.value) {
		alert("メールは必須でございます。");
		log.email.focus();
		return false;
	}
}
