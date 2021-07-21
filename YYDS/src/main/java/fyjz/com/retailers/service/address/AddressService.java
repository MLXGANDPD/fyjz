package fyjz.com.retailers.service.address;

import java.util.List;

import fyjz.com.retailers.entity.Address;

public interface AddressService {
	//����û��ջ��ַ
	int addGainAddressService(Address address);

	//��ʾ�û��ջ��ַ��Ϣ
	List<Address> addGainAddressService(int i);

	//��ѯ�û���ַ
	Address toUpdateAddress(int id);

	//�޸��û���ַ
	int UpdateAddress(Address address);

	//�����û���ַidɾ���û��ջ��ַ
	int toDeleteAddress(int id);

	
	//����Ĭ���ջ��ַ
	int setdefaultAddress(int uid, int id);

	//�����û���Ϣ
	int UpdateUserInforById(int uid, String name, int sex, String phone, String email, String image);
}
