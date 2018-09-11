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
    <title>知识库列表</title>
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
                <a href="/rules/showall" class="list-group-item active">知识库管理</a>
                <a href="${pageContext.request.contextPath}/addRule.jsp" class="list-group-item ">添加新规则</a>
            </div>
        </div>
        <div class="col-md-10">
            <div class="page-header">
                <h1>知识库管理</h1>
            </div>
            <ul class="nav nav-tabs">
                <li class="active">
                    <a href="${pageContext.request.contextPath}/rules/showall">知识库管理</a>
                </li>
                <li >
                    <a href="${pageContext.request.contextPath}/addRule.jsp">添加新规则</a>
                </li>
            </ul>
<div class="forms">
    <form id="form_query" action="${pageContext.request.contextPath}/rules/showall" method="post">
	<input id="page" name="pageNum" type="hidden" value="1" />
	</form>
	</div>
<table class="table table-bordered table-hover " style=" table-layout: fixed;" >
    <thead>
    <tr>
        <th>rkey</th>
        <th>hook</th>
        <th>level</th>
        <th>warning</th>
        <th>suggestion</th>
        <th>category</th>
        <th>other</th>
        <th>operation</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="rule" items="${rulesList}" varStatus="state">
    	<tr>
    		
        <td title="${rule.rkey}">${rule.rkey}</td>
        <td title="${rule.hook}">${rule.hook}</td>
        <td title="${rule.level}">${rule.level}</td>
        <td title="${rule.warning}">${rule.warning}</td>
        <td title="${rule.suggestion}">${rule.suggestion}</td>
        <td title="${rule.category}">${rule.category}</td>
        <td title="${rule.other}">${rule.other}</td>
        <td> 
          <div class="btn-group">
          
                <button type="button" class="btn btn-default btn-info btn-sm"" onclick="javascrtpt:window.location.href='${pageContext.request.contextPath}/rules/toUpdate/${rule.rkey}'">编辑</button>&nbsp;&nbsp;
			   <button type="button" class="btn btn-default  btn-danger btn-sm" onclick="javascrtpt:window.location.href='${pageContext.request.contextPath}/rules/removeRules/${rule.rkey}'">删除</button>
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
<br/>
<br/>
<br/>
<script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script>
  		function jumpPage(pageno){
  			document.getElementById("page").value=pageno;
  			document.getElementById("form_query").submit();
  		};
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
