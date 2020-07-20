package com.allianz.collabarativechallenge.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.allianz.collabarativechallenge.entity.Concentration;

public interface ConcentrationService {
	
	public List<Concentration> retrieveConcentrationByDistrictId(String districtId);
	public Optional<Concentration> getConcentration(Long concentrationId);
	public void saveConcentration (Concentration concentrationId);
	public void deleteConcentration(Long concentrationId);
	public List<Concentration> findByDistrictIdAndEndDateBetween(String districtId, LocalDate startDate, LocalDate endDate);

}
