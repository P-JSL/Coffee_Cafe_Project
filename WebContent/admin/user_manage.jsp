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
				<h3>USER MANAGEMENT</h3>
				<h4>サーブページ</h4>
				<form action="" method="post" name="" inputmode="search">
					<div class="continer input-group input-group-sm form-group">
						<select class="select">
							<option value="writer">名前</option>
							<option value="title">タイトル</option>
							<option value="id">ID</option>
						</select> <input type="search" placeholder="검색하고자 하는 옵션을 선택하여 검색해주세요."
							name="select" class="input form-control"
							aria-describedby="sizing-addon3"> <input type="submit"
							value="검색" class="btn btn-success">
					</div>
				</form>
				<br>
				<h3>ユーザー情報</h3>
				<h4>cofie 様の情報</h4>
				<h4></h4>
				<div class="container">
					<table class="table container">
						<tr class="active">
							<td>登録日</td>
							<td>2020/01/01</td>
						</tr>
						<tr class="active">
							<td>最近作成日</td>
							<td>2020/01/04</td>
						</tr>
						<tr class="active">
							<td>総作成数</td>
							<td>1つ</td>
						</tr>
						<tr class="active">
							<td>接続回数</td>
							<td>10回</td>
						</tr>
					</table>
				</div>
				<br />
				<h4>cofie 様の作成目録</h4>
				<table class="table">
					<thead>
						<tr>

							<th>番号</th>
							<th>タイトル</th>
							<th>作成者</th>
							<th>作成日時</th>
							<th>ヒット数</th>
							<th colspan="2">・</th>

						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<td>今日のコーヒー</td>
							<td>生きがいコーヒー</td>
							<td>2019/08/11</td>
							<td>15</td>
							<td><a type="button" href="#">修正</a></td>
							<td><a type="button" href="#" onclick="return nott();">削除</a></td>
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
<!-- Swiper JS -->
<script type="text/javascript">
	$(function() {

		$(".page .asub1").on("click", function() {
			location.href = "../admin.do";
		})
		$(".page .asub2").on("click", function() {
			location.href = "user_manage.jsp";
		})
		$(".page .asub3").on("click", function() {
			location.href = "contact.jsp";
		})
	})
</script>
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