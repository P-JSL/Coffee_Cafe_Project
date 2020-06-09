<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:choose>
	<c:when test="${sessionScope.user  == 0 }">
		<c:import url="../header_0.jsp"></c:import>
	</c:when>
	<c:when test="${sessionScope.user == 1 }">
		<c:import url="../header.jsp"></c:import>
	</c:when>
	<c:when test="${sessionScope.user==2 }">
		<c:import url="../header_2.jsp"></c:import>
	</c:when>
</c:choose>
<script type="text/javascript"
	src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=pzhvagxt3g"></script>
<section
	class="section  pt-5 top-slant-white2 relative-higher bottom-slant-gray">
	<div id="map" style="width: 100%; height: 400px;"></div>
	<div class="container" style="margin-top: 40px;">
		<div class="row">
			<div class="col-lg-6">
				<div class="row">
					<div class="col-md-12 form-group" style="text-align: center;">
						<h4>${cvo.id }様</h4>
					</div>
					<div class="col-md-12 form-group">
						<label for="name">Name</label> <input type="text" id="name"
							class="form-control " name="name" value="${cvo.name }"
							readonly="readonly">
					</div>
				</div>
				<div class="row">
					<div class="col-md-12 form-group">
						<label for="email">email</label> <input type="email" id="email"
							class="form-control " name="email" value="${cvo.email }"
							readonly="readonly">
					</div>
				</div>
				<div class="row">
					<div class="col-md-12 form-group">
						<label for="message">Get Message</label>
						<p id="message" class="form-control">${cvo.msg }</p>
					</div>
				</div>
			</div>
			<div class="col-lg-6">
				<form action="cont?command=Request" method="post">
				<input type="hidden" name="num" value="<%=request.getParameter("num")%>">
					<div class="row">
						<div class="col-md-12 form-group">
							<label for="name">Name</label>
							<span id="name" class="form-control">管理者</span>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12 form-group"></div>
					</div>
					<div class="row">
						<div class="col-md-12 form-group"></div>
					</div>
					<div class="row">
						<div class="col-md-12 form-group">
							<label for="message">Request Message</label>
							<textarea name="response" id="message" class="form-control " cols="30"
								rows="8"></textarea>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6 form-group">
							<input type="submit" value="送信" class="btn btn-primary">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

</section>



<script type="text/javascript"
	src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=pzhvagxt3g&callback=CALLBACK_FUNCTION"></script>
<script type="text/javascript">
	//size 옵션이 생략되면 map DOM 요소의 HTML 렌더링 크기로 자동으로 조정됩니다.
	var map = new naver.maps.Map('map', {
		center : new naver.maps.LatLng(36.3268458, 127.4077654),
		zoom : 10
	});

	var marker = new naver.maps.Marker({
		position : new naver.maps.LatLng(36.3268458, 127.4077654),
		map : map
	});
	map.setOptions({
		mapTypeControl : true,
		scaleControl : false,
		logoControl : false
	});

	// 미니 맵이 들어갈 HTML 요소를 controls 객체에 추가합니다. 가장 오른쪽 아래에 위치하기 위해서 다른 옵션들을 잠시 끕니다.
	map.controls[naver.maps.Position.BOTTOM_RIGHT].push($("#minimap")[0]);
	map.setOptions({
		scaleControl : true,
		logoControl : true,
	});

	var minimap = new naver.maps.Map('minimap', { //미니 맵 지도를 생성합니다.
		bounds : map.getBounds(),
		scrollWheel : false,
		scaleControl : false,
		mapDataControl : false,
		logoControl : false
	});

	var semaphore = false;
	naver.maps.Event.addListener(map, 'bounds_changed', function(bounds) {
		if (semaphore)
			return;

		minimap.fitBounds(bounds);
	});
	naver.maps.Event.addListener(map, 'mapTypeId_changed', function(mapTypeId) {
		var toTypes = {
			"normal" : "hybrid",
			"terrain" : "satellite",
			"satellite" : "terrain",
			"hybrid" : "normal"
		};

		minimap.setMapTypeId(toTypes[mapTypeId]);
	});
	naver.maps.Event.addListener(minimap, 'drag', function() {
		semaphore = true;
		map.panTo(minimap.getCenter());
		naver.maps.Event.once(map, 'idle', function() {
			semaphore = false;
		});

	});
</script>

<%@include file="../footer.jsp"%>

