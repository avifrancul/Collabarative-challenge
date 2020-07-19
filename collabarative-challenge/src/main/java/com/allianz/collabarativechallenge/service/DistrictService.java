package com.allianz.collabarativechallenge.service;

import java.util.List;

import com.allianz.collabarativechallenge.entity.District;

public interface DistrictService {
	
	public List<District> retriveAllDistricts();
	public List<District> retrieveDistrictsByCityId(String cityId);
	public District getDistrict(String districtId);
	public void saveDistrict (District district);
	public void deleteDistrict(String districtId);
	public void updateDistrict(District district);

}
