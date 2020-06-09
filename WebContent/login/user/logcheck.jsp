<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${ login == 1}">
			<script type="text/javascript">
				alert("無事にログインしました。");
				location.href = "index?command=main";
			</script>
		</c:when>
		<c:when test="${login == 0 }">
			<script type="text/javascript">
				alert("エーラーです。また入力してください。");
				history.go(-1);
			</script>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				alert("エーラー。もう少し後で試してください。");
				history.go(-1);
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>