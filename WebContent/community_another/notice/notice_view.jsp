<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String p = request.getContextPath();
%>
<c:choose>
	<c:when test="${sessionScope.user == 0 }">
		<c:import url="../../header_0.jsp"></c:import>
	</c:when>
	<c:when test="${sessionScope.user == 1 }">
		<c:import url="../../header.jsp"></c:import>
	</c:when>
	<c:when test="${sessionScope.user==2 }">
		<c:import url="../../header_2.jsp"></c:import>
	</c:when>
</c:choose>
<style>
.comment-list {
	background: rgba(123, 237, 159, .45) !important;
}
</style>
<section class="section pt-4 bg-light">
	<div class="container">
		<div class="row">
			<div class="col-lg-8 blog-content">
				${nvo.userid } /
				<fmt:formatDate value="${nvo.n_date}" pattern="yyyy-MM-dd HH:MM" />
				&nbsp;<b>#ヒット:${nvo.n_count }</b>
				<h3 style="border-bottom: 1px solid #555;" class="mb-4">${nvo.n_title }</h3>

				<p>${nvo.n_content }</p>

				<div class="pt-5">
					<hr>
					<h4 class="mb-5">${count }件のコメントがあります。</h4>
					<hr>
					<ol class="comment-list">
						<c:forEach var="rep" items="${clist }">

							<li class="comment"><input type="hidden" name="num"
								value="${rep.num }">
								<div class="comment-body">
									<div class="meta">${rep.userid }@<fmt:formatDate
											value="${rep.reply_date }" pattern="yyyy/MM/dd HH:MM" />
									</div>

								</div> <br /> コメント : <span>${rep.re_comment }</span><br /> <br /> <c:choose>
									<c:when
										test="${sessionScope.id !=null  && sessionScope.user==2}">
										<p>
											<a href="javascript:void(0);"><i
												class="fa fa-trash-o fa-2x" id="delete" aria-hidden="true"
												style="color: red;"></i></a>
										</p>
									</c:when>
									<c:otherwise>

									</c:otherwise>
								</c:choose></li>
							<hr>
						</c:forEach>
					</ol>
					<!-- END comment-list -->

					<form action="notice?command=noticeReply" class="form-group"
						method="post" name="fm" onsubmit="return sending(e);">
						<c:if test="${sessionScope.user >= 1 }">
							<div class="comment-form-wrap pt-5">
								<h3 class="mb-5">comment</h3>
								<div class="form-group">
									<label for="ID">ID *</label> <input type="text"
										class="form-control" id="ID" name="ID"
										value="${sessionScope.id }" readonly>
								</div>
								<div class="form-group">
									<label for="message">Message *</label>
									<textarea name="comment" id="message" cols="30" rows="10"
										class="form-control"></textarea>
								</div>
								<div class="form-group">
									<input type="submit" value="コメント"
										class="btn btn-outline-success" id="on"> <a
										href="javascript:history.go(-1);" class="btn btn-outline-danger">戻る</a>
								</div>
							</div>
						</c:if>
					</form>
				</div>
			</div>
		</div>
	</div>
</section>
<script type="text/javascript">
	$("#on").on("click", function(e) {
		sending(e);
		var num = '${nvo.num}';
		var id = fm.ID.value;
		var msg = fm.comment.value;
		$.ajax({
			url : "notice?command=noticeReply",
			Type : "post",
			data : {
				id : id,
				msg : msg,
				num : num
			},
			dataType : "json",
			success : function(response) {
				if (response.ok == 1) {
					alert("성공");
					location.reload(true);
				} else if (response.no == 1) {
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
	$(".comment > p > a > #delete").on(
			"click",
			function() {
				var list = $(this).parent().parent().parent().eq(0).children()
						.children().text();
				var k = list.indexOf("@");
				var id = list.substr(0, k); // id
				var num = $(".comment").children().eq(0).val();
				$.ajax({
					url : "ajax?command=Notice_Reply_Delete",
					type : "post",
					data : {
						id : id,
						num : num
					},
					datatype : "json",
					success : function(response) {
						if (response.complete == 1) {
							location.reload();
						} else {
							alert("ログインしてください。");
							location.href = "index?command=indexSelect";
						}
					},
					error : function(request, status, error) {
						alert("ERROR");
					}
				});
			})
</script>
<%@include file="../../footer.jsp"%>
</body>
</html>