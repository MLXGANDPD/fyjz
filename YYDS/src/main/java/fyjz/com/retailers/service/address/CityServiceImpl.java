package fyjz.com.retailers.service.address;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fyjz.com.retailers.entity.City;
import fyjz.com.retailers.entity.Provinces;
import fyjz.com.retailers.mapper.city.CityMapper;

@Service
public class CityServiceImpl implements CityService{
	@Autowired
	private CityMapper cityMapper;
	

	//根据省code返回市
	public List<City> getcityListService(String provinceCode) {
		
		return cityMapper.getcityListMapper(provinceCode);
	}
		
	
}
