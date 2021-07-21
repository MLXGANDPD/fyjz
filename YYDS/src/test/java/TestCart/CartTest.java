package TestCart;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fyjz.com.retailers.entity.Cart;
import fyjz.com.retailers.mapper.cart.CartMapper;
import fyjz.com.retailers.mapper.goods.GoodsMapper;
import fyjz.com.retailers.service.cart.CartService;
import fyjz.com.retailers.service.cart.CartServiceImpl;
import fyjz.com.retailers.service.goods.GoodsService;

public class CartTest {
	ApplicationContext ac;
	CartMapper mapper;
	CartService service;
	
	
	@Before
	@Test
	public void init(){
		ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-web.xml");
		mapper=ac.getBean("cartMapper",CartMapper .class);
		service=ac.getBean("cartService",CartServiceImpl.class);
	}
	
	
	@Test
	public void addCart(){
		Cart c=new Cart(0,11,10000017, "pdddsa","pidfdss",60,1100);
		int n=service.addCartService(c);
		System.out.println(n);
	}
	
	
	@Test
	public void deleteCart(){
		String[] str={"17","20"};
		mapper.deleteCartItemsMapper(str);
	}
	
	@Test
	public void addGoods(){
		Cart c=new Cart(1,11,12,"pdd","uzi",20,60);
		int n=mapper.insertgoodsTofavorite(c);
		System.out.println(n);
		
	}
}
