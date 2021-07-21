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
    
  //根据用户id查询商品购物车
  	List<Cart> showGoodsDateByUid(int uid);
  	
  	
  	//批量删除购物车商品
  	void deleteCartItemsMapper(@Param("str")String[] str);

  	
  	//添加商品到收藏车中
	int insertgoodsTofavorite(Cart cart);

	
	//根据用户id查询用户收藏的商品
	List<Cart> selectCollGoodsById(int uid);

}