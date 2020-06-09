<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>COFFEE &mdash; Website</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700,800"
	rel="stylesheet">

<link rel="stylesheet" href="<%=path%>/css/bootstrap.min.css">

<link rel="stylesheet" href="<%=path%>/css/animate.css">
<link rel="stylesheet" href="<%=path%>/css/owl.carousel.min.css">
<link rel="stylesheet" href="<%=path%>/css/aos.css">

<link rel="stylesheet" href="<%=path%>/css/magnific-popup.css">


<link rel="stylesheet"
	href="<%=path%>/fonts/ionicons/css/ionicons.min.css">
<link rel="stylesheet"
	href="<%=path%>/fonts/fontawesome/css/font-awesome.min.css">
<link rel="stylesheet" href="<%=path%>/fonts/flaticon/font/flaticon.css">
<link rel="stylesheet"
	href="<%=path%>/fonts/flaticon/font2/flaticon.css">

<!-- Theme Style -->
<link rel="stylesheet" href="<%=path%>/css/style.css">
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="<%=path%>/js/com.js"></script>
</head>
<body>
	<header role="banner">
		<nav class="navbar navbar-expand-md navbar-dark bg-dark ">
			<div class="container">

				<a class="navbar-brand" href="<%=path%>/index?command=index">COFFEE</a>
				<!-- 링크 -->

				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarsExample05" aria-controls="navbarsExample05"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarsExample05">
					<ul class="navbar-nav ml-auto pl-lg-5 pl-0">
						<li class="nav-item"><a class="nav-link active"
							href="<%=path%>/index?command=main"><i
								class="fa fa-home fa-2x" aria-hidden="true"></i></a></li>
						<c:choose>
							<c:when
								test="${sessionScope.log == 1  || sessionScope.user == 0}">
								<!-- 링크 -->
								<li class="nav-item"><a class="nav-link"
									href="<%=path%>/header?command=Intro">Introduce</a></li>

								<li class="nav-item"><a class="nav-link"
									href="<%=path%>/header?command=News">News</a> <!-- 링크 --></li>
								<li class="nav-item dropdown"><a
									class="nav-link dropdown-toggle"
									href="<%=path%>/header?command=Bean" id="dropdown04"
									data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false">Services</a> <!-- 링크 -->
									<div class="dropdown-menu" aria-labelledby="dropdown04">
										<a class="dropdown-item" href="<%=path%>/header?command=Bean">What
											the Coffee bean?</a> <a class="dropdown-item"
											href="<%=path%>/header?command=HMC">How make Coffee</a>
										<!-- 링크 -->
										<a class="dropdown-item"
											href="<%=path%>/header?command=History">Coffee`s history</a>
										<!-- 링크 -->
										<a class="dropdown-item"
											href="<%=path%>/header?command=Culture">Coffee culture</a>
										<!-- 링크 -->

									</div></li>

								<li class="nav-item dropdown"><a
									class="nav-link dropdown-toggle"
									href="<%=path%>/header?command=Board" id="dropdown04"
									data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false">Community</a> <!-- 링크 -->
									<div class="dropdown-menu" aria-labelledby="dropdown04">
										<a class="dropdown-item" href="<%=path%>/header?command=Board">Coffee
											BOARD</a>
										<!-- 링크 -->
										<a class="dropdown-item"
											href="<%=path%>/header?command=Notice">Coffee <!-- 링크 -->
											NOTICE
										</a> <a class="dropdown-item"
											href="<%=path%>/gallery?command=gallery">Gallery </a> <a
											class="dropdown-item" href="<%=path%>/header?command=QnA">
											<!-- 링크 --> QnA
										</a>

									</div></li>


								<li class="nav-item dropdown"><a
									class="nav-link dropdown-toggle" href="#" id="dropdown04"
									data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false">Setting</a> <!-- 링크 -->
									<div class="dropdown-menu" aria-labelledby="dropdown04">

										<a class="dropdown-item"
											href="<%=path%>/index?command=signupmove">SIGN-UP </a> <a
											class="dropdown-item" href="<%=path%>/user?command=loginmove">SIGN-IN</a>

									</div></li>
							</c:when>
						</c:choose>
					</ul>

					<ul class="navbar-nav ml-auto">

					</ul>

				</div>
			</div>
		</nav>
	</header>
	<!-- END header -->
	<div class="slider-wrap">
		<section class="home-slider owl-carousel">
			<div class="slider-item"
				style="background-image: url('<%=path%>/img/coffeing.jpg');">

				<div class="container">
					<div
						class="row slider-text align-items-center justify-content-center">
						<div class="col-md-8 text-center col-sm-12 ">
							<h1 data-aos="fade-up">Enjoy Your Coffee</h1>
							<p class="mb-5" data-aos="fade-up" data-aos-delay="100">様々なコーヒー豆の種類を楽しみながらコーヒーを楽しもう</p>
							<p data-aos="fade-up" data-aos-delay="200">
								<!-- <a href="#" class="btn btn-white btn-outline-white">Get
									Started</a> -->
							</p>
						</div>
					</div>
				</div>

			</div>

			<div class="slider-item"
				style="background-image: url('<%=path%>/img/coffeing-2.jpg');">
				<div class="container">
					<div
						class="row slider-text align-items-center justify-content-center">
						<div class="col-md-8 text-center col-sm-12 ">
							<h1 data-aos="fade-up">Good Quality Coffee</h1>
							<p class="mb-5" data-aos="fade-up" data-aos-delay="100">自分だけの最適なコーヒーを淹れ方を探そう</p>
							<p data-aos="fade-up" data-aos-delay="200">
								<!-- <a href="#" class="btn btn-white btn-outline-white">Get
									Started</a> -->
							</p>
						</div>
					</div>
				</div>

			</div>

		</section>
		<!-- END slider -->
	</div>