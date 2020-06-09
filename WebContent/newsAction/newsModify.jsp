<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String p = request.getContextPath();
%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${sessionScope.user == 1 }">
		<c:import url="../header.jsp"></c:import>
	</c:when>
	<c:when test="${sessionScope.user ==2 }">
		<c:import url="../header_2.jsp"></c:import>
	</c:when>
	<c:otherwise>
	</c:otherwise>
</c:choose>
<script src="<%=p%>/js/jquery.slim.min.js"></script>
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

.modal-backdrop.show {
	position: inherit;
}

.file_input {
	margin-top: 10px;
}

.file_input label {
	position: relative;
	cursor: pointer;
	display: inline-block;
	vertical-align: middle;
	overflow: hidden;
	width: 100px;
	height: 30px;
	background: #777;
	color: #fff;
	text-align: center;
	line-height: 30px;
}

.file_input label input {
	position: absolute;
	width: 0;
	height: 0;
	overflow: hidden;
}

.file_input input[type=text] {
	vertical-align: middle;
	display: inline-block;
	width: 400px;
	height: 28px;
	line-height: 28px;
	font-size: 11px;
	padding: 0;
	border: 0;
	border: 1px solid #777;
}

.file_input label {
	position: relative;
	cursor: pointer;
	display: inline-block;
	vertical-align: middle;
	overflow: hidden;
	width: 100px;
	height: 30px;
	background: #777;
	color: #fff;
	text-align: center;
	line-height: 30px;
	margin: 0 0 2px;
}

.file_input label input {
	position: absolute;
	width: 0;
	height: 0;
	overflow: hidden;
}

.file_input input[type=text] {
	vertical-align: middle;
	display: inline-block;
	width: 400px;
	height: 28px;
	line-height: 28px;
	font-size: 11px;
	padding: 0;
	border: 0;
	border: 1px solid #777;
}

input[type=submit], input[type=reset], .btn-group>.form-group>a {
	color: #fff;
	font-weight: bold;
}
</style>

<section class="section pt-4 bg-light">
	<div class="container" style="position: relative;">
		<div class="row">
			<div class="col-lg-10 blog-content">
				<form action="news?command=newsModify" name="write"
					enctype="multipart/form-data" method="post" class="form-group"
					onsubmit="return newscheck();">
					<input type="hidden" name="id" value="${sessionScope.id }">
					<input type="hidden" name="photo" value="${nvo.photo }">
					<input type="hidden" name="num" value="<%=request.getParameter("num")%>">

					<h3 style="border-bottom: 1px solid #555;" class="mb-4">
						<input type="text" name="n_title" class="form-control"
							value="${nvo.title }">
					</h3>
					<textarea name="n_content" id="summernote">${nvo.content }</textarea>

					<div class="file_input">
						<label> File Attach <input type="file"
							onchange="javascript:document.getElementById('file_route').value=this.value"
							name="photo" id="file">
						</label> <input type="text" readonly="readonly" title="File Route"
							id="file_route" placeholder="イメージのみ添付可能です。">
					</div>

					<div class="btn-group" style="margin-top: 10px;">
						<div class="form-group">
							<input type="submit" value="修正" class="btn btn-warning btn-md"
								class="form-control"> <input type="reset" value="リセット"
								class="btn btn-warning btn-md" class="form-control"> <a
								href="header?command=News" class="btn btn-warning btn-md">戻る</a>
						</div>
					</div>
				</form>
				<!-- END comment-list -->
			</div>
		</div>
	</div>
</section>
<script type="text/javascript">
	function newscheck() {
		var file = $("#file_route").val();
		var reg = /(.*?)\.(jpg|jpeg|png|gif)$/;
		if (!file || file == "" || !file.match(reg)) {
			alert("イメージファイルのみ添付できます。");
			document.getElementById('file_route').value = "";
			var ok = window.confirm("イメージファイル無しでもよければ確認を押してください。");
			if(ok){
				return true;
			}else{
				return false;
			}
		}
	}
</script>
<script>
	$('#summernote')
			.summernote(
					{
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
<script type="text/javascript">
	$(window).ready(function() {
		$(".modal-footer").html("");
		$(".modal-title").text("");
	})
</script>
<%@include file="../footer.jsp"%>