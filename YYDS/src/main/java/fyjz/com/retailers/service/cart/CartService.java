package fyjz.com.retailers.service.cart;

import java.util.List;

import javax.servlet.http.HttpSession;

import fyjz.com.retailers.entity.Cart;

public interface CartService {
	//添加购物车
	int addCartService(Cart cart);
	
	//根据用户id查询商品购物车
	List<Cart> selectGoodsDateByUid(int uid);
	
	//根据商品id删除购物车商品
	void deleteCartByIdService(int itemId);
	
	//批量删除购物车商品
	void deleteCartItemsService(String itemIds);
	
	//修改商品数量
	void updateCartItemsNumService(HttpSession session);

	
	//添加商品到收藏车中
	int addFavoriteGood(Cart cart);

	//根据用户id查询用户收藏的商品
	List<Cart> selectCollectGoodsByUid(int uid);
}
