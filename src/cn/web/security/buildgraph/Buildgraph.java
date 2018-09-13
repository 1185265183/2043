package cn.web.security.buildgraph;

import java.util.ArrayList;
import java.util.List;

import cn.web.security.pojo.Assign;
import cn.web.security.pojo.Callfunction;
import cn.web.security.pojo.Classment;
import cn.web.security.pojo.Functions;
import cn.web.security.pojo.Node;
import cn.web.security.pojo.Var;
import cn.web.security.service.impl.ProjectanalysisServiceImpl;

public class Buildgraph {
	
	private DiGraph<String> graph;
	 
	public Buildgraph() {
		this.graph = new DiGraph<String>();
		buildGraph();
	}
	
	
	/*建立函数级的软件网络*/
	private void buildGraph() {
    	
		
   	    //获得函数列表(顶点)
		List<Functions> funclist = new ArrayList<Functions>();  //改为从数据库获取指定项目的函数对象列表
        

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
    }
	
	/*构建函数与变量之间的软件网络*/
	private void buildGraph_1() {
		
		
		//获得函数列表(顶点)
        List<Functions> funclist = new ArrayList<Functions>(); //改为从数据库获取指定项目的函数对象列表
        
        String funcname = new String();
       
        if(funclist.size()!=0){
       	
       	 for(Functions function:funclist){
       	
       		 funcname = function.getName();
       		 
       		 if (!graph.containsVertex(funcname)) { //判断是否已包含该节点
                
       			 graph.addVertex(funcname);   //添加节点
                
       		 } 
       	 
       	 }
        
        }
        
        //获得变量列表（顶点）
        List<Var> varlist = new ArrayList<Var>();       //改为从数据库获取指定项目的变量对象列表（不要类属性变量，提取类实例变量）
        
        String varname = new String();
        
        if(varlist.size()!=0) {
        	
        	for(Var var:varlist) {
        		
        		varname = var.getName();
        		
        		if (!graph.containsVertex(varname)) { //判断是否已包含该节点
                    
          			 graph.addVertex(varname);   //添加节点
                   
          		 } 
        		
        	}
       
        }
               
        //获得依赖关系（边）              这里是函数指向函数的边
        List<Callfunction> callfunctionlist = new ArrayList<Callfunction>();
        
        if(callfunctionlist.size()!=0){
       
       	 for(Callfunction callfunction:callfunctionlist){
       	
       		 int fromfuncid = callfunction.getFunctionid();           //函数id
       		 int tofuncid = callfunction.getBefunctionid();       //被调用函数的id
       		 
       		 String fromfuncname = new String();          //查询数据库，根据函数Id找到对应的函数名
       		 String tofuncname = new String();           //查询数据库，根据函数Id找到对应的函数名
       		 
       	     graph.addEdge(String.valueOf(fromfuncid), String.valueOf(tofuncid), 1);

       	 }
        }
		
		//获得依赖关系（边）           这里是函数指向变量的边
        
        //List<Var> varlist = new ArrayList<Var>();      //和上边的varlist是同一个变量
        List<Assign> assignlist = new ArrayList<Assign>();  //从数据库获得指定项目的赋值对象列表
        
        if(varlist.size()!=0) {
        	for(Var var:varlist) {
        		
        		int fromfuncid = var.getFunctionid();        //变量所属函数的id
        		String fromfuncname = new String();          //根据函数Id找到  对应的函数名
    
        		String tovarname = var.getName();             //变量名 
        		
        		graph.addEdge(fromfuncname,tovarname,1);
        		
        	}
        }
        
        if(assignlist.size()!=0) {
        	for(Assign assign:assignlist) {
        		
        		int fromfuncid = assign.getFunctionid();	 //变量所属函数的id
        		String fromfuncname = new String();          //根据函数Id找到  对应的函数名
        		
        		int tovarid = assign.getBevarid();
        		String tovarname = new String();
        		
        		graph.addEdge(fromfuncname,tovarname,1);
        		
        	}
        }
        

		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@SuppressWarnings("unchecked")
	public DiGraph<String> getGraph() {
        return (DiGraph<String>) graph.deepClone();
    }
	
	
}
  