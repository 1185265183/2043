<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
     <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1 , user-scalable=no">
    <title>知识库管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-maizi.css"/>
	<style type="text/css">         
        td{   
            white-space: nowrap;/*控制单行显示*/   
            overflow: hidden;/*超出隐藏*/   
            text-overflow: ellipsis;/*隐藏的字符用省略号表示*/   
            text-align: center;
        }  
         th{   
    
            text-align: center; //内容居中
        }    
    </style> 
	
  </head>
  
  <body>
   <jsp:include page="header.jsp"></jsp:include>
<!--导航-->

<div class="container" type="4" id="div">
	<div class="row">
        <div class="col-md-2">
            <div class="list-group">
                <a href="${pageContext.request.contextPath}/project/queryProjects" class="list-group-item active">项目管理</a>
                <a href="${pageContext.request.contextPath}/addProject.jsp" class="list-group-item ">添加新项目</a>
            </div>
        </div>
        <div class="col-md-10">
            <div class="page-header">
                <h1>项目列表</h1>
            </div>
            <ul class="nav nav-tabs">
                <li class="active">
                    <a href="${pageContext.request.contextPath}/project/queryProjects">项目管理</a>
                </li>
                <li >
                    <a href="${pageContext.request.contextPath}/addProject.jsp">添加新项目</a>
                </li>
            </ul>
<div class="forms">
    <form id="form_query" action="${pageContext.request.contextPath}/project/queryProjects" method="post">
	<input id="page" name="pageNum" type="hidden" value="1" />
	</form>
<table class="table table-bordered table-hover " >
    <thead>
    <tr>
        <th>项目编号</th>
        <th>项目名称</th>
        <th>项目类型</th>
        <th>项目版本号</th>
        <th>项目描述</th>
        <th>项目路径</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="project" items="${projectList}" varStatus="state">
    	<tr>
    		
        <td title="${project.id}">${project.id}</td>
        <td title="${project.name}">${project.name}</td>
        <td title="${project.type}">${project.type}</td>
        <td title="${project.versionid}">${project.versionid}</td>
        <td title="${project.description}">${project.description}</td>
   		<td title="${project.path}">${project.path}</td>
        <td>
              <div class="btn-group">
					<button type="button" class="btn btn-default  btn-primary btn-sm" onclick="javascrtpt:window.location.href='${pageContext.request.contextPath}/project/detectProject/${project.id}'">检测</button>
					<button type="button" class="btn btn-default  btn-info btn-sm" onclick="javascrtpt:window.location.href='${pageContext.request.contextPath}/project/toUpdate/${project.id}'">编辑</button>
					<button type="button" class="btn btn-default  btn-danger btn-sm" onclick="javascrtpt:window.location.href='${pageContext.request.contextPath}/project/removeProject/${project.id}'">删除</button>

			</div>
        </td>
    	</tr>
    	</c:forEach>
    </tbody>
</table>
<nav class="pull-left">
   【当前第${pageInfo.pageNum}页，总共${pageInfo.pages}页，总共${pageInfo.total}条记录】
</nav>
<nav class="pull-right">
    <ul class="pagination">
        <li> <a href="javascript:jumpPage(1)" title="">首页</a></li>
        <li> <a href="javascript:jumpPage(${pageInfo.prePage})" title="">上一页</a></li>
        <li><a href="javascript:jumpPage(${pageInfo.nextPage})" title="">下一页</a></li>
        <li> <a href="javascript:jumpPage(${pageInfo.pages})" title="">尾页</a> </li>
    </ul>
</nav>
</div>
</div>
</div>
<script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script>
  		function jumpPage(pageno){
  			document.getElementById("page").value=pageno;
  			document.getElementById("form_query").submit();
  		}
  
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
