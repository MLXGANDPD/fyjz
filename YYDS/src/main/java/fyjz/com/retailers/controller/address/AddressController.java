package fyjz.com.retailers.controller.address;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import fyjz.com.retailers.commons.HandlerException;
import fyjz.com.retailers.commons.JsonResult;
import fyjz.com.retailers.entity.Address;
import fyjz.com.retailers.entity.Area;
import fyjz.com.retailers.entity.City;
import fyjz.com.retailers.entity.Provinces;
import fyjz.com.retailers.entity.User;
import fyjz.com.retailers.service.address.AddressService;
import fyjz.com.retailers.service.address.AreaService;
import fyjz.com.retailers.service.address.CityService;
import fyjz.com.retailers.service.address.ProvinceService;
import fyjz.com.retailers.service.user.UserService;

/*
 * 收货地址
 */
@Controller
@RequestMapping("address")
public class AddressController extends HandlerException {
	@Autowired
	private ProvinceService  provinceService;
	@Autowired 
	private CityService cityService;
	@Autowired 
	private AreaService areaService;
	@Autowired
	private UserService userService;
	@Autowired
	private AddressService addressService; 
	
	//收货地址
	@RequestMapping("toAddressHTML.do")
	public String toAddressHTML(){
		return "addressAdmin";
	}
	
	//得到省份集合
	@RequestMapping("getProvinceList.do")
	@ResponseBody
	public JsonResult<List<Provinces>> getProvinceList(){
		List<Provinces> list=provinceService.getProvinceListService();
		return new JsonResult<List<Provinces>>(list);
	}
	
	//得到市的集合
	@RequestMapping("getcityList.do")
	@ResponseBody
	public JsonResult<List<City>> getcityList(String provinceCode){
		List<City> list=cityService.getcityListService(provinceCode);
		
		return new JsonResult<List<City>>(list);
	}
	
	//得到县的集合
	@RequestMapping("getareaList.do")
	@ResponseBody
	public JsonResult<List<Area>> getareaList(String cityCode){
		List<Area> list=areaService.getareaListService(cityCode);
		
		return new JsonResult<List<Area>>(list);
	}
	
	//添加用户收获地址
	@RequestMapping("toAddGainAddress.do")
	@ResponseBody
	public JsonResult<Integer> toAddGainAddress(Address address,HttpSession session){
		/*User user=(User) session.getAttribute("user");
		int uid=user.getId();*/
		address.setUid(20);
		int n=addressService.addGainAddressService(address);
		return new JsonResult<Integer>(n);
	}
	
	//显示用户所有的用户地址信息
	@RequestMapping("toGetAllAddress.do")
	@ResponseBody
	public JsonResult<List<Address>> toGetAllAddress(HttpSession session){
		/*User user=(User) session.getAttribute("user");
		int uid=user.getId();*/
		session.setAttribute("uid",20);
		List<Address> list=addressService.addGainAddressService(20);
		return new JsonResult<List<Address>>(list);
	}
	
	//根据用户地址id查询用户收获地址
	@RequestMapping("tofindAddressAddress.do")
	@ResponseBody
	public JsonResult<Address> toUpdateAddress(int id){
		Address address=addressService.toUpdateAddress(id);
		return new JsonResult<Address>(address);
	}
	
	//根据用户地址id删除用户收获地址
	@RequestMapping("toDeleteAddressAddress.do")
	@ResponseBody
	public JsonResult<Integer> toDeleteAddress(int id){
		int n=addressService.toDeleteAddress(id);
		return new JsonResult<Integer>(n);
	}
	
	//根据用户地址id修改用户收获地址
	@RequestMapping("toUpdateAddress.do")
	@ResponseBody
	public JsonResult<Integer> UpdateAddress(Address address){
		int b=addressService.UpdateAddress(address);
		return new JsonResult<Integer>(b);
	}
	
	//设置默认收获地址
	@RequestMapping("defaultAddress.do")
	@ResponseBody
	public JsonResult<Integer> defaultAddress(HttpSession session,int id){
		int uid=(int) session.getAttribute("uid");
		int n=addressService.setdefaultAddress(uid,id);
		return new JsonResult<Integer>(n);
	}
	
	//我的信息页面
	@RequestMapping("toMyinforHTML.do")
	public String toSetHeadHTML(HttpSession session){
		User user=(User) session.getAttribute("user");
		session.setAttribute("u",user);
		return "personage";
	}
	
	//更改用户信息
	@RequestMapping("saveChage.do")
	@ResponseBody
	public JsonResult<Integer> saveChage(HttpSession session,String name,int sex,String phone,String email,String image){
		User u=(User) session.getAttribute("user");
		int uid=u.getId();
		int n=addressService.UpdateUserInforById(uid,name,sex,phone,email,image);
		return new JsonResult<Integer>(n);
		
	}
	
	
	//安全管理页面
	@RequestMapping("toUpdateHTML.do")
	public String toUpdateHTML(){
		return "personal_password";
	}
	
	
	//查询用户旧密码与输入密码是否一置
	@RequestMapping("tofindoldPwd.do")
	@ResponseBody
	public JsonResult<Boolean> tofindoldPwd(HttpSession session,String oldpwd){
		User user=(User) session.getAttribute("user");
		String  pwd=user.getPassword();
		String str="超";
		String pwdMd5=DigestUtils.md5Hex(oldpwd+str);
		boolean b=true;
		if(!pwd.equals(pwdMd5)){
			throw new RuntimeException("用户输入的旧密码不正确");
		}
		return new JsonResult<Boolean>(b);
	}
	
	//修改用户密码
	@RequestMapping("toUpdatePwd.do")
	@ResponseBody
	public JsonResult<Boolean> toUpdatePwd(HttpSession session,String newpwd){
		User user=(User) session.getAttribute("user");
		int uid=user.getId();
		//对密码加密
		String str="超";
		String pwdMd5=DigestUtils.md5Hex(newpwd+str);
		boolean b=userService.updateUserPwdById(uid,pwdMd5);
		return new JsonResult<Boolean>(b);
	}
	
	
	//更换头像 
	@RequestMapping("toupload.do")
	@ResponseBody
	public JsonResult<String> toupload(MultipartFile file,HttpSession session) throws IllegalStateException, IOException{
		//获取真实路径
		String path=session.getServletContext().getRealPath("");
		System.out.println(path);
		System.out.println(21);
		//获取真实文件及名字
		String fileName=file.getOriginalFilename();
		System.out.println("文件名"+fileName);
		
		//用UUID解决文件重名
		String d=UUID.randomUUID().toString();
		System.out.println(d);
		
		//存入数据库中文件地址
		String url="/upload/image/"+d+fileName;
		session.setAttribute("url", url);
		File f=new File(path, url);
		if(!f.exists()){//判断file文件是否存在
			f.mkdirs();//如果不存在则创建目录
		}
		//进行图片上传
		file.transferTo(f);
		return new JsonResult<String>(url);
	}
}
