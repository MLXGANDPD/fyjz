package TestDemo;


import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fyjz.com.retailers.entity.User;
import fyjz.com.retailers.mapper.user.UserMapper;

public class TestUser {
	ApplicationContext ac;
	UserMapper mapper;
	
	@Before
	@Test
	public void init(){
		ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		mapper=ac.getBean("userMapper",UserMapper.class);
	}
	
	
	@Test
	public void test01(){
		User u=new User();
		u.setUserName("admin999");
		u.setPassword("521125");
		u.setEmail("164825@qq.com");
		u.setPhone("17829892931");
		u.setCreateUser("admin888");
		u.setModifiedUser("admin222");
		boolean b=mapper.addUserMapper(u);
		System.out.println(b);
	}
	
}
