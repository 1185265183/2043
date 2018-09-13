package cn.web.security.complexnetwork;

import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
//这个类不知道有什么鸟用，和application类相关联（      后续删除    或者重写    ）
public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private String account;
	private String name;
	private String password;
	private Boolean state;
	private Boolean deleted;
	private Set applications = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String account, String password, Boolean state) {
		this.account = account;
		this.password = password;
		this.state = state;
	}

	/** full constructor */
	public User(String account, String name, String password, Boolean state,Boolean deleted,
			Set applications) {
		this.account = account;
		this.name = name;
		this.password = password;
		this.state = state;
		this.deleted = deleted;
		this.applications = applications;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getState() {
		return this.state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}
	
	public Boolean getDeleted() {
		return this.deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	
	public Set getApplications() {
		return this.applications;
	}

	public void setApplications(Set applications) {
		this.applications = applications;
	}

}