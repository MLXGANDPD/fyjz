package fyjz.com.retailers.service.user;


import java.util.List;

import fyjz.com.retailers.entity.Cart;
import fyjz.com.retailers.entity.User;

public interface UserService {
	//�����û��������û���������
	int findNumByName(String name);
	
	//�û�ע��
	boolean addUserService(User user);
	
	//�û���¼
	User selectNumByNameAndPwd(String name,String pwd);

	//�����û�id�޸��û�����
	boolean updateUserPwdById(int uid, String newpwd);
	
	

}
