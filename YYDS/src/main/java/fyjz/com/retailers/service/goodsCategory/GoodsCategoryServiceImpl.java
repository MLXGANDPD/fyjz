package fyjz.com.retailers.service.goodsCategory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fyjz.com.retailers.entity.Goods;
import fyjz.com.retailers.entity.GoodsCategory;
import fyjz.com.retailers.mapper.goods.GoodsMapper;
import fyjz.com.retailers.mapper.goodsCategory.GoodsCategoryMapper;

@Service("GcService")
public class GoodsCategoryServiceImpl implements GoodsCategoryService{
	@Autowired
	private GoodsCategoryMapper mapper;
	@Autowired
	private GoodsMapper goodsMapper;
	
	
	//���ݷ���ĸ�id��ѯ��ص���Ʒ
	public Map<String, Object> findgoodsCategoryByParentId(Long pid, Integer start, Integer pagesize) {
		Map<String,Object> map=new HashMap<String, Object>();
		//��ȡ������Ʒ����
		List<GoodsCategory> list2=mapper.findGoodCategoryByPrientendId(pid, start, pagesize);
		//��ȡ������Ʒ����
		List<List<GoodsCategory>> list3=new ArrayList<>();
		for(int i=0;i<list2.size();i++){
			List<GoodsCategory> l=mapper.findGoodCategoryByPrientendId(list2.get(i).getId(),null,null);
			list3.add(l);
		}
		map.put("list2",list2);
		map.put("list3",list3);
		List<Goods> goods=goodsMapper.findGoodsByCategoryId(163L,0,3);
		map.put("goods", goods);
		
		List<Goods> goods2=goodsMapper.findGoodsByCategoryId(241L,0,2);
		map.put("goods2",goods2);
		return map;
	}

}
