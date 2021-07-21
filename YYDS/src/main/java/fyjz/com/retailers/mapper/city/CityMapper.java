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

    //根据省返回市
	List<City> getcityListMapper(String provinceCode);

	//根据市的编号查询市的名字
	String findCityNameByCode(String recvCitycode);
}