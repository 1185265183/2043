package cn.web.security.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.web.security.buildgraph.DiGraph;
import cn.web.security.buildgraph.DiGraphAlgorithm;
import cn.web.security.common.StringUtil;
import cn.web.security.complexnetwork.NodeMetrics;
import cn.web.security.complexnetwork.PropertyComputing;
import cn.web.security.pojo.Callfunction;
import cn.web.security.pojo.ClassmentInfoView;
import cn.web.security.pojo.Functions;
import cn.web.security.pojo.FunctionsInfoView;
import cn.web.security.pojo.Networkmetrics;
import cn.web.security.pojo.Nodemetrics;
import cn.web.security.pojo.VarInfoView;
import cn.web.security.service.NetworkService;
import cn.web.security.service.ProjectanalysisService;
import cn.web.security.service.ResultsService;

@Controller
@RequestMapping("/network")
public class NetworkController {
	
	@Autowired
	private ProjectanalysisService projectanalysisService;
	
	@Autowired
	private NetworkService networkService;
	
	@Autowired
	private ResultsService resultsService;
	
	
	//       /network/buildgraph_01/3
	
	@RequestMapping("/buildgraph_01")
	public ModelAndView buildgraph_01(@RequestParam int projectid){
		
		
		//先进行判断该项目是否已经解析
		List<VarInfoView> list = resultsService.findAnalysisVarResults(projectid);
		List<FunctionsInfoView> list1 = resultsService.findAnalysisFunctionResults(projectid);
		List<ClassmentInfoView> list2 = resultsService.findAnalysisClassResults(projectid);
		List<Nodemetrics> list3 = networkService.getNodemetrics(projectid);
		List<Networkmetrics> list4 = networkService.getNetworkmetrics(projectid);
		System.out.println(2222222);
		System.out.println((list.size()>0||list1.size()>0||list2.size()>0)&&(list3.size()>0||list4.size()>0));
		System.out.println(list.size()==0&&list1.size()==0&&list2.size()==0);
		if ((list.size()>0||list1.size()>0||list2.size()>0)&&(list3.size()>0||list4.size()>0)) {
			ModelAndView mvAndView=new ModelAndView();
			mvAndView.addObject("projectid", projectid);
			mvAndView.addObject("analysis", "1");
			mvAndView.addObject("network", "1");
			mvAndView.setViewName("networkResult");
			return mvAndView;
		}
		if (list.size()==0&&list1.size()==0&&list2.size()==0) {
			ModelAndView mvAndView=new ModelAndView();
			mvAndView.addObject("projectid", projectid);
			mvAndView.addObject("analysis", "0");
			mvAndView.addObject("network", "1");
			mvAndView.setViewName("networkResult");
			return mvAndView;
		}
		DiGraph<String> graph = new DiGraph<String>();

		//构建函数级软件复杂网络
		//获得函数列表(顶点)
		List<Functions> funclist = new ArrayList<Functions>();  //改为从数据库获取指定项目的函数对象列表
		
		funclist = projectanalysisService.getFunctions(projectid);

		String funcname = new String();
		       
		if(funclist.size()!=0){
		       	
		     for(Functions function:funclist){
		       	
		         funcname = function.getId().toString();
		       		 
		         if (!graph.containsVertex(funcname)) { //判断是否已包含该节点
		                
		       		   graph.addVertex(funcname);   //添加节点
		                
		       	} 
		       	 
		      }
		        
		 }
		        
		 //获得依赖关系（边）
		 List<Callfunction> callfunctionlist = new ArrayList<Callfunction>();
		 
		 callfunctionlist = projectanalysisService.getCallfunctions(projectid);
		 
		 if(callfunctionlist.size()!=0){
		       
		   for(Callfunction callfunction:callfunctionlist){
		       	
		      Integer fromfuncid = callfunction.getFunctionid();           //函数id
		      Integer tofuncid = callfunction.getBefunctionid();       //被调用函数的id
		       		 
		      String fromfuncname = new String();          //查询数据库，根据函数Id找到对应的函数名(数据库中一定存在)
		      String tofuncname = new String();           //查询数据库，根据函数Id找到对应的函数名(数据库中可能没有)
		      if(tofuncid!=null){
		       	    graph.addEdge(String.valueOf(fromfuncid), String.valueOf(tofuncid), 1);
		      }
		    }
		        
		 }
         
		 //测试网络
		int b = graph.numberOfEdges();
		int c = graph.numberOfVertices();
		String d = graph.toString();
		System.out.println("边数："+b+"  "+"定点数："+c);	
		System.out.println(d);
		//判断是否有环
		System.out.println(DiGraphAlgorithm.containSCC(graph));	
		//拓扑排序
		ArrayList<LinkedList<String>> componentList = DiGraphAlgorithm.stronglyConnectedComponents(graph);		
		for(LinkedList<String> linkedList:componentList) {		
			for(String string:linkedList) {				
				System.out.println(string);
				}
		    System.out.println("*******************************************");
		}
	    
		//计算网络特征参数
        PropertyComputing propertyComputing = new PropertyComputing(graph);
		
		List<Nodemetrics> nodeMetricslList=propertyComputing.getNodeMetrics(projectid);
		
		Networkmetrics networkmetrics=propertyComputing.getNetworkMetrics(projectid);
		
		for (Nodemetrics nodemetrics : nodeMetricslList) {
			networkService.addNodemetrics(nodemetrics);
		}
		
		networkService.addNetworkmetrics(networkmetrics);
		
		System.out.println(nodeMetricslList.toString());
		System.out.println(networkmetrics.toString());
		//计算完毕
		ModelAndView mv=new ModelAndView();
		mv.addObject("projectid", projectid);
		mv.addObject("analysis", "1");
		mv.addObject("network", "0");
		mv.setViewName("networkResult");
		System.out.println(333333);
		return mv;
	}
		
	/**
	 * 根据项目id查询解析结果中的节点级网络复杂度量
	 * 
	 * @param projectid
	 * @param results
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("/queryNodeMetResults")
	@ResponseBody
	public JSONObject queryNodeMetResults(@RequestParam Map map) throws Exception {

		JSONObject result = new JSONObject();
		if (StringUtil.isNULLOREmpty((String) map.get("pn"))) {
			map.put("pn", "1");
		}
		Integer pn = Integer.valueOf((String) map.get("pn"));
		Integer projectid = Integer.valueOf((String) map.get("projectid"));
		PageHelper.startPage(pn, 10);

		List<Nodemetrics> list = networkService
				.getNodemetrics(projectid);
		System.out.println(list.toString());

		// 获取PageInfo分页bean
		PageInfo pageInfo = new PageInfo<>(list);
		result.put("type", "node");
		result.put("pageInfo", pageInfo);
		return result;
	}


	/**
	 * 根据项目id查询解析结果中的节点级网络复杂度量
	 * 
	 * @param projectid
	 * @param results
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("/queryNetworkMetResults")
	@ResponseBody
	public JSONObject queryNetworkMetResults(@RequestParam Map map) throws Exception {

		JSONObject result = new JSONObject();
		if (StringUtil.isNULLOREmpty((String) map.get("pn"))) {
			map.put("pn", "1");
		}
		Integer pn = Integer.valueOf((String) map.get("pn"));
		Integer projectid = Integer.valueOf((String) map.get("projectid"));
		PageHelper.startPage(pn, 10);

		List<Networkmetrics> list = networkService.getNetworkmetrics(projectid);
		System.out.println(list.toString());

		// 获取PageInfo分页bean
		PageInfo pageInfo = new PageInfo<>(list);
		result.put("type", "net");
		result.put("pageInfo", pageInfo);
		return result;
	}
	
	
}
