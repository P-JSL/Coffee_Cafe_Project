<%@page import="com.usagi.dao.FileDAO.FileDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<style>
table {
	border-bottom: 1px solid #2f2529;
}
</style>
<body leftmargin="60px" topmargin="50px">
	<div class="all">
		<div dir="ltr" lang="ja-JP">
			<div class="col-md-10">
				<div class="header" style="text-align: center;">全ファイル</div>
			</div>
			<hr />
			<table width="900px" border="1px solid grey;" frame="void"
				rules="groups">
				<tbody style="text-align: center;">
					<tr class="Header">
						<td width="30%" height="30px" valign="top">ファイル名</td>
						<td width="30%" height="30px" valign="top">ユーザー名</td>
						<td width="10%" height="30px" valign="top">サイズ</td>
						<td width="30%" height="30px" valign="top">アップロード日</td>
					</tr>
				</tbody>
				<tbody style="text-align: center;">
					<tr>
						<td height="10px" colspan="3"></td>
					</tr>
					<c:forEach var="All" items="${AllFiles }">
						<tr>
							<td class="Regular"><a href="filefolder/${All.files }">${All.files }</a></td>
							<c:choose>
								<c:when test="${FileDAO.getInstance().File_U_F(All.num) != 2}">
									<td class="Secondary">${All.userid }</td>
								</c:when>
								<c:otherwise>
									<td class="Secondary">管理者</td>
								</c:otherwise>
							</c:choose>
							<td>${All.size }Byte</td>
							<td class="Secondary"><fmt:formatDate
									value="${All.upload_day }" pattern="yyyy年/MM月/dd日" /></td>
						</tr>
					</c:forEach>
					<tr>
						<td height="10px" colspan="3"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<div class="user">
		<div dir="ltr" lang="ja-JP">
			<div class="col-md-10">
				<div class="header" style="text-align: center;">私のファイル</div>
			</div>
			<hr />
			<table width="900px" border="1px" frame="void" rules="groups">
				<tbody style="text-align: center;">
					<tr class="Header">
						<td width="30%" height="30px" valign="top">ファイル名</td>
						<td width="30%" height="30px" valign="top">ユーザー名</td>
						<td width="10%" height="30px" valign="top">サイズ</td>
						<td width="30%" height="30px" valign="top">アップロード日</td>
					</tr>
				</tbody>
				<tbody style="text-align: center;">
					<tr>
						<td height="10px" colspan="3"></td>
					</tr>
					<c:forEach var="Alls" items="${UserFiles }">
						<tr>
							<td class="Regular"><a href="filefolder/${Alls.files }">${Alls.files }</a></td>
							<c:choose>
								<c:when test="${FileDAO.getInstance().File_U_F(Alls.num) != 2}">
									<td class="Secondary">${Alls.userid }</td>
								</c:when>
								<c:otherwise>
									<td class="Secondary">管理者</td>
								</c:otherwise>
							</c:choose>	<td>${Alls.size }Byte</td>
							<td class="Secondary"><fmt:formatDate
									value="${Alls.upload_day }" pattern="yyyy年/MM月/dd日" /></td>
						</tr>
					</c:forEach>
					<tr>
						<td height="10px" colspan="3"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
<div class="btn-group col-md-9 pt-4" role="group"
	aria-label="Basic example">
	<div class="col-md-3 col-md-offset-3"></div>
	<div class="btn-group">
		<button type="button" class="btn btn-outline-primary" id="All">全て</button>
		<div class="col-md-1 col-md-offset-1"></div>
		<button type="button" class="btn btn-outline-success" id="USER">私のファイル</button>
	</div>
</div>
<script type="text/javascript">
	$(window).on("load", function() {
		$(".all").show();
		$(".user").hide();
	})
	$("#All").click(()=>{
		$(".all").show();
		$(".user").hide();
	}) 
	$("#USER").click(()=> {
		$(".all").hide();
		$(".user").show();
	})
</script>
</html>