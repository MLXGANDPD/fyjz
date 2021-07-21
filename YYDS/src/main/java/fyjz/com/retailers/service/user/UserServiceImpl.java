package fyjz.com.retailers.service.user;


import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import fyjz.com.retailers.commons.NameExitesException;
import fyjz.com.retailers.commons.NameNotNullException;
import fyjz.com.retailers.entity.User;
import fyjz.com.retailers.mapper.user.UserMapper;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper mapper;
	
	
	//根据用户名查找用户名的数量
	public int findNumByName(String name) {
		if(name==null||name.trim().isEmpty()){
			throw new NameNotNullException("用户名不能为空");
		}
		int n=mapper.findNumByName(name);
		if(n>0){
			throw new NameExitesException("用户名已经存在");
		}
		return n;
	}


	//用户注册
	public boolean addUserService(User user) {
		//获取用户输入的密码
		String pwd=user.getPassword();
		System.out.println(pwd);
		//对密码加密
		String str="超";
		String pwdMd5=DigestUtils.md5Hex(pwd+str);
		user.setPassword(pwdMd5);
		boolean b=mapper.addUserMapper(user);
		if(b==false){
			throw new RuntimeException("系统维护中");
		}else{
			return b;
		}

	}


	//用户登录
	public User selectNumByNameAndPwd(String name, String pwd) {
		//对密码进行加密
		String str="超";
		String pwdMd5=DigestUtils.md5Hex(pwd+str);
		User user=mapper.selectNumByNameAndPwd(name, pwdMd5);
		if(user==null){
			throw new RuntimeException("用户名或密码不正确");
		}
		return user;
	}


	//根据用户id修改用户密码
	public boolean updateUserPwdById(int uid, String newpwd) {
		boolean b=mapper.updateUserPwdById(uid,newpwd);
		return b;
	}
	
	
	
}
