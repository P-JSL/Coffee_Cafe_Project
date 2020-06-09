<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String p = request.getContextPath();
%>
<c:choose>
	<c:when test="${sessionScope.user  == 0 }">
		<c:import url="../../header_0.jsp"></c:import>
	</c:when>
	<c:when test="${sessionScope.user == 1 }">
		<c:import url="../../header.jsp"></c:import>
	</c:when>
	<c:when test="${sessionScope.user==2 }">
		<c:import url="../../header_2.jsp"></c:import>
	</c:when>
</c:choose>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="<%=p%>/css/test.css">
<style>
.owl-carousel.home-slider .slider-item:before {
	margin-bottom: 100px;
}


</style>
<div class="body">
	<div class="wrapper">
		<div class="book">
			<div class="book-cover">
				<div class="header-image img1">
					<div class="overlay"></div>
				</div>
				<div class="title-wrap">
					<h1 class="article-title">世界のコーヒー文化</h1>
				</div>
				<p class="book-cover-expert">

					<!-- one -->
					<b>1. フィンランド</b><br />
					<iframe width="270" height="185"
						src="https://www.youtube.com/embed/AcL9AkAfTl0" frameborder="0"
						allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
						allowfullscreen></iframe>
					<br /> <sub>フィンランドの人たちは juustoleipä
						と呼ばれるチーズ塊の上に熱いコーヒーを注いで一緒に飲む。変わった組み合わせなのかも知らないが、フィンランドの人々はこのコンビネーションをすごく気に入ってると知られている</sub>
					<br>

					<!-- one end -->
					<!-- two -->
					<b>2. トルコ</b><br />
					<iframe width="270" height="185"
						src="https://www.youtube.com/embed/8-IV8ZH2j3Y" frameborder="0"
						allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
						allowfullscreen></iframe>
					<br /> <sub>焼かれたコーヒー豆を細かく磨って銅ポートみたいな容器に入れてお湯を注いで沈ませる
						トルココーヒーが独特な点は細かく擂われたコーヒー粗のままでサービングされるってことだ。
						沈まれたコーヒーの粗は置いて液体だけ飲めばいい。</sub> <br>

					<!-- two end -->
					<!-- three -->
					<b>3. オーストラリア</b><br />
					<iframe width="270" height="185"
						src="https://www.youtube.com/embed/5lQsoZ3BSX0" frameborder="0"
						allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
						allowfullscreen></iframe>
					<br /> <sub>ラテと似ているけれど量はもっと少ない。このオーストラリアコーヒーはsteam処理された牛乳泡をエスプレッソショットに乗せて頼めるといい。</sub>
					<br>

					<!-- three end -->

					<br> <span class="social"> <i class="fa fa-facebook"></i>
						<i class="fa fa-twitter"></i> <i class="fa fa-linkedin"></i> <i
						class="fa fa-instagram"></i>
					</span>
				</p>
			</div>


			<div class="book-content">
				<p>
					<span class="drop-cap">O</span>
				</p>
			</div>
		</div>
	</div>
</div>

<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript">
	$('.book').on('click', function() {
		$(this).toggleClass('book-expanded');
	})
</script>
<%@ include file="../../footer.jsp"%>