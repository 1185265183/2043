package cn.web.security.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import cn.web.security.pojo.AJAXResult;
import cn.web.security.pojo.User;
import cn.web.security.service.UserService;


@Controller
public class DispatcherController {
	
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/index")
	public String main() {
		return "index";
	}
	
	/**
	 * 执行登陆
	 * @return
	 */
   @RequestMapping("/login.do")
   @ResponseBody
   public Object doAJAXLogin(@RequestParam Map map, HttpSession session) {
	   
	  
	   AJAXResult result = new AJAXResult();
		// 2) 查询用户信息
		List<User> dbUser = userService.queryLoginUser(map);
		
		// 3) 判断用户信息是否存在
		if ( dbUser != null &&dbUser.size()>0) {
			session.setAttribute("loginUser", dbUser);
			result.setSuccess(true);
		} else {
			result.setSuccess(false);
		}
		
		return result;
	}
 //注销方法
   @RequestMapping("/Loginout")
   public String Loginout(HttpSession session){
       //通过session.invalidata()方法来注销当前的session
       session.invalidate();
       return "login";
   }
	

}
