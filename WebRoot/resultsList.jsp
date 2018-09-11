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
    <title>项目检测结果</title>
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
	<div class="row" style="background-color: #5BC0DE">
    	 
           <h1 style="margin-left: 25px; font-size: 17px;">检查结果列表</h1>
    </div>
   <div class="forms">
    <form id="form_query" action="${pageContext.request.contextPath}/project/queryResults/${projectid}" method="post">
	<input id="page" name="pageNum" type="hidden" value="1" />
	</form>
	</div>        

<table class="table table-bordered table-hover "style="margin-top: 25px;">
    <thead>
    <tr>
        <th>源文件路径</th>
        <th>所在行数</th>
        <th>风险等级</th>
        <th>风险种类</th>
        <th>风险函数</th>
        <th>警告信息</th>
        <th>建议信息</th>
    </tr>
    </thead>
    <tbody>
   <c:forEach var="results" items="${resultsList}" varStatus="state">
    	<tr>	
         <td title="${results.filepath}">${results.filepath}</td>
        <td title="${results.line}">${results.line}</td>
        <td title="${results.risklevel}">${results.risklevel}</td>
        <td title="${results.category}">${results.category}</td>
   		<td title="${results.rkey}">${results.rkey}</td>
   		<td title="${results.warning}">${results.warning}</td>
   		<td title="${results.suggestion}">${results.suggestion}</td>
       
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
		$(".nav li").removeClass("active");
		$(".nav li").eq(4).addClass("active");
	}
	});
	</script>
</body>
</html>