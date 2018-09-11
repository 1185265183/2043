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
    	 
                <h1 style="margin-left: 15px;font-size: 17px;">知识库规则修改</h1>
               </div>
    <div class="row">
        <div class="col-md-offset-3">
            <form action="${pageContext.request.contextPath}/rules/updateRulesSubmit" method="post" style="margin-top: 25px;">
            	<div class="row" style="margin-top: 25px;">
            	<div class="form-group">
            	<input type="hidden" name="rkey" value="${rules.rkey}"/>
            	</div>
                <div class="form-group">
                    <label for="title" class="col-sm-2 control-labe">rkey:</label>
                   <div class="col-lg-4">
                <p class="form-control-static">${rules.rkey}</p>
                 </div>
                </div>
                </div>
                <div class="row" style="margin-top: 25px;">
                <div class="form-group">
                    <label for="title" class="col-sm-2 control-labe">hook:</label>
                    <div class="col-lg-4">
                <input type="text" name="hook" class="form-control" value="${rules.hook}" required="required">
                 </div>
                </div>
                </div>
                <div class="row" style="margin-top: 25px;">
                <div class="form-group">
                    <label for="title" class="col-sm-2 control-labe">level:</label>
                     <div class="col-lg-4">
                <select name="level" class="form-control" id="sel" >
			      <option value="1">1</option>
			      <option value="2">2</option>
			      <option value="3">3</option>
			      <option value="4">4</option>
			      <option value="5">5</option>
			    </select>
                 </div>
                </div>
                </div>
                 <div class="row" style="margin-top: 25px;">
                <div class="form-group">
                    <label for="title" class="col-sm-2 control-labe">category:</label>
                     <div class="col-lg-4">
                <input type="text" name="category" class="form-control" value="${rules.category}" required="required">
                 </div>
                </div>
            </div>
            <div class="row" style="margin-top: 25px;">
                <div class="form-group">
                    <label for="title" class="col-sm-2 control-labe">warning:</label>
                     <div class="col-lg-6">
                <textarea name="warning" class="form-control" rows="3" cols="6" >${rules.warning}</textarea>
                 </div>
                </div>
            </div>
            <div class="row" style="margin-top: 25px;">
                <div class="form-group">
                    <label for="title" class="col-sm-2 control-labe">suggestion:</label>
                     <div class="col-lg-6">
                 <textarea name="suggestion" class="form-control" rows="3" cols="6" >${rules.suggestion}</textarea>
                 </div>
                </div>
            </div>
            <div class="row" style="margin-top: 25px;">
                <div class="form-group">
                    <label for="title" class="col-sm-2 control-labe">other:</label>
                     <div class="col-lg-6">
                <textarea name="other" class="form-control" rows="3" cols="6" >${rules.other}</textarea>
                 </div>
                </div>
            </div>
               <div class="row" style="margin-top: 25px;">
                <div class="form-group">
               <div class="col-sm-offset-3 col-sm-10">
               <button type="submit" class="btn btn-success">更新</button>&nbsp;&nbsp;&nbsp;&nbsp;
               <button type="reset" class="btn btn-warning" onclick="location='${pageContext.request.contextPath}/rules/showall'">取消</button>
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
<script>
	$(function(){
	
		$("#sel").find("option[value=${rules.level}]").attr("selected",true);
		
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