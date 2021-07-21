package fyjz.com.retailers.service.cart;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fyjz.com.retailers.entity.Cart;
import fyjz.com.retailers.mapper.cart.CartMapper;
import fyjz.com.retailers.mapper.goods.GoodsMapper;

@Service("cartService")
public class CartServiceImpl implements CartService{
	@Autowired
	CartMapper  cartMapper;
	@Autowired
	GoodsMapper goodsMapper;
	
	//添加购物车
	public int addCartService(Cart cart) {
		//获取商品id
		int id=cart.getGoodsId();
		//获取商品数量
		int goodNum=goodsMapper.findGoodsNumByGoodId(id);
		
		
		//添加的商品数量和库存量校验
		if(goodNum<cart.getNum()){
			throw new RuntimeException("库存不足");
		}
		
		return cartMapper.insertSelective(cart);
	}

	//根据用户id查询商品购物车
	public List<Cart> selectGoodsDateByUid(int uid) {
		List<Cart> list=new ArrayList<Cart>();
		list=cartMapper.showGoodsDateByUid(uid);
		return list;
	}

	//根据商品id删除购物车商品
	public void deleteCartByIdService(int itemId) {
		cartMapper.deleteByPrimaryKey(itemId);
	}

	//批量删除购物车商品
	public void deleteCartItemsService(String itemIds) {
		String[] str=itemIds.split(",");
		cartMapper.deleteCartItemsMapper(str);
	}

	//修改商品数量
	public void updateCartItemsNumService(HttpSession session) {
		List<Cart> list=(List<Cart>) session.getAttribute("cart_list");
		for(int i=0;i<list.size();i++){
			//商品id
			int goodsId=list.get(i).getGoodsId();
			//根据购物车中的商品goodsId查询库存数量
			int num=list.get(i).getNum();
			goodsMapper.updateCartItemByIdMapper(goodsId,num);
		}
	}

	//添加商品到收藏车中
	public int addFavoriteGood(Cart cart) {
		
		return cartMapper.insertgoodsTofavorite(cart);
	}

	//根据用户id查询用户收藏的商品
	public List<Cart> selectCollectGoodsByUid(int uid) {
		List<Cart> list=cartMapper.selectCollGoodsById(uid);
		return list;
	}

	
	
}
