package cn.web.security.service;

import java.util.List;

import cn.web.security.pojo.Assign;
import cn.web.security.pojo.Callfunction;
import cn.web.security.pojo.Classment;
import cn.web.security.pojo.Functions;
import cn.web.security.pojo.Node;
import cn.web.security.pojo.Var;

public interface ProjectanalysisService {
	
	public void addClassment(List<Classment> list);
	
	public void addFunction(List<Functions> list);
	
	public void addVar(List<Var> list);
	
	public void addNode(List<Node> list);
	
	public void addAssign(List<Assign> list);
	
	public void addCallfunction(List<Callfunction> list);
	
	public int getClassmentcount();
	
	public int getFunctioncount();
	
	public int getVarcount();
	
	public int getNodecount();
	
	public int getAssigncount();
	
	public int getCallfunctioncount();
	
	public List<Functions> getFunctions(int id);    //project's id
	
	public List<Callfunction> getCallfunctions(int id);   //project's id
	
}
