package fyjz.com.retailers.service.address;

import java.util.List;

import fyjz.com.retailers.entity.City;
import fyjz.com.retailers.entity.Provinces;

public interface CityService {

	
	//根据省code返回市
	List<City> getcityListService(String provinceCode);
	
	
}
