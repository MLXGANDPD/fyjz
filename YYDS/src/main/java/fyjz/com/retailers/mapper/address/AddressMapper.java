package fyjz.com.retailers.mapper.address;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import fyjz.com.retailers.entity.Address;

public interface AddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer id);

    //�޸��û���ַ
    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);

    
    //��ʾ�û��ջ��ַ��Ϣ
	List<Address> addGainAddressMapper(int i);

	
	int updateaddressdefaut0(int uid);

	int updateaddressdefaut1(int id);

	//�����û���Ϣ
	int UpdateUserInforById(@Param("uid")int uid,@Param("name")String name,@Param("sex")int sex, @Param("phone")String phone,@Param("email")String email,@Param("image")String image);

	

	
}