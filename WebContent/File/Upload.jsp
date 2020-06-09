<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FILE UPLOAD WINDOW</title>
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
</head>
<body>
	<form action="../upload_file.file" method="post"
		enctype="multipart/form-data" name="form">
		<input type="hidden" name="Size">
		<div class="alert alert-primary" role="alert">
			<input type="hidden" name="id" value="${id }"> <b
				style="color: blue;">ファイル:</b> <input type="file" name="files"
				id="upfile" class="btn btn-outline-primary" /> <input type="button"
				value="Upload" class="btn btn-warning"
				onclick="fileCheck( this.form.file )" />
		</div>

	</form>
	<script type="text/javascript">
		$('#upfile')
				.on(
						'change',
						function() {

							ext = $(this).val().split('.').pop().toLowerCase(); //확장자

							//배열에 추출한 확장자가 존재하는지 체크
							if ($.inArray(ext, [ 'gif', 'png', 'jpg', 'jpeg',
									'txt' ]) != -1) {
								resetFormElement($(this)); //폼 초기화
								window
										.alert('イメージファイルではありません! (gif, png, jpg, jpeg, txt 는 업로드 불가능)');
							}
						})
		function resetFormElement(e) {
			e.wrap('<form>').closest('form').get(0).reset();
			//리셋하려는 폼양식 요소를 폼(<form>) 으로 감싸고 (wrap()) , 
			//요소를 감싸고 있는 가장 가까운 폼( closest('form')) 에서 Dom요소를 반환받고 ( get(0) ),
			//DOM에서 제공하는 초기화 메서드 reset()을 호출
			e.unwrap(); //감싼 <form> 태그를 제거
		}
	</script>
	<script type="text/javascript">
		/* 업로드 체크 */
		function fileCheck(file) {
			// 사이즈체크
			var maxSize = 1024 * 1024 * 1024 //1GB
			var fileSize = 0;

			// 브라우저 확인
			var browser = navigator.appName;

			// 익스플로러일 경우
			if (browser == "Microsoft Internet Explorer") {
				var oas = new ActiveXObject("Scripting.FileSystemObject");
				fileSize = oas.getFile(file.value).size;
			}
			// 익스플로러가 아닐경우
			else {
				fileSize = document.getElementById("upfile").files[0].size;

			}

			alert("파일사이즈 : " + fileSize + "Byte" + ", 최대파일사이즈 : 1GB");

			if (fileSize > maxSize) {
				alert("첨부파일 사이즈는 5MB 이내로 등록 가능합니다.    ");
				return;
			}
			form.Size.value = fileSize;
			form.submit();
		}
	</script>
</body>
</html>