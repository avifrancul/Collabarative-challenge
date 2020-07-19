package com.allianz.collabarativechallenge.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allianz.collabarativechallenge.entity.District;
import com.allianz.collabarativechallenge.repository.CityRepository;
import com.allianz.collabarativechallenge.repository.DistrictRepository;
import com.allianz.collabarativechallenge.service.DistrictService;

@Service
public class DistrictServiceImpl implements DistrictService {

	@Autowired
	DistrictRepository districtRepository;
	
	@Autowired
	CityRepository cityRepository;

	@Override
	public List<District> retriveAllDistricts() {
		// TODO Auto-generated method stub
		List<District> districts = districtRepository.findAll();
		return districts;
	}

	@Override
	public List<District> retrieveDistrictsByCityId(String cityId) {
		// TODO Auto-generated method stub
		return districtRepository.findBycity(cityId);
	}

	@Override
	public District getDistrict(String districtId) {
		// TODO Auto-generated method stub
		Optional<District> optDistrict = districtRepository.findById(districtId);
		return optDistrict.get();
	}

	@Override
	public void saveDistrict(District district) {
		// TODO Auto-generated method stub
		String cityId = district.getCity().getId();
		if(cityRepository.findById(cityId)!=null) {
			districtRepository.save(district);
		}
		
	}

	@Override
	public void deleteDistrict(String districtId) {
		// TODO Auto-generated method stub
		districtRepository.deleteById(districtId);
	}

	@Override
	public void updateDistrict(District district) {
		// TODO Auto-generated method stub
		String cityId = district.getCity().getId();
		if(cityRepository.findById(cityId)!=null) {
			districtRepository.save(district);
		}
	}
	
	
}
