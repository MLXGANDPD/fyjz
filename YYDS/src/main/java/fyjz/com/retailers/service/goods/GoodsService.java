package fyjz.com.retailers.service.goods;

import java.util.List;
import java.util.Map;

import fyjz.com.retailers.commons.PageObject;
import fyjz.com.retailers.entity.Goods;

public interface GoodsService {
	//根据商品分类id获取相关商品
	Map<String,Object> findGoodsByCategoryIdService(Long cid,PageObject page);

	
	//商品详情页
	Goods findGoodsByIdService(String id);
	
}
