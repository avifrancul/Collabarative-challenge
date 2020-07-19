package com.allianz.collabarativechallenge.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.allianz.collabarativechallenge.dto.DistrictDTO;
import com.allianz.collabarativechallenge.entity.City;
import com.allianz.collabarativechallenge.entity.District;
import com.allianz.collabarativechallenge.exception.CityNotFoundException;
import com.allianz.collabarativechallenge.exception.DistrictNotFoundException;
import com.allianz.collabarativechallenge.service.CityService;
import com.allianz.collabarativechallenge.service.DistrictService;

@RestController
public class DistrictRestController {
	@Autowired
	private DistrictService districtService;
	
	@Autowired
	private CityService cityService;
	
	@GetMapping("/api/districts")
	public List<District> getAllDistricts(){
		return districtService.retriveAllDistricts();
	}
	
	@GetMapping("/api/district/{districtId}")
	public District getDistrict(@PathVariable(name="districtId") String districtId) {
		District dst = districtService.getDistrict(districtId);
		if(dst == null) 
			throw new DistrictNotFoundException("id-"+districtId);
		return districtService.getDistrict(districtId);
	}
	
	@PostMapping("/api/district/")
	public ResponseEntity<Object> saveDistrict(@Valid @RequestBody DistrictDTO districtDTO){
		ModelMapper modelMapper = new ModelMapper();
	    District district = modelMapper.map(districtDTO, District.class);
		String cityId = district.getCity().getId();
		City cty = cityService.getCity(cityId);
		if(cty == null) 
			throw new CityNotFoundException("id-"+cityId);	
		districtService.saveDistrict(district);
		URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(district.getId()).toUri();
	    return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/api/district/{districtId}")
	public void deleteDistrict(@PathVariable(name="districtId") String districtId) {
		District dst = districtService.getDistrict(districtId);
		if(dst == null) 
			throw new DistrictNotFoundException("id-"+districtId);	
		districtService.deleteDistrict(districtId);
	}
	
	@PutMapping("/api/district/{districtId}")
	public void updateDistrict(@Valid @RequestBody DistrictDTO districtDTO, @PathVariable(name="districtId") String districtId ) {
		ModelMapper modelMapper = new ModelMapper();
	    District district = modelMapper.map(districtDTO, District.class);		
		String cityId = district.getCity().getId();
		City cty = cityService.getCity(cityId);
		if(cty == null) 
			throw new CityNotFoundException("id-"+cityId);	
		District dst = districtService.getDistrict(districtId);
		if(dst == null) 
			throw new DistrictNotFoundException("id-"+districtId);	
		districtService.saveDistrict(district);
	}
	
	@GetMapping("/api/district/{cityId}/districts")
	public List<District> getAllDistrictsByCityId(@PathVariable(name="cityId") String cityId){
		City cty = cityService.getCity(cityId);
		if(cty == null) 
			throw new CityNotFoundException("id-"+cityId);	
		return districtService.retrieveDistrictsByCityId(cityId);
	}
}
