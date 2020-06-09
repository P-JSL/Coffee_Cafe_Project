<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:choose>
	<c:when test="${sessionScope.user==0}">
		<c:import url="../../header_0.jsp"></c:import>

	</c:when>
	<c:when test="${sessionScope.user==1 }">
		<c:import url="../../header.jsp"></c:import>
	</c:when>
	<c:when test="${sessionScope.user==2 }">
		<c:import url="../../header_2.jsp"></c:import>
	</c:when>
</c:choose>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote-bs4.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote-bs4.min.js"></script>
<style>
.modal-backdrop.in, .modal-backdrop {
	position: inherit;
}

.comment-body>p>img {
	max-height: 150px;
	max-width: 250px;
}

.comment-list {
	background: rgba(112, 161, 255, 0.3) !important;
}
</style>
<section class="section pt-4 bg-light">
	<div class="container">
		<div class="row">
			<div class="col-lg-8 blog-content">
				<h3 style="border-bottom: 1px solid #555;">${bvo.b_title }
					<small><fmt:formatDate value="${bvo.b_date }"
							pattern="yy/MM/dd" /></small>
				</h3>
				<p style="text-align: right; font-size: 1.2rem;">${bvo.b_count }</p>
				<p class="lead">${bvo.b_content }</p>
				<hr>
				<div class="pt-5">
					<h3 class="mb-5" style="text-align: center;">${count }&nbsp;Comment</h3>
					<ul class="comment-list">
						<c:forEach var="c" items="${commentlist }">
							<hr>
								<input type="hidden" value="${c.num }" name="num">
							<ol class="comment">
								<div class="comment-body">
									ID :<b style="margin-top: 25px;">${c.userid }</b>
									<div class="meta">
										作成日 :
										<fmt:formatDate value="${c.reply_date }" pattern="yyyy-MM-dd" />
									</div>
									コメント :
									<p>${c.re_comment }</p>

									<c:choose>
										<c:when test="${sessionScope.id !=null }">
											<p>
												<a href="javascript:void(0);"><i
													class="fa fa-trash-o fa-2x" id="delete" aria-hidden="true"
													style="color: red;"></i></a>
											</p>
										</c:when>
										<c:otherwise>

										</c:otherwise>
									</c:choose>
								</div>
							</ol>
							<hr>
						</c:forEach>
					</ul>
					<!-- END comment-list -->
					<c:choose>
						<c:when test="${sessionScope.id != null  && sessionScope.user>=1}">
							<div class="comment-form-wrap pt-5">
								<h3 class="mb-5">Reply</h3>
								<form action="board?command=reply" method="post" name="fm"
									onsubmit="return sending(e);" id="fm">
									<input type="hidden" value="<%=request.getParameter("num")%>"
										name="num"> <input type="hidden"
										value="${sessionScope.id}" name="id">
									<div class="form-group">
										<label for="message">Message</label>
										<textarea id="summernote" name="comment"></textarea>
									</div>
									<div class="form-group">
										<input type="submit" value="コメント"
											class="btn btn-outline-success" id="on"> <a
											href="javascript:history.go(-1);"
											class="btn btn-outline-danger">戻る</a>

									</div>
								</form>
							</div>

						</c:when>
						<c:otherwise>
							<a href="javascript:history.go(-1);"
								class="btn btn-outline-secondary">戻る</a>
						</c:otherwise>
					</c:choose>

				</div>
			</div>
		</div>
	</div>
</section>
<script type="text/javascript">
	$("#on").on("click", function(e) {
		sending(e);
		var num = fm.num.value;
		var id = fm.id.value;
		var msg = fm.comment.value;
		console.log(num);
		console.log(id);
		console.log(msg);
		$.ajax({
			url : "board?command=reply",
			Type : "post",
			data : {
				id : id,
				msg : msg,
				num : num
			},
			dataType : "json",
			success : function(response) {
				if (response.rt == 1) {
					alert("성공");
					location.reload(true);
				} else if (response.rt == 1) {
					error();
				}
			},
			error : function(request, status, error) {
				alert("실패");

			}
		})
	})

	function sending(e) {
		e.preventDefault();
	}
</script>
<script type="text/javascript">
	$(".comment-body> p > a> #delete").on(
			"click",
			function() {
				var ok = confirm("コメントを消しますか？");
				var id = '${sessionScope.id}';

				var thisid = $("#delete").parents(".comment-body").children()
						.eq(0).text();
				console.log(thisid);
				var number = $(this).parents(".comment").prev().val();
				console.log(number);

				if ((ok == true) && (id == thisid)) {
					$.ajax({
						url : "ajax?command=ReplyDelete",
						Type : "post",
						data : {
							id : id,
							num : number
						},
						datatype : "json",
						success : function(response) {
							if (response.ok == 1) {

								alert("コメントが削除しました。");
								console.log("성공");
								location.reload();
							}
						},
						error : function(request, status, error) {
							console.log("실패");
							history.go(-1);
						}
					});
				} else {
					alert("消しません。　IDを確かめてください。");
					return false;
				}
			})
</script>
<script type="text/javascript">
	$('#summernote').summernote(
			{
				placeholder : 'Hello stand alone ui',
				tabsize : 2,
				height : 120,
				toolbar : [ [ 'style', [ 'style' ] ],
						[ 'font', [ 'bold', 'underline', 'clear' ] ],
						[ 'color', [ 'color' ] ],
						[ 'para', [ 'ul', 'ol', 'paragraph' ] ],
						[ 'table', [ 'table' ] ],
						[ 'insert', [ 'link', 'picture', 'video' ] ],
						[ 'view', [ 'fullscreen', 'codeview', 'help' ] ] ]
			});
</script>

<%@include file="../../footer.jsp"%>