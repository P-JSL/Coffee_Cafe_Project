<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/table.css">
<link rel="stylesheet" href="css/index.css">
<meta content="width=device-width, initial-scale=1" name="viewport">
<script src="js/menubar.js"></script>
<link href="css/index-in.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<style>
button:nth-child(2) {
	margin-left: 10px !important;
	margin-right: 10px !important;
}
</style>
<div class="container pd0 back_op7">
	<div class="container center shadow">
		<br /> <br /> <br /> <br />
		<h2>INDEX PAGE</h2>
		<p style="text-align: center;">会員ではない場合、非会員を選択してください。</p>
		<br /> <span>新年までのカウントダウン</span> <br />
		<h2>2021</h2>
		<div class="countdown">
			<div id="day">NA</div>
			<div id="hour">NA</div>
			<div id="minute">NA</div>
			<div id="second">NA</div>
		</div>
		<br />
		<table class="table" style="width: 70%; margin-top: 70px;">
			<tr>
				<td>
					<div class="input-group-append alert alert-light" role="alert"
						style="justify-content: center;">
						<button value="0" name="user" type="button"
							class="btn btn-outline-secondary">非会員</button>
						<button value="1" name="user" type="button"
							class="btn btn-outline-primary">会員</button>
						<button value="2" name="user" type="button"
							class="btn btn-outline-danger">管理者</button>
					</div>
				</td>
			</tr>
		</table>
	</div>
</div>
<script type="text/javascript">
	$('button').click(function() {
		var bvalue = $(this).val();

		var form = document.createElement("form");
		form.setAttribute("charset", "UTF-8");
		form.setAttribute("method", "post");
		form.setAttribute("action", "index");

		var hinput = document.createElement("input");
		hinput.setAttribute("type", "hidden");
		hinput.setAttribute("name", "command");
		hinput.setAttribute("value", "indexSelect");

		var vinput = document.createElement("input");
		vinput.setAttribute("type", "hidden");
		vinput.setAttribute("name", "user");
		vinput.setAttribute("value", bvalue);

		form.appendChild(hinput);
		form.appendChild(vinput);
		document.body.appendChild(form);
		form.submit();

	})
</script>
<script type="text/javascript">
	var countDate = new Date('jan 1, 2021 00:00:00').getTime();

	function newYear() {
		var now = new Date().getTime();
		gap = countDate - now;

		var second = 1000;
		var minute = second * 60;
		var hour = minute * 60;
		var day = hour * 24;

		var d = Math.floor(gap / (day));
		var h = Math.floor((gap % (day)) / (hour));
		var m = Math.floor((gap % (hour)) / (minute));
		var s = Math.floor((gap % (minute)) / (second));

		document.getElementById('day').innerText = d;
		document.getElementById('hour').innerText = h;
		document.getElementById('minute').innerText = m;
		document.getElementById('second').innerText = s;

	}
	setInterval(function() {
		newYear()
	}, 1000);
</script>