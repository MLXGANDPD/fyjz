package fyjz.com.retailers.service.goods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fyjz.com.retailers.commons.PageObject;
import fyjz.com.retailers.entity.Goods;
import fyjz.com.retailers.mapper.goods.GoodsMapper;
@Controller
public class GoodServiceImpl implements GoodsService{
		@Autowired
		private GoodsMapper mapper;
		
	//根据商品分类id获取相关商品
	public Map<String,Object> findGoodsByCategoryIdService(Long cid, PageObject page) {
		Map<String,Object> map=new HashMap<String, Object>();
		
		
		//获取当前页数
		int pageCurrent=page.getPageCurrent();
		//获取记录数
		int rowCount=mapper.findGoodsNumByCategoryId(cid);
		
		page.setRowCount(rowCount);
		
		//获取总页数
		int pageCount=page.getPageCount();
 
		
		//分页的起始位置
		int start=page.getStartIndex();
		
		//每页显示的行数
		int pagesize=page.getPageSize();

		
		//根据分类id查询所有商品
		List<Goods> goods=mapper.findGoodsByCategoryId(cid, start, pagesize);
		
		map.put("goods",goods);
		map.put("pageCurrent", pageCurrent);
		map.put("pageCount",pageCount);
		
		//查询四级商品对应的三级商品的名字
		String cateName=mapper.findCategoryNameByGoodsCategoryId(cid);
		map.put("cateName", cateName);
		return map;
	}

	//商品详情页根据id
	public Goods findGoodsByIdService(String id) {
		
		return mapper.selectByPrimaryKey(id);
	}

}
