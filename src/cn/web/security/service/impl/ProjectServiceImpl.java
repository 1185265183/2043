package cn.web.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.web.security.mapper.ProjectMapper;
import cn.web.security.pojo.Project;
import cn.web.security.pojo.ProjectExample;
import cn.web.security.service.ProjectService;
import cn.web.security.utils.ZipUtil;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectMapper projectMapper;

	@Override
	public void addProject(Project project) {
		// TODO Auto-generated method stub
		projectMapper.insert(project);
	}

	@Override
	public List<Project> findProjects(Project project) {
		// TODO Auto-generated method stub
		ProjectExample example = new ProjectExample();
		
		List<Project> list = projectMapper.selectByExample(example);
		
		if (!list.isEmpty()) {
			return list;
		}
		return null;

	}

	@Override
	public void myzip(String str1, String str2) {
		// TODO Auto-generated method stub
		try {
			ZipUtil.deCompress(str1, str2);   //将上传的项目压缩包，解压到指定路径
			System.out.println("解压成功！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Project getProjectById(int projectid) {
		// TODO Auto-generated method stub
		
		return projectMapper.selectByPrimaryKey(projectid);
	}

	@Override
	public void updateProject(Project project) {
		// TODO Auto-generated method stub
		projectMapper.updateByPrimaryKey(project);
		
	}

	@Override
	public void removeProject(int projectid) {
		// TODO Auto-generated method stub
		projectMapper.deleteByPrimaryKey(projectid);
	}
	
	
}
