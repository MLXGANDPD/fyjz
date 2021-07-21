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

    //获取所有的省份
	List<Provinces> getProvinceListMapper();

	//根据省的编号查询省的名字
	String findProvinceNameByCode(String recvProvincecode);
}