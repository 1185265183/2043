package cn.web.security.complexnetwork;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;



/**
 *
 * @author Loach(wei_huihui@126.com)
 *
 */
/*存放网络属性的结构*/
public class PropertyContainer {
    
    public HashMap<String, Property> m = new HashMap<String, Property>();
    
    /**网络直径属性*/
    private int networkDiameter;
    /**图的核数*/
    private int networkCoreness;
    /**vertex number*/
    private int vertexNum;
    /**edge number*/
    private int edgeNum;
    /**average shortest path length*/
    private double aspl;
    /**network clustering coefficient*/
    private double clusteringCoefficient;
    /**自己加的  网络效率  属性*/
    private double networkEfficiency;
    /**节点平均度*/
    private double nodeAverageDegree;
    /**自己加的  最短路径数目  属性*/
    private int shortestPathNumOfGraph;
    /**network coreness*/
    private int coreness;
    /**network coreness-in*/
    private int coreness_in;
    /**network coreness-out*/
    private int coreness_out;
    /**average degree*/
    private float k;
    /**average in-degree*/
    private float k_in;
    /**average out-degree*/
    private float k_out;
    /**strongly connected core size*/
    private int SCCore_Size;
    /**strongly connected core edges*/
    private int SCCore_Edges;
    /**the number of SCC which size > 1*/
    private int component_num;
    /***/
    private int all_componentSize;
    /***/
    private int max_componentSize;

    public Property getProperty(String vertex) {
        Property p = m.get(vertex);
        if (p == null) {
            p = new Property();
            m.put(vertex, p);
        }
        return p;
    }
    
    public void setnetworkCoreness(int networkCoreness){
    	this.networkCoreness = networkCoreness;
    }
    public  void setNodeAverageDegree(double nodeAverageDegree){
    	this.nodeAverageDegree=nodeAverageDegree;
    }
    public double getNodeAverageDegree(){
    	return nodeAverageDegree;
    }
    public void setAspl(double aspl) {
        this.aspl = aspl;
    }
    
    public void setnetworkDiameter(int networkDiameter){
    	this.networkDiameter =networkDiameter;
    }
    
    public void setClusteringCoefficient(double clusteringCoefficient) {
        this.clusteringCoefficient = clusteringCoefficient;
    }

    public double getAspl() {
        return aspl;
    }
    
    public int getnetworkCoreness(){
    	return networkCoreness;
    }
    public double getNetworkEfficiency() {
        return networkEfficiency;
    }
    public double getClusteringCoefficient() {
        return clusteringCoefficient;
    }
    public int getshortestPathNumOfGraph(){
    	return shortestPathNumOfGraph;
    }
    public void setshortestPathNumOfGraph(int shortestPathNumOfGraph){
    	this.shortestPathNumOfGraph = shortestPathNumOfGraph;
    }
    public int getVertexNum() {
        return vertexNum;
    }

    public void setVertexNum(int vertexNum) {
        this.vertexNum = vertexNum;
    }

    public int getEdgeNum() {
        return edgeNum;
    }

    public void setEdgeNum(int edgeNum) {
        this.edgeNum = edgeNum;
    }
    
    public int getnetworkDiameter(){
    	return networkDiameter;
    }
    
    public int getCoreness() {
        coreness = 0;
        Iterator<Entry<String, Property>> iter = m.entrySet().iterator();
        while (iter.hasNext()) {
            Entry<String, Property> entry = iter.next();
            if (entry.getValue().getNodeCore() > coreness) {
                coreness = entry.getValue().getNodeCore();
            }
        }
        return coreness;
    }

    public int getCoreness_in() {
        coreness_in = 0;
        Iterator<Entry<String, Property>> iter = m.entrySet().iterator();
        while (iter.hasNext()) {
            Entry<String, Property> entry = iter.next();
            if (entry.getValue().getNodeCoreIndegree() > coreness_in) {
                coreness_in = entry.getValue().getNodeCoreIndegree();
            }
        }
        return coreness_in;
    }

    public int getCoreness_out() {
        coreness_out = 0;
        Iterator<Entry<String, Property>> iter = m.entrySet().iterator();
        while (iter.hasNext()) {
            Entry<String, Property> entry = iter.next();
            if (entry.getValue().getNodeCoreOutdegree() > coreness_out) {
                coreness_out = entry.getValue().getNodeCoreIndegree();
            }
        }
        return coreness_out;
    }

    public float getK() {
        double sum = 0;
        Iterator<Entry<String, Property>> iter = m.entrySet().iterator();
        while (iter.hasNext()) {
            Entry<String, Property> entry = iter.next();
            sum += entry.getValue().getIndegree() + entry.getValue().getOutdegree();
        }
        return k = (float) (sum * 1.0 / m.size());
    }

    public float getK_in() {
        double sum = 0;
        Iterator<Entry<String, Property>> iter = m.entrySet().iterator();
        while (iter.hasNext()) {
            Entry<String, Property> entry = iter.next();
            sum += entry.getValue().getIndegree();
        }
        return k_in = (float) (sum * 1.0 / m.size());
    }

    public float getK_out() {
        double sum = 0;
        Iterator<Entry<String, Property>> iter = m.entrySet().iterator();
        while (iter.hasNext()) {
            Entry<String, Property> entry = iter.next();
            sum += entry.getValue().getOutdegree();
        }
        return k_out = (float) (sum * 1.0 / m.size());

    }

    public int getSCCore_Size() {
        return SCCore_Size;
    }

    public void setSCCore_Size(int sCCoreSize) {
        SCCore_Size = sCCoreSize;
    }

    public int getSCCore_Edges() {
        return SCCore_Edges;
    }

    public void setSCCore_Edges(int sCCoreEdges) {
        SCCore_Edges = sCCoreEdges;
    }

    public int getComponent_num() {
        return component_num;
    }

    public void setComponent_num(int componentNum) {
        component_num = componentNum;
    }
    public void setNetworkEfficiency(double networkEfficiency) {
    	this.networkEfficiency = networkEfficiency;
    }
    public int getAll_componentSize() {
        return all_componentSize;
    }

    public void setAll_componentSize(int allComponentSize) {
        all_componentSize = allComponentSize;
    }

    public int getMax_componentSize() {
        return max_componentSize;
    }

    public void setMax_componentSize(int maxComponentSize) {
        max_componentSize = maxComponentSize;
    }

    public int[] getDegreeDistribution(){
        int[] distribution = new int[2*m.size()];
        Iterator<Entry<String, Property>> iter = m.entrySet().iterator();
        int degree = -1;
        while (iter.hasNext()) {
            Entry<String, Property> entry = iter.next();
            degree = entry.getValue().getIndegree() + entry.getValue().getOutdegree();
            distribution[degree]++;
        }
        return distribution;
    }

    public int[] getInDegreeDistribution(){
        int[] distribution = new int[m.size()+1];
        Iterator<Entry<String, Property>> iter = m.entrySet().iterator();
        int degree = -1;
        while (iter.hasNext()) {
            Entry<String, Property> entry = iter.next();
            degree = entry.getValue().getIndegree();
            distribution[degree]++;
        }
        return distribution;
    }

    public int[] getOutDegreeDistribution(){
        int[] distribution = new int[m.size()+1];
        Iterator<Entry<String, Property>> iter = m.entrySet().iterator();
        int degree = -1;
        while (iter.hasNext()) {
            Entry<String, Property> entry = iter.next();
            degree = entry.getValue().getOutdegree();
            distribution[degree]++;
        }
        return distribution;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("VertexNum -").append(vertexNum).append("\n");
        sb.append("EdgeNum -").append(edgeNum).append("\n");
        sb.append("ASPL -").append(aspl).append("\n");
        sb.append("NCC -").append(clusteringCoefficient).append("\n");
        sb.append("<k> -").append(this.getK()).append("\n");
        //sb.append("<k-in> -").append(this.getK_in()).append("\n");
        //sb.append("<k-out> -").append(this.getK_out()).append("\n");
        sb.append("Coreness -").append(this.getCoreness()).append("\n");
        sb.append("Coreness-in -").append(this.getCoreness_in()).append("\n");
        sb.append("Coreness-out -").append(this.getCoreness_out()).append("\n");

        Iterator<Entry<String, Property>> iter = m.entrySet().iterator();
        while (iter.hasNext()) {
            Entry<String, Property> entry = iter.next();
            sb.append(entry.getKey()).append(":").append(entry.getValue().toString());
        }
        return sb.toString();
    }

    
}
