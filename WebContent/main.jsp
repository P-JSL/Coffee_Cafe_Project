<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String p = request.getContextPath();
%>

<c:choose>
	<c:when test="${sessionScope.user == 0 }">
		<c:import url="header_0.jsp"></c:import>
	</c:when>
	<c:when test="${sessionScope.user == 1 }">
		<c:import url="header.jsp"></c:import>
	</c:when>
	<c:when test="${sessionScope.user==2 }">
		<c:import url="header_2.jsp"></c:import>
	</c:when>
</c:choose>
<style>
.card {
	margin-left: 20px;
}
</style>
<section class="section bg-light py-5 pb-5 bottom-slant-gray">
	<div class="container">
		<div class="row">
			<div class="col-md-6 mb-4 mb-lg-0 col-lg-4 text-left service-block"
				data-aos="fade-up" data-aos-delay="">
				<span class="wrap-icon"><span
					class="flaticon-coffee-bean d-block mb-4"></span></span>
				<h3 class="mb-2 text-primary">Kinds of Coffee bean</h3>
				<p>ここではコーヒー豆と呼ばれる加工された状態と言われる生豆と焙煎豆に大別できることの情報を扱っております。</p>
			</div>
			<div class="col-md-6 mb-4 mb-lg-0 col-lg-4 text-left service-block"
				data-aos="fade-up" data-aos-delay="100">
				<span class="wrap-icon"><span
					class="flaticon-timer d-block mb-4" style="margin-left: 5px;"></span></span>
				<h3 class="mb-2 text-primary">how we long make coffee</h3>
				<p>コーヒーを飲むに最適な作り方はどれかについても説明がございます。</p>
			</div>
			<div class="col-md-6 mb-4 mb-lg-0 col-lg-4 text-left service-block"
				data-aos="fade-up" data-aos-delay="200">
				<span class="wrap-icon"><span
					class="flaticon-food d-block mb-4"
					style="margin-left: 3px; margin-bottom: 2px;"></span></span>
				<h3 class="mb-2 text-primary">Cup of Coffees</h3>
				<p>多様なコーヒーに関するいろんな情報を提供しております。お楽しみください。</p>
			</div>
		</div>
	</div>
</section>
<section class="section pb-0 py-5 padtop-10">
	<div class="container">
		<div class="row mb-5 justify-content-center" data-aos="fade">
			<div class="col-md-7 text-center heading-wrap">
				<h2 data-aos="fade-up">The coffee</h2>
				<p data-aos="fade-up" data-aos-delay="100">よく知られているカフェインの効果は覚せい作用です。カフェインの覚醒作用により、頭をすっきりさせて集中力を高める効果があります。また、利尿効果があり、体内の老廃物の排出を促進させる効果があります。他にも、中枢神経を刺激して、自律神経の働きを高めたり、運動能力を向上させたり、心臓の筋肉の収縮力を強化させたりするなど、コーヒーに含まれるカフェインは、多彩な効果をもっています。</p>
			</div>
		</div>
		<div class="row align-items-center">
			<div class="col-lg-4">
				<img src="img/coffee_1.jpg" alt="Image"
					class="img-fluid about_img_1" data-aos="fade" data-aos-delay="200">
			</div>
			<div class="col-lg-4">
				<img src="img/coffee_2.jpg" alt="Image"
					class="img-fluid about_img_1" data-aos="fade" data-aos-delay="300">
				<img src="img/coffee_3.jpg" alt="Image"
					class="img-fluid about_img_1" data-aos="fade" data-aos-delay="400">
			</div>
			<div class="col-lg-4">
				<img src="img/coffee_4.jpg" alt="Image"
					class="img-fluid about_img_1" data-aos="fade" data-aos-delay="500">
			</div>
		</div>
	</div>
</section>



<section class="section bg-light  top-slant-white bottom-slant-gray ">

	<div class="clearfix mb-5 pb-5 padtop-10">
		<div class="container-fluid">
			<div class="row" data-aos="fade">
				<div class="col-md-12 text-center heading-wrap">
					<h2>Kind of Coffee bean</h2>
				</div>
			</div>
		</div>
	</div>

	<div class="container">

		<div class="row no-gutters">
			<div class="col-md-6">
				<div class="sched d-block d-lg-flex">
					<div class="bg-image order-2"
						style="background-image: url('img/colombian bean.jpg');"
						data-aos="fade"></div>
					<div class="text order-1">
						<h3>Colombian Milds</h3>
						<p>
							コロンビアから生産される生豆であり、アメリカでは最高のコーヒーで認識されます。 <br>
							コーヒー豆の大きさを意味するExcelso ＆ Supremoで仕分けられ、優しい酸味ときれいな裏味が特徴です。
						</p>
					</div>

				</div>

				<div class="sched d-block d-lg-flex">
					<div class="bg-image"
						style="background-image: url('img/Hawaiian kona.jpg');"
						data-aos="fade"></div>
					<div class="text">
						<h3>Hawaiian Kona</h3>
						<p>ハワイのビックアイランドのコーナー地域から生産されるコーヒーできれいな裏味が軽くて繊細です。</p>

					</div>

				</div>

			</div>

			<div class="col-md-6">
				<div class="sched d-block d-lg-flex">
					<div class="bg-image order-2"
						style="background-image: url('img/Jamaican Blue.jpg');"
						data-aos="fade"></div>
					<div class="text order-1">
						<h3>Jamaican Blue Mountain</h3>
						<p>
							非常に有名なコーヒーの１つ。 <br>
							ジャマイカブルーマウンテン地域から生産され、いちばんプレミアムが高いコーヒーの１つで名声をもっています。
							味は優しく、軽いバーディー感が特徴です。
						</p>

					</div>

				</div>

				<div class="sched d-block d-lg-flex">
					<div class="bg-image"
						style="background-image: url('img/JAVA_Bean.jpg');"
						data-aos="fade"></div>
					<div class="text">
						<h3>JAVA</h3>
						<p>インドネシアのジャヴァ島で生産され、イエメンモカとお互い補完して調和をとったモカジャヴァにブランディングされて人気が多いです。</p>

					</div>

				</div>

			</div>
		</div>
	</div>
</section>
<div class="container" style="margin-top: 50px; background-color: #fff">
	<ul class="nav nav-tabs">
		<li class="nav-item"><a class="nav-link active" data-toggle="tab"
			href="#qwe">お知らせ</a></li>
		<li class="nav-item"><a class="nav-link" data-toggle="tab"
			href="#asd">掲示板</a></li>
		<li class="nav-item"><a class="nav-link" data-toggle="tab"
			href="#zxc">News</a></li>
		<li class="nav-item"><a class="nav-link" data-toggle="tab"
			href="#gal">Gallery</a></li>

	</ul>
	<div class="tab-content">
		<div class="tab-pane fade show active" id="qwe">
			<table class="table table-striped" style="text-align: center;">
				<thead>
					<tr>
						<th scope="col">番号</th>
						<th scope="col">タイトル</th>
						<th scope="col">作成日</th>
						<th scope="col">ヒット数</th>
					</tr>
				</thead>
				<tbody>
					<c:set value="${nto }" var="n"></c:set>
					<c:forEach var="noti" items="${nlist }">
						<tr>
							<th scope="row">${n }</th>
							<td><a href="notice?command=noticeView&num=${noti.num }">${noti.n_title }</a></td>
							<td>${noti.n_date }</td>
							<td>${noti.n_count }</td>
						</tr>
						<c:set var="n" value="${n-1 }"></c:set>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="tab-pane fade" id="asd">
			<table class="table table-striped" style="text-align: center;">
				<thead>
					<tr>
						<th scope="col" class="">番号</th>
						<th scope="col">タイトル</th>
						<th scope="col">作成日</th>
						<th scope="col">ヒット数</th>
					</tr>
				</thead>
				<tbody>
					<c:set var="b" value="${bto }"></c:set>
					<c:forEach var="bo" items="${blist }">
						<tr>
							<th scope="row">${b }</th>
							<c:choose>
								<c:when test="${i.onoff eq 'on' }">
									<td><a
										href="board?command=boardView&num=${bo.num }&onoff=${bo.onoff}">${bo.b_title }</a></td>
								</c:when>
								<c:otherwise>
									<td><a href="board?command=boardView&num=${bo.num }">${bo.b_title }</a></td>
								</c:otherwise>
							</c:choose>

							<td>${bo.b_date }</td>
							<td>${bo.b_count }</td>
						</tr>
						<c:set value="${b-1 }" var="b"></c:set>
					</c:forEach>
				</tbody>
			</table>
			<hr />
		</div>
		<div class="tab-pane fade" id="zxc">
			<div class="container">

				<div class="row">
					<c:forEach var="news" items="${elist }">
						<div class="card" style="border: inherit;">
							<label><fmt:formatDate value="${news.news_date }"
									pattern="yyyy年MM月dd日" /> @ 管理者</label> <a
								href="news?command=newsview&num=${news.num }" class="thumbnail">
								<img src="<%=p %>/news_upload/${news.photo}"
								style="max-width: 300px; height: auto">
							</a>
						</div>
					</c:forEach>
				</div>
			</div>

		</div>
		<div class="tab-pane fade" id="gal">
			<div class="alert alert-light" role="alert"
				style="text-align: center;">
				<h4>最近アップロードされた ${gto }件です。</h4>
			</div>
			<div class="row">
				<c:forEach var="gal" items="${glist }">
					<div class="card" style="width: 15rem; margin-top: 10px;">
						<img class="card-img-top" src="Galleryupload/${gal.photo }"
							alt="Card image cap" style="height: 240px;">
						<div class="card-body">
							<h5 class="card-title"
								style="font: sans-serif; font-size: inherit; width: 100%;">
								<fmt:formatDate value="${gal.photodate }" pattern="yyyy/MM/dd" />
							</h5>
							<p class="card-text">作成者:${gal.userid }</p>

						</div>
					</div>
				</c:forEach>
			</div>
		</div>

	</div>
</div>




<%@include file="footer.jsp"%>