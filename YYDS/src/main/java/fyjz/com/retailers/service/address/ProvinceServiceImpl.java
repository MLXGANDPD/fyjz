package fyjz.com.retailers.service.address;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fyjz.com.retailers.entity.Provinces;
import fyjz.com.retailers.mapper.provinces.ProvincesMapper;

@Service
public class ProvinceServiceImpl implements ProvinceService{
		
	@Autowired
	ProvincesMapper provincesMapper;
	
	//��ȡ���е�ʡ��
	public List<Provinces> getProvinceListService() {
		
		return provincesMapper.getProvinceListMapper();
	}

}
