<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../header_0.jsp"%>
<section class="section bg-light bottom-slant-gray">

	<div class="container">
		<form action="index?command=indexAuthOk" method="post" name="log" class="log">
		<input type="hidden" name="email" value="${email }">
		<input type="hidden" name="name" value="${name }">
		<input type="hidden" name="login" value="1"> <!-- 비회원 인증 여부 확인기능 , 이게 없으면 다른 링크를 못감 -->
			<div class="col-lg-6" style="margin: 0 auto;">
				<div class="container">
					<h2>メール確認</h2>
					<p>メール認証をしないと利用できません。</p>
					<div class="row ">
				
						<div class="col-md-6 form-group">
							<label for="auth">認証番号</label> <input type="text" id="auth"
								class="form-control" name="auth">
						</div>
					</div>
					<div class="col-md-6 form-group">
						<div class="row">
							<input type="submit" value="確認する" class="btn btn-primary">
						</div>
					</div>
				</div>
			</div>
		</form>


	</div>

</section>
<%@include file="../../footer.jsp"%>