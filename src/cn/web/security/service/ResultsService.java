package cn.web.security.service;

import java.util.List;

import cn.web.security.pojo.ClassmentInfoView;
import cn.web.security.pojo.FunctionsInfoView;
import cn.web.security.pojo.Results;
import cn.web.security.pojo.VarInfoView;

public interface ResultsService {
	
	public void addResults(Results results);
	
	public List<Results> findResults(int projectid);

	public List<VarInfoView> findAnalysisVarResults(int projectid);
	
	public List<FunctionsInfoView> findAnalysisFunctionResults(int projectid);
	
	public List<ClassmentInfoView> findAnalysisClassResults(int projectid);
	
}
