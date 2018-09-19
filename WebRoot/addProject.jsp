<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1 , user-scalable=no">
    <title>添加新规则</title>
    <link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/mycss/loading.css" />
 <link rel="stylesheet" href="assets/css/ace.min.css" />
<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />
<link rel="stylesheet" href="assets/css/ace-skins.min.css" />
<link rel="stylesheet" href="assets/css/font-awesome.min.css" />

<script src="assets/js/ace-extra.min.js"></script> 
</head>
<body>
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
<!--导航-->
    <!--导航-->
			<div type="4" id="div">
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
										<li><i class="glyphicon glyphicon-list-alt"></i><span> &nbsp;我的管理</span></li>
										<li class="active"> <a
											href="${pageContext.request.contextPath}/project/queryProjects">项目管理</a></li>
									</ul>
									<!-- .breadcrumb -->

								</div>
							</div>
       
        
        
            <ul class="nav nav-tabs">
                <li>
                    <a href="${pageContext.request.contextPath}/project/queryProjects">项目列表</a>
                </li>
                <li class="active">
                    <a >添加新项目</a>
                </li>
            </ul>
				<div class="col-md-10 col-md-offset-2">
            <form action="${pageContext.request.contextPath}/project/addProject"  style="margin-top: 25px;" enctype="multipart/form-data" method="post">
            	
            	<div class="row " style="margin-top: 25px;">
		
                <div class="form-group">
                    <label for="title" class="col-sm-2 control-labe">项目名称:</label>
                   <div class="col-lg-4">
                <input type="text" name="name" class="form-control" required="required" >
                 </div>
                </div>
                </div>
                <div class="row" style="margin-top: 25px;">
                <div class="form-group">
                    <label for="title" class="col-sm-2 control-labe">项目类型:</label>
                     <div class="col-lg-4">
                <select class="form-control" name="type">
			      <option>C</option>
			      <option>C++</option>
			    </select>
                 </div>
                </div>
                </div>
                <div class="row" style="margin-top: 25px;">
                <div class="form-group">
			   <label for="title" class="col-sm-2 control-labe">项目上传:</label>
			    <input type="file"  name="pic"  class="col-lg-4">
			  </div>
			  </div>
			 <div class="row" style="margin-top: 25px;">
                <div class="form-group">
                    <label for="title" class="col-sm-2 control-labe">项目版本号:</label>
                   <div class="col-lg-4">
                <input type="text" name="versionid" class="form-control" required="required" >
                 </div>
                </div>
                </div>
            <div class="row" style="margin-top: 25px;">
                <div class="form-group">
                    <label for="title" class="col-sm-2 control-labe">项目描述:</label>
                     <div class="col-lg-6">
                <textarea name="description" class="form-control" rows="3" cols="6" ></textarea>
                 </div>
                </div>
            </div>
               <div class="row" style="margin-top: 50px; ">
                <div class="form-group">
               <div class="col-sm-offset-2 col-sm-10">
               <button type="submit" class="btn btn-success">保存</button>&nbsp;&nbsp;&nbsp;&nbsp;
               <button type="reset" class="btn btn-warning" onclick="location='${pageContext.request.contextPath}/project/queryProjects'">取消</button>
               </div>
               </div>
 			 </div>
 			 <br/>
 			
  	          </form>
  	          <br/>
  	           <br/>
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
					<script src="layer/layer.js"></script>
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
				if (a == "4") {
					$(".navbar-nav li").removeClass("active");
					$(".navbar-nav li").eq(4).addClass("active");
				}
			});
		</script>
</body>
</html>