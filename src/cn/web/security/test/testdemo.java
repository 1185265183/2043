package cn.web.security.test;

import java.util.ArrayList;
import java.util.LinkedList;

import cn.web.security.buildgraph.Buildgraph;
import cn.web.security.buildgraph.DiGraph;



public class testdemo {
	public static void main(String[] args) {
		
		Buildgraph buildgraph = new Buildgraph();
		DiGraph<String> graph = buildgraph.getGraph();
		
		
		//调用计算的函数，计算网络特征值
		/*
		PropertyComputing propertyComputing = new PropertyComputing(graph);
		
		propertyComputing.getNodeMetrics();
		
		propertyComputing.getNetworkMetrics();
		*/
		//用于测试图
		int b = graph.numberOfEdges();
		int c = graph.numberOfVertices();
		String d = graph.toString();
		System.out.println("边数："+b+"  "+"定点数："+c);
		
		System.out.println(d);
		
		//判断是否有环
		//System.out.println(DiGraphAlgorithm.containSCC(graph));
		
		//拓扑排序
		/*
		ArrayList<LinkedList<String>> componentList = DiGraphAlgorithm.stronglyConnectedComponents(graph);
		
		for(LinkedList<String> linkedList:componentList) {
			
			for(String string:linkedList) {				
				System.out.println(string);
			}
			System.out.println("*******************************************");
		}
		*/
		
		
		
	}
}
