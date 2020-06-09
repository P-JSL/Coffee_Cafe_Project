<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String p = request.getContextPath();
%>

<%@include file="../../header_2.jsp"%>
<script src="<%=p%>/js/jquery.slim.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote-lite.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote-lite.min.js"></script>
<script src="<%=p%>/dist/lang/summernote-ja-JP.js"></script>
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
				<form action="notice" name="write" method="post" class="form-group">
					<input value="noticeInsert" name="command" type="hidden"> <input
						type="hidden" name="id" value="${sessionScope.id }">
					<h3 style="border-bottom: 1px solid #555;" class="mb-4">
						<input type="text" name="title" placeholder="제목을 입력해주세요."
							class="form-control">
					</h3>
					<textarea name="content" id="summernote"></textarea>

					<div class="btn-group" style="margin-top: 10px;">
						<div class="form-group">
							<input type="submit" value="書く" class="btn btn-outline-secondary"
								class="form-control"> <a class="btn btn-outline-info"
								href="header?command=Notice">戻る</a>
						</div>
					</div>
				</form>
				<!-- END comment-list -->


			</div>
		</div>
	</div>
</section>
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
						onImageUpload : function(files, editor, welEditable) {
							sendFile(files[0], editor, welEditable);
						},
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