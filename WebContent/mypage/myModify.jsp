<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
<c:when test="${confirm == true }">
<script type="text/javascript">
alert("修正されました。");
history.back();
</script>
</c:when>
<c:otherwise>
<script type="text/javascript">
alert("エーラー。");
history.go(-1);
</script>
</c:otherwise>

</c:choose>
</body>
</html>