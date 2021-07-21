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
	
	
	//�����û��������û���������
	public int findNumByName(String name) {
		if(name==null||name.trim().isEmpty()){
			throw new NameNotNullException("�û�������Ϊ��");
		}
		int n=mapper.findNumByName(name);
		if(n>0){
			throw new NameExitesException("�û����Ѿ�����");
		}
		return n;
	}


	//�û�ע��
	public boolean addUserService(User user) {
		//��ȡ�û����������
		String pwd=user.getPassword();
		System.out.println(pwd);
		//���������
		String str="��";
		String pwdMd5=DigestUtils.md5Hex(pwd+str);
		user.setPassword(pwdMd5);
		boolean b=mapper.addUserMapper(user);
		if(b==false){
			throw new RuntimeException("ϵͳά����");
		}else{
			return b;
		}

	}


	//�û���¼
	public User selectNumByNameAndPwd(String name, String pwd) {
		//��������м���
		String str="��";
		String pwdMd5=DigestUtils.md5Hex(pwd+str);
		User user=mapper.selectNumByNameAndPwd(name, pwdMd5);
		if(user==null){
			throw new RuntimeException("�û��������벻��ȷ");
		}
		return user;
	}


	//�����û�id�޸��û�����
	public boolean updateUserPwdById(int uid, String newpwd) {
		boolean b=mapper.updateUserPwdById(uid,newpwd);
		return b;
	}
	
	
	
}
