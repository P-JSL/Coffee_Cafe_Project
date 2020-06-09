<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String p = request.getContextPath();
%>

<c:choose>
	<c:when test="${sessionScope.user==1 }">
		<c:import url="../../header.jsp"></c:import>
	</c:when>
	<c:when test="${sessionScope.user==2 }">
		<c:import url="../../header_2.jsp"></c:import>
	</c:when>
</c:choose>
<script src="<%=p%>/js/jquery.slim.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote-lite.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote-lite.min.js"></script>
<script src="<%=p%>/dist/lang/summernote-ja-JP.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="<%=p%>/js/validity.js"></script>
<style>
.visually-hidden {
	position: absolute !important;
	height: 1px;
	width: 1px;
	overflow: hidden;
	clip: rect(1px, 1px, 1px, 1px);
}

input.visually-hidden:focus+label {
	outline: thin dotted;
}

ul, ol {
	list-style: none;
	padding-left: 0px;
}

.note-modal-backdrop {
	position: inherit;
}
</style>

<section class="section pt-4 bg-light">
	<div class="container">
		<div class="row">
			<div class="col-lg-8 blog-content">
				<form action="../../board" name="write" method="post"
					class="form-group">
					<input type="hidden" name="command" value="boardInsert"> <input
						type="hidden" value="off" id="password-on" name="password-on">
					<input type="hidden" value="${sessionScope.id }" name="id">
					<h3 style="border-bottom: 1px solid #555;">
						<input type="text" name="title" placeholder="제목을 입력해주세요."
							class="form-control">
					</h3>



					<textarea name="content" id="summernote"></textarea>
					<i class="fa fa-unlock fa-2x" id="lock"></i> <br />

					<div class="btn-group" style="margin-top: 20px;">
						<div class="form-group">
							<input type="submit" value="書く"
								class="btn btn-outline-success active btn-md"
								class="form-control"> <a
								href="../../header?command=Board"
								class="btn btn-outline-secondary active">戻る</a>
						</div>
					</div>
				</form>
				<!-- END comment-list -->

			</div>
		</div>
	</div>
</section>
<script type="text/javascript">
	$("#lock").css({
		"cursor" : "pointer",
		"margin-top" : "10px"
	});
	$("#lock").on("click", function() { // unlock

		var c = $(this).attr("class"); //6
		var lock = c.substring(c.indexOf("l"), c.indexOf("k") + 1);
		var onoff = $("#password-on").val();
		if (onoff == "off") {
			console.log("onoff=off? : " + (onoff == "off"));
			$("#password-on").val("on");
			$(this).after('<input type="password" name="b_pw">');
			$(this).next().css({
				"margin-left" : "10px",
				"margin-top" : "-3px"
			});
			$(this).next().attr("placeholder", "パスワード")
			$(this).removeClass();
			$(this).addClass("fa");
			$(this).addClass("fa-lock");
			$(this).addClass("fa-2x");
			console.log("unlock --> lock: " + c);
		} else if (onoff = "on") {
			console.log("onoff=on? : " + (onoff == "on"));
			$("#password-on").val("off");
			$(this).removeClass();
			$(this).addClass("fa");
			$(this).addClass("fa-unlock");
			$(this).addClass("fa-2x");
			$(this).next().remove();
			console.log("lock --> unlock: " + c);
		}
	})
</script>
<script>
	$('#summernote')
			.summernote(
					{
						placeholder : 'Hello stand alone ui',
						tabsize : 2,
						height : 300, // set editor height
						minHeight : null, // set minimum height of editor
						maxHeight : null,
						lang : 'ja-JP',// set maximum height of editor
						focus : true, // set focus to editable area after initializing summernote
						codemirror : { // codemirror options
							theme : 'monokai'

						},
						popover : {
							air : [
									[ 'color', [ 'color' ] ],
									[ 'font', [ 'bold', 'underline', 'clear' ] ] ],
							image : [
									[
											'image',
											[ 'resizeFull', 'resizeHalf',
													'resizeQuarter',
													'resizeNone' ] ],
									[
											'float',
											[ 'floatLeft', 'floatRight',
													'floatNone' ] ],
									[ 'remove', [ 'removeMedia' ] ] ],
							link : [ [ 'link', [ 'linkDialogShow', 'unlink' ] ] ],
							table : [
									[
											'add',
											[ 'addRowDown', 'addRowUp',
													'addColLeft', 'addColRight' ] ],
									[
											'delete',
											[ 'deleteRow', 'deleteCol',
													'deleteTable' ] ], ],
							air : [
									[ 'color', [ 'color' ] ],
									[ 'font', [ 'bold', 'underline', 'clear' ] ],
									[ 'para', [ 'ul', 'paragraph' ] ],
									[ 'table', [ 'table' ] ],
									[ 'insert', [ 'link', 'picture' ] ] ]
						},
						onImageUpload : function(files, editor, welEditable) {
							sendFile(files[0], editor, welEditable);
						}

					});
	$('#summernote').summernote('bold');
	$('#summernote').summernote('italic');
	$('#summernote').summernote('underline');
	$('#summernote').summernote('strikethrough');
	$('#summernote').summernote('justifyLeft');
	$('#summernote').summernote('justifyRight');
	$('#summernote').summernote('justifyCenter');
	$('#summernote').summernote('justifyFull');
</script>

<%@include file="../../footer.jsp"%>