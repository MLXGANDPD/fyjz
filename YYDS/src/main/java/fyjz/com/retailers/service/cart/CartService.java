package fyjz.com.retailers.service.cart;

import java.util.List;

import javax.servlet.http.HttpSession;

import fyjz.com.retailers.entity.Cart;

public interface CartService {
	//��ӹ��ﳵ
	int addCartService(Cart cart);
	
	//�����û�id��ѯ��Ʒ���ﳵ
	List<Cart> selectGoodsDateByUid(int uid);
	
	//������Ʒidɾ�����ﳵ��Ʒ
	void deleteCartByIdService(int itemId);
	
	//����ɾ�����ﳵ��Ʒ
	void deleteCartItemsService(String itemIds);
	
	//�޸���Ʒ����
	void updateCartItemsNumService(HttpSession session);

	
	//�����Ʒ���ղس���
	int addFavoriteGood(Cart cart);

	//�����û�id��ѯ�û��ղص���Ʒ
	List<Cart> selectCollectGoodsByUid(int uid);
}
