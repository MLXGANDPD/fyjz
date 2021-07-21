package fyjz.com.retailers.service.goods;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import fyjz.com.retailers.commons.PageObject;
import fyjz.com.retailers.entity.Goods;
import fyjz.com.retailers.mapper.goods.GoodsMapper;

@Controller
@RequestMapping("good")
public class GoodController {
	@Autowired
	GoodsService service;
	
	@Autowired
	private GoodsMapper mapper;
	
	
	@RequestMapping("searchHTML.do")
	public String serchHtml(String id,ModelMap model,HttpSession session){
		//获取四级分类商品
		System.out.println(id);
		
		
		PageObject page=new PageObject();
		Long cid=Long.parseLong(id);
		session.setAttribute("cid",cid);
		Map<String,Object> map=service.findGoodsByCategoryIdService(cid,page);
		model.addAttribute("map", map);
		return "search";
	}
	
	//商品下一页
	@RequestMapping("nextpage.do")
	public String nextpage(ModelMap model,PageObject page,HttpSession session){
		Long cid=(Long)session.getAttribute("cid");
		//获取当前页数
		int pageCurrent=page.getPageCurrent();
		
		//获取及记录数
		int rowCount=mapper.findGoodsNumByCategoryId(cid);
		page.setRowCount(rowCount);
		//总页数
		int pageCount=page.getPageCount();
		
		//如果当前页数是总页数，
		if(pageCurrent==pageCount){
			pageCurrent=pageCount;
		}else{
			pageCurrent++;
		}
		
		page.setPageCurrent(pageCurrent);
		Map<String,Object> map=service.findGoodsByCategoryIdService(cid,page);
		model.addAttribute("map", map);
		return "search";
	}
	
	//下一页
	@RequestMapping("toppage.do")
	public String toppage(ModelMap model,PageObject page,HttpSession session){
		Long cid=(Long)session.getAttribute("cid");
		//获取当前页数
		int pageCurrent=page.getPageCurrent();
		
		
		//如果当前页数是1
		if(pageCurrent==1){
			pageCurrent=1;
		}else{
			pageCurrent--;
		}
		
		page.setPageCurrent(pageCurrent);
		Map<String,Object> map=service.findGoodsByCategoryIdService(cid,page);
		model.addAttribute("map", map);
		return "search";
	}

	//获取当前页数对应的数据
	@RequestMapping("getpage.do")
	public String getpage(ModelMap model,PageObject page,HttpSession session){
		Long cid=(Long)session.getAttribute("cid");
		Map<String,Object> map=service.findGoodsByCategoryIdService(cid,page);
		model.addAttribute("map", map);
		return "search";
	}
	
	
	//商品详情页
	@RequestMapping("detailsHTML.do")
	public String detailsHTML(String id,ModelMap model){
		Goods good=service.findGoodsByIdService(id);
		model.addAttribute("good", good);
		return "product_details";
	}
	
}
