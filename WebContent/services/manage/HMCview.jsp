<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../header.jsp"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="../../css/test.css">
<div class="body">
	<div class="wrapper">
		<div class="book">
			<div class="book-cover">
				<div class="header-image img3">
					<div class="overlay"></div>
				</div>
				<div class="title-wrap">
					<h1 class="article-title">How to select good COFFEE BEAN`s</h1>
				</div>
				<p class="book-cover-expert">
					<br> <br> <span class="social"> <i
						class="fa fa-facebook"></i> <i class="fa fa-twitter"></i> <i
						class="fa fa-linkedin"></i> <i class="fa fa-instagram"></i>
					</span>
				</p>
				<p></p>
			</div>


			<div class="book-content">
				<p>
					<span class="drop-cap">O</span>
				</p>
			</div>

		</div>

	</div>
</div>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript">
	$('.book').on('click', function() {
		$(this).toggleClass('book-expanded');
	})
</script>
<%@include file="../../footer.jsp"%>