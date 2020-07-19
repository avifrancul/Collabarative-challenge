package com.allianz.collabarativechallenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.allianz.collabarativechallenge.city.CityNotFoundException;
import com.allianz.collabarativechallenge.entity.City;
import com.allianz.collabarativechallenge.service.CityService;

@RestController
public class CityRestController {

	@Autowired
	private CityService cityService;
	
	@GetMapping("/api/cities")
	public List<City> getAllCity(){
		List<City> allCity = cityService.retrieveCities();
		return allCity;
	}
	
	@GetMapping("/api/city/{cityId}")
	public City getCity(@PathVariable(name="cityId") String cityId){
		City city = cityService.getCity(cityId);
		if(null == city) 
			throw new CityNotFoundException("id-"+cityId);
		return city;
	}
	
	
	
	
}
