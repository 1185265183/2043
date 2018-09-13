package cn.web.security.complexnetwork;

import java.util.HashSet;
import java.util.Set;

/**
 * Application entity. @author MyEclipse Persistence Tools
 */

public class Application implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private String name;
	private String state;
	private Boolean deleted;
	private Set methodEntries = new HashSet(0);
	private Set nodes = new HashSet(0);
	private Set classEntries = new HashSet(0);
	private Set packageEntries = new HashSet(0);
	private Set featureNetworkMetricses = new HashSet(0);
	private Set classNetworkMetricses = new HashSet(0);
	private Set fieldEntries = new HashSet(0);

	// Constructors

	/** default constructor */
	public Application() {
	}

	/** minimal constructor */
	public Application(User user, String name) {
		this.user = user;
		this.name = name;
		this.deleted = false;
	}

	/** full constructor */
	public Application(User user, String name, String state, Boolean deleted,
			Set methodEntries, Set nodes, Set classEntries, Set packageEntries,
			Set featureNetworkMetricses, Set classNetworkMetricses,
			Set fieldEntries) {
		this.user = user;
		this.name = name;
		this.state = state;
		this.deleted = deleted;
		this.methodEntries = methodEntries;
		this.nodes = nodes;
		this.classEntries = classEntries;
		this.packageEntries = packageEntries;
		this.featureNetworkMetricses = featureNetworkMetricses;
		this.classNetworkMetricses = classNetworkMetricses;
		this.fieldEntries = fieldEntries;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Boolean getDeleted() {
		return this.deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Set getMethodEntries() {
		return this.methodEntries;
	}

	public void setMethodEntries(Set methodEntries) {
		this.methodEntries = methodEntries;
	}

	public Set getNodes() {
		return this.nodes;
	}

	public void setNodes(Set nodes) {
		this.nodes = nodes;
	}

	public Set getClassEntries() {
		return this.classEntries;
	}

	public void setClassEntries(Set classEntries) {
		this.classEntries = classEntries;
	}

	public Set getPackageEntries() {
		return this.packageEntries;
	}

	public void setPackageEntries(Set packageEntries) {
		this.packageEntries = packageEntries;
	}

	public Set getFeatureNetworkMetricses() {
		return this.featureNetworkMetricses;
	}

	public void setFeatureNetworkMetricses(Set featureNetworkMetricses) {
		this.featureNetworkMetricses = featureNetworkMetricses;
	}

	public Set getClassNetworkMetricses() {
		return this.classNetworkMetricses;
	}

	public void setClassNetworkMetricses(Set classNetworkMetricses) {
		this.classNetworkMetricses = classNetworkMetricses;
	}

	public Set getFieldEntries() {
		return this.fieldEntries;
	}

	public void setFieldEntries(Set fieldEntries) {
		this.fieldEntries = fieldEntries;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		int result = 17;

		result = 37
				* result
				+ (getId() == null ? 0 : this.getId()
						.hashCode());
		
		return result;
	}

	@Override
	public boolean equals(Object other) {
		// TODO Auto-generated method stub
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Application))
			return false;
		Application castOther = (Application) other;

		return ((this.getId() == castOther.getId()) || (this
				.getId() != null && castOther.getId() != null && this
				.getId().equals(castOther.getId())));
	}
	
	
	public static void main(String[] args) {
		
		Application application1 = new  Application();
		
		application1.setId(23);
		
		Application application2 = null;
		
		//application2.setId(23);
		System.out.println(application1.equals(application2));
		System.out.println(application1.hashCode());
		
		//System.out.println(application2.hashCode());
		Set<Application> set = new HashSet<Application>();
		
		set.add(application1);
		set.add(application2);
		System.out.println(set.size());
	
	}
}