package fyjz.com.retailers.service.address;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fyjz.com.retailers.entity.Area;
import fyjz.com.retailers.mapper.area.AreaMapper;

@Service
public class AreaServiceImpl implements AreaService{
	@Autowired
	private AreaMapper areaMapper;
	
	public List<Area> getareaListService(String cityCode) {
		
		return areaMapper.getareaListMapper(cityCode);
	}

}
