package fyjz.com.retailers.controller.user;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fyjz.com.retailers.commons.HandlerException;
import fyjz.com.retailers.commons.JsonResult;
import fyjz.com.retailers.entity.User;
import fyjz.com.retailers.service.goodsCategory.GoodsCategoryService;
import fyjz.com.retailers.service.user.UserService;

@Controller
@RequestMapping("user")
public class UserController extends HandlerException{
	@Autowired
	private UserService service;
	
	@Autowired
	private GoodsCategoryService categoryService;
	
	//ע��ҳ��
	@RequestMapping("toRegisterHTML.do")
	public String toRegisterHTML(){
		return "register";
	}
	
	//У������
	@RequestMapping("tocheckName.do")
	@ResponseBody
	public JsonResult<Integer> tocheckName(String name){
		int n=service.findNumByName(name);
		return new JsonResult<Integer>(n);
	}
	
	//�û�ע��
	@RequestMapping("toRegister.do")
	@ResponseBody
	public	JsonResult<Boolean> toRegister(User user){
		boolean b=service.addUserService(user);
		return new JsonResult<Boolean>(b);
	}
	
	//��¼ҳ��
	@RequestMapping("tologinHtmL.do")
	public String tologinHtmL(){
		return "login";
	}
	
	//������֤��
	@RequestMapping(value="code.do",produces="image/png")
	@ResponseBody
	public byte[] code(HttpSession session) throws IOException{
		String code=getCode(4);
		//��code
		session.setAttribute("code",code);
		byte[] imgbyte=createimage(code);
		return imgbyte;
	}
	
	
	
	
	//����֤��
	public byte[] createimage(String code) throws IOException{
		//����BufferedImage
		BufferedImage img=new BufferedImage(100,40,BufferedImage.TYPE_3BYTE_BGR);
		//��������
		Graphics2D g=img.createGraphics();
		//���������ɫ
		Random random=new Random();
		Color c=new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));
		//ʮ���������������ɫ
		//Color c2=new Color(random.nextInt(0xFFFFFF)); 
		//���������������ɫ
		g.setColor(c);
		//����������ͼƬ������
		g.fillRect(0,0,100,40);
		//����500�������
		for(int i=0;i<500;i++){
			img.setRGB(random.nextInt(100),random.nextInt(40),random.nextInt(0xFFFFFF));
		}
		
		//������
		for(int i=0;i<10;i++){
			//���������ɫ
			g.setColor(new Color(random.nextInt(0xFFFFFF)));
			int x1=random.nextInt(100);//����
			int y1=random.nextInt(40);//�����
			int x2=random.nextInt(100);//�յ��
			int y2=random.nextInt(40);//�յ���
			g.drawLine(x1, y1, x2, y2);
			
		}
		//���������С
		Font font=new Font(Font.SANS_SERIF,Font.PLAIN,30);
		g.setFont(font);
		
		//����ƽ������ݻ���(��Ҫ�ɲ�Ҫ)
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		
		//���üӴ�
		g.setStroke(new BasicStroke(10.0f));
		
		
		//���������ɫ
		g.setColor(new Color(random.nextInt(0xFFFFFF)));
		g.drawString(code,10,30);
		
		//��excel�������л�Ϊbyte[]����
		ByteArrayOutputStream out=new ByteArrayOutputStream();
		//��imgд��out��
		ImageIO.write(img,"png",out);
		//��baos����ת��Ϊ����
		byte[] bytes=out.toByteArray();
		return bytes;
	}
	
	
	//���ɲ��ظ������ֺ���ĸ
	public String getCode(int m){
		String str="";
		for(int i=0;i<m;i++){
			Random rd=new Random();
			int n=65+rd.nextInt(26);
			int a=48+rd.nextInt(10);
			int b=97+rd.nextInt(26);
			Random r=new Random();
			int k=r.nextInt(3);
			int g=0;
			
			if(k==0){
				g=n;
			}else if(k==1){
				g=a;
			}else{
				g=b;
			}
			char c=(char)g;
			str+=c;
		}
		return str;
	}
	
	//�û���¼
	@RequestMapping("tologin.do")
	@ResponseBody
	public JsonResult<User> tologin(String lname,String lwd,String code,HttpSession session){
		//��ȡcode
		String c=(String) session.getAttribute("code");
		//У����֤��equalsIgnoreCase���Դ�Сд
		if(!c.equalsIgnoreCase(code)){
			throw new RuntimeException("��֤�����");
		}
		User user=service.selectNumByNameAndPwd(lname, lwd);
		//���û�����
		session.setAttribute("user",user);
		
		return new JsonResult<User>(user);
	}
	
	/*
	 * ModelMap������Ҫ���ڴ��ݿ��Ʒ����������ݵ����ҳ�棬
	 * ������request�����е�setAttribute����������
	 */
	@RequestMapping("toindexHTML.do")
	public String toindexHTML(HttpSession session,ModelMap model){
		//��ȡuser����
		User user=(User) session.getAttribute("user");
		model.addAttribute("user", user);
		//��ȡ������Ʒ
		Map<String,Object> map=categoryService.findgoodsCategoryByParentId(161L,0, 3);
		Map<String,Object> map2=categoryService.findgoodsCategoryByParentId(161L,4, 3);
		model.addAttribute("map",map);
		model.addAttribute("map2",map2);
		return "index";
	}
	
	
	//�������
	@RequestMapping("help.do")
	public String help(){
		return "help";
	}
	
	
	
}
