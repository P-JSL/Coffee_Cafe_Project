<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String p = request.getContextPath();
%>
<link rel="stylesheet" href="<%=p%>/css/qna.css">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${sessionScope.user  == 0 }">
		<c:import url="../../header_0.jsp"></c:import>
	</c:when>
	<c:when test="${sessionScope.user == 1 }">
		<c:import url="../../header.jsp"></c:import>
	</c:when>
	<c:when test="${sessionScope.user==2 }">
		<c:import url="../../header_2.jsp"></c:import>
	</c:when>
</c:choose>
<div class="body">
	<div class="container">
		<div class="row">
			<div class="col-lg-4">
				<div class="nav nav-pills faq-nav" id="faq-tabs" role="tablist"
					aria-orientation="vertical">
					<a href="#tab1" class="nav-link active" data-toggle="pill"
						role="tab" aria-controls="tab1" aria-selected="true"> <i
						class="mdi mdi-help-circle"></i> ホームページに関して
					</a> <a href="#tab2" class="nav-link" data-toggle="pill" role="tab"
						aria-controls="tab2" aria-selected="false"> <i
						class="mdi mdi-account"></i> サービスなど
					</a> 
				</div>
			</div>
			<div class="col-lg-8">
				<div class="tab-content" id="faq-tab-content">
					<div class="tab-pane show active" id="tab1" role="tabpanel"
						aria-labelledby="tab1">
						<div class="accordion" id="accordion-tab-1">
							<div class="card">
								<div class="card-header" id="accordion-tab-1-heading-1">
									<h5>
										<button class="btn btn-link" type="button"
											data-toggle="collapse"
											data-target="#accordion-tab-1-content-1"
											aria-expanded="false"
											aria-controls="accordion-tab-1-content-1">このホームページは何をするサイトですか？</button>
									</h5>
								</div>
								<div class="collapse show" id="accordion-tab-1-content-1"
									aria-labelledby="accordion-tab-1-heading-1"
									data-parent="#accordion-tab-1">
									<div class="card-body">
										<p>
											ここ、コーヒーなどの共有および知識などを話し合いながらもっと自分の好きなコーヒーについても知ることができる場所です。 <br />他に聞きたいことがありましたら、CONTACTで連絡ください。
										</p>

									</div>
								</div>
							</div>
							<div class="card">
								<div class="card-header" id="accordion-tab-1-heading-2">
									<h5>
										<button class="btn btn-link" type="button"
											data-toggle="collapse"
											data-target="#accordion-tab-1-content-2"
											aria-expanded="false"
											aria-controls="accordion-tab-1-content-2">ホームページの機能について</button>
									</h5>
								</div>
								<div class="collapse" id="accordion-tab-1-content-2"
									aria-labelledby="accordion-tab-1-heading-2"
									data-parent="#accordion-tab-1">
									<div class="card-body">
										<p>
											機能としては 「１」最新話題のコーヒーシュースを見られる【NEWS】がありまして、<br />
											コーヒーに関する歴史などを紹介/説明を書いている【SERVICES】が。
											また、お互いコミュニケーションができる【COMMUNITY】が。 そして、写真を共有する【GALLERY】がございます。
										</p>
									</div>
								</div>
							</div>
							<div class="card">
								<div class="card-header" id="accordion-tab-1-heading-3">
									<h5>
										<button class="btn btn-link" type="button"
											data-toggle="collapse"
											data-target="#accordion-tab-1-content-3"
											aria-expanded="false"
											aria-controls="accordion-tab-1-content-3">その他</button>
									</h5>
								</div>
								<div class="collapse" id="accordion-tab-1-content-3"
									aria-labelledby="accordion-tab-1-heading-3"
									data-parent="#accordion-tab-1">
									<div class="card-body">
										<p>
											自分が乗せたり、アップロードした写真などをすぐわかるように【マイページ】がございますので、
											【マイページ】でご確認ください。<br /> ありがとうございます。
										</p>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="tab-pane" id="tab2" role="tabpanel"
						aria-labelledby="tab2">
						<div class="accordion" id="accordion-tab-2">
							<div class="card">
								<div class="card-header" id="accordion-tab-2-heading-1">
									<h5>
										<button class="btn btn-link" type="button"
											data-toggle="collapse"
											data-target="#accordion-tab-2-content-1"
											aria-expanded="false"
											aria-controls="accordion-tab-2-content-1">ホームページサービス</button>
									</h5>
								</div>
								<div class="collapse show" id="accordion-tab-2-content-1"
									aria-labelledby="accordion-tab-2-heading-1"
									data-parent="#accordion-tab-2">
									<div class="card-body">
										<p>
											わが社はご覧になってる方々に少しながら見やすくて目にやさしいホームページを提供しております。 <br />
											また、改善事項がありましたらすぐ対応できるよう待機しております。
											そして、

										</p>
									</div>
								</div>
							</div>
							<div class="card">
								<div class="card-header" id="accordion-tab-2-heading-2">
									<h5>
										<button class="btn btn-link" type="button"
											data-toggle="collapse"
											data-target="#accordion-tab-2-content-2"
											aria-expanded="false"
											aria-controls="accordion-tab-2-content-2">問い合わせは？</button>
									</h5>
								</div>
								<div class="collapse" id="accordion-tab-2-content-2"
									aria-labelledby="accordion-tab-2-heading-2"
									data-parent="#accordion-tab-2">
									<div class="card-body">
										<p>CONTACTでお問い合わせすることや気になったとこ、改善点を書いて伝送すれば管理者が読んで回答できます。
										<br/>
										
										</p>
									</div>
								</div>
							</div>
							<div class="card">
								<div class="card-header" id="accordion-tab-2-heading-3">
									<h5>
										<button class="btn btn-link" type="button"
											data-toggle="collapse"
											data-target="#accordion-tab-2-content-3"
											aria-expanded="false"
											aria-controls="accordion-tab-2-content-3">コンタクトアースの使い方</button>
									</h5>
								</div>
								<div class="collapse" id="accordion-tab-2-content-3"
									aria-labelledby="accordion-tab-2-heading-3"
									data-parent="#accordion-tab-2">
									<div class="card-body">
										<p>お名前とメッセージを書いて伝送ボタンを押すと終わりです。
										<br/>
										淡々とお使いお願いいたします。
										</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="../../footer.jsp"%>