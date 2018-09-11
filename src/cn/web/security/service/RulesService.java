package cn.web.security.service;

import java.util.List;

import cn.web.security.pojo.Rules;

public interface RulesService {
	
	/**
	 * 返回所有已有规则条目
	 * @return
	 */
	public List<Rules> showallrule();
	
	public void updateRules(Rules rules);
	
	public  Rules getRulesByRkey(String rkey);
	
	public void addRules(Rules rules);
	
	public void removeRules(String rkey);

}
