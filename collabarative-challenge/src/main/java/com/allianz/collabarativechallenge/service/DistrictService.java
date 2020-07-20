package com.allianz.collabarativechallenge.service;

import java.util.List;
import java.util.Optional;

import com.allianz.collabarativechallenge.entity.District;

public interface DistrictService {
	
	public List<District> retrieveDistrictsByCityId(String cityId);
	public Optional<District> getDistrict(String districtId);
	public void saveDistrict (District district);
	public void deleteDistrict(String districtId);

}
