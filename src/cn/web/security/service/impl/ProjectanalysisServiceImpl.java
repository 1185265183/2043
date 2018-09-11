package cn.web.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.web.security.mapper.ClassmentMapper;
import cn.web.security.pojo.Classment;
import cn.web.security.service.ProjectanalysisService;

@Service
public class ProjectanalysisServiceImpl implements ProjectanalysisService {
	
	@Autowired
	private ClassmentMapper classmentMapper;
	
	@Override
	public void addClassment(List<Classment> list) {
		// TODO Auto-generated method stub
		for(Classment record:list){
			classmentMapper.insert(record);
		}
		System.out.println("类列表保存成功！");
		
	}

	@Override
	public int getClassmentcount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
