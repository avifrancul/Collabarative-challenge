package com.allianz.collabarativechallenge.service;

import java.util.List;

import com.allianz.collabarativechallenge.entity.City;

public interface CityService {
	
	public List<City> retrieveCities();
	public City getCity(String cityId);
	public void saveCity(City city);
	public void deleteCity(String cityId);
	public void updateCity(City city);

}
