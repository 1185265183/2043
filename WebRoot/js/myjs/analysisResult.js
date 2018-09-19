var totalRecord, currentPage;

var page_info_area = $("#var_page_info_area");
var page_nav_area = $("#var_page_nav_area");
var form = $("#var-form");
var projectid = $("body").attr("projectid");
var analysis = $("body").attr("analysis");
if (!(projectid>0)) {
	window.location.href = "project/queryProjects1";
}
to_page(page_info_area, page_nav_area, 1);
// 解析显示分页信息
function build_page_info(ele1, ele2, result) {
	ele1.empty();
	ele1.append("【当前第" + result.pageNum + "页,共" + result.pages + "页,总共"
			+ result.total + "条记录】");
}
// 解析显示分页条，点击分页要能去下一页....
function build_page_nav(ele1, ele2, result) {
	// page_nav_area
	ele2.empty();
	var ul = $("<ul></ul>").addClass("pagination");

	// 构建元素
	var firstPageLi = $("<li></li>").append(
			$("<a></a>").append("首页").attr("href", "#"));
	var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
	if (result.hasPreviousPage == false) {
		firstPageLi.addClass("disabled");
		prePageLi.addClass("disabled");
	} else {
		// 为元素添加点击翻页的事件
		firstPageLi.click(function() {
			to_page(ele1, ele2, 1);
		});
		prePageLi.click(function() {
			to_page(ele1, ele2, result.pageNum - 1);
		});
	}
	var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
	var lastPageLi = $("<li></li>").append(
			$("<a></a>").append("末页").attr("href", "#"));
	if (result.hasNextPage == false) {
		nextPageLi.addClass("disabled");
		lastPageLi.addClass("disabled");
	} else {
		nextPageLi.click(function() {
			to_page(ele1, ele2, result.pageNum + 1);
		});
		lastPageLi.click(function() {
			to_page(ele1, ele2, result.pages);
		});
	}
	// 添加首页和前一页 的提示
	ul.append(firstPageLi).append(prePageLi);
	// 1,2，3遍历给ul中添加页码提示
	$.each(result.navigatepageNums, function(index, item) {

		var numLi = $("<li></li>").append($("<a></a>").append(item));
		if (result.pageNum == item) {
			numLi.addClass("active");
		}
		numLi.click(function() {
			to_page(ele1, ele2, item);
		});
		ul.append(numLi);
	});
	// 添加下一页和末页 的提示
	ul.append(nextPageLi).append(lastPageLi);

	// 把ul加入到nav
	var navEle = $("<nav></nav>").append(ul);
	navEle.appendTo(ele2);
}

function build_table(result) {
	// 清空table表格
	form.find('tbody').empty();
	var items = result.pageInfo.list;
	if (result.type == "var" && result.pageInfo.size != 0) {
		$.each(items, function(index, item) {
			var vName = $("<td></td>").append(item.vName);
			var vModifier = $("<td></td>").append(item.vModifier);
			var vType = $("<td></td>").append(item.vType);
			var vValue = $("<td></td>").append(item.vValue);
			var fName = $("<td></td>").append(
					item.fName == null ? "无" : item.fName);
			var cName = $("<td></td>").append(
					item.cName == null ? "无" : item.cName);
			var pName = $("<td></td>").append(item.pName);
			$("<tr></tr>").append(vName).append(vModifier).append(vType)
					.append(vValue).append(fName).append(cName).append(pName)
					.appendTo("#var-form tbody");
		});
	}
	;
	if (result.type == "function" && result.pageInfo.size != 0) {
		$.each(items, function(index, item) {
			var fParameter = $("<td></td>").append(item.fParameter);
			var fModifiter = $("<td></td>").append(item.fModifiter);
			var fReturntype = $("<td></td>").append(item.fReturntype);
			var fName = $("<td></td>").append(item.fName);
			var pName = $("<td></td>").append(
					item.pName == null ? "无" : item.pName);
			var cName = $("<td></td>").append(
					item.cName == null ? "无" : item.cName);
			$("<tr></tr>").append(fName).append(fModifiter).append(fReturntype)
					.append(fParameter).append(cName).append(pName).appendTo(
							"#function-form tbody");
		});
	}
	if (result.type == "classment" && result.pageInfo.size != 0) {
		$.each(items, function(index, item) {
			var vName = $("<td></td>").append(item.vName);
			var vModifier = $("<td></td>").append(item.vModifier);
			var vType = $("<td></td>").append(item.vType);
			var vValue = $("<td></td>").append(item.vValue);
			var fName = $("<td></td>").append(
					item.fName == null ? "无" : item.fName);
			var cName = $("<td></td>").append(
					item.cName == null ? "无" : item.cName);
			$("<tr></tr>").append(vName).append(vModifier).append(vType)
					.append(vValue).append(fName).append(cName).appendTo(
							"#classment-form tbody");
		});
	}
}
function queryClassmentResults(pn) {

	$.ajax({
		type : "post",
		url : "projectAnalysis/queryClassmentResults",
		data : {
			"pn" : pn,
			"projectid" : projectid
		},
		dataType : 'json',
		success : function(data) {
			build_table(data);
			build_page_nav(page_info_area, page_nav_area, data.pageInfo);
			build_page_info(page_info_area, page_nav_area, data.pageInfo);

		},
		error : function() {
			/* layer.alert('获取分析结果失败！'); */
		}
	});
}
function queryVarResults(pn) {

	$.ajax({
		type : "post",
		url : "projectAnalysis/queryVarResults",
		data : {
			"pn" : pn,
			"projectid" : projectid
		},
		dataType : 'json',
		success : function(data) {
			console.log(data);
			build_table(data);
			build_page_nav(page_info_area, page_nav_area, data.pageInfo);
			build_page_info(page_info_area, page_nav_area, data.pageInfo);

		},
		error : function() {
			/* layer.alert('获取分析结果失败！'); */
		}
	});
}

function queryFunctionsResults(pn) {

	$.ajax({
		type : "post",
		url : "projectAnalysis/queryFunctionsResults",
		data : {
			"pn" : pn,
			"projectid" : projectid
		},
		dataType : 'json',
		success : function(data) {
			console.log(data);
			build_table(data);
			build_page_nav(page_info_area, page_nav_area, data.pageInfo);
			build_page_info(page_info_area, page_nav_area, data.pageInfo);

		},
		error : function() {
			/*layer.alert('获取分析结果失败！'); */
		}
	});
}

function to_page(ele1, ele2, pn) {
	if (analysis=="1") {
		 layer.msg("该项目已被解析，现将跳转到解析结果页面...", {time:2000, icon:16});
	}
    var loadingIndex = null;
	 loadingIndex = layer.msg("解析中，请稍候...", {icon: 16});
	if (form.attr("type") == "var") {
		queryVarResults(pn);
	}
	if (form.attr("type") == "function") {
		queryFunctionsResults(pn);

	}
	if (form.attr("type") == "classment") {
		queryClassmentResults(pn);
	}
	layer.close(loadingIndex);
}

$('#myTab a').click(function(e) {
	if ($(this).parent().hasClass('active')) {
		return false;
	}

	text = $(this).text();
	text = String(text).trim();
	form.find("tbody").empty();
	page_info_area.empty();
	page_nav_area.empty();

	if (text == "变量列表") {
		page_info_area = $("#var_page_info_area");
		page_nav_area = $("#var_page_nav_area");
		form = $("#var-form");

	}
	if (text == "函数列表") {
		page_info_area = $("#function_page_info_area");
		page_nav_area = $("#function_page_nav_area");
		form = $("#function-form");

	}
	if (text == "类与对象列表") {
		page_info_area = $("#classment_page_info_area");
		page_nav_area = $("#classment_page_nav_area");
		form = $("#classment-form");

	}
	to_page(page_info_area, page_nav_area, 1);
	e.preventDefault();
	$(this).tab('show');

});
