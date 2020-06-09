<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>

<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote-bs4.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote-bs4.min.js"></script>
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<style>
.modal-backdrop.show {
	position: inherit;
}

img {
	max-height: 50%;
	max-width: 50% !important;
}
</style>
<section class="section pt-4 bg-light">
	<div class="container">
		<div class="row">
			<div class="col-lg-8 blog-content">
				<p>${nvo.userid }@<fmt:formatDate value="${nvo.news_date }"
						pattern="yyyy-MM-dd HH:mm" />
				</p>
				<h3 style="border-bottom: 1px solid #555;" class="mb-4">${nvo.title }</h3>
				<p>
					<img src="news_upload/${nvo.photo }" alt="Image"
						class="img-fluid rounded">
				</p>
				<p class="lead">${nvo.content }</p>
				<hr>
				<c:if test="${sessionScope.user == 2 }">
					<a href="news?command=newsModifyMove&num=${nvo.num }" class="btn"
						style="font-family: monospace; font-weight: bold; font-size: 1rem; background: rgb(255, 196, 46)">修正</a>
					<a href="news?command=newsDelete&num=${nvo.num }"
						class="btn btn-danger"
						style="font-family: monospace; color: #fff; font-weight: bold; font-size: 1rem">削除</a>
				</c:if>
				<a href="javascript:history.go(-1);" class="btn btn-outline-info"
					style="font-family: monospace; font-weight: bold; font-size: 1rem">戻る</a>
				<hr>
				<div class="pt-5">
					<h3 class="mb-5">${comc }件のコメント</h3>
					<ul class="comment-list">
						<c:forEach var="r" items="${rnvo }">
							<hr>
							<li class="comment" style="list-style: none;">
								<div class="comment-body">
									<b> <i class="fa fa-lightbulb-o" aria-hidden="true"></i>&nbsp;&nbsp;&nbsp;${r.userid }
									</b> <br />
									<hr>
									<div class="meta">
										<fmt:formatDate value="${r.reply_date }"
											pattern="yyyy-MM-dd HH:mm" />
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;삭제:<i
											class="fa fa-minus-square-o fa-lg" aria-hidden="true"></i>
									</div>
									<p>${r.re_comment }</p>
								</div>
							</li>
						</c:forEach>
					</ul>
					<hr>
					<!-- END comment-list -->
					<c:if test="${sessionScope.user >=1 }">
						<div class="comment-form-wrap pt-5">
							<h3 class="mb-5">コメント</h3>
							<form action="#" method="post" name="com">
								<input type="hidden" value="${nvo.num }" name="num">
								<div class="form-group">
									<label for="name">ID *</label> <input type="text"
										class="form-control" id="id" name="id" value="${nvo.userid }"
										readonly>
								</div>
								<div class="form-group">
									<label for="email">Massage</label>
									<textarea id="summernote" name="comment"></textarea>

								</div>
								<div class="form-group">
									<input type="submit" value="コメント"
										class="btn btn-primary btn-md" id="CMT"> <a
										href="header?command=News" class="btn btn-info btn-md">戻る
									</a>
								</div>
							</form>
						</div>
					</c:if>
				</div>
			</div>
		</div>
	</div>
</section>
<script type="text/javascript">
	$("#CMT").on("click", function(e) {
		var id = com.id.value;
		var msg = com.comment.value;
		var num = com.num.value;
		e.preventDefault();
		$.ajax({
			url : "news?command=newsreply",
			type : "post",
			data : {
				id : id,
				comment : msg,
				num : num
			},
			datatype : "json"
		}).done(function(data) {
			console.log(data);
			if (data.ok == 1) {
				location.reload();
			}
		}).fail(function(data) {
			console.log(data);
			return false;
		});
	})
</script>
<script>
	$('#summernote').summernote(
			{
				placeholder : 'Hello Bootstrap 4',
				tabsize : 2,
				height : 100,
				lang : "ja-JP",
				height : 250,
				toolbar : [ [ 'style', [ 'style' ] ],
						[ 'font', [ 'bold', 'underline', 'clear' ] ],
						[ 'color', [ 'color' ] ],
						[ 'para', [ 'ul', 'ol', 'paragraph' ] ],
						[ 'table', [ 'table' ] ],
						[ 'insert', [ 'link', 'picture', 'video' ] ],
						[ 'view', [ 'fullscreen', 'codeview', 'help' ] ] ]
			});
</script>

<%@include file="../footer.jsp"%>
</body>
</html>