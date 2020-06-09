<%@page import="com.usagi.dao.BoardDAO.BoardDAO"%>
<%@page import="com.usagi.util.paging.pageDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String p = request.getContextPath();
%>
<link rel="stylesheet" href="<%=p%>/css/history.css">
<%@include file="../header.jsp"%>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<link rel="stylesheet" href="https://unpkg.com/swiper/css/swiper.css">
<link rel="stylesheet" href="https://unpkg.com/swiper/css/swiper.css">
<link rel="stylesheet"
	href="https://unpkg.com/swiper/css/swiper.min.css">

<script src="https://unpkg.com/swiper/js/swiper.js"></script>
<script src="https://unpkg.com/swiper/js/swiper.min.js"></script>
<!-- Link Swiper's CSS -->
<link rel="stylesheet" href="<%=p%>/css/swiper.min.css">
<link rel="stylesheet" href="<%=p%>/css/swiper_silder.css">
<link rel="stylesheet" href="<%=p%>/css/table.css">
<script src="<%=p%>/js/com.js"></script>
<style>
#img img {
	max-height: 80px;
	max-width: 125px;
}
</style>
<div class="imging">
	<div class="container">
		<!-- Swiper -->
		<div class="swiper-container">
			<div class="swiper-wrapper">
				<div class="swiper-slide" id="slided">
					<h3>マイページ</h3>
					<br>
					<h4>私の情報</h4>
					<div class="container">
						<c:set var="m" value="${mvo }"></c:set>
						<table class="table container">
							<tr>
								<td>会員登録日</td>
								<td><fmt:formatDate value="${m.signupdate }"
										pattern="yyyy-MM-dd" /></td>
							</tr>
							<tr>
								<td>最近作成日</td>
								<td><fmt:formatDate value="${m.b_date }"
										pattern="yyyy-MM-dd" /></td>
							</tr>
							<tr>
								<td>全てヒット数</td>
								<td>${hit }</td>
							</tr>
							<tr>
								<td>ログイン回数</td>
								<td>${m.loginnum }</td>
							</tr>

						</table>
					</div>
					<br />
					<h4>個人情報修正</h4>
					<form action="<%=p%>/user?command=usermodify" method="post"
						name="modify" id="modifyForm">
						<div class="row">
							<div class="col-md-6 form-group">
								<label for="userid">ID</label> <input type="text" id="userid"
									class="form-control" disabled value="${sessionScope.id }"
									name="userid">
							</div>
							<div class="col-md-6 form-group">
								<label for="email">メール</label> <input type="email" id="email"
									class="form-control " name="useremail" value="${email }">
							</div>
						</div>
						<div class="row">
							<div class="col-md-6 form-group">
								<label for="password">暗証番号</label> <input type="password"
									id="password" class="form-control" name="password">
							</div>
							<div class="col-md-6 form-group">
								<label for="password2">暗証番号確認</label> <input type="password"
									id="password2" class="form-control" name="passwords">
							</div>
						</div>

						<div class="col-md-6 form-group">
							<div class="row">
								<input type="submit" value="修正" class="btn btn-outline-danger"
									onclick="return pwcon();">
							</div>
						</div>
					</form>
					<br />
					<div class="form-group">
						<div class="btn-group">
							<button id="mb" class="btn btn-outline-info btn-sm">私の掲示</button>
							<button id="mc" class="btn btn-outline-success btn-sm">私のコメント</button>
							<button id="mcu" class="btn btn-outline-warning btn-sm">CONTACT
								US</button>
							<button id="GALLERY" class="btn btn-outline-secondary btn-sm">GALLERY</button>
						</div>
					</div>

					<div class="myboard">
						<h4>私の掲示</h4>
						<table class="table">
							<thead>
								<tr>
									<th>番号</th>
									<th>タイトル</th>
									<th>内容</th>
									<th>作成日時</th>
									<th>ヒット数</th>
									<th colspan="2">備考</th>
								</tr>
							</thead>
							<tbody>
								<c:set var="ino" value="${count-(nowpage - 1)*5 }"></c:set>
								<c:forEach var="i" items="${mylist }">
									<tr>
										<td>${ino }</td>
										<td>${i.b_title }</td>
										<td id=img>${i.b_content }</td>
										<td><fmt:formatDate value="${i.b_date }"
												pattern="yyyy-MM-dd" /></td>
										<td>${i.b_count }</td>
										<td><a type="button"
											href="board?command=boardmodifymove&num=${i.num }">修正</a></td>
										<td><a type="button"
											href="board?command=boarddelete&num=${i.num }"
											onclick="return nott();">削除</a></td>
									</tr>
									<c:set value="${ino-1 }" var="ino"></c:set>
								</c:forEach>
							</tbody>
						</table>
						<!-- Start Pagination -->
						<!-- 페이징 세팅 -->

						<div class="pagination">
							<ul>${pages }
							</ul>
							<!-- 페이징 처리 끝 -->
						</div>
					</div>

					<div class="mycomment">
						<h4>私のコメント</h4>
						<table class="table">
							<thead>
								<tr>
									<th>番号</th>
									<th>内容</th>
									<th>作成日時</th>
									<th colspan="1">備考</th>
								</tr>
							</thead>
							<tbody>
								<c:set var="bno" value="${recount - (nowpage2-1)*5 }"></c:set>
								<c:forEach var="com" items="${comment }">

									<tr>
										<td>${com.b_num }</td>
										<td>${com.re_comment}</td>
										<td><fmt:formatDate value="${com.reply_date }"
												pattern="yyyy-MM-dd" /></td>
										<td><a type="button"
											href="rep?command=MyReplyDelete&num=${com.num }"
											onclick="return nott();">削除</a></td>
									</tr>
									<c:set var="bno" value="${bno-1 }"></c:set>

								</c:forEach>
							</tbody>
						</table>
						<div class="pagination">
							<ul>${pages2 }
							</ul>
							<!-- 페이징 처리 끝 -->
						</div>
					</div>
					<div class="mycontact">
						<h4>CONTACT US</h4>
						<table class="table">
							<thead>
								<tr>
									<th>返事状態</th>
									<th>番号</th>
									<th>名前</th>
									<th>内容</th>
									<th>作成日時</th>
									<th colspan="1"></th>
								</tr>
							</thead>
							<tbody>
								<c:set var="co" value="${ccount-(nowpage3 - 1)*3 }"></c:set>
								<c:forEach var="con" items="${contact }">

									<tr>
										<td><c:choose>
												<c:when test="${con.res_confirm == 0 }">

													<i class="fa fa-times" aria-hidden="true"></i>
												</c:when>
												<c:when test="${con.res_confirm == 1 }">

													<i class="fa fa-check" aria-hidden="true"></i>
												</c:when>
											</c:choose></td>
										<td>${co}</td>
										<td>${con.name }</td>
										<td>${fn:substring(con.msg,0,15) }・・・</td>
										<td><fmt:formatDate value="${con.send_date }"
												pattern="yyyy-MM-dd HH:mm" /></td>
										<td><a type="button" href="javascript:void(0);"
											class="${con.num }" id="res">返事を見る</a></td>
									</tr>
									<c:set var="co" value="${co-1 }"></c:set>
								</c:forEach>


							</tbody>
						</table>
						<!-- Start Pagination -->
						<!-- 페이징 세팅 -->

						<div class="pagination">
							<ul>${pages3 }
							</ul>
							<!-- 페이징 처리 끝 -->
						</div>
					</div>
					<div class="gallery">
						<h4>MY GALLERY</h4>
						<br />
						<div class="row">
							<c:forEach var="gal" items="${glist }">
								<div class="card" style="width: 15rem; margin-top: 10px;">
									<img class="card-img-top" src="Galleryupload/${gal.photo }"
										alt="Card image cap" style="height: 250px;">
									<div class="card-body">
										<h5 class="card-title"
											style="font: sans-serif; font-size: inherit; width: 100%;">
											<fmt:formatDate value="${gal.photodate }"
												pattern="yyyy/MM/dd" />
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
												href="gallery?command=GalDelete&num=${gal.num }"
												class="badge badge-danger badge-sm">除去</a>
										</h5>
										<p class="card-text">作成者:${gal.userid }</p>

									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>

			</div>
			<!-- Add Scroll Bar -->
			<div class="swiper-scrollbar"></div>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(".table > tbody > tr > td:nth-child(6) #res").on(
			"click",
			function(e) {
				var num = $(this).attr("class");
				e.preventDefault();
				console.log(num);

				$.ajax({
					url : "cont?command=Receive",
					type : "post",
					data : {
						num : num
					},
					dataType : "json"
				}).done(
						function(data) {
							console.log(data.msg);
							console.log(data.id);
							var urls = 'contact/contact_user_recive.jsp?id='
									+ data.id + '&msg=' + data.msg;
							var wop = window.open(urls, "",
									"width:200px,height:200px");
						}).fail(function(data) {

				});
			})
</script>
<script type="text/javascript">
	function pwcon() {
		if (modify.password.value != modify.passwords.value) {
			alert("暗証番号を正しくお書きください。");
			modify.password.focus();
			return false;
		}
	}
</script>
<script type="text/javascript">
	$(window).on("load", function() {
		$(".myboard").show();
		$(".mycomment").hide();
		$(".mycontact").hide();
		$(".gallery").hide();
		$("#slided").css({
			"max-height" : "800px;"
		})
	})
	$("#mb").on("click", function() {
		$(".myboard").show();
		$(".mycomment").hide();
		$(".mycontact").hide();
		$(".gallery").hide();
	})
	$("#mc").on("click", function() {
		$(".myboard").hide();
		$(".mycomment").show();
		$(".mycontact").hide();
		$(".gallery").hide();
	})
	$("#mcu").on("click", function() {
		$(".myboard").hide();
		$(".mycomment").hide();
		$(".mycontact").show();
		$(".gallery").hide();
	})
	$("#GALLERY").on("click", function() {
		$(".myboard").hide();
		$(".mycomment").hide();
		$(".mycontact").hide();
		$(".gallery").show();
	})
</script>
<script type="text/javascript">
	setInterval(function() {
		const p = $("#password").val().length;
		console.log(p);
		var pw1 = $("#password").val();
		var uid = $("#userid").val();
		$
				.ajax({
					url : "user?command=modifyPw",
					type : "post",
					data : {
						userid : uid,
						userpw : pw1
					},
					success : function(data) {
						if (p > 4) {
							if (data.success != 1) {
								$("#password").css("background-color",
										"rgba(0,255,0,0.5)");
							} else {
								$("#password").css("background-color",
										"rgba(255,0,0,0.6)");
							}
						} else {
							$("#password").attr("placeholder", "最小4字以上です。"), $(
									"#password").css("background-color",
									"rgba(255,222,144,0.5)");
						}
					},
					error : function(request, status, error) {
						console.log("에러");
						$("#password").css("background-color",
								"rgba(255,150,100,0.6)");
					}
				})
	}, 10000)
</script>
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