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
     <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-maizi.css"/>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<!--导航-->

<div class="container" type="4" id="div">
    <div class="row">
        <div class="col-md-2">
            <div class="list-group">
                <a href="${pageContext.request.contextPath}/rules/showall" class="list-group-item">知识库管理</a>
                <a href="addRules.jsp" class="list-group-item active">添加新规则</a>
            </div>
        </div>
        <div class="col-md-10">
            <div class="page-header">
                <h1>添加新规则</h1>
            </div>
            <ul class="nav nav-tabs">
                <li>
                    <a href="${pageContext.request.contextPath}/rules/showall">知识库管理</a>
                </li>
                <li class="active">
                    <a href="addRules.jsp">添加新规则</a>
                </li>
            </ul>
            <form action="${pageContext.request.contextPath}/rules/addRulesSubmit" style="margin-top: 25px;"  method="post">
            	
            	<div class="row" style="margin-top: 25px;">
                <div class="form-group">
                    <label for="title" class="col-sm-2 control-labe">rkey:</label>
                   <div class="col-lg-4">
                <input type="text" name="rkey" class="form-control" required="required">
                 </div>
                </div>
                </div>
                <div class="row" style="margin-top: 25px;">
                <div class="form-group">
                    <label for="title" class="col-sm-2 control-labe">hook:</label>
                    <div class="col-lg-4">
                <input type="text" class="form-control" name="hook" required="required">
                 </div>
                </div>
                </div>
                <div class="row" style="margin-top: 25px;">
                <div class="form-group">
                    <label for="title" class="col-sm-2 control-labe">level:</label>
                     <div class="col-lg-4">
                <select class="form-control" name="level">
			      <option>1</option>
			      <option>2</option>
			      <option>3</option>
			      <option>4</option>
			      <option>5</option>
			    </select>
                 </div>
                </div>
                </div>
                 <div class="row" style="margin-top: 25px;">
                <div class="form-group">
                    <label for="title" class="col-sm-2 control-labe">category:</label>
                     <div class="col-lg-4">
                <input type="text" class="form-control" name="category" required="required">
                 </div>
                </div>
            </div>
            <div class="row" style="margin-top: 25px;">
                <div class="form-group">
                    <label for="title" class="col-sm-2 control-labe">warning:</label>
                     <div class="col-lg-6">
                <textarea name="warning" class="form-control" rows="3" cols="6" ></textarea>
                 </div>
                </div>
            </div>
            <div class="row" style="margin-top: 25px;">
                <div class="form-group">
                    <label for="title" class="col-sm-2 control-labe">suggestion:</label>
                     <div class="col-lg-6">
                 <textarea name="suggestion" class="form-control" rows="3" cols="6" ></textarea>
                 </div>
                </div>
            </div>
            <div class="row" style="margin-top: 25px;">
                <div class="form-group">
                    <label for="title" class="col-sm-2 control-labe">other:</label>
                     <div class="col-lg-6">
                <textarea name="other" class="form-control" rows="3" cols="6" ></textarea>
                 </div>
                </div>
            </div>
               <div class="row" style="margin-top: 25px;">
                <div class="form-group">
               <div class="col-sm-offset-2 col-sm-10">
               <button type="submit" class="btn btn-default alert-success">保存</button>&nbsp;&nbsp;&nbsp;&nbsp;
               <button type="reset" class="btn btn-default alert-warning" onclick="location='${pageContext.request.contextPath}/rules/showall'">取消</button>
               </div>
               </div>
 			 </div>
 			 <br/>
 			 <br/>
 			 <br/>
  	          </form>
  	          <br/>
  	           <br/>
  	            <br/>

        </div>
    </div>
</div>
<script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
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