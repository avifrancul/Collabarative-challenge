package com.allianz.collabarativechallenge.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allianz.collabarativechallenge.entity.City;
import com.allianz.collabarativechallenge.repository.CityRepository;
import com.allianz.collabarativechallenge.service.CityService;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityRepository cityRepository;

	@Override
	public List<City> retrieveCities() {
		// TODO Auto-generated method stub
		List<City> cities = cityRepository.findAll();
		return cities;
	}

	@Override
	public City getCity(String cityId) {
		// TODO Auto-generated method stub
		Optional<City> opCity = cityRepository.findById(cityId);
		return opCity.get();
	}

	@Override
	public void saveCity(City city) {
		// TODO Auto-generated method stub
		cityRepository.save(city);
	}

	@Override
	public void deleteCity(String cityId) {
		// TODO Auto-generated method stub
		cityRepository.deleteById(cityId);
	}

	@Override
	public void updateCity(City city) {
		// TODO Auto-generated method stub
		cityRepository.save(city);
	}
	
	
}
