package cn.web.security.service;

import java.util.List;
import java.util.Map;




import cn.web.security.pojo.User;

public interface UserService {

	List<User> queryLoginUser(Map map);


}
