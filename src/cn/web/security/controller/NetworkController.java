package cn.web.security.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.web.security.buildgraph.DiGraph;
import cn.web.security.buildgraph.DiGraphAlgorithm;
import cn.web.security.complexnetwork.PropertyComputing;
import cn.web.security.pojo.Callfunction;
import cn.web.security.pojo.Functions;
import cn.web.security.service.ProjectanalysisService;

@Controller
@RequestMapping("/network")
public class NetworkController {
	
	@Autowired
	private ProjectanalysisService projectanalysisService;
	
	//       /network/buildgraph_01/2
	
	@RequestMapping("/buildgraph_01/{projectid}")
	public void buildgraph_01(@PathVariable int projectid){
		
		DiGraph<String> graph = new DiGraph<String>();

		//构建函数级软件复杂网络
		//获得函数列表(顶点)
		List<Functions> funclist = new ArrayList<Functions>();  //改为从数据库获取指定项目的函数对象列表
		
		funclist = projectanalysisService.getFunctions(2);

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
		 
		 callfunctionlist = projectanalysisService.getCallfunctions(2);
		 
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
		
		propertyComputing.getNodeMetrics();
		
		propertyComputing.getNetworkMetrics();
		
		//计算完毕
 
	}
	
	
	
	
	
}
