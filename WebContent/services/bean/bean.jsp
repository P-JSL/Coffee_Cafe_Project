<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String p = request.getContextPath();
%>
<link rel="stylesheet" href="<%=p%>/css/history.css">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link rel="stylesheet" href="https://unpkg.com/swiper/css/swiper.css">
<link rel="stylesheet"
	href="https://unpkg.com/swiper/css/swiper.min.css">

<script src="https://unpkg.com/swiper/js/swiper.js"></script>
<script src="https://unpkg.com/swiper/js/swiper.min.js"></script>
<!-- Link Swiper's CSS -->
<link rel="stylesheet" href="<%=p%>/css/swiper.min.css">
<link rel="stylesheet" href="<%=p%>/css/swiper_silder.css">
<!-- Demo styles -->


</head>
<body>
	<div class="container">
		<!-- Swiper -->
		<div class="swiper-container">
			<div class="swiper-wrapper">
				<div class="swiper-slide">
					<h4>${bvo.title }</h4>
					<p>${bvo.content }</p>
				</div>
			</div>
			<!-- Add Scroll Bar -->
			<div class="swiper-scrollbar"></div>
		</div>
	</div>
	<div class="container" style="margin: 0 auto; margin-top: 10px;">
		<c:choose>
			<c:when test="${sessionScope.user == 0 || sessionScope.user == 1}">
				<!-- 로그인 한 userid로 변경 할 것 -->

			</c:when>
			<c:when test="${ sessionScope.user ==2 }">
				<!-- 로그인 한 userid로 변경 할 것 -->
				<div class="container" style="margin-top: 20px; position: relative;">
					<div class="btn-group"
						style="position: absolute; left: 50%; transform: translateX(-50%); z-index: 111">
						<c:choose>
							<c:when test="${bvo.onoff!=1 }">

								<a href="<%=p%>/service?command=beanWrite"
									class="btn btn-primary">作成</a>
							</c:when>
							<c:otherwise>

								<a href="service?command=beanModifyMove" class="btn btn-primary"
									style="margin-left: 20px;">修正</a>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</c:when>
		</c:choose>

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
	<%@include file="../../footer.jsp"%>