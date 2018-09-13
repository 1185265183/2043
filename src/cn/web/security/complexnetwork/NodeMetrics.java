package cn.web.security.complexnetwork;

/**
 * NodeMetrics entity. @author MyEclipse Persistence Tools
 */

public class NodeMetrics implements java.io.Serializable {

	// Fields

	private NodeMetricsId id;
	private Integer degree;
	private Integer outDegree;
	private Integer inDegree;
	private Double nodeCC;
	private Double proximity;
	private Double MNC;
	private Double DMNC;
	private Double influenceRegion;
	private Double degreeCentrality;
	private Double nodeBC;
	private Integer nodeCore;

	// Constructors

	/** default constructor */
	public NodeMetrics() {
	}

	/** minimal constructor */
	public NodeMetrics(NodeMetricsId id) {
		this.id = id;
	}

	/** full constructor */
	public NodeMetrics(NodeMetricsId id, Integer degree, Integer outDegree,
			Integer inDegree, Double nodeCC, Double proximity, Double MNC,
			Double DMNC, Double influenceRegion, Double degreeCentrality,
			Double nodeBC, Integer nodeCore) {
		this.id = id;
		this.degree = degree;
		this.outDegree = outDegree;
		this.inDegree = inDegree;
		this.nodeCC = nodeCC;
		this.proximity = proximity;
		this.MNC = MNC;
		this.DMNC = DMNC;
		this.influenceRegion = influenceRegion;
		this.degreeCentrality = degreeCentrality;
		this.nodeBC = nodeBC;
		this.nodeCore = nodeCore;
	}

	// Property accessors

	public NodeMetricsId getId() {
		return this.id;
	}

	public void setId(NodeMetricsId id) {
		this.id = id;
	}

	public Integer getDegree() {
		return this.degree;
	}

	public void setDegree(Integer degree) {
		this.degree = degree;
	}

	public Integer getOutDegree() {
		return this.outDegree;
	}

	public void setOutDegree(Integer outDegree) {
		this.outDegree = outDegree;
	}

	public Integer getInDegree() {
		return this.inDegree;
	}

	public void setInDegree(Integer inDegree) {
		this.inDegree = inDegree;
	}

	public Double getNodeCC() {
		return this.nodeCC;
	}

	public void setNodeCC(Double nodeCC) {
		this.nodeCC = nodeCC;
	}

	public Double getProximity() {
		return this.proximity;
	}

	public void setProximity(Double proximity) {
		this.proximity = proximity;
	}

	public Double getMNC() {
		return this.MNC;
	}

	public void setMNC(Double MNC) {
		this.MNC = MNC;
	}

	public Double getDMNC() {
		return this.DMNC;
	}

	public void setDMNC(Double DMNC) {
		this.DMNC = DMNC;
	}

	public Double getInfluenceRegion() {
		return this.influenceRegion;
	}

	public void setInfluenceRegion(Double influenceRegion) {
		this.influenceRegion = influenceRegion;
	}

	public Double getDegreeCentrality() {
		return this.degreeCentrality;
	}

	public void setDegreeCentrality(Double degreeCentrality) {
		this.degreeCentrality = degreeCentrality;
	}

	public Double getNodeBC() {
		return this.nodeBC;
	}

	public void setNodeBC(Double nodeBC) {
		this.nodeBC = nodeBC;
	}

	public Integer getNodeCore() {
		return this.nodeCore;
	}

	public void setNodeCore(Integer nodeCore) {
		this.nodeCore = nodeCore;
	}

}