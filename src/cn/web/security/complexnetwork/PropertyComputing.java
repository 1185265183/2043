package cn.web.security.complexnetwork;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.stringtemplate.v4.compiler.CodeGenerator.list_return;

import com.sun.jndi.cosnaming.CNCtx;

import cn.web.security.buildgraph.DiGraph;
import cn.web.security.buildgraph.LinkedQueue;
import cn.web.security.buildgraph.VertexColor;
import cn.web.security.pojo.Networkmetrics;
import cn.web.security.pojo.Nodemetrics;

public class PropertyComputing {
	
	 	final public static int INFINITY = Integer.MAX_VALUE;
	 	
	 	//属性容器（用于记录多个顶点的属性）
		private PropertyContainer pc;
		
		//输入的有向图
		private DiGraph<String> graph;
		
		///////////////////////这个为我们使用的构造器/////////////////////////////////
		public PropertyComputing(DiGraph<String> graph){
			this.pc = new PropertyContainer();
			this.graph = graph;
		}
		
		/**
		 * 计算所有节点的相关度量，并存入数据库
		 * 该函数之前要调用PropertyComputing(DiGraph<String> graph,PropertyContainer pc)
		 */
		public List<Nodemetrics> getNodeMetrics(int projectid){
			/////////以下全是节点度量///////////////
			System.out.println("开始计算节点级别的复杂网络度量");
			
			this.degree();//度、入度、出度
			System.out.println("完成‘度’的计算");
			
			this.allNodeInfluenceRegion();//影响范围
			System.out.println("完成‘影响范围’的计算");
			
			this.allDegreeCentrality();//度中心性
			System.out.println("完成‘度中心性’的计算");
			
			this.allMNC();//最大邻居连通度
			System.out.println("完成‘最大邻居连通度’的计算");
			
			this.allDMNC();//最大邻居连通密度
			System.out.println("完成‘最大邻居连通密度’的计算");

			this.Proximity();//接近度
			System.out.println("完成‘接近度’的计算");
			
			this.allNodeClusteringCoefficient();//聚集系数
			System.out.println("完成‘聚集系数’的计算");
			
			this.betweennessCentrality();//介数
			System.out.println("完成‘介数’的计算");
			
			this.coreness_Decomposition();//核数
			System.out.println("完成‘核数’的计算");

			System.out.println("开始将nodemetrics存入数据库");
			
			Iterator<String> iter = graph.vertexSet().iterator();             //该迭代器用于遍历图的顶点集
			
			String vertexName = null;
			
			List<Nodemetrics> nodeMetricsList = new LinkedList<Nodemetrics>();               //顶点属性集
			
			while(iter.hasNext()){
				
				vertexName = iter.next();
				
				Property property = pc.getProperty(vertexName);
				
				int degree = property.getDegree();
				System.out.println("度："+degree);
				
				int inDegree = property.getIndegree();
				System.out.println("入度"+inDegree);
				
				int outDegree = property.getOutdegree();
				System.out.println("出度："+outDegree);
				
				double nodeInfluenceRegion = property.getInfluenceRegion();
				System.out.println("影响范围："+nodeInfluenceRegion);
				
				double nodeMNC = property.getMNC();
				System.out.println("最大邻居连通度："+nodeMNC);
				
				double nodeDMNC = property.getDMNC();
				System.out.println("最大邻居连通密度："+nodeDMNC);
				
				double proximity = property.getProximity();
				System.out.println("接近度："+proximity);
				
				double nodeCC = property.getNodeCC();
				System.out.println("节点聚类系数"+nodeCC);
				
				double nodeBC = property.getNodeBC();
				System.out.println("节点中介中心性"+nodeBC);
				
				int nodeCore =  property.getNodeCore();
				System.out.println("node core："+nodeCore);
				
				double degreeCentrality = property.getDegreeCentrality();
				System.out.println("度中心性："+degreeCentrality);
				
				/*
				NodeId nodeId = new NodeId(application,vertexName);
				NodeDAO nodeDAO = new NodeDAO();
				Node node = nodeDAO.findById(nodeId);
				if(node!=null){	
				NodeMetricsId nodeMetricsId = new NodeMetricsId(node);
				NodeMetrics nodeMetrics = new NodeMetrics(nodeMetricsId);
				
				nodeMetrics.setDegree(degree);
				nodeMetrics.setDegreeCentrality(degreeCentrality);
				nodeMetrics.setDMNC(nodeDMNC);
				nodeMetrics.setInDegree(inDegree);
				nodeMetrics.setOutDegree(outDegree);
				nodeMetrics.setInfluenceRegion(nodeInfluenceRegion);
				nodeMetrics.setMNC(nodeMNC);
				nodeMetrics.setNodeBC(nodeBC);
				nodeMetrics.setNodeCC(nodeCC);
				nodeMetrics.setNodeCore(nodeCore);
				nodeMetrics.setProximity(proximity);
				nodeMetricsList.add(nodeMetrics);
				}else{
					System.out.println("节点："+vertexName+"不存在");
				}
				*/
                Nodemetrics nodeMetrics = new Nodemetrics();
				
				nodeMetrics.setDegree(degree);
				nodeMetrics.setDegreecentrality(degreeCentrality);
				nodeMetrics.setNodedmnc(nodeDMNC);
				nodeMetrics.setIndegree(inDegree);
				nodeMetrics.setOutdegree(outDegree);
				nodeMetrics.setNodeinfluenceregion(nodeInfluenceRegion);
				nodeMetrics.setNodemnc(nodeMNC);
				nodeMetrics.setNodebc(nodeBC);
				nodeMetrics.setNodecc(nodeCC);
				nodeMetrics.setNodecore(nodeCore);
				nodeMetrics.setProximity(proximity);
				nodeMetrics.setProjectid(projectid);
				nodeMetricsList.add(nodeMetrics);
				
		}
			//nodeMetricsService.addNodeMetricsBylist(nodeMetricsList);
			System.out.println("nodemetrics存入数据库 完成");
			return nodeMetricsList;
	   }
		
		/**
		 *计算输入粒度的网络的度量，并存入数据库
		 */
		public Networkmetrics getNetworkMetrics(int projectid){
			//////////以下全是网络度量///////////
			System.out.println("开始计算网络级别的复杂网络度量");
			
			pc.setVertexNum(graph.numberOfVertices());
			System.out.println("完成‘节点数’的计算");
			
			pc.setEdgeNum(graph.numberOfEdges());
			System.out.println("完成‘网络边数’的计算");
			
			this.networkDiameter();//网络直径
			System.out.println("完成‘网络直径’的计算");
			
			this.nodeAverageDegree();//网络节点平均度
			System.out.println("完成‘网络节点平均度’的计算");
			
			this.networkClusteringCoefficient();//聚集系数
			System.out.println("完成‘聚集系数’的计算");
			
			this.networkCoreness();//网络核数
			System.out.println("完成‘网络核数’的计算");
			
			this.getNetworkEfficiency();//网络效率
			System.out.println("完成‘网络效率’的计算");
			
			this.averageShortestPathLength();//网络平均最短路径长度
			System.out.println("完成‘网络平均最短路径长度’的计算");
			
			System.out.println("开始将网络级度量存入数据库");
			
			int vertexNum = pc.getVertexNum();
			System.out.println("节点数:"+vertexNum);
			
			int edgeNum = pc.getEdgeNum();
			System.out.println("网络边数:"+edgeNum);
			
			int networkDiameter = pc.getnetworkDiameter();
			System.out.println("网络直径:"+networkDiameter);
			
			int networkCoreness = pc.getnetworkCoreness();
			System.out.println("网络核数:"+networkCoreness);
			
			double nodeAverageDegree = pc.getNodeAverageDegree();
			System.out.println("网络节点平均度:"+nodeAverageDegree);
			
			double averageShortestPathLength = pc.getAspl();
			System.out.println("网络平均最短路径长度:"+averageShortestPathLength);
			
			double networkEfficiency = pc.getNetworkEfficiency();
			System.out.println("网络效率:"+networkEfficiency);
			
			double networkClusteringCoefficient = pc.getClusteringCoefficient();
			System.out.println("聚集系数:"+networkClusteringCoefficient);
			
			/*
			if(!classNetworkMetricsService.judgeClassNetworkMetricsByApplicatiuon(application)){
				
				classNetworkMetricsService.addClassNetworkMetrics(application, vertexNum, edgeNum, 
						networkDiameter, averageShortestPathLength, networkClusteringCoefficient, networkCoreness,
						networkEfficiency, nodeAverageDegree);
				
			}else{
				classNetworkMetricsService.updateClassNetworkMetrics(application, vertexNum, edgeNum, 
						networkDiameter, averageShortestPathLength, networkClusteringCoefficient, networkCoreness, 
						networkEfficiency, nodeAverageDegree);
			}
			*/
			
			Networkmetrics networkmetrics=new Networkmetrics();
			networkmetrics.setVertexnum(vertexNum);
			networkmetrics.setEdgenum(edgeNum);
			networkmetrics.setNetworkdiameter(networkDiameter);
			networkmetrics.setNetworkcoreness(networkCoreness);
			networkmetrics.setNodeaveragedegree(nodeAverageDegree);
			networkmetrics.setAverageshortestpathlength(averageShortestPathLength);
			networkmetrics.setNetworkefficiency(networkEfficiency);
			networkmetrics.setNetworkclusteringcoefficient(networkClusteringCoefficient);
			networkmetrics.setProjectid(projectid);
			System.out.println("网络级度量存入数据库  完成");
			return networkmetrics;
					
		}
		
		
		/**
		 * 网络直径
		 */
		public void networkDiameter(){
			Iterator<String> iter = graph.vertexSet().iterator();
			
			LinkedList<LinkedList<String>> shortestPathSet = new LinkedList<LinkedList<String>>();
			shortestPathSet = shortestPathSet();
			//System.out.println("最短路径条数："+shortestPathSet.size());
			Iterator<LinkedList<String>> iterList = shortestPathSet.iterator();
			
			LinkedList<String> llist = new LinkedList<String>();
			
			int[] networkDiameter = new int[shortestPathSet.size()];
			int size;
			int i=0;
			while(iterList.hasNext()){
				llist = iterList.next();
				size = llist.size();
				networkDiameter[i] = size;
				i++;
			}
			int D=0;
			for(int j=0;j<networkDiameter.length;j++){
				//System.out.println(networkDiameter[j]);
				if(networkDiameter[j]>D){
					D = networkDiameter[j];
				}
			}
			
			pc.setnetworkDiameter(D);
		}
	    
		/**
		 * 计算网络节点平均度
		 * 网络中所有节点的度的平均值
		 */
		public void nodeAverageDegree(){
			int nodeNum = graph.numberOfVertices();
			int  sumNodeDegree = 0;
			double nodeAverageDegree = 0;
			Iterator<String> iter = graph.vertexSet().iterator();
			String vertex = null;
			while(iter.hasNext()){
				vertex = iter.next();
				sumNodeDegree+=(graph.inDegree(vertex)+graph.outDegree(vertex));
			}
			if(nodeNum!=0){
				nodeAverageDegree = sumNodeDegree*1.0/nodeNum;
				nodeAverageDegree = BigDecimal.valueOf(nodeAverageDegree).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
			}
			pc.setNodeAverageDegree(nodeAverageDegree);
		}
		
		/**
	     * 网络平均聚集系数
	     *
	     * @param graph
	     */
	    public void networkClusteringCoefficient(){
	    	Iterator<String> iter = graph.vertexSet().iterator();
	        String sVertex = null;

	        Property property;
	        double ncc = 0;
	        double nodeCC = 0;
	        while(iter.hasNext()){
	        	sVertex = iter.next();
	        	nodeCC = nodeClusteringCoefficient(sVertex);

	        	ncc += nodeCC;

	        	nodeCC = BigDecimal.valueOf(nodeCC).setScale(7, BigDecimal.ROUND_HALF_UP).doubleValue();

	        	property = pc.getProperty(sVertex);
	        	property.setNodeCC(nodeCC);
	        }
	        //计算公式
	        if(graph.vertexSet().size() != 0){
	        	ncc = ncc / graph.vertexSet().size();
	            ncc = BigDecimal.valueOf(ncc).setScale(7, BigDecimal.ROUND_HALF_UP).doubleValue();
	        }else{
	        	ncc = 0;
	        }
	        pc.setClusteringCoefficient(ncc);
	    }
		
	    /**
	     * 求图的核数(即节点核数的最大值)
	     */
	    public void networkCoreness(){
	    	Iterator<String> Iter = graph.vertexSet().iterator();
	    	
	    	int n;
	    	int networkCoreness=0;
	    	String vertex = null;
	    	while(Iter.hasNext()){
	    		vertex = Iter.next();
	    		n = pc.getProperty(vertex).getNodeCore();
	    		
	    		if(n>networkCoreness){
	    			networkCoreness = n;
	    		}
	    	}
	    	pc.setnetworkCoreness(networkCoreness);
	    }
		
	    public void getNetworkEfficiency(){
			
			Set<String> Llink = graph.vertexSet();
			LinkedList<LinkedList<String>> shortestPathSet = shortestPathSet();
			
			double sum = 0;
			//int test = 0;
			//LinkedList<String> link = new LinkedList<String>();
			
			for(LinkedList<String> link:shortestPathSet){
				if(link.size()>1){
					int test = link.size()-1;
					
					sum = sum + (1.0/test);
					//System.out.println("sum:"+sum);
					}
			}
				
			double networkEfficiency;
			int num = graph.vertexSet().size();
			if(num != 1&&num != 0){
				networkEfficiency = sum * 1.0 /(num * (num - 1));
				
			}
			else{
				networkEfficiency = 0;
				
			}
			// 保留7位小数
			networkEfficiency = BigDecimal.valueOf(networkEfficiency).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
			
			pc.setNetworkEfficiency(networkEfficiency);
		}
		
	    /**
		 * 网络平均最短路径长度
		 * @param graph
		 */
		public void averageShortestPathLength(){

			/*Iterator<String> iter = graph.vertexSet().iterator();
			String vertexName = null;
			int sum = 0;

			while (iter.hasNext()) {
				vertexName = iter.next();
				sum += getShortestPathLength(vertexName);
			}*/
			Set<String> Llink = graph.vertexSet();
			LinkedList<LinkedList<String>> shortestPathSet = new LinkedList<LinkedList<String>>();
			shortestPathSet = shortestPathSet();
			double sum = 0;
			
			//LinkedList<String> link = new LinkedList<String>();
			
			for(LinkedList<String> link:shortestPathSet){
				sum+=(link.size()-1);
			}
			// 计算平均值
			double aspl;
			int num = graph.vertexSet().size();
			if(num!= 1&&num!=0){
				 aspl = sum * 1.0 /(num * (num - 1));
			}
			else{
				aspl = 0;
			}

			// 保留三位小数
			aspl = BigDecimal.valueOf(aspl).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();

			pc.setAspl(aspl);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*完成‘度’的计算*/
		private void degree(){
	    	Iterator<String> iter = graph.vertexSet().iterator();
	    	String vertex;
	    	Property property;
	    	while(iter.hasNext()){
	    		vertex = iter.next();
	    		property = pc.getProperty(vertex);
	    		property.setIndegree(graph.inDegree(vertex));
	    		property.setOutdegree(graph.outDegree(vertex));
	    		property.setDegree(graph.inDegree(vertex)+graph.outDegree(vertex));
	    	}
	    }	
		
		/**
		 * 计算所有节点的影响范围，并给每个节点赋值
		 */
		public  void allNodeInfluenceRegion(){
			visitedSetClear();
			double influenceRegion = 0;
			
			Iterator<String> iter = graph.vertexSet().iterator();
			String vertexName = null;
			while(iter.hasNext()){
				vertexName = iter.next();
				visitedSetClear();
				influenceRegion = nodeInfluenceRegion(vertexName)-1;
				Property property = pc.getProperty(vertexName);
				property.setInfluenceRegion(influenceRegion);
			}
			
		}
		
		/**
		 * 计算所有节点的度中心性
		 */
		public void allDegreeCentrality(){
			double degreeCentrality = 0;
			String vertex = null;
			Property property;
			
			Iterator<String> iter = graph.vertexSet().iterator();
			while(iter.hasNext()){
				vertex = iter.next();
				degreeCentrality = degreeCentrality(vertex);
				property = pc.getProperty(vertex);
				property.setdegreeCentrality(degreeCentrality);
			}
		}
		
		/**
	     * 网络中所有节点介数
	     *
	     * @param graph
	     */
	    public void betweennessCentrality(){
	    System.out.println("开始计算 介数：");
	    	Iterator<String> iter = graph.vertexSet().iterator();


	    	LinkedList<LinkedList<String>> shortestPathSet =  new LinkedList<LinkedList<String>>();
	    	shortestPathSet = shortestPathSet();
	    	
	    	//统计并计算
	        Iterator<LinkedList<String>> iterList = shortestPathSet.iterator();
	        LinkedList<String> shortestPath = new LinkedList<String>();

	        Iterator<String> iterPath;

	        String vertex;
	        double temp = 0.0;
	        
	        int i = 0;//测试用
	        Property property ;
	       
	        while (iterList.hasNext()) {
	            shortestPath = iterList.next();
	            iterPath = shortestPath.iterator();
	            i++;
	           
	            while (iterPath.hasNext()) {
	                String v = iterPath.next();
	               
	                pc.getProperty(v).increaseNodeBC();
	             
	            }
	        }    
	        iter = graph.vertexSet().iterator();//重置
	        while (iter.hasNext()) {
	            vertex = iter.next();
	            
	            property = pc.getProperty(vertex);
	            temp = property.getNodeBC();
	           
	            if(pc.getshortestPathNumOfGraph() !=0){
	            	temp = BigDecimal.valueOf(temp * 1.0 / pc.getshortestPathNumOfGraph()).setScale(9, BigDecimal.ROUND_HALF_UP).doubleValue();   
	            }
	            else{
	            	temp = 0;
	            }
	            //System.out.println("节点:"+vertex+" 的介数为："+temp);
	            property.setNodeBC(temp);
	        }
	       
	     
	    }
		
	    /**
	     * 所有节点核数
	     * k-core(相当于无向图)
	     * @param graph
	     */
	    public void coreness_Decomposition(){
	    	System.out.println("开始计算 核数");
	    	DiGraph<String> copy = (DiGraph<String>) graph.deepClone();
	    	int kcore = 0;
	    	int minDegree = 0;
	    	int degree = 0;
	    	int numOfVertex = copy.vertexSet().size();

	    	int counter = 0; //用于测试

	    	Iterator<String> iter = copy.vertexSet().iterator();
	    	String sVertex = null;

	    	Property property;

	    	while(true){

				//Debugger.println("*******************************"+kcore);
	    		while(true && numOfVertex > 0){
	    			iter = copy.vertexSet().iterator();
	    			while(iter.hasNext()){ //完成一轮
	    				sVertex = iter.next();
	    				degree = copy.inDegree(sVertex) + copy.outDegree(sVertex);

	    				if(degree > kcore){
	    					continue;
	    				}
	    				else{
	    					counter++;
	    					iter.remove();    //这个操作完成了节点删除
	    					//System.out.println(sVertex+": "+kcore);
	    					property = pc.getProperty(sVertex);
	    					property.setNodeCore(kcore);
	    					//System.out.println("节点："+sVertex+" 的核数为："+kcore);
	    					//k_core_Map.put(sVertex, kcore);
	    				}
	    			}
	    			//判断是否剩余子图中还含有度小于kcore的节点
	    			minDegree = minimalDegree(copy);
	    			if(minDegree > kcore){ //跳出循环
	    				kcore++;
	    				break;
	    			}

	    		}
	    		numOfVertex = copy.vertexSet().size();
	    		if(numOfVertex == 0){ //降解完毕
	    			break;
	    		}
	    	}
	    }
		
		
	    /**
	     * 图中最小度
	     *
	     * @param graph
	     * @return
	     */
	    private int minimalDegree(DiGraph<String> graph){
	    	int miniDegree = Integer.MAX_VALUE;
	    	int degree = 0;
	    	String vertex = null;

	    	Iterator<String> iter = graph.vertexSet().iterator();
	    	while(iter.hasNext()){
	    		vertex = iter.next();
	    		degree = graph.inDegree(vertex) + graph.outDegree(vertex);
	    		if(miniDegree > degree){
	    			miniDegree = degree;
	    		}
	    	}
	    	return miniDegree;
	    }
		
		
		
		
		
		/**
		 * 节点度中心性
		 * 节点i的相关联边数/节点i可能存在的最大边数
		 * @param vertex
		 * @return
		 */
		public double degreeCentrality(String vertex){
			double DegreeCentrality = 0 ;
			//节点的相关联边数，即为该节点的度数
			int degree = graph.inDegree(vertex)+graph.outDegree(vertex);
			int nodeNum = graph.numberOfVertices();
			if(nodeNum!=1){
				DegreeCentrality = degree*1.0/(2*(nodeNum-1));
			    DegreeCentrality = BigDecimal.valueOf(DegreeCentrality).setScale(9, BigDecimal.ROUND_HALF_UP).doubleValue();
				
			}
			return DegreeCentrality;
		}
		
		/**
		 * 计算图中所有节点的MNC
		 */
		public void allMNC(){
			System.out.println("开始计算MNC:");
			double nodeMNC=0;
			String vertex = null;
			Iterator<String> iter = graph.vertexSet().iterator();
			Property property;
			while(iter.hasNext()){
				vertex = iter.next();
				nodeMNC = getMNC(vertex);
				//System.out.println("节点："+vertex+" 的MNC为："+nodeMNC);
				property = pc.getProperty(vertex);
				property.setMNC(nodeMNC);
			}
					
		}
		
		/**
		 * 计算某个节点的DMNC(最大邻居连通密度)
		 * @param vertex 输入节点
		 * @return 输入节点的DMNC
		 */
		public double getDMNC(String vertex){
			double DMNC = 0;
			int edgeNum = 0;
			int nodeNum = 0;
			
			DiGraph<String> copy = (DiGraph<String>) graph.deepClone();
			copy.removeVertex(vertex);
			
			edgeNum = copy.numberOfEdges();
			nodeNum = copy.numberOfVertices();
			
			if(nodeNum!=0){
				double N = Math.pow(nodeNum, 1.7);
				DMNC = edgeNum*1.0/N;
				DMNC = BigDecimal.valueOf(DMNC).setScale(9, BigDecimal.ROUND_HALF_UP).doubleValue();
			}
			 return DMNC;
		}
		
		/**
		 * 计算输入节点的MNC
		 * @param vertex 输入节点
		 * @return 输入节点的MNC
		 */
		public int getMNC(String vertex){
			int MNC = 0;
			
			Set<String> friendSet = getFriends(vertex);
			int  size = friendSet.size();
			//System.out.println("friendSet.size"+size);
			int[] number = new int[size];
			int i=0;
			graph.colorWhite();
			
			for(String s:friendSet){
				if(graph.getColor(s)!=VertexColor.BLACK){
					number[i] = BreadthFirstSearch(s,friendSet);
					i++;
				}
			}
			//System.out.println("int[].lenth: "+number.length);
			/*for(int k=0;k<number.length;k++){
				System.out.println(k+": "+number[k]);
			}*/
			int test=0;
			for(int j=0;j<number.length;j++){
				if(number[j]>test){
					test = number[j];
					//System.out.println("此时test为："+test);
				}
			}
			MNC = test;
			return MNC;
			
		}
		/**
		 * 计算某个图的所有节点的DMNC
		 */
		public void allDMNC(){
			System.out.println("开始计算DMNC");
			Iterator<String> iter = graph.vertexSet().iterator();
			String vertex = null;
			double DMNC = 0 ;
			Property property ; 
			while(iter.hasNext()){
				vertex = iter.next();
				DMNC = getDMNC(vertex);
				//System.out.println("节点："+vertex+" 的DMNC为："+DMNC);
				property = pc.getProperty(vertex);
			    property.setDMNC(DMNC);
			}
			
		}
		
		/**
		 * 得到输入节点的朋友集合(这里定义某节点的朋友为：该节点的父母和邻居，即和该节点有直接边相连的节点，不论方向)
		 * @param vertex  输入节点
		 * @return  输入节点的朋友集合
		 */
		public Set<String> getFriends(String vertex){
			//要返回的结果：朋友集合
			Set<String> friendSet = new HashSet<String>();
			
			//输入节点的父母集合
			Set<String> neighborSet = graph.getNeighbors(vertex);
			Iterator<String> neighborIter = neighborSet.iterator();
			//输入节点的邻居集合
	        Set<String> parentSet = graph.getParents(vertex);
	        Iterator<String> parentIter = parentSet.iterator();
	        
	        String vertexName = null;
	        while(neighborIter.hasNext()){
	        	vertexName = neighborIter.next();
	        	friendSet.add(vertexName);
	        }
	        while(parentIter.hasNext()){
	        	vertexName = parentIter.next();
	        	friendSet.add(vertexName);
	        }
	        return friendSet;
		}
		//存储已访问过的节点，每次使用后要清空
	    public List<String> visited = new ArrayList<String>();
	    /**
	     * 清空visited集合。每次使用visited后要调用此方法
	     */
	    public void visitedClear(){
	    	this.visited.clear();
	    }
		/**
	     * 广度优先搜索
	     * @param vertex 输入节点
	     * @param friends 朋友集合
	     * @return 搜索后的节点数
	     */
		public int  BreadthFirstSearch(String vertex,Set<String> friends){
			int count = 0;
			Queue<String> q = new LinkedList<String>();
			q.add(vertex);
			//graph.setColor(vertex, VertexColor.BLACK);
			while(!q.isEmpty()){
				String currVertex = q.poll();
				if(!visited.contains(currVertex)){
					visited.add(currVertex);
					graph.setColor(currVertex, VertexColor.BLACK);
					Set<String> currFriends = getFriends(currVertex);
					for(String s:currFriends){
						if(friends.contains(s)){
							q.add(s);
						}
					}
				}
			}
			count = visited.size();
			visitedClear();
			return count;
		}
		
		
		public void Proximity(){
			//System.out.println("进入 接近度 计算方法");
			LinkedList<LinkedList<String>> shortestPathSet = new LinkedList<LinkedList<String>>();
			shortestPathSet = shortestPathSet();

			Iterator<String> iter = graph.vertexSet().iterator();
			int test=0;
			double proximity=0;
			Property property;
			String vertexName = null;
			while (iter.hasNext()) {
				vertexName = iter.next();
				//test= getShortestPathLength(vertexName);
				for(LinkedList<String> l:shortestPathSet){
					if(l.getFirst().endsWith(vertexName)&&l.size()>1){
						test+=(l.size()-1);
					}
				}
				if(test!=0){
				proximity = 1.0/test;
				proximity = BigDecimal.valueOf(proximity).setScale(9, BigDecimal.ROUND_HALF_UP).doubleValue();
				//System.out.println("节点："+vertexName+" 的接近度为："+proximity);
				property = pc.getProperty(vertexName);
				property.setProximity(proximity);
				} else{
					property = pc.getProperty(vertexName);
					property.setProximity(0);
				}
			}	
		}
		/**
	     * 获取最短路径集合
	     * @param graph
	     * @return
	     */
	    public LinkedList<LinkedList<String>> shortestPathSet(){
	    	LinkedList<LinkedList<String>> shortestPathSet = new LinkedList<LinkedList<String>>();

	    	Iterator<String> iter = graph.vertexSet().iterator();
	    	String sVertex = null;

	    	while(iter.hasNext()){
	    		sVertex = iter.next();

	    		shortestPath(sVertex, shortestPathSet);
	    	}

			return shortestPathSet;
	    }
		
	    
	    /**
	     * 计算所有节点的聚集系数
	     */
	    public void allNodeClusteringCoefficient(){
	    	System.out.println("开始计算 聚集系数");
	    	 double nodecc = 0;
	    	 String vertex = null;
	    	 Property property;
	    	 Iterator<String> iter = graph.vertexSet().iterator();
	    	 while(iter.hasNext()){
	    		 vertex = iter.next();
	    		 nodecc = nodeClusteringCoefficient(vertex);
	    		 //System.out.println("节点："+vertex+" 的聚集系数为："+nodecc);
	    		 property = pc.getProperty(vertex);
	    		 property.setNodeCC(nodecc);
	    	 }
	    	 
	    }
	    
	    /**
	     * 计算节点的聚集系数
	     * 思想（从源节点朋友（包括邻居和父节点）查找它们之间是否为朋友（邻居或父节点））
	     *
	     * @param graph
	     * @param sVertex
	     * @return
	     */
	    public double nodeClusteringCoefficient(String sVertex){
	        Set<String> neighborSet = graph.getNeighbors(sVertex);
	        Iterator<String> neighborIter = neighborSet.iterator();

	        Set<String> parentSet = graph.getParents(sVertex);
	        Iterator<String> parentIter = parentSet.iterator();

	        double nodecc = 0;

	        int friendNum = neighborSet.size() + parentSet.size();//该节点的直接朋友数

	        int edgesNum = 0;
	        String neighborName;
	        String parentName;

	        Set<String> friendDownSet, friendUpSet;
	        Iterator<String> friendDownIter, friendUpIter;
	        String friendName;

	        //先查看邻居
	        while (neighborIter.hasNext()) {
	            neighborName = neighborIter.next();

	            //////////////////
	            //System.out.println("->  " + neighborName);

	            //邻居的邻居
	            friendDownSet = graph.getNeighbors(neighborName);
	            friendDownIter = friendDownSet.iterator();

	            while (friendDownIter.hasNext()) {
	                friendName = friendDownIter.next();
	                if (neighborSet.contains(friendName)) {
	                    //////////////
	                    //System.out.println("    -> " + friendName + "!!!");
	                    edgesNum++;
	                }
	                if (parentSet.contains(friendName)) {
	                    /////////////
	                    //System.out.println("    -> " + friendName + "!!!");
	                    edgesNum++;
	                }
	            }

	            //邻居的父节点
	            friendUpSet = graph.getParents(neighborName);
	            friendUpIter = friendUpSet.iterator();

	            while (friendUpIter.hasNext()) {
	                friendName = friendUpIter.next();

	                if (neighborSet.contains(friendName)) {
	                    ///////////
	                    //System.out.println("    <- " + friendName + "!!!");
	                    edgesNum++;
	                }
	                if (parentSet.contains(friendName)) {
	                    /////////////////
	                    //System.out.println("    <- " + friendName + "!!!");
	                    edgesNum++;
	                }
	            }

	        }//neighbor while

	        //查看父节点
	        while (parentIter.hasNext()) {
	            parentName = parentIter.next();

	            ///////////////////
	            //System.out.println("<-  " + parentName);

	            //父节点的邻居
	            friendDownSet = graph.getNeighbors(parentName);
	            friendDownIter = friendDownSet.iterator();

	            while (friendDownIter.hasNext()) {
	                friendName = friendDownIter.next();
	                if (neighborSet.contains(friendName)) {
	                    /////////////////
	                    //System.out.println("    -> " + friendName + "!!!");
	                    edgesNum++;
	                }
	                if (parentSet.contains(friendName)) {
	                    /////////////////
	                    //System.out.println("    -> " + friendName + "!!!");
	                    edgesNum++;
	                }
	            }

	            //父节点的父节点
	            friendUpSet = graph.getParents(parentName);
	            friendUpIter = friendUpSet.iterator();

	            while (friendUpIter.hasNext()) {
	                friendName = friendUpIter.next();

	                if (neighborSet.contains(friendName)) {
	                    /////////////
	                    //System.out.println("    <- " + friendName + "!!!");
	                    edgesNum++;
	                }
	                if (parentSet.contains(friendName)) {
	                    ////////////
	                    //System.out.println("    <- " + friendName + "!!!");
	                    edgesNum++;
	                }
	            }
	        }//parent while

	        if (friendNum != 0 && friendNum != 1) {
	           
	            nodecc = (edgesNum * 1.0 / 2) / (friendNum * (friendNum - 1));
	            nodecc = BigDecimal.valueOf(nodecc).setScale(9, BigDecimal.ROUND_HALF_UP).doubleValue();  
	        } else {
	            
	        	 nodecc = 0;  
	        }

	        /////////////
	        //System.out.println("******************************************" + nodecc);
	        return nodecc;
	    }
	    
	    
	    
	    
	    
	    /**
	     * 形成最短路径子图
	     *
	     * @param graph
	     * @param sVertex  源节点
	     * @param shortestPathSet
	     */
		private void shortestPath(String sVertex,LinkedList<LinkedList<String>> shortestPathSet){
	        //存储访问节点
	        LinkedQueue<String> visitQueue = new LinkedQueue<String>();

	        Set<String> edgeSet;
	        Iterator<String> edgeIter;
	        String currVertex = null, neighborVertex = null;

	        //每个节点与源节点的最短路径长度
	        int currentPathLength;

	        if (!graph.containsVertex(sVertex)) {
	            throw new IllegalArgumentException(
	                    "shortestPath(): starting vertex not in the graph");
	        }

	        // set each vertex data value to INFINITY
	        graph.initData();

	        // sVertex is its own parent and the shortest path
	        // to itself has length 0
	        graph.setParent(sVertex, sVertex);
	        graph.setData(sVertex, 0);

	        // insert starting vertex into the queue
	        visitQueue.push(sVertex);

	        //存储最短路径上的节点
	        LinkedList<String> pathList = new LinkedList<String>();
	        //存储所有最短路径上的节点（关键节点会重复出现）
	        LinkedList<String> dfsList = new LinkedList<String>();
	        //存储源节点的可访问节点
	        LinkedList<String> accessableList = new LinkedList<String>();
	    
	        //可访问节点的数量（这里包含了自身，距离为0）
	        int accessableVertexNum = 0;

	        // process vertices until the queue is empty
	        while (!visitQueue.isEmpty()) {
	            // delete a queue entry
	            currVertex = visitQueue.pop();

	            //统计可达节点的数量
	            accessableVertexNum++;
	            accessableList.add(currVertex);

	            edgeSet = graph.getNeighbors(currVertex);
	            // sequence through the edge set and look for vertices
	            // that have not been visited. assign each such vertex
	            // a dataValue of currentPathLength + 1
	            currentPathLength = graph.getData(currVertex);
	            edgeIter = edgeSet.iterator();
	            while (edgeIter.hasNext()) {
	                neighborVertex = edgeIter.next();

	                //只对未访问节点进行操作
	                if (graph.getData(neighborVertex) == INFINITY) {
	                    //设置距离+1
	                    graph.setData(neighborVertex, currentPathLength + 1);

	                    //设置父节点（currVertex->neighborVertex）
	                    graph.setParent(neighborVertex, currVertex);
	                    //入队
	                    visitQueue.push(neighborVertex);
	                }
	            }

	            //获得路径
	            pathList = path(sVertex, currVertex);
	            if(!(pathList.size()==1&&(graph.getNeighbors(sVertex).size()!=0||graph.getParents(sVertex).size()!=0))){
	                shortestPathSet.add((LinkedList<String>) pathList.clone());
	            }
	            pc.setshortestPathNumOfGraph(shortestPathSet.size());
	            ////输出该点到每个点的路径
	            //System.out.println(pathList + "  "+(pathList.size()-1));
	        }


	        //////////////////////////////////////////////////////////////////////
	        //完成最短路径算法后,最短路径子图也就形成了
	        //可以执行计算两点之间多条最短路径的算法
	        //统计最短路径的条数和最短路径中节点集合
	        ///////////////////////////////////
	        //可访问节点中移除自身
	        /*accessableList.remove(sVertex);

	        Iterator<String> alIter = accessableList.iterator();
	        String eVertex;
	        int pathNum;*/

	        /*while (alIter.hasNext()) {
	            pathNum = 0;

	            eVertex = alIter.next();

	            depthFirstVisit_ShortestPathSubGraph(graph, sVertex, eVertex, dfsList);

	            /////////////////////
	            //System.out.println("源节点：" + sVertex + " -> 目的节点:" + eVertex);
	            //System.out.println("最短路径子图：" + dfsList);

	            //清理dfsList,去除源节点和目的节点,统计两点之间最短路径的数目
	            while (dfsList.contains(sVertex)) {
	                pathNum++;
	                dfsList.remove(sVertex);
	            }
	            dfsList.remove(eVertex);
	            ///////////////////
	            //System.out.println("最短路径条数：" + pathNum + "  " + dfsList);
	            shortestPathNumOfGraph += pathNum;

	          
	        
	           //shortestPathSet.add((LinkedList<String>) dfsList.clone());
	            /////////////////
	            //System.out.println(ComputingParameters.shortestPathSet);

	            //清空
	            dfsList.clear();
	        }*/
	    }
		
		/**
	     * 给出两个节点之间的路径（须在完成最短路径算法完成之后调用，用于测试）
	     * @param graph
	     * @param sVertex 源节点
	     * @param dVertex 目的节点
	     * @return 路径上所有节点的一个链表
	     */
	    public  LinkedList<String> path(String sVertex, String dVertex) {
	        String currVertex = dVertex;//当前节点

	        LinkedList<String> path = new LinkedList<String>();

	        if (graph.getData(dVertex) == INFINITY) {
	            return path;
	        }

	        //从目的节点反推,查找父节点
	        while (!currVertex.equals(sVertex)) {
	            path.addFirst(currVertex);
	            currVertex = graph.getParent(currVertex);
	        }

	        path.addFirst(sVertex);

	        return path;
	    }
	    
	    
	    
		
		
		
		
		//////以下部分为递归求输入节点的影响范围/////
		public Set<String> visitedSet = new HashSet<String>();
		/**
		 * 清空visitedSet，每次重新调用nodeInfluenceRegion时需调用此函数
		 */
		public void visitedSetClear(){
			visitedSet.clear();
		}
		/**
		 * 求输入节点的影响范围
		 * 最后结果需要-1
		 * 注意：每次调用前都要清空visitedSet。
		 * @param vertex 输入节点
		 * @return
		 */
		public  int nodeInfluenceRegion(String vertex){
			if(visitedSet.contains(vertex)){
				return 0;
			}
			visitedSet.add(vertex);
			if(vertex==null){
				return 0;
			}
			int count=0;
			Set<String> neighborSet = graph.getNeighbors(vertex);
			
			for(String s:neighborSet){
				if(!visitedSet.contains(s)){
				count+=nodeInfluenceRegion(s);
				}
			}
			return count+1;
		}
		
}
