package fyjz.com.retailers.service.user;


import java.util.List;

import fyjz.com.retailers.entity.Cart;
import fyjz.com.retailers.entity.User;

public interface UserService {
	//根据用户名查找用户名的数量
	int findNumByName(String name);
	
	//用户注册
	boolean addUserService(User user);
	
	//用户登录
	User selectNumByNameAndPwd(String name,String pwd);

	//根据用户id修改用户密码
	boolean updateUserPwdById(int uid, String newpwd);
	
	

}
