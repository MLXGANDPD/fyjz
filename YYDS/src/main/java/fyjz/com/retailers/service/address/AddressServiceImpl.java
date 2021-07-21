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

	
	//����û��ջ��ַ
	public int addGainAddressService(Address address) {
		//����ʡ�ı�Ų�ѯʡ������
		String provinceName=provinceMapper.findProvinceNameByCode(address.getRecvProvincecode());
		//�����еı�Ų�ѯ�е�����
		String cityName=cityMapper.findCityNameByCode(address.getRecvCitycode());
		//�����صı�Ų�ѯ�ص�����
		String areaName=areaMapper.findAreaNameByCode(address.getRecvAreacode());
		
		
		//��ȡ�����ַ
		String ress=address.getRecvAddress();
		address.setRecvDistrict(provinceName+","+cityName+","+areaName+","+ress);
		
		
		//����ʱ��
		Date d=new Date();
		address.setCreateTime(d);
		//�޸�ʱ��
		Date d2=new Date();
		address.setModifiedTime(d2);
		return addressMapper.insertSelective(address);
	}


	//��ʾ�û��ջ��ַ��Ϣ
	public List<Address> addGainAddressService(int i) {
		List<Address> list=addressMapper.addGainAddressMapper(i);
		return list;
	}


	//��ѯ�õ��ջ��ַ
	public Address toUpdateAddress(int id) {
		Address address=addressMapper.selectByPrimaryKey(id);
		return address;
	}


	


	//�޸��û���ַ
	public int UpdateAddress(Address address) {
		int b=addressMapper.updateByPrimaryKeySelective(address);
		return b;
	}


	//�����û���ַidɾ���û��ջ��ַ
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


	//�����û���Ϣ
	public int UpdateUserInforById(int uid, String name, int sex, String phone, String email,String image) {
		int n=addressMapper.UpdateUserInforById(uid,name,sex,phone,email,image);
		return n;
	}

}
