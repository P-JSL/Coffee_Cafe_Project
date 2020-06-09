<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String p = request.getContextPath();
%>
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<link href="<%=p%>/css/table.css">
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
<style type="text/css">
.row>div>div>img {
	display: inline-block;
	height: auto;
	max-width: 100%;
}

.ml {
	margin-left: 25px;
}

.backgrounds {
	background-image: url("img/winter.jpg");
	background-color: rgba(255, 255, 255, 0.5);
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
	background-attachment: fixed;
	background-clip: border-box;
}

.op1 {
	background: rgba(255, 255, 255, 0.7);
}
</style>
<div class="backgrounds">
	<div class="container">
		<section class="section pt-6 op1">
			<div class="container">
				<div class="row text-center">

					<div class="col-lg-12 blog-content">
						<div class="row">
							<div class="col-md-12 border ">コーヒー豆が大勢に席を占める以前、コーヒー世界の先頭はミックスコーヒーでした。
								今は「インスタント」という烙印を押さえられましたが、特有の甘味が好みの方は今だにもよく楽しみながらお飲みになっています。
								ミックスコーヒーをおいしく飲む方法があることはご存知でしたか?</div>
						</div>
						<c:set var="no" value="${count-(nowpage-1) }"></c:set>
						<c:forEach var="h" items="${list }">
							<input type="hidden" value="${h.num }" name="num" id="num">
							<div class="row">
								<table class="table table-bordered">
									<colgroup>
										<col width="7%;">
										<col width="80%;">
										<col width="8%">
										<col width="5%;">
									</colgroup>
									<tbody>
										<tr style="text-align: center;">
											<td style="font-size: 12px;">${nowpage }p/${totalpage }p</td>
											<td>Chapter ${no }</td>
											<td>HIT:${h.readcount }</td>
											<td><i id="like" class="fa fa-thumbs-o-up"
												aria-hidden="true"
												style="text-align: right; margin-right: 5px;"></i>${h.likes }</td>
										</tr>
										<tr style="text-align: center;">
											<td colspan="4">${h.title }

												<p>
													<a href="hmc?command=HmcView&num=${h.num }"
														class="btn btn-danger" id="reading"
														style="margin-top: 15px;">読む</a>
												</p>
											</td>
										</tr>
									</tbody>
								</table>
							</div>
							<c:set var="no" value="${no-1 }"></c:set>
						</c:forEach>
					</div>
				</div>
			</div>
			<form action="header?command=HMC" name="paging" method="post">
				<div class="input-group" style="justify-content: center;">
					<input type="button" value="次" class="btn btn-info" id="more">
					<input type="button" value="以前" class="btn btn-danger" id="nomore">
					<input type="hidden" name="page" id="page" value="${nowpage }">
				</div>
			</form>
			<c:if test="${sessionScope.id !=null && sessionScope.user ==2 }">
				<p style="text-align: center;">
					<a href="hmc?command=HmcWriteMove" class="btn btn-info">作成</a>
				</p>
			</c:if>
		</section>
	</div>
</div>
<script type="text/javascript">
	$("#like").on("click", function() {
		var num = $("#num").val();
		$.ajax({
			url : "ajax?command=like",
			type : "post",
			data : {
				num : num
			},
			dataType : "json"
		}).done(function(data) {
			$(this).text(data.like);
		}).fail(function(data) {
			console.log("Fail");
		});
	})
</script>
<script type="text/javascript">
	var page = $("#page").val();
	$("#more").on("click", function() {
		var totpage = $
		{
			totalpage
		}
		;
		page++;
		if (page > totpage) {
			page = totpage;
		}
		$("#page").val(page);

		paging.submit();

	})
	$("#nomore").on("click", function() {
		page--;
		if (page < 1) {
			page = 1;
		}
		$("#page").val(page);

		paging.submit();
	})
</script>
<%@include file="../../footer.jsp"%>