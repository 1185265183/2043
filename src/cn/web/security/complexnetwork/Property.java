package cn.web.security.complexnetwork;



/*存放节点属性的结构*/
public class Property {
	/**node clustering coefficient*/
	private double nodeCC;
	/**影响范围*/
	private  double influenceRegion;
	/**node betweenness centrality*/
	private double nodeBC;
	/** 自己加的接近度属性*/
	private double proximity;
	/** 度中心性*/
	private double degreeCentrality;
	/** 节点的偏心度*/
	private int eccentricityDegree;
	/**最大邻居连通度 */
	private double MNC;
	/**最大邻居连通密度 */
	private double DMNC;
	public int degree;
	/**node indegree*/
	private int indegree;
	
	/**node outdegree*/
	private int outdegree;
	
	/**node core*/
	private int nodeCore;
	
	/**node core indegree*/
	private int nodeCoreIndegree;
	
	/**node core outdegree*/
	private int nodeCoreOutdegree;
	
	public Property(){
		this.nodeCC = 0;
		this.nodeBC = 0;
		this.indegree = 0;
		this.outdegree = 0;
		this.nodeCore = 0;
		this.nodeCoreIndegree = 0;
		this.nodeCoreOutdegree = 0;
		this.degree = 0;
		
	}
    public void setdegreeCentrality(double degreeCentrality){
    	this.degreeCentrality = degreeCentrality;
    }
    public double getDegreeCentrality(){
    	return  degreeCentrality;
    }
	public double getNodeCC() {
		return nodeCC;
	}
    public double getInfluenceRegion(){
        return influenceRegion;
    }
    public void setInfluenceRegion(double influenceRegion){
    	this.influenceRegion = influenceRegion;
    }
	public void setMNC(double MNC){
		this.MNC = MNC;
	}
	public void setEccentricityDegree(int eccentricityDegree){
		this.eccentricityDegree = eccentricityDegree;
	}
	public void setDMNC(double DMNC){
		this.DMNC = DMNC;
	}
	
	public void setNodeCC(double nodeCC) {
		this.nodeCC = nodeCC;
	}

	public double getNodeBC() {
		return nodeBC;
	}

	public void setNodeBC(double nodeBC) {
		this.nodeBC = nodeBC;
	}
	
	public void increaseNodeBC(){
		/*double bc = this.getNodeBC();
		bc = bc + 1;
		this.setNodeBC(bc);*/
	    this.nodeBC++;
	}
    
	public double getMNC() {
		return MNC;
	}
	public double getDMNC() {
		return DMNC;
	}
	public void setDegree(int degree){
		this.degree = degree;
	}
	public  int getDegree(){
		return degree;
	}
	
	public int getIndegree() {
		return indegree;
	}
    public int getEccentricityDegree(){
    	return eccentricityDegree;
    }
	public void setIndegree(int indegree) {
		this.indegree = indegree;
	}

	public int getOutdegree() {
		return outdegree;
	}
    
	public double getProximity(){
		return proximity;
	}
	
	public void setOutdegree(int outdegree) {
		this.outdegree = outdegree;
	}

	public int getNodeCore() {
		return nodeCore;
	}

	public void setNodeCore(int nodeCore) {
		this.nodeCore = nodeCore;
	}
    public void setProximity(double proximity){
    	this.proximity = proximity;
    }
	public int getNodeCoreIndegree() {
		return nodeCoreIndegree;
	}

	public void setNodeCoreIndegree(int nodeCoreIndegree) {
		this.nodeCoreIndegree = nodeCoreIndegree;
	}

	public int getNodeCoreOutdegree() {
		return nodeCoreOutdegree;
	}

	public void setNodeCoreOutdegree(int nodeCoreOutdegree) {
		this.nodeCoreOutdegree = nodeCoreOutdegree;
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append(" nodeBC-").append(nodeBC);
		sb.append(" nodeCC-").append(nodeCC);
		sb.append(" nodeCore-").append(nodeCore);
		sb.append(" nodeCoreIndegree-").append(nodeCoreIndegree);
		sb.append(" nodeCoreOutdegree").append(nodeCoreOutdegree);
		sb.append(" indegree-").append(indegree);
		sb.append(" outdegree-").append(outdegree).append("\n");
		return sb.toString();
		
	}
	
	
}
