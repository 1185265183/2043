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

<div class="container" type="1" id="div">
	<div class="row">
        <div >
            <div class="page-header">
                <h1>解析结果</h1>
            </div>
            <ul class="nav nav-tabs">
                <li >
                    <a href="varResults.jsp">变量列表</a>
                </li>
                <li >
                    <a href="functionResult.jsp">函数列表</a>
                </li>
                <li >
                    <a href="classResult.jsp">类与对象列表</a>
                </li>
                <li  >
                    <a href="nodeResult.jsp">控制节点列表</a>
                </li>
                 <li class="active disabled">
                    <a href="assignResult.jsp">赋值语句列表</a>
                </li>
                  <li>
                    <a href="callfunctionResult.jsp">函数调用列表</a>
                </li>
            </ul>
<div class="forms">
    <form id="form_query" action="${pageContext.request.contextPath}/project/queryProjects1" method="post">
	<input id="page" name="pageNum" type="hidden" value="1" />
	</form>
<table class="table table-bordered table-hover " style=" table-layout: fixed;">
    <thead>
    <tr>
        <th>语句id</th>
        <th>所在类名</th>
        <th>被赋值变量名</th>
        <th>所属函数</th>
        <th>语句内容</th>
        <th>所属项目</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="project" items="${projectList}" varStatus="state">
    	<tr>
        <td title="${project.projectid}">${project.projectid}</td>
        <td title="${project.projectname}">${project.projectname}</td>
        <td title="${project.projecttype}">${project.projecttype}</td>
        <td title="${project.projectdesc}">${project.projectdesc}</td>
        <td title="${project.projectdesc}">${project.projectdesc}</td>
        <td title="${project.project}">${project.projectdesc}</td>
   		<td title="${project.projectpath}">${project.projectpath}</td>
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
	if (a=="1") {
		$(".navbar-nav li").removeClass("active");
		$(".navbar-nav li").eq(1).addClass("active");
	}
	});
	</script>
</body>
</html>
