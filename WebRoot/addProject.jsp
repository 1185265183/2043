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
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/bootstrap-maizi.css"/>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container">
        <!--小屏幕导航按钮和logo-->
        <div class="navbar-header">
            <button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="index.html" class="navbar-brand">软件评估平台</a>
        </div>
        <!--小屏幕导航按钮和logo-->
        <!--导航-->
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="index.html"><span class="glyphicon glyphicon-home"></span>&nbsp;&nbsp;后台首页</a></li>
                <li><a href="user_list.html"><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;项目管理</a></li>
                <li><a href="content.html"><span class="glyphicon glyphicon-list-alt"></span>&nbsp;&nbsp;内容管理</a></li>
                <li><a href="tag.html"><span class="glyphicon glyphicon-tags"></span>&nbsp;&nbsp;标签管理</a></li>
                   <li class="dropdown active">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-list-alt"></span>&nbsp;&nbsp;项目管理<span class="caret"></span></a>
                   <ul class="dropdown-menu">
                 <li><a href="${pageContext.request.contextPath}/project/queryProjects">项目管理</span></a></li>
                  <li><a href="${pageContext.request.contextPath}/rules/showall">知识库管理</span></a></li>
                  <!--<li><a href="#">Something else here</a></li>
                  <li role="separator" class="divider"></li>
                  <li class="dropdown-header">Nav header</li>
                  <li><a href="#">Separated link</a></li>
                  <li><a href="#">One more separated link</a></li>-->
                </ul>
              </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a id="dLabel" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        admin
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="dLabel">
                        <li><a href="index.html"><span class="glyphicon glyphicon-screenshot"></span>&nbsp;&nbsp;前台首页</a></li>
                        <li><a href="index.html"><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;个人主页</a></li>
                        <li><a href="index.html"><span class="glyphicon glyphicon-cog"></span>&nbsp;&nbsp;个人设置</a></li>
                        <li><a href="index.html"><span class="glyphicon glyphicon-credit-card"></span>&nbsp;&nbsp;账户中心</a></li>
                        <li><a href="index.html"><span class="glyphicon glyphicon-heart"></span>&nbsp;&nbsp;我的收藏</a></li>
                    </ul>
                </li>
                <li><a href="#bbs"><span class="glyphicon glyphicon-off"></span>&nbsp;&nbsp;退出</a></li>
            </ul>
        </div>
        <!--导航-->

    </div>
</nav>
<!--导航-->

<div class="container">
    <div class="row">
        <div class="col-md-2">
            <div class="list-group">
                <a href="${pageContext.request.contextPath}/project/queryProjects" class="list-group-item">项目管理</a>
                <a href="addProject.jsp" class="list-group-item active">添加新项目</a>
            </div>
        </div>
        <div class="col-md-10">
            <div class="page-header">
                <h1>添加新项目</h1>
            </div>
            <ul class="nav nav-tabs">
                <li>
                    <a href="${pageContext.request.contextPath}/project/queryProjects">项目管理</a>
                </li>
                <li class="active">
                    <a href="addProject.jsp">添加新项目</a>
                </li>
            </ul>
            <form action="${pageContext.request.contextPath}/project/addProject"  style="margin-top: 25px;" enctype="multipart/form-data" method="post">
            	
            	<div class="row" style="margin-top: 25px;">
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
<script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>