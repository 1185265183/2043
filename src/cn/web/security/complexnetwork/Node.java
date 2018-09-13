package cn.web.security.complexnetwork;

import java.util.HashSet;
import java.util.Set;


/**
 * Node entity. @author MyEclipse Persistence Tools
 */

public class Node implements java.io.Serializable {

	// Fields

	private NodeId id;
	private Set nodeImportanceValues = new HashSet(0);
	private Set nodeMetricses = new HashSet(0);
	private Set dependEntriesForDependEntryIbfk2 = new HashSet(0);
	private Set dependEntriesForDependEntryIbfk1 = new HashSet(0);

	// Constructors

	/** default constructor */
	public Node() {
	}

	/** minimal constructor */
	public Node(NodeId id) {
		this.id = id;
	}

	/** full constructor */
	public Node(NodeId id, Set nodeImportanceValues, Set nodeMetricses,
			Set dependEntriesForDependEntryIbfk2,
			Set dependEntriesForDependEntryIbfk1) {
		this.id = id;
		this.nodeImportanceValues = nodeImportanceValues;
		this.nodeMetricses = nodeMetricses;
		this.dependEntriesForDependEntryIbfk2 = dependEntriesForDependEntryIbfk2;
		this.dependEntriesForDependEntryIbfk1 = dependEntriesForDependEntryIbfk1;
	}

	// Property accessors

	public NodeId getId() {
		return this.id;
	}

	public void setId(NodeId id) {
		this.id = id;
	}

	public Set getNodeImportanceValues() {
		return this.nodeImportanceValues;
	}

	public void setNodeImportanceValues(Set nodeImportanceValues) {
		this.nodeImportanceValues = nodeImportanceValues;
	}

	public Set getNodeMetricses() {
		return this.nodeMetricses;
	}

	public void setNodeMetricses(Set nodeMetricses) {
		this.nodeMetricses = nodeMetricses;
	}

	public Set getDependEntriesForDependEntryIbfk2() {
		return this.dependEntriesForDependEntryIbfk2;
	}

	public void setDependEntriesForDependEntryIbfk2(
			Set dependEntriesForDependEntryIbfk2) {
		this.dependEntriesForDependEntryIbfk2 = dependEntriesForDependEntryIbfk2;
	}

	public Set getDependEntriesForDependEntryIbfk1() {
		return this.dependEntriesForDependEntryIbfk1;
	}

	public void setDependEntriesForDependEntryIbfk1(
			Set dependEntriesForDependEntryIbfk1) {
		this.dependEntriesForDependEntryIbfk1 = dependEntriesForDependEntryIbfk1;
	}
	public int hashCode(){
		int result = 17;

		result = 37
				* result
				+ (getId() == null ? 0 : this.getId()
						.hashCode());
		
        return result;  
	}
	public boolean equals(Object obj) {  
		if (this == obj) {  
            return true;  
        }  
        if (obj == null) {  
            return false;  
        }  
        if (!(obj instanceof Node)) {  
            return false;  
        }  
        Node castOther = (Node) obj;
        
    	return ((this.getId() == castOther.getId()) || (this
				.getId() != null && castOther.getId() != null && this
				.getId().equals(castOther.getId())));
        
        
        
	} 
	public static void main(String[] args) {
		/*
		ApplicationDAO applicationDAO = new ApplicationDAO();
		
		Application application = applicationDAO.findById(1);
		
		NodeId nodeId = new NodeId(application, "org.gjt.sp.jedit.gui.statusBar");
		
		Node node = new Node(nodeId);
		
		NodeDAO nodeDAO	= new NodeDAO();
		
		nodeDAO.save(node);
		*/
	}
}