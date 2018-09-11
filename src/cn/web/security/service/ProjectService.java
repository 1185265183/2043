package cn.web.security.service;

import java.util.List;

import cn.web.security.pojo.Project;

public interface ProjectService {
	
	/**
	 * 用于向数据库中添加项目
	 * @param project
	 */
	public void addProject(Project project);
	
	/**
	 * 找出数据库中所有项目
	 * @param project
	 * @return
	 */
	public List<Project> findProjects(Project project);
	
	public void myzip(String str1,String str2);
	
	public Project getProjectById(int projectid);
	
	public void updateProject(Project project);
	
	public void removeProject(int projectid);
}
