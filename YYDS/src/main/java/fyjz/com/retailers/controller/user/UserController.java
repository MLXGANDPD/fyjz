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
	
	//注册页面
	@RequestMapping("toRegisterHTML.do")
	public String toRegisterHTML(){
		return "register";
	}
	
	//校验名字
	@RequestMapping("tocheckName.do")
	@ResponseBody
	public JsonResult<Integer> tocheckName(String name){
		int n=service.findNumByName(name);
		return new JsonResult<Integer>(n);
	}
	
	//用户注册
	@RequestMapping("toRegister.do")
	@ResponseBody
	public	JsonResult<Boolean> toRegister(User user){
		boolean b=service.addUserService(user);
		return new JsonResult<Boolean>(b);
	}
	
	//登录页面
	@RequestMapping("tologinHtmL.do")
	public String tologinHtmL(){
		return "login";
	}
	
	//生成验证码
	@RequestMapping(value="code.do",produces="image/png")
	@ResponseBody
	public byte[] code(HttpSession session) throws IOException{
		String code=getCode(4);
		//绑定code
		session.setAttribute("code",code);
		byte[] imgbyte=createimage(code);
		return imgbyte;
	}
	
	
	
	
	//画验证码
	public byte[] createimage(String code) throws IOException{
		//创建BufferedImage
		BufferedImage img=new BufferedImage(100,40,BufferedImage.TYPE_3BYTE_BGR);
		//创建画笔
		Graphics2D g=img.createGraphics();
		//随机生成颜色
		Random random=new Random();
		Color c=new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));
		//十六进制生成随机颜色
		//Color c2=new Color(random.nextInt(0xFFFFFF)); 
		//给画笔设置随机颜色
		g.setColor(c);
		//填充矩形区域（图片背景）
		g.fillRect(0,0,100,40);
		//绘制500个随机点
		for(int i=0;i<500;i++){
			img.setRGB(random.nextInt(100),random.nextInt(40),random.nextInt(0xFFFFFF));
		}
		
		//干扰线
		for(int i=0;i<10;i++){
			//设置随机颜色
			g.setColor(new Color(random.nextInt(0xFFFFFF)));
			int x1=random.nextInt(100);//起点横
			int y1=random.nextInt(40);//起点纵
			int x2=random.nextInt(100);//终点横
			int y2=random.nextInt(40);//终点纵
			g.drawLine(x1, y1, x2, y2);
			
		}
		//设置字体大小
		Font font=new Font(Font.SANS_SERIF,Font.PLAIN,30);
		g.setFont(font);
		
		//设置平滑抗锯齿绘制(可要可不要)
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		
		//设置加粗
		g.setStroke(new BasicStroke(10.0f));
		
		
		//设置随机颜色
		g.setColor(new Color(random.nextInt(0xFFFFFF)));
		g.drawString(code,10,30);
		
		//将excel对象序列化为byte[]数据
		ByteArrayOutputStream out=new ByteArrayOutputStream();
		//将img写入out中
		ImageIO.write(img,"png",out);
		//将baos对象转化为数组
		byte[] bytes=out.toByteArray();
		return bytes;
	}
	
	
	//生成不重复的数字和字母
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
	
	//用户登录
	@RequestMapping("tologin.do")
	@ResponseBody
	public JsonResult<User> tologin(String lname,String lwd,String code,HttpSession session){
		//获取code
		String c=(String) session.getAttribute("code");
		//校验验证码equalsIgnoreCase忽略大小写
		if(!c.equalsIgnoreCase(code)){
			throw new RuntimeException("验证码错误");
		}
		User user=service.selectNumByNameAndPwd(lname, lwd);
		//绑定用户数据
		session.setAttribute("user",user);
		
		return new JsonResult<User>(user);
	}
	
	/*
	 * ModelMap对象主要用于传递控制方法处理数据到结果页面，
	 * 类似于request对象中的setAttribute方法的作用
	 */
	@RequestMapping("toindexHTML.do")
	public String toindexHTML(HttpSession session,ModelMap model){
		//获取user数据
		User user=(User) session.getAttribute("user");
		model.addAttribute("user", user);
		//获取分类商品
		Map<String,Object> map=categoryService.findgoodsCategoryByParentId(161L,0, 3);
		Map<String,Object> map2=categoryService.findgoodsCategoryByParentId(161L,4, 3);
		model.addAttribute("map",map);
		model.addAttribute("map2",map2);
		return "index";
	}
	
	
	//点击帮助
	@RequestMapping("help.do")
	public String help(){
		return "help";
	}
	
	
	
}
