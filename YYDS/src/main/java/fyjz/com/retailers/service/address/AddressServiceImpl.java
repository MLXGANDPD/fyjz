package fyjz.com.retailers.service.address;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fyjz.com.retailers.entity.Address;
import fyjz.com.retailers.mapper.address.AddressMapper;
import fyjz.com.retailers.mapper.area.AreaMapper;
import fyjz.com.retailers.mapper.city.CityMapper;
import fyjz.com.retailers.mapper.provinces.ProvincesMapper;
@Service
public class AddressServiceImpl implements AddressService{
	@Autowired
	private AddressMapper addressMapper;
	@Autowired
	private ProvincesMapper provinceMapper;
	@Autowired
	private CityMapper cityMapper;
	@Autowired
	private AreaMapper areaMapper;

	
	//添加用户收获地址
	public int addGainAddressService(Address address) {
		//根据省的编号查询省的名字
		String provinceName=provinceMapper.findProvinceNameByCode(address.getRecvProvincecode());
		//根据市的编号查询市的名字
		String cityName=cityMapper.findCityNameByCode(address.getRecvCitycode());
		//根据县的编号查询县的名字
		String areaName=areaMapper.findAreaNameByCode(address.getRecvAreacode());
		
		
		//获取详情地址
		String ress=address.getRecvAddress();
		address.setRecvDistrict(provinceName+","+cityName+","+areaName+","+ress);
		
		
		//创建时间
		Date d=new Date();
		address.setCreateTime(d);
		//修改时间
		Date d2=new Date();
		address.setModifiedTime(d2);
		return addressMapper.insertSelective(address);
	}


	//显示用户收获地址信息
	public List<Address> addGainAddressService(int i) {
		List<Address> list=addressMapper.addGainAddressMapper(i);
		return list;
	}


	//查询用地收获地址
	public Address toUpdateAddress(int id) {
		Address address=addressMapper.selectByPrimaryKey(id);
		return address;
	}


	


	//修改用户地址
	public int UpdateAddress(Address address) {
		int b=addressMapper.updateByPrimaryKeySelective(address);
		return b;
	}


	//根据用户地址id删除用户收获地址
	public int toDeleteAddress(int id) {
		int n=addressMapper.deleteByPrimaryKey(id);
		return n;
	}


	@Transactional
	public int setdefaultAddress(int uid, int id) {
		int n=addressMapper.updateaddressdefaut0(uid);
		int n2=addressMapper.updateaddressdefaut1(id);
		return n;
	}


	//更改用户信息
	public int UpdateUserInforById(int uid, String name, int sex, String phone, String email,String image) {
		int n=addressMapper.UpdateUserInforById(uid,name,sex,phone,email,image);
		return n;
	}

}
