package fyjz.com.retailers.service.goodsCategory;

import java.util.Map;

public interface GoodsCategoryService {
	//���ݷ���ĸ�id��ѯ��ص���Ʒ
	Map<String,Object> findgoodsCategoryByParentId(Long pid,Integer start,Integer pagesize);
}
