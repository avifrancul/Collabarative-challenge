package com.allianz.collabarativechallenge.service;

import java.util.List;
import java.util.Optional;

import com.allianz.collabarativechallenge.entity.City;

public interface CityService {
	
	public List<City> retrieveCities();
	public Optional<City> getCity(String cityId);
	public void saveCity(City city);
	public void deleteCity(String cityId);

}
