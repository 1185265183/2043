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
    <title>修改规则</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-maizi.css"/>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<!--导航-->

<div class="container" type="4" id="div">
    <div class="row" style="background-color: #269ABC;">
    	 
                <h1 style="margin-left: 15px;font-size: 17px;">项目更新</h1>
               </div>
    
             <form action="${pageContext.request.contextPath}/project/updateProjectSubmit" 
	               enctype="multipart/form-data" method="post" style="margin-top: 60px; margin-left: 200px;">
	              <input type="hidden" name="id" value="${project.id}"/>
	               <input type="hidden" name="path" value="${project.path}"/>
            	<div class="row" style="margin-top: 25px;">
                <div class="form-group">
                    <label for="title" class="col-sm-2 control-labe">项目名称:</label>
                   <div class="col-lg-4">
                <input type="text" class="form-control" name="name" value="${project.name}" required="required">
                 </div>
                </div>
                </div>
                <div class="row" style="margin-top: 25px;">
                <div class="form-group">
                    <label for="title" class="col-sm-2 control-labe">项目类型:</label>
                     <div class="col-lg-4">
                <select class="form-control" id="sel" name="type">
			      <option value="C">C</option>
			      <option value="C++">C++</option>
			    </select>
                 </div>
                </div>
                </div>
                <div class="row" style="margin-top: 25px;">
                <div class="form-group has-warning">
			   <label for="title" class="col-sm-2 control-labe">选择项目:</label>
			    <input type="file" id="inputfile" class="col-lg-3" aria-describedby="helpBlock" name="pic" value="">
			  <span id="helpBlock2" class="help-block has-warning">如果未选择文件则默认为原文件</span>
			  
			  </div>
			    </div>
			     <div class="row" style="margin-top: 25px;">
			    <div class="form-group">
                    <label for="title" class="col-sm-2 control-labe">项目版本号:</label>
                   <div class="col-lg-4">
                <input type="text" class="form-control" name="versionid" value="${project.versionid}" required="required">
                 </div>
                </div>
                </div>
            <div class="row" style="margin-top: 25px;">
                <div class="form-group">
                    <label for="title" class="col-sm-2 control-labe">项目描述:</label>
                     <div class="col-lg-6">
                <textarea name="description" class="form-control" rows="3" cols="6" >${project.description}</textarea>
                 </div>
                </div>
            </div>
               <div class="row" style="margin-top: 50px; ">
                <div class="form-group">
               <div class="col-sm-offset-3 col-sm-10">
               <button type="submit" class="btn btn-success">更新</button>&nbsp;&nbsp;&nbsp;&nbsp;
               <button type="reset" class="btn btn-warning" onclick="location='${pageContext.request.contextPath}/project/queryProjects'">取消</button>
               </div>
               </div>
 			 </div>
 			 <br/>
 			
  	          </form>
  	          <br/>
  	           <br/>
  	            <br/>

        </div>
   
<script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script>
	$(function(){
	
		 $("#sel").find("option[value='${project.type}']").attr("selected",true); 
		
	})
</script>
<script type="text/javascript">
  $(function(){
	var a=($("#div").attr("type"));
	if (a=="4") {
		$(".navbar-nav li").removeClass("active");
		$(".navbar-nav li").eq(4).addClass("active");
	}
	});
	</script>
</body>
</html>