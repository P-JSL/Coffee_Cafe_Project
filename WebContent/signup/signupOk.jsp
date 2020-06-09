<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
	<c:when test="${result == 1 }">
		<script type="text/javascript">
			alert("会員登録できました。歓迎いたします。ごゆっくりお過ごしください。");
			location.href = "user?command=loginmove";
		</script>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
			alert("登録に失敗しました。　正しく書いてください。");
			history.go(-1);
		</script>
	</c:otherwise>
</c:choose>