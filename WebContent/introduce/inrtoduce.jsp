<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${sessionScope.user  == 0 }">
		<c:import url="../header_0.jsp"></c:import>
	</c:when>
	<c:when test="${sessionScope.user == 1 }">
		<c:import url="../header.jsp"></c:import>
	</c:when>
	<c:when test="${sessionScope.user==2 }">
		<c:import url="../header_2.jsp"></c:import>
	</c:when>
</c:choose>
<%
	String p = request.getContextPath();
%>

<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>

<section class="section bg-light  top-slant-white bottom-slant-gray ">

	<div class="clearfix mb-5 pb-5 padtop-10">
		<div class="container-fluid">
			<div class="row" data-aos="fade">
				<div class="col-md-12 text-center heading-wrap">
					<h2>紹介</h2>
				</div>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-md-3 ml-auto"></div>
			<div class="col-md-6 text-center">コーヒーの美味しさ、素晴らしさを伝えたい。
				そしてコーヒーを飲むことで日常が豊かで元気になってほしい。 そんな思いでこのホームページを開設しました。
				小さなホームページですが、ここでしか楽しめないいろんな意見交換と増える知識をお楽しみください。</div>
			<div class="col-md-3 mr-auto"></div>
		</div>
	</div>
</section>
<!-- .section -->



<section class="section relative-higher">

	<div class="clearfix mb-5 pb-5">
		<div class="container-fluid">
			<div class="row" data-aos="fade">
				<div class="col-md-12 text-center heading-wrap">
					<h2>メンバー</h2>
					<!-- <span class="back-text">Testimonial</span> -->
				</div>
			</div>
		</div>
	</div>

	<div class="container">

		<div class="row justify-content-center">
			<div class="col-lg-7">
				<div class="owl-carousel centernonloop2">
					<div class="slide" data-aos="fade-left" data-aos-delay="100">
						<blockquote class="testimonial">
							<p>&ldquo; Far far away, behind the word mountains, far from
								the countries Vokalia and Consonantia. &rdquo;</p>
							<div class="d-flex author">
								<img src="img/A_profile.jpg" alt="" class="mr-4">
								<div class="author-info">
									<h4>シンギヨン</h4>
									<p>プロジェクト責任者</p>
								</div>
							</div>
						</blockquote>
					</div>
					<!--<div class="slide" data-aos="fade-left" data-aos-delay="200">
						<blockquote class="testimonial">
							<p>&ldquo; Far far away, behind the word mountains, far from
								the countries Vokalia and Consonantia, there live the blind
								texts. Separated they live in Bookmarksgrove right at the coast
								of the Semantics, a large language ocean. &rdquo;</p>
							<div class="d-flex author">
								<img src="../img/person_2.jpg" alt="" class="mr-4">
								<div class="author-info">
									<h4>Mike Richardson</h4>
									<p>CEO, XYZ Company</p>
								</div>
							</div>
						</blockquote>
					</div>
					<div class="slide" data-aos="fade-left" data-aos-delay="300">
						<blockquote class="testimonial">
							<p>&ldquo; Far far away, behind the word mountains, far from
								the countries Vokalia and Consonantia, there live the blind
								texts. Separated they live in Bookmarksgrove right at the coast
								of the Semantics, a large language ocean. &rdquo;</p>
							<div class="d-flex author">
								<img src="../img/person_3.jpg" alt="" class="mr-4">
								<div class="author-info">
									<h4>Charles White</h4>
									<p>CEO, XYZ Company</p>
								</div>
							</div>
						</blockquote>
					</div>  -->
				</div>
			</div>
		</div>




	</div>
</section>
<!-- .section -->
<script type='text/javascript'>
	//<![CDATA[
	// // 사용할 앱의 JavaScript 키를 설정해 주세요.
	Kakao.init('02631dded891cbbd678ffa4bbeaaed83');
	// // 카카오링크 버튼을 생성합니다. 처음 한번만 호출하면 됩니다.
	function sendLink() {
		Kakao.Link
				.sendDefault({
					objectType : 'feed',
					content : {
						title : '커피 콩',
						description : '공유하기',
						imageUrl : '190:168:0:24:8080/Project_USAGI_02/img/coffee_bean_1.jpg',
						link : {
							mobileWebUrl : 'http://localhost:8080/Project_USAGI_02/introduce/inrtoduce.jsp',
							webUrl : 'http://localhost:8080/Project_USAGI_02/introduce/inrtoduce.jsp'
						}
					},
					social : {
						likeCount : 1,
						commentCount : 0,
						sharedCount : 2
					},
					buttons : [ {
						title : '웹으로 보기',
						link : {
							mobileWebUrl : 'https://developers.kakao.com',
							webUrl : 'https://developers.kakao.com'
						}
					}, {
						title : '앱으로 보기',
						link : {
							mobileWebUrl : 'https://developers.kakao.com',
							webUrl : 'https://developers.kakao.com'
						}
					} ]
				});
	}
	//]]>
</script>
<%@include file="../footer.jsp"%>

