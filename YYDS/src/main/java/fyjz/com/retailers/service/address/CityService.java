package fyjz.com.retailers.service.address;

import java.util.List;

import fyjz.com.retailers.entity.City;
import fyjz.com.retailers.entity.Provinces;

public interface CityService {

	
	//����ʡcode������
	List<City> getcityListService(String provinceCode);
	
	
}
