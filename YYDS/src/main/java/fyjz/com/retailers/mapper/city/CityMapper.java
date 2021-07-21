package fyjz.com.retailers.mapper.city;

import java.util.List;

import fyjz.com.retailers.entity.City;

public interface CityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(City record);

    int insertSelective(City record);

    City selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);

    //����ʡ������
	List<City> getcityListMapper(String provinceCode);

	//�����еı�Ų�ѯ�е�����
	String findCityNameByCode(String recvCitycode);
}