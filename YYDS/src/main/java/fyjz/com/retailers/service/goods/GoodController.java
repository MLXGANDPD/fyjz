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
		//��ȡ�ļ�������Ʒ
		System.out.println(id);
		
		
		PageObject page=new PageObject();
		Long cid=Long.parseLong(id);
		session.setAttribute("cid",cid);
		Map<String,Object> map=service.findGoodsByCategoryIdService(cid,page);
		model.addAttribute("map", map);
		return "search";
	}
	
	//��Ʒ��һҳ
	@RequestMapping("nextpage.do")
	public String nextpage(ModelMap model,PageObject page,HttpSession session){
		Long cid=(Long)session.getAttribute("cid");
		//��ȡ��ǰҳ��
		int pageCurrent=page.getPageCurrent();
		
		//��ȡ����¼��
		int rowCount=mapper.findGoodsNumByCategoryId(cid);
		page.setRowCount(rowCount);
		//��ҳ��
		int pageCount=page.getPageCount();
		
		//�����ǰҳ������ҳ����
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
	
	//��һҳ
	@RequestMapping("toppage.do")
	public String toppage(ModelMap model,PageObject page,HttpSession session){
		Long cid=(Long)session.getAttribute("cid");
		//��ȡ��ǰҳ��
		int pageCurrent=page.getPageCurrent();
		
		
		//�����ǰҳ����1
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

	//��ȡ��ǰҳ����Ӧ������
	@RequestMapping("getpage.do")
	public String getpage(ModelMap model,PageObject page,HttpSession session){
		Long cid=(Long)session.getAttribute("cid");
		Map<String,Object> map=service.findGoodsByCategoryIdService(cid,page);
		model.addAttribute("map", map);
		return "search";
	}
	
	
	//��Ʒ����ҳ
	@RequestMapping("detailsHTML.do")
	public String detailsHTML(String id,ModelMap model){
		Goods good=service.findGoodsByIdService(id);
		model.addAttribute("good", good);
		return "product_details";
	}
	
}
