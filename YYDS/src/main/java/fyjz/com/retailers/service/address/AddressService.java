package fyjz.com.retailers.service.address;

import java.util.List;

import fyjz.com.retailers.entity.Address;

public interface AddressService {
	//添加用户收获地址
	int addGainAddressService(Address address);

	//显示用户收获地址信息
	List<Address> addGainAddressService(int i);

	//查询用户地址
	Address toUpdateAddress(int id);

	//修改用户地址
	int UpdateAddress(Address address);

	//根据用户地址id删除用户收获地址
	int toDeleteAddress(int id);

	
	//设置默认收获地址
	int setdefaultAddress(int uid, int id);

	//更改用户信息
	int UpdateUserInforById(int uid, String name, int sex, String phone, String email, String image);
}
