package cn.web.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.web.security.mapper.ClassmentInfoViewMapper;
import cn.web.security.mapper.FunctionsInfoViewMapper;
import cn.web.security.mapper.ResultsMapper;
import cn.web.security.mapper.VarInfoViewMapper;
import cn.web.security.pojo.ClassmentInfoView;
import cn.web.security.pojo.ClassmentInfoViewExample;
import cn.web.security.pojo.FunctionsInfoView;
import cn.web.security.pojo.FunctionsInfoViewExample;
import cn.web.security.pojo.Results;
import cn.web.security.pojo.ResultsExample;
import cn.web.security.pojo.VarInfoView;
import cn.web.security.pojo.VarInfoViewExample;
import cn.web.security.service.ResultsService;

@Service
public class ResultsServiceImpl implements ResultsService {
	
	@Autowired
	private ResultsMapper resultsMapper;
	@Autowired
	private VarInfoViewMapper varInfoViewMapper;
	@Autowired
	private  FunctionsInfoViewMapper functionsInfoViewMapper;
	@Autowired
	private ClassmentInfoViewMapper classmentInfoViewMapper;

	@Override
	public void addResults(Results results) {
		// TODO Auto-generated method stub
		
		resultsMapper.insert(results);
		
	}

	@Override
	public List<Results> findResults(int projectid) {
		
		
		ResultsExample example = new ResultsExample();
		ResultsExample.Criteria criteria = example.createCriteria();
		
		if(projectid>0){
				criteria.andProjectidEqualTo(projectid);
		}
		
		example.setOrderByClause("filepath asc");
		
		List<Results> list=resultsMapper.selectByExample(example);
		
		
		return list;
	}

	@Override
	public List<VarInfoView> findAnalysisVarResults(int projectid) {
	    

		VarInfoViewExample example = new VarInfoViewExample();
		VarInfoViewExample.Criteria criteria = example.createCriteria();
		
		if(projectid>0){
				criteria.andPIdEqualTo(projectid);
		}		
		List<VarInfoView> list=varInfoViewMapper.selectByExample(example);		
		return list;
	}

	@Override
	public List<FunctionsInfoView> findAnalysisFunctionResults(int projectid) {

		FunctionsInfoViewExample example = new FunctionsInfoViewExample();
		FunctionsInfoViewExample.Criteria criteria = example.createCriteria();
		
		if(projectid>0){
				criteria.andPIdEqualTo(projectid);
		}
		List<FunctionsInfoView> list=functionsInfoViewMapper.selectByExample(example);		
		return list;
	}

	@Override
	public List<ClassmentInfoView> findAnalysisClassResults(int projectid) {
		
		
		ClassmentInfoViewExample example = new ClassmentInfoViewExample();
		ClassmentInfoViewExample.Criteria criteria = example.createCriteria();
		
		if(projectid>0){
				criteria.andPIdEqualTo(projectid);
		}

		
		List<ClassmentInfoView> list=classmentInfoViewMapper.selectByExample(example);		
		return list;
	}
	
	
	
	
}
