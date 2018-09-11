package cn.web.security.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.web.security.pojo.Rules;
import cn.web.security.service.RulesService;

@Controller
@RequestMapping("/rules")
public class RulesController {
	
	@Autowired
	private RulesService rulesService;
	public static final int PAGE_SIZE=20;
	
	@RequestMapping("/showall")
	public ModelAndView showall(@RequestParam(value="pageNum",required=false,defaultValue="1")int pageNum){
		
		ModelAndView mv = new ModelAndView();
		//先设置分页的拦截参数
		PageHelper.startPage(pageNum, PAGE_SIZE);
		List<Rules> list = rulesService.showallrule();
		mv.addObject("rulesList", list);
		//获取PageInfo分页bean
		PageInfo pageInfo = new PageInfo<>(list);
		mv.addObject("pageInfo", pageInfo);
		
		mv.setViewName("rulesList");
		return mv;
	}
	
	@RequestMapping("/toUpdate/{rkey}")
	public ModelAndView toUpdate(@PathVariable String rkey){
		
		Rules rules = rulesService.getRulesByRkey(rkey);
		ModelAndView mv = new ModelAndView();
		mv.addObject("rules", rules);
		mv.setViewName("updateRules");           
		
		return mv;
	}
	
	@RequestMapping("/updateRulesSubmit")
	public String updateRulesSubmit(Rules rules){
		
		//System.out.println("修改之后的level:"+rules.getLevel());
		//System.out.println("222222222222:"+rules.getRkey());
		rulesService.updateRules(rules);
		
		return "redirect:/rules/showall";                      
	}
	
	@RequestMapping("/addRulesSubmit")
	public String addRulesSubmit(Rules rules){
		rulesService.addRules(rules);
		return "redirect:/rules/showall";
	}
	
	@RequestMapping("/removeRules/{rkey}")
	public String removeRules(@PathVariable String rkey){
		rulesService.removeRules(rkey);
		return "redirect:/rules/showall";
	}
	
	

}
