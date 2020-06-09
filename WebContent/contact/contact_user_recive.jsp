<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="col-md-6"
			style="border: 3px double black; padding: 40px; height: 100%;">
			<div>
				<h4 style="text-align: center;">メッセージ</h4>
			</div>
			<div class="form-group">
				<label for="id" class="col-sm-3 control-label">ID</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="id" name="ids"
						value="<%=request.getParameter("id")%>" readonly="readonly">
				</div>
				<div class="form-group">
					<label for="msg" class="col-sm-3 control-label">Massage : </label>
					<div class="col-sm-9">
						<span class="form-control" id="msg"><%=request.getParameter("msg")%></span>
					</div>
				</div>
			</div>
			<div class="input-form" style="text-align: center;">
				<a href="javascript:self.close();" class="btn btn-info">閉める</a>
			</div>

		</div>
	</div>
</body>
</html>