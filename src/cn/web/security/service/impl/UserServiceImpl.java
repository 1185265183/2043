package cn.web.security.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stringtemplate.v4.compiler.CodeGenerator.list_return;

import java.util.List;

import cn.web.security.common.StringUtil;
import cn.web.security.mapper.UserMapper;
import cn.web.security.pojo.User;
import cn.web.security.pojo.UserExample;
import cn.web.security.pojo.UserExample.Criteria;
import cn.web.security.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;
	
	@Override
	public List<User> queryLoginUser(Map map) {
		 
	
	if (!StringUtil.isNULLOREmpty((String) map.get("username"))&&!StringUtil.isNULLOREmpty((String) map.get("password"))) {
			System.out.println(33333);
		UserExample example=new UserExample();
		Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo((String) map.get("username"));
        criteria.andPasswordEqualTo((String) map.get("password"));
		return  userMapper.selectByExample(example);
	}
		else {
			return null;
		}

}
}
