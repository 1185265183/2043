package cn.web.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.web.security.mapper.ResultsMapper;
import cn.web.security.pojo.Results;
import cn.web.security.pojo.ResultsExample;
import cn.web.security.service.ResultsService;

@Service
public class ResultsServiceImpl implements ResultsService {
	
	@Autowired
	private ResultsMapper resultsMapper;

	@Override
	public void addResults(Results results) {
		// TODO Auto-generated method stub
		
		resultsMapper.insert(results);
		
	}

	@Override
	public List<Results> findResults(int projectid) {
		// TODO Auto-generated method stub
		
		ResultsExample example = new ResultsExample();
		ResultsExample.Criteria criteria = example.createCriteria();
		
		if(projectid>0){
				criteria.andProjectidEqualTo(projectid);
		}
		
		example.setOrderByClause("filepath asc");
		
		List<Results> list=resultsMapper.selectByExample(example);
		
		
		return list;
	}
	
	
	
	
}
