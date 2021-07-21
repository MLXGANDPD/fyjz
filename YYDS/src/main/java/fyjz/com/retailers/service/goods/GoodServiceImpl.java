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
		
	//������Ʒ����id��ȡ�����Ʒ
	public Map<String,Object> findGoodsByCategoryIdService(Long cid, PageObject page) {
		Map<String,Object> map=new HashMap<String, Object>();
		
		
		//��ȡ��ǰҳ��
		int pageCurrent=page.getPageCurrent();
		//��ȡ��¼��
		int rowCount=mapper.findGoodsNumByCategoryId(cid);
		
		page.setRowCount(rowCount);
		
		//��ȡ��ҳ��
		int pageCount=page.getPageCount();
 
		
		//��ҳ����ʼλ��
		int start=page.getStartIndex();
		
		//ÿҳ��ʾ������
		int pagesize=page.getPageSize();

		
		//���ݷ���id��ѯ������Ʒ
		List<Goods> goods=mapper.findGoodsByCategoryId(cid, start, pagesize);
		
		map.put("goods",goods);
		map.put("pageCurrent", pageCurrent);
		map.put("pageCount",pageCount);
		
		//��ѯ�ļ���Ʒ��Ӧ��������Ʒ������
		String cateName=mapper.findCategoryNameByGoodsCategoryId(cid);
		map.put("cateName", cateName);
		return map;
	}

	//��Ʒ����ҳ����id
	public Goods findGoodsByIdService(String id) {
		
		return mapper.selectByPrimaryKey(id);
	}

}
