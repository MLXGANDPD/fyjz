package fyjz.com.retailers.mapper.address;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import fyjz.com.retailers.entity.Address;

public interface AddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer id);

    //修改用户地址
    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);

    
    //显示用户收获地址信息
	List<Address> addGainAddressMapper(int i);

	
	int updateaddressdefaut0(int uid);

	int updateaddressdefaut1(int id);

	//更改用户信息
	int UpdateUserInforById(@Param("uid")int uid,@Param("name")String name,@Param("sex")int sex, @Param("phone")String phone,@Param("email")String email,@Param("image")String image);

	

	
}