package TestGoodsCategory;

import java.util.List;
import java.util.Map;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fyjz.com.retailers.entity.GoodsCategory;
import fyjz.com.retailers.mapper.goodsCategory.GoodsCategoryMapper;
import fyjz.com.retailers.service.goodsCategory.GoodsCategoryService;


public class Testcategory {
	ApplicationContext ac;
	GoodsCategoryMapper  mapper;
	GoodsCategoryService service;
	
	@Before
	@Test
	public void init(){
		ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-web.xml");
		mapper=ac.getBean("goodsCategoryMapper",GoodsCategoryMapper .class);
		service=ac.getBean("GcService",GoodsCategoryService.class);
	}
	
	@Test
	public void test01(){
		List<GoodsCategory> list=mapper.findGoodCategoryByPrientendId(161l,0,3);
		System.out.println(list);
	}
	
	@Test
	public void test02(){
		Map<String,Object> map=service.findgoodsCategoryByParentId(161L,0,3);
		System.out.println(map.size());
		/*List<GoodsCategory> list1=(List<GoodsCategory>) map.get("list2");
		
		List<List<GoodsCategory>> list2=(List<List<GoodsCategory>>) map.get("list3");
		//每个二级商品下有多少个三级商品
		for(List<GoodsCategory> l:list2){
			System.out.println(l.size());
		}
		
		System.out.println(list1.size());
		System.out.println(list2.size());*/
		map.forEach((k,v)->{
			System.out.print(k);
			System.out.println(v);
		});
	}
}
