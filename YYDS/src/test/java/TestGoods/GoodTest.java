package TestGoods;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fyjz.com.retailers.commons.PageObject;
import fyjz.com.retailers.entity.Cart;
import fyjz.com.retailers.entity.Goods;
import fyjz.com.retailers.mapper.goods.GoodsMapper;
import fyjz.com.retailers.service.cart.CartService;
import fyjz.com.retailers.service.goods.GoodsService;


public class GoodTest {
	ApplicationContext ac;
	GoodsMapper mapper;
	GoodsService service;
	CartService cartservice;
	@Before
	@Test
	public void init(){
		ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-web.xml");
		mapper=ac.getBean("goodsMapper",GoodsMapper .class);
		service=ac.getBean("goodServiceImpl",GoodsService.class);
		cartservice=ac.getBean("cartServiceImpl",CartService.class);
		
	}
	
	@Test
	public void test01(){
		List<Goods> list=mapper.findGoodsByCategoryId(163L,0,3);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
	
	@Test
	public void test02(){
		PageObject page=new PageObject();
		Map<String,Object> map=service.findGoodsByCategoryIdService(163l,page);
		/*map.get("goods");
		map.get("pageCurrent");
		map.get("pageCount");*/
		System.out.println(map.get("goods"));
		System.out.println(map.get("pageCurrent"));
		System.out.println(map.get("pageCount"));
	}
	
	
	
}
