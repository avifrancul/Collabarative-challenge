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
	public List<District> retrieveDistrictsByCityId(String cityId) {
		return districtRepository.findByCityId(cityId);
	}

	@Override
	public Optional<District> getDistrict(String districtId) {
		return districtRepository.findById(districtId);
	}

	@Override
	public void saveDistrict(District district) {		
			districtRepository.save(district);
		
	}

	@Override
	public void deleteDistrict(String districtId) {
		districtRepository.deleteById(districtId);
	}

	
	
}
