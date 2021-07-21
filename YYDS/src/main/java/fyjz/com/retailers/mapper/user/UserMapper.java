package fyjz.com.retailers.mapper.user;

import org.apache.ibatis.annotations.Param;

import fyjz.com.retailers.entity.User;

public interface UserMapper {
	//根据用户名查找用户名的数量
	int findNumByName(String name);
	
	//用户注册
	boolean addUserMapper(User user);
	
	//用户登录
	User selectNumByNameAndPwd(@Param("name")String name,@Param("pwd")String pwd);

	//根据用户id修改用户密码
	boolean updateUserPwdById(@Param("uid")int uid,@Param("newpwd")String newpwd);
}
