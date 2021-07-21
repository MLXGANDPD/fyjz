package fyjz.com.retailers.mapper.cart;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import fyjz.com.retailers.entity.Cart;


public interface CartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cart record);
    
  //�����û�id��ѯ��Ʒ���ﳵ
  	List<Cart> showGoodsDateByUid(int uid);
  	
  	
  	//����ɾ�����ﳵ��Ʒ
  	void deleteCartItemsMapper(@Param("str")String[] str);

  	
  	//�����Ʒ���ղس���
	int insertgoodsTofavorite(Cart cart);

	
	//�����û�id��ѯ�û��ղص���Ʒ
	List<Cart> selectCollGoodsById(int uid);

}