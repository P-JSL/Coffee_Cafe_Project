<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path1 = request.getContextPath();
%>
<link rel="stylesheet" href="<%=path1%>/css/footer.css">
<style>
.d-block {
	float: inherit;
	width: inherit;
}
</style>
<footer class="site-footer" role="contentinfo">
	<!-- Real Time Digital clock -->
	<script src="<%=path1%>/js/realtimeclock.js"></script>
	<div class="container padtop-10">
		<div class="row">
			<div class="col-md-4 mb-5">
				<h3>About Us</h3>
				<p class="mb-5">ここでしか楽しめないいろんな意見交換と増える知識をお楽しみください。</p>
				<ul>
					<li><p>
							<img
								src="https://api.qrserver.com/v1/create-qr-code/?size=100x100&data=http://localhost:8080/Project_USAGI_02/"
								title="コーヒー紹介ホームページ" />
						</p></li>
				</ul>


			</div>
			<div class="col-md-5 mb-5">

				<div>
					<h3>Contact Info</h3>
					<ul class="list-unstyled footer-link">
						<li class="d-block"><span class="d-block text-black">Address:</span>
							<span>大田廣域市(テジョングァンヨクシ) 中區(チュング) 龍頭洞(ヨンドゥドン) 35-17 ヒヨンビル
								JSL人材開発院 ５層</span></li>
						<li class="d-block"><span class="d-block text-black">Phone:</span><span>+10
								8605 xxxx</span></li>
						<li class="d-block"><span class="d-block text-black">Email:</span><span>althsuwpfl@info.com</span></li>
					</ul>
				</div>
				<div id="RealTime"
					style="color: #333; font-size: 1rem; text-align: center;">0</div>
			</div>
			<div class="col-md-3 mb-5">
				<h3>Quick Links</h3>
				<table class="footer-link">
					<tr>
						<td>
							<form action="<%=path1%>/quick" method="post" name="quick">
								<div class="input-group">
									<select class="select" name="link">
										<optgroup label="index">
											<option value="index">index</option>
										</optgroup>
										<optgroup label="Main">
											<option value="main">Main</option>
											<option value="Intro">Intro</option>
											<option value="News">News</option>
										</optgroup>
										<optgroup label="Service">
											<option value="Bean">Coffee bean</option>
											<option value="HMC">Coffee Make Coffee</option>
											<option value="History">Coffee History</option>
											<option value="Culture">Coffee Culture</option>
										</optgroup>
										<optgroup label="Community">
											<option value="Board">BOARD</option>
											<option value="Notice">NOTICE</option>
											<option value="QnA">Q&A</option>
										</optgroup>
										<optgroup label="Ect">
											<option value="Contact">Contact</option>
										</optgroup>
									</select>
									<div class="input-group-append">
										<input type="submit" name="move" value="移動"
											class="btn btn-success btn-sm">
									</div>
								</div>
							</form>
						</td>
					</tr>
				</table>


				<div class="pt-2">
					<button type="button" class="btn btn-outline-dark" id="uploading">ファイルアップロード</button>
				</div>
				<div class="pt-2">
					<button type="button" class="btn btn-outline-danger"
						id="downloading">ファイルダウンロード</button>
				</div>
				<div class="top pt-2">
					<button type="button" class="btn btn-light">TOP</button>
				</div>
			</div>
			<div class="col-md-3"></div>
		</div>
		<div class="row">
			<div class="col-12 text-md-center text-left">
				<p>
					<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
					Copyright &copy;
					<script>
						document.write(new Date().getFullYear());
					</script>
					All rights reserved <i class="fa fa-heart text-danger"
						aria-hidden="true"></i> by <a href="https://colorlib.com"
						target="_blank">SHIN GIYEON</a>
					<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
				</p>
			</div>
		</div>
	</div>
</footer>
<!-- END footer -->
<script type="text/javascript">
			$("#uploading").on(
					"click",
					function(e) {
						const id = '${sessionScope.id}';
						console.log(id);
						if(id == null || id == "" || id == ''){
							alert("ログインをしない限り、使用できません。");
							location.href="index?command=index";
							return ;
						}
						
						var conpath = '<%=path1%>';
						$.ajax({
							url:conpath+"/upload.file",
							type:"post",
							data:{
								id : id
							},
							dataType:"json"
						}).done(function(res){
							var url = conpath+"/"+res.urls
							window.open(url, "File_Upload_Window",
							"width=900px,height=700px");
						}).fail(function(req){
							console.log("fail");
						});
					});
			$("#downloading").on(
					"click",
					function(e) {
						var conpath = '<%=path1%>
	';
		const id = '${sessionScope.id}';
		console.log(id);

		$.ajax({
			url : conpath + "/download.file",
			type : "post",
			data : {
				id : id
			},
			dataType : "json"
		}).done(function(res) {
			var url = conpath + "/" + res.urls;
			window.open(url, "File_Upload_Window", "width=900px,height=700px");
		}).fail(function(req) {
			console.log("fail");
		});
	});
</script>
<script type="text/javascript">
	$(".top button").on("click", function() {
		$("html, body").animate({
			scrollTop : 0
		}, 500);
	})
</script>
<!-- loader -->
<div id="loader" class="show fullscreen">
	<svg class="circular" width="48px" height="48px">
			<circle class="path1-bg" cx="24" cy="24" r="22" fill="none"
			stroke-width="4" stroke="#eeeeee" />
			<circle class="path1" cx="24" cy="24" r="22" fill="none"
			stroke-width="4" stroke-miterlimit="10" stroke="#cf1d16" /></svg>
</div>

<script src="<%=path1%>/js/jquery-3.2.1.min.js"></script>
<script src="<%=path1%>/js/popper.min.js"></script>
<script src="<%=path1%>/js/bootstrap.min.js"></script>
<script src="<%=path1%>/js/owl.carousel.min.js"></script>
<script src="<%=path1%>/js/jquery.waypoints.min.js"></script>
<script src="<%=path1%>/js/aos.js"></script>

<script src="<%=path1%>/js/jquery.magnific-popup.min.js"></script>
<script src="<%=path1%>/js/magnific-popup-options.js"></script>


<script src="<%=path1%>/js/main.js"></script>