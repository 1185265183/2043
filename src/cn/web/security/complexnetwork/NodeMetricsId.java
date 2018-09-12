package cn.web.security.complexnetwork;

/**
 * NodeMetricsId entity. @author MyEclipse Persistence Tools
 */

public class NodeMetricsId implements java.io.Serializable {

	// Fields

	private Node node;

	// Constructors

	/** default constructor */
	public NodeMetricsId() {
	}

	/** full constructor */
	public NodeMetricsId(Node node) {
		this.node = node;
	}

	// Property accessors

	public Node getNode() {
		return this.node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof NodeMetricsId))
			return false;
		NodeMetricsId castOther = (NodeMetricsId) other;

		return ((this.getNode() == castOther.getNode()) || (this.getNode() != null
				&& castOther.getNode() != null && this.getNode().equals(
				castOther.getNode())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getNode() == null ? 0 : this.getNode().hashCode());
		return result;
	}

}