<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../header.jsp"%>
<section class="section bg-light bottom-slant-gray">

	<div class="container">
		<form action="#" method="post" name="log" class="log">
			<div class="col-lg-6" style="margin: 0 auto;">
				<div class="container">
					<h2>Password確認</h2>
					<div class="row ">
				
						<div class="col-md-6 form-group">
							<label for="password">Password</label> <input type="password" id="password"
								class="form-control">
						</div>
						<div class="col-md-6 form-group">
							<label for="pw_auth">Password</label> <input type="password" id="pw_auth"
								class="form-control">
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
<%@include file="../footer.jsp"%>