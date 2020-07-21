package com.allianz.collabarativechallenge.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
import com.allianz.collabarativechallenge.exception.RecordNotFoundException;
import com.allianz.collabarativechallenge.exception.ResourceAlreadyExists;
import com.allianz.collabarativechallenge.service.CityService;
import com.allianz.collabarativechallenge.service.DistrictService;

@RestController
public class DistrictRestController {
	@Autowired
	private DistrictService districtService;
	
	@Autowired
	private CityService cityService;
	
	@GetMapping("/district/{districtId}")
	public Optional<District> getDistrict(@PathVariable(name="districtId") String districtId) {
		Optional<District> dst = districtService.getDistrict(districtId);
		if(!dst.isPresent()) 
			throw new RecordNotFoundException("id-"+districtId);
		return districtService.getDistrict(districtId);
	}
	
	@PostMapping("/district/{cityId}")
	public ResponseEntity<Object> saveDistrict(@PathVariable(name="cityId") String cityId,@Valid @RequestBody DistrictDTO districtDTO){
		Optional<City> cty = cityService.getCity(cityId);
		if (!cty.isPresent())
			throw new RecordNotFoundException("id-"+cityId);
		Optional<District> dist = districtService.getDistrict(districtDTO.getId());
		if (dist.isPresent())
			throw new ResourceAlreadyExists("id-"+districtDTO.getId());		
		ModelMapper modelMapper = new ModelMapper();
	    District district = modelMapper.map(districtDTO, District.class);	    
		district.setCity(cty.get());
		districtService.saveDistrict(district);
		URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(district.getId()).toUri();
	    return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/district/{districtId}")
	public void deleteDistrict(@PathVariable(name="districtId") String districtId) {
		Optional<District> dst = districtService.getDistrict(districtId);
		if(!dst.isPresent()) 
			throw new RecordNotFoundException("id-"+districtId);	
		districtService.deleteDistrict(districtId);
	}
	
	@PutMapping("/district")
	public void updateDistrict(@Valid @RequestBody DistrictDTO districtDTO ) {		
			
		Optional<District> dst = districtService.getDistrict(districtDTO.getId());
		if(!dst.isPresent()) 
			throw new RecordNotFoundException("id-"+districtDTO.getId());	
		ModelMapper modelMapper = new ModelMapper();
	    District district = modelMapper.map(districtDTO, District.class);
	    district.setCity(dst.get().getCity());
		districtService.saveDistrict(district);
	}
	
	@GetMapping("/city/{cityId}/districts")
	public List<District> getAllDistrictsByCityId(@PathVariable(name="cityId") String cityId){
		Optional<City> city = cityService.getCity(cityId);
		if (!city.isPresent())
			throw new RecordNotFoundException("id-"+cityId);	
		return districtService.retrieveDistrictsByCityId(cityId);
	}
}
