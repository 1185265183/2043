package cn.web.security.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.web.security.mapper.AssignMapper;
import cn.web.security.mapper.CallfunctionMapper;
import cn.web.security.mapper.ClassmentMapper;
import cn.web.security.mapper.FunctionsMapper;
import cn.web.security.mapper.NodeMapper;
import cn.web.security.mapper.VarMapper;
import cn.web.security.pojo.Assign;
import cn.web.security.pojo.AssignExample;
import cn.web.security.pojo.Callfunction;
import cn.web.security.pojo.CallfunctionExample;
import cn.web.security.pojo.Classment;
import cn.web.security.pojo.ClassmentExample;
import cn.web.security.pojo.Functions;
import cn.web.security.pojo.FunctionsExample;
import cn.web.security.pojo.Node;
import cn.web.security.pojo.NodeExample;
import cn.web.security.pojo.Var;
import cn.web.security.pojo.VarExample;
import cn.web.security.service.ProjectanalysisService;

@Service
public class ProjectanalysisServiceImpl implements ProjectanalysisService {
	
	@Autowired
	private ClassmentMapper classmentMapper;
	@Autowired
	private FunctionsMapper functionsMapper;
	@Autowired
	private VarMapper varMapper;
	@Autowired
	private NodeMapper nodeMapper;
	@Autowired
	private AssignMapper assignMapper;
	@Autowired
	private CallfunctionMapper callfunctionMapper;
	
	
	
	public void addClassment(List<Classment> list) {
		// TODO Auto-generated method stub
		for(Classment record:list){
			classmentMapper.insert(record);
		}

	}

	public int getClassmentcount() {
		// TODO Auto-generated method stub
		ClassmentExample example = new ClassmentExample();
		int classmentcount = classmentMapper.countByExample(example);
		return classmentcount;
	}

	public int getFunctioncount() {
		// TODO Auto-generated method stub
		FunctionsExample example = new FunctionsExample();
		int functioncount = functionsMapper.countByExample(example);
		return functioncount;
	}
	
	

	@Override
	public int getVarcount() {
		// TODO Auto-generated method stub
		VarExample example = new VarExample();
		int varcount = varMapper.countByExample(example);
		return varcount;
	}


	@Override
	public int getNodecount() {
		// TODO Auto-generated method stub
		NodeExample example = new NodeExample();
		int nodecount = nodeMapper.countByExample(example);
		return nodecount;
	}


	@Override
	public int getAssigncount() {
		// TODO Auto-generated method stub
		AssignExample example = new AssignExample();
		int assigncount = assignMapper.countByExample(example);
		return assigncount;
	}


	@Override
	public int getCallfunctioncount() {
		// TODO Auto-generated method stub
		CallfunctionExample example = new CallfunctionExample();
		int callfunctioncount = callfunctionMapper.countByExample(example);
		return callfunctioncount;
	}

	@Override
	public void addFunction(List<Functions> list) {
		// TODO Auto-generated method stub
		for(Functions record:list){
			functionsMapper.insert(record);
		}
	}

	@Override
	public void addVar(List<Var> list) {
		// TODO Auto-generated method stub
		for(Var record:list){
			varMapper.insert(record);
		}
	}

	@Override
	public void addNode(List<Node> list) {
		// TODO Auto-generated method stub
		for(Node record:list){
			nodeMapper.insert(record);
		}
	}

	@Override
	public void addAssign(List<Assign> list) {
		// TODO Auto-generated method stub
		for(Assign record:list){
			assignMapper.insert(record);
		}
	}

	@Override
	public void addCallfunction(List<Callfunction> list) {
		// TODO Auto-generated method stub
		for(Callfunction record:list){
			callfunctionMapper.insert(record);
		}
	}

	@Override
	public List<Functions> getFunctions(int id) {
		// TODO Auto-generated method stub
		FunctionsExample example = new FunctionsExample();
		List<Functions> list = new ArrayList<Functions>();
		list = functionsMapper.selectByExample(example);
		
		return list;
	}

	@Override
	public List<Callfunction> getCallfunctions(int id) {
		// TODO Auto-generated method stub
		CallfunctionExample example = new CallfunctionExample();
		List<Callfunction> list = new ArrayList<Callfunction>();
		list = callfunctionMapper.selectByExample(example);
		return list;
	}

	
	
	
	
	

}
