<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1 , user-scalable=no">
    <title>bootstrap项目实战</title>
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
</head>
<body>
<!--导航-->
<!-- Loading -->
	<div class="loader1">
		<i></i><i></i>
	</div>
	<div class="loading" align="center">加载中，请稍候 ...</div>
	<!-- Loading Ends -->
	<jsp:include page="header.jsp"></jsp:include>
<!--警告框-->
<div class="main-container"  id="main-container">
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
					<div class="col-md-10 col-md-offset-1">


						<div class="page-content">
							

    <div class="row" type="0" id="div">
        <div class="col-md-12">
            <div class="alert alert-danger alert-dismissible fade in" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
                <h4>网站程序有漏洞，急需修复！</h4>
                <p>当前版本程序(V1.22)存在严重安全问题，容易造成攻击，请即可修复！</p>
                <p>
                    <button type="button" class="btn btn-danger">立即修复</button>
                    <button type="button" class="btn btn-default"  data-dismiss="alert"  >稍后处理</button>
                </p>
            </div>
        </div>
        <div class="col-md-6">
            <div class="panel panel-default">
                <div class="panel-heading">网站数据统计</div>
                <div class="panel-body">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>统计项目</th>
                                <th>今日</th>
                                <th>昨日</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                 <th scope="row">注册会员</th>
                                 <td>200</td>
                                 <td>400</td>
                            </tr>
                            <tr>
                                <th scope="row">登录会员</th>
                                <td>4100</td>
                                <td>5112</td>
                            </tr>
                            <tr>
                                <th scope="row">今日发帖</th>
                                <td>1540</td>
                                <td>4511</td>
                            </tr>
                            <tr>
                                <th scope="row">转载次数</th>
                                <td>150</td>
                                <td>110</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="panel panel-default">
                <div class="panel-heading">网站热帖</div>
                    <ul class="list-group">
                        <li class="list-group-item">
                            <a href="index.html"><span class="glyphicon glyphicon-list-alt"></span>&nbsp;&nbsp;泛Mooc职业教育， 效果和就业为王<small class="pull-right">2015/08/08</small></a>
                        </li>
                        <li class="list-group-item">
                            <a href="index.html"><span class="glyphicon glyphicon-list-alt"></span>&nbsp;&nbsp;泛Mooc职业教育， 效果和就业为王<small class="pull-right">2015/08/08</small></a>
                        </li>
                        <li class="list-group-item">
                            <a href="index.html"><span class="glyphicon glyphicon-list-alt"></span>&nbsp;&nbsp;泛Mooc职业教育， 效果和就业为王<small class="pull-right">2015/08/08</small></a>
                        </li>
                        <li class="list-group-item">
                            <a href="index.html"><span class="glyphicon glyphicon-list-alt"></span>&nbsp;&nbsp;泛Mooc职业教育， 效果和就业为王<small class="pull-right">2015/08/08</small></a>
                        </li>
                        <li class="list-group-item">
                            <a href="index.html"><span class="glyphicon glyphicon-list-alt"></span>&nbsp;&nbsp;泛Mooc职业教育， 效果和就业为王<small class="pull-right">2015/08/08</small></a>
                        </li>
                        <li class="list-group-item">
                            <a href="index.html"><span class="glyphicon glyphicon-list-alt"></span>&nbsp;&nbsp;泛Mooc职业教育， 效果和就业为王<small class="pull-right">2015/08/08</small></a>
                        </li>
                    </ul>
            </div>
        </div>
        <div class="col-md-6">
            <div class="panel panel-default">
                <div class="panel-heading">今日访客统计</div>
                <div class="panel-body">
                    <canvas id="canvas" class="col-md-12"></canvas>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="panel panel-default">
                <div class="panel-heading">服务器状态</div>
                <div class="panel-body">
                    <p>内存使用率：40%</p>
                    <div class="progress">
                        <div class="progress-bar progress-bar-success progress-bar-striped" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%"></div>
                    </div>
                    <p>数据库使用率：20%</p>
                    <div class="progress">
                        <div class="progress-bar progress-bar-info progress-bar-striped" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%"></div>
                    </div>
                    <p>磁盘使用率：60%</p>
                    <div class="progress">
                        <div class="progress-bar progress-bar-warning progress-bar-striped" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%"></div>
                    </div>
                    <p>CPU使用率：80%</p>
                    <div class="progress">
                        <div class="progress-bar progress-bar-danger progress-bar-striped" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%"></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading">团队留言板</div>
                <div class="panel-body">
                    <div class="col-md-7">
                        <div class="media well">
                            <div class="media-left">
                                <a href="#">
                                    <img class="media-object wh64" src="images/a.png" alt="卓大哥">
                                </a>
                            </div>
                            <div class="media-body">
                                <h4 class="media-heading">卓大哥</h4>
                                技术大哥，今晚请把网站程序升级一下哈，现在的系统有漏洞，安全起见！
                            </div>
                        </div>
                        <div class="media well">
                            <div class="media-body text-right">
                                <h4 class="media-heading">技术大哥</h4>
                                收到，今晚凌晨2点准时升级！
                            </div>
                            <div class="media-right">
                                <a href="#">
                                    <img class="media-object wh64" src="images/b.png" alt="技术大哥">
                                </a>
                            </div>
                        </div>
                        <div class="media well">
                            <div class="media-body text-right">
                                <h4 class="media-heading">技术大哥</h4>
                                你先在站点发布一下通知哈！
                            </div>
                            <div class="media-right">
                                <a href="#">
                                    <img class="media-object wh64" src="images/b.png" alt="技术大哥">
                                </a>
                            </div>
                        </div>
                        <div class="media well">
                            <div class="media-left">
                                <a href="#">
                                    <img class="media-object wh64" src="images/a.png" alt="卓大哥">
                                </a>
                            </div>
                            <div class="media-body">
                                <h4 class="media-heading">卓大哥</h4>
                                好嘞。
                            </div>
                        </div>
                    </div>
                    <div class="col-md-5">
                        <form action="#">
                            <div class="form-group">
                                <label for="text1">输入留言内容</label>
                                <textarea class="form-control" id="text1" rows="5" cols="10" placeholder="请输入留言内容"></textarea>
                                <button type="submit" class="btn btn-default mar_t15">留言</button>
                            </div>
                        </form>
                        <div class="panel panel-default">
                            <div class="panel-heading">团队联系手册</div>
                            <div class="panel-body">
                                <ul class="list-group">
                                    <li class="list-group-item">站长(李小龙)：<span class="glyphicon glyphicon-phone"></span>&nbsp;&nbsp;13134848615</li>
                                    <li class="list-group-item">技术(大牛哥)：<span class="glyphicon glyphicon-phone"></span>&nbsp;&nbsp;13456127694</li>
                                    <li class="list-group-item">推广(张二哥)：<span class="glyphicon glyphicon-phone"></span>&nbsp;&nbsp;13457815482</li>
                                    <li class="list-group-item">客服(王女士)：<span class="glyphicon glyphicon-phone"></span>&nbsp;&nbsp;13134567782&nbsp;&nbsp;<span class="glyphicon glyphicon-phone-alt"></span>&nbsp;&nbsp;028-888888</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
</div>
</div>


<!--footer-->
<footer>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <p>
                    Copyright&nbsp;©&nbsp;2012-2015&nbsp;&nbsp;www.maiziedu.com&nbsp;&nbsp;蜀ICP备13014270号-4
                </p>
            </div>
        </div>
    </div>
</footer>
<!--footer-->


<script type="text/javascript">
		window.jQuery
				|| document
						.write("<script src='assets/js/jquery-2.0.3.min.js'>"
								+ "<"+"/script>");
	</script>
	<script src="${pageContext.request.contextPath}/js/myjs/loading.js"></script>
	<!-- <![endif]-->
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
			if (a == "0") {
				$(".navbar-nav li").removeClass("active");
				$(".navbar-nav li").eq(0).addClass("active");
			}
		});
	</script>
<script src="js/Chart.js"></script>
<script src="js/script.js"></script>
</body>
</html>