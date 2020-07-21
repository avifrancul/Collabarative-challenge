package com.allianz.collabarativechallenge.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allianz.collabarativechallenge.entity.Concentration;
import com.allianz.collabarativechallenge.repository.ConcentrationRepository;
import com.allianz.collabarativechallenge.service.ConcentrationService;

@Service
public class ConcentrationServiceImpl implements ConcentrationService {	
	
	
	@Autowired
	ConcentrationRepository concentrationRepository;

	@Override
	public List<Concentration> retrieveConcentrationByDistrictId(String districtId) {
		return  concentrationRepository.findByDistrictId(districtId);
	}

	@Override
	public Optional<Concentration> getConcentration(Long concentrationId) {
		return concentrationRepository.findById(concentrationId);
	}

	@Override
	public void saveConcentration(Concentration concentration) {
		concentrationRepository.save(concentration);
		
	}

	@Override
	public void deleteConcentration(Long concentrationId) {
		concentrationRepository.deleteById(concentrationId);
		
	}

	@Override
	public List<Concentration> findByDistrictIdAndEndDateBetween(String districtId, LocalDate start, LocalDate end) {
		System.out.println("before start="+start);
		java.util.Date startDate = Date.from(start.atStartOfDay(ZoneId.systemDefault()).toInstant());
		System.out.println("after start="+startDate);
		java.util.Date endDate = Date.from(end.atStartOfDay(ZoneId.systemDefault()).toInstant());
		return concentrationRepository.findByDistrictIdAndEntryDateBetween(districtId, startDate, endDate);
	}

}
