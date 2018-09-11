package cn.web.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.web.security.mapper.RulesMapper;
import cn.web.security.pojo.Rules;
import cn.web.security.pojo.RulesExample;
import cn.web.security.service.RulesService;

@Service
public class RulesServiceImpl implements RulesService {
	
	@Autowired
	private RulesMapper rulesMapper;
	
	@Override
	public List<Rules> showallrule() {
		// TODO Auto-generated method stub
		
		RulesExample example = new RulesExample();
		
		List<Rules> list = rulesMapper.selectByExample(example);
		
		if (!list.isEmpty()) {
			return list;
		}
		return null;
	}

	@Override
	public void updateRules(Rules rules) {
		// TODO Auto-generated method stub
		rulesMapper.updateByPrimaryKey(rules);
	}

	@Override
	public Rules getRulesByRkey(String rkey) {
		// TODO Auto-generated method stub
		return rulesMapper.selectByPrimaryKey(rkey);
	}

	@Override
	public void addRules(Rules rules) {
		// TODO Auto-generated method stub
		
		rulesMapper.insert(rules);
		
		
	}

	@Override
	public void removeRules(String rkey) {
		// TODO Auto-generated method stub
		
		rulesMapper.deleteByPrimaryKey(rkey);
		
	}

}
