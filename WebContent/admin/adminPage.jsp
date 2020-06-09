<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<style>
.select {
	font-size: 18px;
}

.table tbody tr:nth-child(2)>td:nth-child(3)>p:nth-child(1) {
	text-align: inherit!impartant;
	margin-right: 20px;
	display: inline-block;
}

.table tbody tr:nth-child(2)>td:nth-child(3)>p:nth-child(2) {
	display: inline-block;
}

.table tbody tr:nth-child(2)>td:nth-child(3)>p:nth-child(2)>img {
	max-height: 130px;
	max-width: 170px;
}

.table>tbody>tr>td:nth-child(3)>p {
	text-align: center !important;
}

.card {
	margin-left: 25px;
}
</style>
<div class="container">
	<!-- Swiper -->
	<div class="swiper-container">
		<div class="swiper-wrapper">
			<div class="swiper-slide">
				<h3>ADMIN MANAGE</h3>
				<div class="form-group">
					<div class="btn-group">
						<button id="ADMIN" class="btn btn-outline-info btn-sm">ADMIN</button>
						<button id="CONTACT" class="btn btn-outline-success btn-sm">CONTACT</button>
						<button id="USER" class="btn btn-outline-warning btn-sm">USER</button>
						<button id="MANAGEMENT" class="btn btn-outline-light btn-sm">MANAGEMENT</button>
						<button id="GALLERY" class="btn btn-outline-danger">GALLERY</button>
					</div>
				</div>
				<div class="admin">
					<div class="container">
						<h4>管理者 作成目録</h4>
						<table class="table">
							<thead>
								<tr>
									<th>番号</th>
									<th>タイトル</th>
									<th>作成者</th>
									<th>作成日時</th>
									<th>ヒット数</th>
									<th colspan="2">・・</th>
								</tr>
							</thead>
							<tbody>
								<c:set var="no" value="${count - (nowpage - 1) * 3 }"></c:set>
								<c:forEach var="n" items="${nlist }">
									<tr>
										<td>${no }</td>
										<td>${n.n_title }</td>
										<td>${n.n_content }</td>
										<td><fmt:formatDate value="${n.n_date }"
												pattern="yyyy-MM-dd" /></td>
										<td>${n.n_count }</td>
										<td><a type="button"
											href="admin?command=admin_notice_modify_move&num=${n.num }">修正</a></td>
										<td><a type="button"
											href="admin?command=admin_notice_delete&num=${n.num }"
											onclick="return nott();">削除</a></td>
									</tr>
									<c:set value="${no-1 }" var="no"></c:set>
								</c:forEach>
							</tbody>
						</table>
						<!-- Start Pagination -->
						<ul class="pagination">${page }
						</ul>
						<!-- End Pagination -->
					</div>
				</div>
				<div class="contact">
					<div class="container">
						<h4>CONTACT</h4>
						<table class="table container">
							<thead>
								<tr class="success">
									<th>返事</th>
									<th>番号</th>
									<th>ID</th>
									<th>内容</th>
									<th>メール</th>
									<th>作成日</th>
									<th colspan="1">…</th>
								</tr>
							</thead>
							<tbody>
								<c:set var="nos" value="${count1 - (nowpage1 - 1 ) * 3}"></c:set>
								<c:forEach var="ct" items="${nlist1 }">

									<tr>
										<td><c:choose>
												<c:when test="${ct.res_confirm == 0 }">
													<i class="fa fa-times" aria-hidden="true"></i>
												</c:when>
												<c:when test="${ct.res_confirm==1 }">
													<i class="fa fa-check" aria-hidden="true"></i>
												</c:when>
											</c:choose></td>
										<td>${nos }</td>
										<td>${ct.id }</td>
										<td>${ct.msg }</td>
										<td>${ct.email }</td>
										<td><fmt:formatDate value="${ct.send_date }"
												pattern="yyyy-MM-dd" /></td>
										<td><c:choose>
												<c:when test="${ct.res_confirm == 0 }">
													<a type="button"
														href="cont?command=contResponse&num=${ct.num }">返事</a>
												</c:when>
												<c:when test="${ct.res_confirm ==1 }">
												</c:when>
											</c:choose></td>
									</tr>
									<c:set var="nos" value="${nos -1 }"></c:set>
								</c:forEach>
							</tbody>
						</table>
						<!-- Start Pagination -->
						<ul class="pagination">${page1 }
						</ul>
						<!-- End Pagination -->
					</div>
				</div>
				<div class="user">
					<div class="container">
						<h4>ユーザー管理目録</h4>
						<table class="table container">
							<colgroup>
								<col width="10%;">
								<col width="10%;">
								<col width="12.5%;">
								<col width="12.5%;">
								<col width="10%;">
								<col width="10%;">
								<col width="15%;">
							</colgroup>
							<thead>
								<tr class="success">
									<th>番号</th>
									<th>ユーザーID</th>
									<th>ユーザーメール</th>
									<th>登録日</th>
									<th>接続回数</th>
									<th colspan="2">備考</th>
								</tr>
							</thead>
							<tbody>
								<c:set var="u" value="${count2 - (nowpage2 - 1)*3 }"></c:set>
								<c:forEach var="user" items="${nlist2 }">
									<tr class="success">
										<td>${u }</td>
										<td>${user.userid}</td>
										<td>${user.useremail }</td>
										<td><fmt:formatDate value="${user.signupdate }"
												pattern="yyyy-MM-dd" /></td>
										<td>${user.loginnum }</td>
										<td><a type="button" class="btn btn-outline-danger"
											href="admin?command=Admin_User_Unregister&id=${user.userid }"
											onclick="return nott();">脱退</a></td>
										<td><div class="input-group" style="width: 190px;">
												<select class="custom-select" name="admin"
													id="inputGroupSelect04"
													aria-label="Example select with button addon">
													<option value="2" selected>管理者</option>
													<option value="1">一般</option>
												</select>
												<div class="input-group-append">
													<input class="btn btn-outline-secondary" value="アップ" style="width: 100px;">
												</div>
											</div></td>
									</tr>
									<c:set var="u" value="${u-1 }">
									</c:set>
								</c:forEach>
							</tbody>
						</table>
						<!-- Start Pagination -->
						<ul class="pagination">${page2 }
						</ul>
						<!-- End Pagination -->
					</div>
				</div>
				<div class="management">
					<h3>USER MANAGEMENT</h3>
					<h4>サーブページ</h4>
					<form action="admin?command=adminPage" method="post"
						inputmode="search">
						<div class="continer input-group input-group-sm form-group">
							<select class="select" name="select">
								<option value="b_id">ID</option>
							</select> <input type="search"
								placeholder="検索するIDを書いてください。管理者のID は検索できません。" name="search"
								class="input form-control" aria-describedby="sizing-addon3"
								style="height: 35px;"> <input type="submit" value="검색"
								class="btn btn-success">
						</div>
					</form>
					<br>
					<h3>ユーザー情報</h3>
					<h4>${uid }様の情報</h4>
					<h4></h4>
					<div class="container">
						<table class="table container">
							<c:set var="m" value="${mvo }"></c:set>
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
								<td><c:choose>
										<c:when test="${hit == null or hit == 0 }">
								0</c:when>
										<c:when test="${hit != null or hit != 0 }">
								${hit }
								</c:when>
									</c:choose></td>
							</tr>
							<tr>
								<td>ログイン回数</td>
								<td>${m.loginnum }</td>
							</tr>
						</table>
					</div>
					<br />
					<h4>${uid }様の作成目録</h4>
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
							<c:set value="${count3 - (nowpage3 - 1)*5 }" var="uno"></c:set>
							<c:forEach var="user" items="${nlist3 }">
								<tr>
									<td>${uno }</td>
									<td>${user.b_title }</td>
									<td>${user.b_content }</td>
									<td>${user.b_date }</td>
									<td>${user.b_count }</td>
									<td><a type="button" href="#">修正</a></td>
									<td><a type="button" href="#" onclick="return nott();">削除</a></td>
								</tr>
								<c:set var="uno" value="${uno-1 }"></c:set>
							</c:forEach>
						</tbody>
					</table>
					<!-- Start Pagination -->
					<ul class="pagination">${page3 }
					</ul>
					<!-- End Pagination -->
				</div>
				<div class="gallery">
					<h4>All GALLERY</h4>
					<br />
					<div class="row">
						<c:forEach var="gal" items="${glist }">
							<div class="card" style="width: 15rem; margin-top: 10px;">
								<img class="card-img-top" src="Galleryupload/${gal.photo }"
									alt="Card image cap" style="height: 150px;">
								<div class="card-body">
									<h5 class="card-title"
										style="font: sans-serif; font-size: inherit; width: 100%;">
										<fmt:formatDate value="${gal.photodate }" pattern="yyyy/MM/dd" />
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
											href="gallery?command=GalDelete&num=${gal.num }"
											class="btn btn-danger btn-sm">除去</a>
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
<script type="text/javascript">
	$(window).on("load", function() {
		$(".admin").show();
		$(".contact").hide();
		$(".user").hide();
		$(".management").hide();
		$(".gallery").hide();
	})
	$("#ADMIN").on("click", function() {
		$(".admin").show();
		$(".contact").hide();
		$(".user").hide();
		$(".management").hide();
		$(".gallery").hide();
	})
	$("#CONTACT").on("click", function() {
		$(".admin").hide();
		$(".contact").show();
		$(".user").hide();
		$(".management").hide();
		$(".gallery").hide();
	})
	$("#USER").on("click", function() {
		$(".admin").hide();
		$(".contact").hide();
		$(".user").show();
		$(".management").hide();
		$(".gallery").hide();
	})
	$("#MANAGEMENT").on("click", function() {
		$(".admin").hide();
		$(".contact").hide();
		$(".user").hide();
		$(".management").show();
		$(".gallery").hide();
	})
	$("#GALLERY").on("click", function() {
		$(".admin").hide();
		$(".contact").hide();
		$(".user").hide();
		$(".management").hide();
		$(".gallery").show();
	})
</script>
<script src="<%=p%>/js/swiper.min.js"></script>
<script type="text/javascript">
	var swiper = new Swiper('.swiper-container', {
		direction : 'vertical',
		slidesPerView : 'auto',
		freeMode : true,
		scrollbar : {
			el : '.swiper-scrollbar',
		},
		mousewheel : true,
	})
</script>
<%@include file="../footer.jsp"%>