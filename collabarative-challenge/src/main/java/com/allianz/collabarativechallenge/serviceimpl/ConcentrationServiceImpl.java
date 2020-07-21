package com.allianz.collabarativechallenge.serviceimpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;
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
	public List<Concentration> findByDistrictIdAndEndDateBetween(String districtId, LocalDateTime start, LocalDateTime end) {
		java.util.Date startDate = Date.from(start.atZone(ZoneId.systemDefault()).toInstant());
		java.util.Date endDate = Date.from(end.atZone(ZoneId.systemDefault()).toInstant());
		return concentrationRepository.findByDistrictIdAndEntryDateBetween(districtId, startDate, endDate);
	}

}
