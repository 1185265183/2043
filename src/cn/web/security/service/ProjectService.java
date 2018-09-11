package cn.web.security.service;

import java.util.List;

import cn.web.security.pojo.Project;

public interface ProjectService {
	
	/**
	 * ���������ݿ��������Ŀ
	 * @param project
	 */
	public void addProject(Project project);
	
	/**
	 * �ҳ����ݿ���������Ŀ
	 * @param project
	 * @return
	 */
	public List<Project> findProjects(Project project);
	
	public void myzip(String str1,String str2);
	
	public Project getProjectById(int projectid);
	
	public void updateProject(Project project);
	
	public void removeProject(int projectid);
}
