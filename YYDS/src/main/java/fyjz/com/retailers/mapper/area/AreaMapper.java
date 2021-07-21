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
	
	//�����صı�Ų�ѯ�ص�����
	String findAreaNameByCode(String recvAreacode);
}