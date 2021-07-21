package fyjz.com.retailers.mapper.goods;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import fyjz.com.retailers.entity.Cart;
import fyjz.com.retailers.entity.Goods;

public interface GoodsMapper {
    int deleteByPrimaryKey(String id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
    
    //������Ʒ����id��ѯ�����Ʒ
    List<Goods> findGoodsByCategoryId(@Param("cid")Long cid,@Param("start")Integer start,@Param("pagesize")Integer pagesize);
    
    //���ݷ���id��ѯ��Ʒ��������
    Integer findGoodsNumByCategoryId(Long cid);
    
    //������Ʒ�ķ���IDȥ��ѯ���������
    String findCategoryNameByGoodsCategoryId(Long cid);

    
    //������Ʒ������ȡ��Ʒ����
	int findGoodsNumByGoodId(int id);

	
	//�޸���Ʒ����
	void updateCartItemByIdMapper(@Param("id")int goodsId,@Param("n")int num);
	
}