package fyjz.com.retailers.controller.cart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fyjz.com.retailers.commons.HandlerException;
import fyjz.com.retailers.commons.JsonResult;
import fyjz.com.retailers.entity.Cart;
import fyjz.com.retailers.entity.Goods;
import fyjz.com.retailers.entity.User;
import fyjz.com.retailers.service.cart.CartService;

@Controller
@RequestMapping("cart")
public class CartContorller extends HandlerException{
	@Autowired
	private CartService cartService;
	
	@RequestMapping("addGoodDate.do")
	@ResponseBody
	public JsonResult<Integer> addGoodDate(HttpSession session,Cart cart){
		//获取用户uid
		User user=(User) session.getAttribute("user");
		System.out.println(user);
		if(user==null){
			throw new RuntimeException("sessionID过期");
		}
		int uid=user.getId();
		cart.setUserId(uid);
		int n=cartService.addCartService(cart);
		
		return new JsonResult<Integer>(n);
		
	}
	
	//显示购物车事件
	@RequestMapping("showGoodDate.do")
	public String showGoodDate(HttpSession session){
		//获取用户id
		User user=(User) session.getAttribute("user");
		System.out.println(user);
		int uid=user.getId();
		List<Cart> list=cartService.selectGoodsDateByUid(uid);
		session.setAttribute("cart_list",list);
		
		return "cart";
	}
	
	//根据商品id删除购物车商品
	@RequestMapping("deleteCart.do")
	public String deleteCart(int itemId){
		cartService.deleteCartByIdService(itemId);
		return "redirect:showGoodDate.do";
	}
	
	
	//批量删除购物车商品
	@RequestMapping("deleteCartItemsId.do")
	public String deleteCartItemsId(String itemIds){
		cartService.deleteCartItemsService(itemIds);
		return "redirect:showGoodDate.do";
	}
	
	//去结算商品
	@RequestMapping("orderConfirm.do")
	public String orderConfirm(HttpSession session,ModelMap model){
		Map<String,Object> map=new HashMap<String, Object>();
		List<Cart> cart_list=(List<Cart>) session.getAttribute("cart_list");
		map.put("cart_list",cart_list);
		model.addAttribute("map",map);
		
		return "orderConfirm";
	}
	
	//商品收货页面
	@RequestMapping("ordersHTML.do")
	public String orders(HttpSession session,ModelMap model){
		cartService.updateCartItemsNumService(session);
		List<Cart> list=(List<Cart>) session.getAttribute("cart_list");
		model.addAttribute("list",list);
		return "orders";
	}
	
	
	//用户收藏
	@RequestMapping("favorites.do")
	@ResponseBody
	public JsonResult<Integer> favorites(HttpSession session,Cart cart){
		//获取用户uid
		User user=(User) session.getAttribute("user");
		System.out.println(user);
		if(user==null){
			throw new RuntimeException("sessionID过期");
		}
		int uid=user.getId();
		cart.setUserId(uid);
		int n=cartService.addFavoriteGood(cart);
		
		return new JsonResult<Integer>(n);
	}
	
	
	//显示收藏商品信息
	@RequestMapping("favouritesHTML.do")
	public String favouritesHTML(HttpSession session){
		User u=(User) session.getAttribute("user");
		int uid=u.getId();
		System.out.println(uid);
		List<Cart> listCollection=cartService.selectCollectGoodsByUid(uid);
		session.setAttribute("listCollection", listCollection);
		return "favorites";
	}
}
