package fyjz.com.retailers.mapper.provinces;

import java.util.List;

import fyjz.com.retailers.entity.Provinces;

public interface ProvincesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Provinces record);

    int insertSelective(Provinces record);

    Provinces selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Provinces record);

    int updateByPrimaryKey(Provinces record);

    //��ȡ���е�ʡ��
	List<Provinces> getProvinceListMapper();

	//����ʡ�ı�Ų�ѯʡ������
	String findProvinceNameByCode(String recvProvincecode);
}