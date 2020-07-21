package com.allianz.collabarativechallenge.serviceimpl;

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
		return cityRepository.findAll();
	}

	@Override
	public Optional<City> getCity(String cityId) {
		return cityRepository.findById(cityId);
	}

	@Override
	public void saveCity(City city) {
		cityRepository.save(city);
	}

	@Override
	public void deleteCity(String cityId) {
		cityRepository.deleteById(cityId);
	}


	
	
}
