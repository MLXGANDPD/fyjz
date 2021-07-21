package fyjz.com.retailers.service.goodsCategory;

import java.util.Map;

public interface GoodsCategoryService {
	//根据分类的父id查询相关的商品
	Map<String,Object> findgoodsCategoryByParentId(Long pid,Integer start,Integer pagesize);
}
