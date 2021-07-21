package fyjz.com.retailers.service.goods;

import java.util.List;
import java.util.Map;

import fyjz.com.retailers.commons.PageObject;
import fyjz.com.retailers.entity.Goods;

public interface GoodsService {
	//������Ʒ����id��ȡ�����Ʒ
	Map<String,Object> findGoodsByCategoryIdService(Long cid,PageObject page);

	
	//��Ʒ����ҳ
	Goods findGoodsByIdService(String id);
	
}
