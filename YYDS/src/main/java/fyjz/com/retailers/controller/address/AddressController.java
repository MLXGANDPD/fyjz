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
 * �ջ���ַ
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
	
	//�ջ���ַ
	@RequestMapping("toAddressHTML.do")
	public String toAddressHTML(){
		return "addressAdmin";
	}
	
	//�õ�ʡ�ݼ���
	@RequestMapping("getProvinceList.do")
	@ResponseBody
	public JsonResult<List<Provinces>> getProvinceList(){
		List<Provinces> list=provinceService.getProvinceListService();
		return new JsonResult<List<Provinces>>(list);
	}
	
	//�õ��еļ���
	@RequestMapping("getcityList.do")
	@ResponseBody
	public JsonResult<List<City>> getcityList(String provinceCode){
		List<City> list=cityService.getcityListService(provinceCode);
		
		return new JsonResult<List<City>>(list);
	}
	
	//�õ��صļ���
	@RequestMapping("getareaList.do")
	@ResponseBody
	public JsonResult<List<Area>> getareaList(String cityCode){
		List<Area> list=areaService.getareaListService(cityCode);
		
		return new JsonResult<List<Area>>(list);
	}
	
	//����û��ջ��ַ
	@RequestMapping("toAddGainAddress.do")
	@ResponseBody
	public JsonResult<Integer> toAddGainAddress(Address address,HttpSession session){
		/*User user=(User) session.getAttribute("user");
		int uid=user.getId();*/
		address.setUid(20);
		int n=addressService.addGainAddressService(address);
		return new JsonResult<Integer>(n);
	}
	
	//��ʾ�û����е��û���ַ��Ϣ
	@RequestMapping("toGetAllAddress.do")
	@ResponseBody
	public JsonResult<List<Address>> toGetAllAddress(HttpSession session){
		/*User user=(User) session.getAttribute("user");
		int uid=user.getId();*/
		session.setAttribute("uid",20);
		List<Address> list=addressService.addGainAddressService(20);
		return new JsonResult<List<Address>>(list);
	}
	
	//�����û���ַid��ѯ�û��ջ��ַ
	@RequestMapping("tofindAddressAddress.do")
	@ResponseBody
	public JsonResult<Address> toUpdateAddress(int id){
		Address address=addressService.toUpdateAddress(id);
		return new JsonResult<Address>(address);
	}
	
	//�����û���ַidɾ���û��ջ��ַ
	@RequestMapping("toDeleteAddressAddress.do")
	@ResponseBody
	public JsonResult<Integer> toDeleteAddress(int id){
		int n=addressService.toDeleteAddress(id);
		return new JsonResult<Integer>(n);
	}
	
	//�����û���ַid�޸��û��ջ��ַ
	@RequestMapping("toUpdateAddress.do")
	@ResponseBody
	public JsonResult<Integer> UpdateAddress(Address address){
		int b=addressService.UpdateAddress(address);
		return new JsonResult<Integer>(b);
	}
	
	//����Ĭ���ջ��ַ
	@RequestMapping("defaultAddress.do")
	@ResponseBody
	public JsonResult<Integer> defaultAddress(HttpSession session,int id){
		int uid=(int) session.getAttribute("uid");
		int n=addressService.setdefaultAddress(uid,id);
		return new JsonResult<Integer>(n);
	}
	
	//�ҵ���Ϣҳ��
	@RequestMapping("toMyinforHTML.do")
	public String toSetHeadHTML(HttpSession session){
		User user=(User) session.getAttribute("user");
		session.setAttribute("u",user);
		return "personage";
	}
	
	//�����û���Ϣ
	@RequestMapping("saveChage.do")
	@ResponseBody
	public JsonResult<Integer> saveChage(HttpSession session,String name,int sex,String phone,String email,String image){
		User u=(User) session.getAttribute("user");
		int uid=u.getId();
		int n=addressService.UpdateUserInforById(uid,name,sex,phone,email,image);
		return new JsonResult<Integer>(n);
		
	}
	
	
	//��ȫ����ҳ��
	@RequestMapping("toUpdateHTML.do")
	public String toUpdateHTML(){
		return "personal_password";
	}
	
	
	//��ѯ�û������������������Ƿ�һ��
	@RequestMapping("tofindoldPwd.do")
	@ResponseBody
	public JsonResult<Boolean> tofindoldPwd(HttpSession session,String oldpwd){
		User user=(User) session.getAttribute("user");
		String  pwd=user.getPassword();
		String str="��";
		String pwdMd5=DigestUtils.md5Hex(oldpwd+str);
		boolean b=true;
		if(!pwd.equals(pwdMd5)){
			throw new RuntimeException("�û�����ľ����벻��ȷ");
		}
		return new JsonResult<Boolean>(b);
	}
	
	//�޸��û�����
	@RequestMapping("toUpdatePwd.do")
	@ResponseBody
	public JsonResult<Boolean> toUpdatePwd(HttpSession session,String newpwd){
		User user=(User) session.getAttribute("user");
		int uid=user.getId();
		//���������
		String str="��";
		String pwdMd5=DigestUtils.md5Hex(newpwd+str);
		boolean b=userService.updateUserPwdById(uid,pwdMd5);
		return new JsonResult<Boolean>(b);
	}
	
	
	//����ͷ�� 
	@RequestMapping("toupload.do")
	@ResponseBody
	public JsonResult<String> toupload(MultipartFile file,HttpSession session) throws IllegalStateException, IOException{
		//��ȡ��ʵ·��
		String path=session.getServletContext().getRealPath("");
		System.out.println(path);
		System.out.println(21);
		//��ȡ��ʵ�ļ�������
		String fileName=file.getOriginalFilename();
		System.out.println("�ļ���"+fileName);
		
		//��UUID����ļ�����
		String d=UUID.randomUUID().toString();
		System.out.println(d);
		
		//�������ݿ����ļ���ַ
		String url="/upload/image/"+d+fileName;
		session.setAttribute("url", url);
		File f=new File(path, url);
		if(!f.exists()){//�ж�file�ļ��Ƿ����
			f.mkdirs();//����������򴴽�Ŀ¼
		}
		//����ͼƬ�ϴ�
		file.transferTo(f);
		return new JsonResult<String>(url);
	}
}
