<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<style>
body {
	margin: 20px;
	font-family: "맑은 고딕";
}

#image_preview {
	display: none;
}

.custom-file-input:lang(en) ~.custom-file-label::after {
	content: "選択"
}
</style>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>

</head>
<body>
	<div class="col-md-10" style="margin: 0 auto;">
		<div class="col-md-offset-3"></div>
		<div class="IMG col-md-6" style="border: 1px solid #eee;">
			<form action="gallery?command=gallery_Insert" method="post"
				name="photo" enctype="multipart/form-data">
				<input type="hidden" value="${param.id }" name="id">
				<div id="image_preview">
					<img src="#" /> <br /> <a href="#" class="btn btn-outline-danger">Remove</a>
				</div>
				<br/>
					<label for="image">Image :</label> <br />
				<div class="custom-file">
					<input type="file" name="image" class="custom-file-input"
						id="image"> <label class="custom-file-label"
						for="customFile">イメージを選んでください。</label>
				</div>
				<!-- <input type="file"
						name="image" id="image" class="btn btn-outline-secondary" />
					 -->
				
			</form>
			<div class="btn-group col-md-6">
				<button class="btn btn-outline-success" id="upload" name="upload">アップロード</button>
				<div class="col-md-2 col-md-offset-2"></div>
				<button class="btn btn-outline-secondary" onclick="javascript:self.close();">閉め</button>

			</div>
		</div>
	</div>


	<script type="text/javascript">
		/** 
		onchange event handler for the file input field.
		It emplements very basic validation using the file extension.
		If the filename passes validation it will show the image using it's blob URL  
		and will hide the input field and show a delete button to allow the user to remove the image
		 */
		$('#image')
				.on(
						'change',
						function() {

							ext = $(this).val().split('.').pop().toLowerCase(); //확장자

							//배열에 추출한 확장자가 존재하는지 체크
							if ($.inArray(ext, [ 'gif', 'png', 'jpg', 'jpeg' ]) == -1) {
								resetFormElement($(this)); //폼 초기화
								window
										.alert('イメージファイルではありません! (gif, png, jpg, jpeg のみ　アップロード可能。)');
							} else {
								file = $('#image').prop("files")[0];
								blobURL = window.URL.createObjectURL(file);
								$('#image_preview img').attr('src', blobURL);
								$('#image_preview img').css({
									"max-height" : "360px",
									"max-width" : "640px"
								})
								$('#image_preview').slideDown(); //업로드한 이미지 미리보기 
								$(this).slideUp(); //파일 양식 감춤
							}
						});

		/**
		onclick event handler for the delete button.
		It removes the image, clears and unhides the file input field.
		 */
		$('#image_preview a').bind('click', function() {
			resetFormElement($('#image')); //전달한 양식 초기화
			$('#image').slideDown(); //파일 양식 보여줌
			$(this).parent().slideUp(); //미리 보기 영역 감춤
			return false; //기본 이벤트 막음
		});

		/** 
		 * 폼요소 초기화 
		 * Reset form element
		 * 
		 * @param e jQuery object
		 */
		function resetFormElement(e) {
			e.wrap('<form>').closest('form').get(0).reset();
			//리셋하려는 폼양식 요소를 폼(<form>) 으로 감싸고 (wrap()) , 
			//요소를 감싸고 있는 가장 가까운 폼( closest('form')) 에서 Dom요소를 반환받고 ( get(0) ),
			//DOM에서 제공하는 초기화 메서드 reset()을 호출
			e.unwrap(); //감싼 <form> 태그를 제거
		}
	</script>
	<script type="text/javascript">
		$("#upload").on("click", function() {
			if (!$('#image').val()) {
				alert("アップロードするイメージを選択してください。");
				return false;
			} else {

				photo.submit();
			}
		})
	</script>
</body>
</html>