package fyjz.com.retailers.mapper.user;

import org.apache.ibatis.annotations.Param;

import fyjz.com.retailers.entity.User;

public interface UserMapper {
	//�����û��������û���������
	int findNumByName(String name);
	
	//�û�ע��
	boolean addUserMapper(User user);
	
	//�û���¼
	User selectNumByNameAndPwd(@Param("name")String name,@Param("pwd")String pwd);

	//�����û�id�޸��û�����
	boolean updateUserPwdById(@Param("uid")int uid,@Param("newpwd")String newpwd);
}
