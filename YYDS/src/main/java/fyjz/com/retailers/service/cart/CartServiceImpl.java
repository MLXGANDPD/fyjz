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
	
	//��ӹ��ﳵ
	public int addCartService(Cart cart) {
		//��ȡ��Ʒid
		int id=cart.getGoodsId();
		//��ȡ��Ʒ����
		int goodNum=goodsMapper.findGoodsNumByGoodId(id);
		
		
		//��ӵ���Ʒ�����Ϳ����У��
		if(goodNum<cart.getNum()){
			throw new RuntimeException("��治��");
		}
		
		return cartMapper.insertSelective(cart);
	}

	//�����û�id��ѯ��Ʒ���ﳵ
	public List<Cart> selectGoodsDateByUid(int uid) {
		List<Cart> list=new ArrayList<Cart>();
		list=cartMapper.showGoodsDateByUid(uid);
		return list;
	}

	//������Ʒidɾ�����ﳵ��Ʒ
	public void deleteCartByIdService(int itemId) {
		cartMapper.deleteByPrimaryKey(itemId);
	}

	//����ɾ�����ﳵ��Ʒ
	public void deleteCartItemsService(String itemIds) {
		String[] str=itemIds.split(",");
		cartMapper.deleteCartItemsMapper(str);
	}

	//�޸���Ʒ����
	public void updateCartItemsNumService(HttpSession session) {
		List<Cart> list=(List<Cart>) session.getAttribute("cart_list");
		for(int i=0;i<list.size();i++){
			//��Ʒid
			int goodsId=list.get(i).getGoodsId();
			//���ݹ��ﳵ�е���ƷgoodsId��ѯ�������
			int num=list.get(i).getNum();
			goodsMapper.updateCartItemByIdMapper(goodsId,num);
		}
	}

	//�����Ʒ���ղس���
	public int addFavoriteGood(Cart cart) {
		
		return cartMapper.insertgoodsTofavorite(cart);
	}

	//�����û�id��ѯ�û��ղص���Ʒ
	public List<Cart> selectCollectGoodsByUid(int uid) {
		List<Cart> list=cartMapper.selectCollGoodsById(uid);
		return list;
	}

	
	
}
