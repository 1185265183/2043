package cn.web.security.service;

import java.util.List;

import cn.web.security.pojo.Results;

public interface ResultsService {
	
	public void addResults(Results results);
	
	public List<Results> findResults(int projectid);
	
}
