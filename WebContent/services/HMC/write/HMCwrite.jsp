<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String p = request.getContextPath();
%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${sessionScope.user == 1 }">
		<c:import url="../../../header.jsp"></c:import>
	</c:when>
	<c:when test="${sessionScope.user ==2 }">
		<c:import url="../../../header_2.jsp"></c:import>
	</c:when>
	<c:otherwise>
	</c:otherwise>
</c:choose>
<script src="<%=p%>/js/jquery.slim.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"
	integrity="sha384-6khuMg9gaYr5AxOqhkVIODVIvm9ynTT5J4V1cfthmT+emCG6yVmEZsRHdxlotUnm"
	crossorigin="anonymous"></script>
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote-lite.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote-lite.min.js"></script>
<script src="<%=p%>/dist/lang/summernote-ja-JP.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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

.note-modal-backdrop{
	position: inherit;
}
</style>

<section class="section pt-4 bg-light">
	<div class="container">
		<div class="row">
			<div class="col-lg-8 blog-content">
				<form action="hmc?command=HmcInsert" name="write" method="post"
					class="form-group">
					<input type="hidden" name="id" value="${sessionScope.id }">
					<h3 style="border-bottom: 1px solid #555;" class="mb-4">
						<input type="text" name="h_title" placeholder="제목을 입력해주세요."
							class="form-control">
					</h3>
					<textarea name="h_content" id="summernote"></textarea>

					<div class="btn-group" style="margin-top: 15px;">
						<div class="form-group">
							<input type="submit" value="作成" class="btn btn-primary"
								class="form-control"> <input type="reset" value="リセット"
								class="btn btn-danger" class="form-control"> <a
								type="submit" href="../HMC.jsp" class="btn btn-info"
								class="form-control">戻る</a>
						</div>
					</div>
				</form>
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
						},
						fontNames : [ 'Arial', 'Arial Black', 'Comic Sans MS',
								'Courier New', 'Merriweather' ],
						fontNamesIgnoreCheck : [ 'Merriweather' ],
						lineHeights : [ '0.2', '0.3', '0.4', '0.5', '0.6',
								'0.8', '1.0', '1.2', '1.4', '1.5', '2.0', '3.0' ],

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
<%@include file="../../../footer.jsp"%>