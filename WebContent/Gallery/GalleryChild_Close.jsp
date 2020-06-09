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
		<c:when test="${result==1 }">
			<script type="text/javascript">
				opener.parent.location.reload();
				self.close();
			</script>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				history.go(-1);
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>