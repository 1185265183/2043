<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE>
<html>
<head>
<base href="<%=basePath%>">

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1 , user-scalable=no">
<title></title>
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/mycss/loading.css" />
<link rel="stylesheet" href="assets/css/ace.min.css" />
<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />
<link rel="stylesheet" href="assets/css/ace-skins.min.css" />
<link rel="stylesheet" href="assets/css/font-awesome.min.css" />

<script src="assets/js/ace-extra.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap-maizi.css" />
<style type="text/css">
td {
	white-space: nowrap; /*控制单行显示*/
	overflow: hidden; /*超出隐藏*/
	text-overflow: ellipsis; /*隐藏的字符用省略号表示*/
	text-align: center;
}

th {
	text-align: center;
	//
	内容居中
}
</style>

</head>

<body  projectid="${projectid}" analysis="${analysis}" network="${network}">
	<!-- Loading -->
	<div class="loader1">
		<i></i><i></i>
	</div>
	<div class="loading" align="center">加载中，请稍候 ...</div>
	<!-- Loading Ends -->
	<jsp:include page="header.jsp"></jsp:include>
	<!--导航-->
	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>
		<div class="main-container-inner">
			<a class="menu-toggler" id="menu-toggler" href="#"> <span
				class="menu-text"></span>
			</a>
			<div type="2" id="div">
				<div class="row">
					<div class="col-md-10 col-md-offset-1">


						<div class="page-content">
							<div class="page-header">
								<div class="breadcrumbs" id="breadcrumbs">
									<script type="text/javascript">
										try {
											ace.settings.check('breadcrumbs',
													'fixed')
										} catch (e) {
										}
									</script>

									<ul class="breadcrumb">
										<li><i class="icon-home home-icon"></i> <a href="#">软件网络构建与特性分析</a>
										</li>
										<li class="active">分析结果</li>
									</ul>
									<!-- .breadcrumb -->

								</div>
							</div>
							<!-- PAGE CONTENT BEGINS -->
							<ul id="myTab" class="nav nav-tabs ">


								<li class="active"><a data-toggle="tab" href="#node-tab">
										<i class="purple bigger-125"></i>节点级网络复杂度量
								</a></li>
								<li><a data-toggle="tab" href="#net-tab"> <i
										class="purple bigger-125"></i> 网络级复杂度量
								</a></li>
								
							</ul>
							<div class="tab-content ">
								<div id="node-tab" class="tab-pane in active">
									<form id="node-form" type="node" class="form-horizon"
										method="post" onsubmit="return false;">
										<div class="row">
											<div class="col-xs-12">
												
												<div class="table-header">Results for "节点级网络复杂度量"</div>
												<table id="node-table"
													class="table table-striped table-bordered table-hover "
													style=" table-layout: fixed;">
													<thead>
														<tr>
															<th>度</th>
															<th>入度</th>
															<th>出度</th>
															<th>影响范围</th>
															<th>最大邻居连通度</th>
															<th>最大邻居连通密度</th>
															<th>接近度</th>
															<th>节点聚类系数</th>
															<th>节点中介中心性</th>
															<th>node core</th>
															<th>度中心性</th>
															<th>所属项目名</th>
														</tr>
													</thead>
													<tbody>
													</tbody>

												</table>
											</div>
										</div>

									</form>
									<br>
									<!-- 显示分页信息 -->
									<div class="row">
										<!--分页文字信息  -->

										<div class="col-md-6 col-md-offset-1" id="node_page_info_area"></div>

										<!-- 分页条信息 -->

										<div class="col-md-6 col-md-offset-7" id="node_page_nav_area">
										</div>
									</div>

								</div>
								<div id="net-tab" class="tab-pane">
									<form id="net-form" type="net" class="form-horizon"
										method="post" onsubmit="return false;">
										<div class="row">
											<div class="col-xs-12">
										
												<div class="table-header">Results for "网络级网络复杂度量"</div>
												<div class="table-responsive">
													<table id="net-table"
														class="table table-striped table-bordered table-hover"
														style=" table-layout: fixed;">
														<thead>
															<tr>
																<th>节点数</th>
																<th>网络边数</th>
																<th>网络直径</th>
																<th>网络核数</th>
																<th>网络节点平均度</th>
																<th>网络平均最短路径长度</th>
																<th>网络效率</th>
																<th>聚集系数</th>
																<th>所属项目名</th>
															</tr>
														</thead>
														<tbody>
														</tbody>

													</table>
												</div>
											</div>
										</div>
									</form>
									<br>
									<!-- 显示分页信息 -->
									<div class="row">
										<!--分页文字信息  -->

										<div class="col-md-6 col-md-offset-1"
											id="net_page_info_area"></div>

										<!-- 分页条信息 -->

										<div class="col-md-6 col-md-offset-7"
											id="net_page_nav_area"></div>
									</div>

								</div>
								
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>


	<script type="text/javascript">
		window.jQuery
				|| document
						.write("<script src='assets/js/jquery-2.0.3.min.js'>"
								+ "<"+"/script>");
	</script>
	<script src="${pageContext.request.contextPath}/js/myjs/loading.js"></script>
	<!-- <![endif]-->
	<script src="layer/layer.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/myjs/networkResult.js"></script>
	<script type="text/javascript">
		if ("ontouchend" in document)
			document
					.write("<script src='assets/js/jquery.mobile.custom.min.js'>"
							+ "<"+"/script>");
	</script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/js/typeahead-bs2.min.js"></script>
	 
	<!-- page specific plugin scripts -->

	<script src="assets/js/jquery.dataTables.min.js"></script>
	<script src="assets/js/jquery.dataTables.bootstrap.js"></script>

	<!-- ace scripts -->

	<script src="assets/js/ace-elements.min.js"></script>
	<script src="assets/js/ace.min.js"></script>

	<script type="text/javascript">
		$(function() {
			var a = ($("#div").attr("type"));
			if (a == "2") {
				$(".navbar-nav li").removeClass("active");
				$(".navbar-nav li").eq(2).addClass("active");
			}
		});
	</script>
</body>
</html>
