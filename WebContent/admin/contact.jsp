<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String p = request.getContextPath();
%>
<link rel="stylesheet" href="<%=p%>/css/history.css">
<%@include file="../header_2.jsp"%>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<link rel="stylesheet" href="https://unpkg.com/swiper/css/swiper.css">
<link rel="stylesheet"
	href="https://unpkg.com/swiper/css/swiper.min.css">

<script src="https://unpkg.com/swiper/js/swiper.js"></script>
<script src="https://unpkg.com/swiper/js/swiper.min.js"></script>
<!-- Link Swiper's CSS -->
<link rel="stylesheet" href="<%=p%>/css/swiper.min.css">
<link rel="stylesheet" href="<%=p%>/css/swiper_silder.css">
<link rel="stylesheet" href="<%=p%>/css/table.css">
<script src="../js/com.js"></script>
<style>
.select {
	font-size: 18px;
}
</style>
<div class="container">
	<div class="page">
		<span class="asub1">会員管理ページ</span> <span class="asub2">ユーザー管理ページ</span><span
			class="asub3">CONTACT管理ページ</span>
	</div>
</div>
<div class="container">
	<!-- Swiper -->
	<div class="swiper-container">

		<div class="swiper-wrapper">
			<div class="swiper-slide">
				<h3>CONTACT US MANAGE</h3>
				<h4>サーブページ</h4>
				<form action="" method="post" name="" inputmode="search">
					<div class="continer input-group input-group-sm form-group">
						<select class="select">
							<option value="id">ID</option>
						</select> <input type="search" placeholder="検索するIDを書いてください。" name="select"
							class="input form-control" aria-describedby="sizing-addon3">
						<input type="submit" value="검색" class="btn btn-success">
					</div>
				</form>
				<br>
				<h3>ユーザー情報</h3>
				<h4></h4>
				<div class="container">
					<table class="table container">
						<tr class="active">
							<td>ID</td>
							<td>cofie</td>
						</tr>
						<tr class="active">
							<td>最近作成日</td>
							<td>2020/01/01</td>
						</tr>

						<tr class="active">
							<td>作成回数</td>
							<td>10</td>
						</tr>
					</table>
				</div>
				<div class="container">
					<h4>管理者 作成目録</h4>
					<table class="table">
						<thead>
							<tr>
								<th>状態</th>
								<th>番号</th>
								<th>ID</th>
								<th>名前</th>
								<th>メール</th>
								<th>内容</th>
								<th colspan="2">・・</th>
							</tr>
						</thead>
						<tbody>
							<tr class="success">
								<td><i class="fa fa-times" aria-hidden="true"></i></td>
								<td>1</td>
								<td>cofie</td>
								<td>香林あかね</td>
								<td>cofie@gmail.com</td>
								<td>お会いしたいですが、地図に・・・</td>
								<td><a type="button" href="#">確認</a></td>
								<td><a type="button" href="#">返事</a></td>
							</tr>
							<tr>
								<td><i class="fa fa-circle-o" aria-hidden="true"></i></td>
								<td>2</td>
								<td>cofie</td>
								<td>香林あかね</td>
								<td>cofie@gmail.com</td>
								<td>以前、受けたメールについてですが・・・</td>
								<td><a type="button" href="#">返事</a></td>
							</tr>
						</tbody>
					</table>
					<!-- Start Pagination -->
					<ul class="pagination">
						<li><a href="#0">&lt;</a></li>
						<li><a href="#0">1</a></li>
						<li><a href="#0">2</a></li>
						<li><a href="#0">3</a></li>
						<li><a href="#0">4</a></li>
						<li><a href="#0">5</a></li>
						<li><a href="#0">&gt;</a></li>
					</ul>
					<!-- End Pagination -->
				</div>
			</div>
			<!-- Add Scroll Bar -->
			<div class="swiper-scrollbar"></div>
		</div>

	</div>
</div>
<!-- Swiper JS -->
<script src="<%=p%>/js/swiper.min.js"></script>

<!-- Initialize Swiper -->
<script>
	var swiper = new Swiper('.swiper-container', {
		direction : 'vertical',
		slidesPerView : 'auto',
		freeMode : true,
		scrollbar : {
			el : '.swiper-scrollbar',
		},
		mousewheel : true,
	});
</script>
<%@include file="../footer.jsp"%>