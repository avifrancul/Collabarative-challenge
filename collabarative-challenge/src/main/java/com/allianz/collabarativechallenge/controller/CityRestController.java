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

import com.allianz.collabarativechallenge.dto.CityDTO;
import com.allianz.collabarativechallenge.entity.City;
import com.allianz.collabarativechallenge.exception.CityNotFoundException;
import com.allianz.collabarativechallenge.service.CityService;

@RestController
public class CityRestController {

	@Autowired
	private CityService cityService;
	
	@GetMapping("/api/cities")
	public List<City> getAllCity(){
		return cityService.retrieveCities();
	}
	
	@GetMapping("/api/city/{cityId}")
	public City getCity(@PathVariable(name="cityId") String cityId){
		City city = cityService.getCity(cityId);
		if(city == null) 
			throw new CityNotFoundException("id-"+cityId);
		return city;
	}
	
	@PostMapping("/api/city")
	public ResponseEntity<Object> saveCity(@Valid @RequestBody CityDTO cityDTO){
		ModelMapper modelMapper = new ModelMapper();
	    City city = modelMapper.map(cityDTO, City.class);
		cityService.saveCity(city);
		URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(city.getId()).toUri();
	    return ResponseEntity.created(location).build();

	}
	
	@DeleteMapping("/api/city/{cityId}")
	public void deleteCity(@PathVariable(name="cityId") String cityId) {
		City cty = cityService.getCity(cityId);
		if(cty == null) 
			throw new CityNotFoundException("id-"+cityId);		
		cityService.deleteCity(cityId);
	}
	
	@PutMapping("/api/city/{cityId}")
	public void updateCity(@Valid @RequestBody CityDTO cityDTO, @PathVariable(name="cityId") String cityId) {
		City cty = cityService.getCity(cityId);
		if(cty == null) 
			throw new CityNotFoundException("id-"+cityId);	
		ModelMapper modelMapper = new ModelMapper();
	    City city = modelMapper.map(cityDTO, City.class);
		cityService.saveCity(city);
	}
	
	
}
