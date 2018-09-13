package cn.web.security.complexnetwork;

/**
 * NodeId entity. @author MyEclipse Persistence Tools
 */

public class NodeId implements java.io.Serializable {

	// Fields

	private Application application;
	private String name;

	// Constructors

	/** default constructor */
	public NodeId() {
	}

	/** full constructor */
	public NodeId(Application application, String name) {
		this.application = application;
		this.name = name;
	}

	// Property accessors

	public Application getApplication() {
		return this.application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof NodeId))
			return false;
		NodeId castOther = (NodeId) other;

		return ((this.getApplication() == castOther.getApplication()) || (this
				.getApplication() != null && castOther.getApplication() != null && this
				.getApplication().equals(castOther.getApplication())))
				&& ((this.getName() == castOther.getName()) || (this.getName() != null
						&& castOther.getName() != null && this.getName()
						.equals(castOther.getName())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getApplication() == null ? 0 : this.getApplication()
						.hashCode());
		result = 37 * result
				+ (getName() == null ? 0 : this.getName().hashCode());
		return result;
	}

}