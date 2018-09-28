var totalRecord, currentPage;

var page_info_area = $("#node_page_info_area");
var page_nav_area = $("#node_page_nav_area");
var form = $("#node-form");
var projectid = $("body").attr("projectid");
var analysis = $("body").attr("analysis");
var network = $("body").attr("network");


if (!(projectid>0)) {
	window.location.href = "project/queryProjects2";
};
if (analysis==0) {
    layer.msg("该项目还未进行解析...", {time:2000, icon:5, shift:6}, function(){
    	
    });
	window.location.href = "project/queryProjects1";
};

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
	if (result.type == "node" && result.pageInfo.size != 0) {
		$.each(items, function(index, item) {
		
			var degree = $("<td></td>").append(item.degree);
			var indegree = $("<td></td>").append(item.indegree);
			var outdegree = $("<td></td>").append(item.outdegree);
			var nodeinfluenceregion = $("<td></td>").append(item.nodeinfluenceregion);
			var nodemnc = $("<td></td>").append(item.nodemnc);
			var nodedmnc = $("<td></td>").append(item.nodedmnc);
			var proximity = $("<td></td>").append(item.proximity);
			var nodecc = $("<td></td>").append(item.nodecc);
			var nodebc = $("<td></td>").append(item.nodebc);
			var nodecore = $("<td></td>").append(item.nodecore);
			var degreecentrality = $("<td></td>").append(item.degreecentrality);
			var projectid = $("<td></td>").append(item.projectid);
	
			$("<tr></tr>").append(degree).append(indegree).append(outdegree)
					.append(nodeinfluenceregion).append(nodemnc)
					.append(nodedmnc).append(proximity).append(nodecc).append(nodebc).append(nodecore).append(degreecentrality).append(projectid)
					.appendTo("#node-form tbody");
		});
	}
	;
	if (result.type == "net" && result.pageInfo.size != 0) {
		$.each(items, function(index, item) {
			var vertexnum = $("<td></td>").append(item.vertexnum);
			var edgenum = $("<td></td>").append(item.edgenum);
			var networkdiameter = $("<td></td>").append(item.networkdiameter);
			var networkcoreness = $("<td></td>").append(item.networkcoreness);
			var nodeaveragedegree = $("<td></td>").append(item.nodeaveragedegree);
			var averageshortestpathlength = $("<td></td>").append(item.averageshortestpathlength);
			var networkefficiency = $("<td></td>").append(item.networkefficiency);
			var networkclusteringcoefficient = $("<td></td>").append(item.networkclusteringcoefficient);
			var projectid = $("<td></td>").append(item.projectid);
			$("<tr></tr>").append(vertexnum).append(edgenum).append(networkdiameter)
					.append(networkcoreness).append(nodeaveragedegree).append(averageshortestpathlength).append(networkefficiency).append(networkclusteringcoefficient).append(projectid)
					.appendTo("#net-form tbody");
		});
	}
}


function queryNodeMetResults(pn) {
	

	$.ajax({
		type : "post",
		url : "network/queryNodeMetResults",
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

function queryNetworkMetResults(pn) {

	$.ajax({
		type : "post",
		url : "network/queryNetworkMetResults",
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

function to_page(ele1, ele2, pn) {
	
	if (form.attr("type") == "node") {
		queryNodeMetResults(pn);
	}
	if (form.attr("type") == "net") {
		queryNetworkMetResults(pn);

	}
	
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

	if (text == "节点级网络复杂度量") {
		page_info_area = $("#node_page_info_area");
		page_nav_area = $("#node_page_nav_area");
		form = $("#node-form");

	}
	if (text == "网络级复杂度量") {
		page_info_area = $("#net_page_info_area");
		page_nav_area = $("#net_page_nav_area");
		form = $("#net-form");

	}
	to_page(page_info_area, page_nav_area, 1);
	e.preventDefault();
	$(this).tab('show');

});
