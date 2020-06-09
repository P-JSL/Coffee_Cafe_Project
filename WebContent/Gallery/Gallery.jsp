<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String p = request.getContextPath();
%>

<c:choose>
	<c:when test="${sessionScope.user == 0 }">
		<c:import url="../header_0.jsp"></c:import>
	</c:when>
	<c:when test="${sessionScope.user == 1 }">
		<c:import url="../header.jsp"></c:import>
	</c:when>
	<c:when test="${sessionScope.user==2 }">
		<c:import url="../header_2.jsp"></c:import>
	</c:when>
</c:choose>
<link rel="stylesheet" href="<%=p%>/css/Photo.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.1.0/jquery.magnific-popup.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.1.0/magnific-popup.min.css">
<script
	src="https://unpkg.com/masonry-layout@4/dist/masonry.pkgd.min.js"></script>
<script src="https://unpkg.com/imagesloaded@4/imagesloaded.pkgd.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
.
.site-footer::before {
	height: 0 !important;
}

.col-lg-4 a:nth-child(3n) img ,.col-lg-4 a:nth-child(3n-1) img {
	margin-top: 10px;
}
</style>
</head>
<body>
	<div class="container">
		<section class="section pb-0 py-5 padtop-10">
			<div class="container">
				<div class="row mb-5 justify-content-center" data-aos="fade">
					<div class="col-md-7 text-center heading-wrap">
						<h2 data-aos="fade-up">The Gallery</h2>
						<p data-aos="fade-up" data-aos-delay="100">写真をアップロードして共有しよう。</p>
					</div>
				</div>
				<div class="row align-items-center gallery">

					<div class="col-lg-4">
						<c:forEach var="gal" items="${glist }">
							<c:if test="${gal.rnum % 3 == 1 }">
								<a href="Galleryupload/${gal.photo }" class="image"><img
									src="Galleryupload/${gal.photo }" alt="Image"
									class="img-fluid about_img_1" data-aos="fade"
									data-aos-delay="300"></a>
							</c:if>
						</c:forEach>
					</div>
					<div class="col-lg-4">
						<c:forEach var="gal" items="${glist }">
							<c:if test="${gal.rnum % 3 == 2 }">
								<a href="Galleryupload/${gal.photo }" class="image"><img
									src="Galleryupload/${gal.photo }" alt="Image"
									class="img-fluid about_img_1" data-aos="fade"
									data-aos-delay="500"></a>
							</c:if>
						</c:forEach>
					</div>
						<div class="col-lg-4">
							<c:forEach var="gal" items="${glist }">
								<c:if test="${gal.rnum % 3 ==0 }">
									<a href="Galleryupload/${gal.photo }" class="image"><img
										src="Galleryupload/${gal.photo }" alt="Image"
										class="img-fluid about_img_1" data-aos="fade"
										data-aos-delay="200"></a>

								</c:if>
							</c:forEach>
						</div>
				</div>
			</div>
		</section>
		<div class="container" style="margin-top: 1vh; z-index: 11;">
			<div class="form-group" style="text-align: center;">
				<button class="btn btn-outline-success" id="gals">ギャラリー作成</button>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$("#gals").on("click", function() {
			var id = '${sessionScope.id}';
			var url = "gallery?command=galleryInsertMove&id=" + id;
			var cw = window.open(url, "사진업로드", "width:400px,height:300px");
		})
	</script>
	<script>
		$(".gallery").magnificPopup({
			delegate : 'a',
			type : 'image',
			gallery : {
				enabled : true,
				navigateByImgClick : true
			},
			callbacks : {
				resize : changeImgSize,
				imageLoadComplete : changeImgSize,
				change : changeImgSize
			},
			retina : {
				ratio : 1, // Increase this number to enable retina image support.
				// Image in popup will be scaled down by this number.
				// Option can also be a function which should return a number (in case you support multiple ratios). For example:
				// ratio: function() { return window.devicePixelRatio === 1.5 ? 1.5 : 2  }
				replaceSrc : function(item, ratio) {
					return item.src.replace(/\.\w+$/, function(m) {
						return '@2x' + m;
					});
				} // function that changes image source
			}
		});
		function changeImgSize() {
			var img = this.content.find('img');
			img.css('max-height', '720px');
			img.css('width', 'auto');
			img.css('max-width', 'auto');
		}
	</script>
	<c:import url="../footer.jsp"></c:import>