package fyjz.com.retailers.mapper.area;

import java.util.List;

import fyjz.com.retailers.entity.Area;

public interface AreaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Area record);

    int insertSelective(Area record);

    Area selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);

	List<Area> getareaListMapper(String cityCode);
	
	//根据县的编号查询县的名字
	String findAreaNameByCode(String recvAreacode);
}