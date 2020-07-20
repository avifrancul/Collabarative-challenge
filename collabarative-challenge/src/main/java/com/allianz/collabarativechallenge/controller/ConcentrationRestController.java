package com.allianz.collabarativechallenge.controller;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.allianz.collabarativechallenge.dto.ConcentrationDTO;
import com.allianz.collabarativechallenge.entity.City;
import com.allianz.collabarativechallenge.entity.Concentration;
import com.allianz.collabarativechallenge.entity.District;
import com.allianz.collabarativechallenge.exception.RecordNotFoundException;
import com.allianz.collabarativechallenge.service.ConcentrationService;
import com.allianz.collabarativechallenge.service.DistrictService;

@RestController
public class ConcentrationRestController {

	@Autowired
	private ConcentrationService concentrationService;
	
	@Autowired
	private DistrictService districtService;
	
	@GetMapping("/concentration/{concentrationId}")
	public Optional<Concentration> getConcentration(@PathVariable(name="concentrationId") Long concentrationId){
		Optional<Concentration> concentration = concentrationService.getConcentration(concentrationId);
		if (!concentration.isPresent())
			throw new RecordNotFoundException("id-"+concentrationId);
		return concentration;
	}
	
	@PostMapping("/concentration/{districtId}")
	public ResponseEntity<Object> saveCity(@PathVariable(name="districtId") String districtId,@Valid @RequestBody ConcentrationDTO concentrationDTO){
		ModelMapper modelMapper = new ModelMapper();
		Concentration concentration = modelMapper.map(concentrationDTO, Concentration.class);
		Optional<District> district = districtService.getDistrict(districtId);
		if (!district.isPresent())
			throw new RecordNotFoundException("id-"+districtId);			
		concentration.setDistrict(district.get());
		concentrationService.saveConcentration(concentration);
		URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(concentration.getId()).toUri();
	    return ResponseEntity.created(location).build();

	}
	
	@GetMapping("/district/{districtId}/concentractions")
	public List<Concentration> getAllConcentrationsByDistrictId(@PathVariable(name="districtId") String districtId){
		Optional<District> district = districtService.getDistrict(districtId);
		if (!district.isPresent())
			throw new RecordNotFoundException("id-"+districtId);	
		return concentrationService.retrieveConcentrationByDistrictId(districtId);
	}
	
	@GetMapping("/district/{districtId}/concentractionsdates/{startDate}/{endDate}")
	public List<Concentration> getAllConcentrationsByDistrictIdAndDate(@PathVariable(name="districtId") String districtId, 
			@PathVariable(name="startDate") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") LocalDate startDate,  
			@PathVariable(name="endDate")  @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") LocalDate endDate){
		
		Optional<District> district = districtService.getDistrict(districtId);
		if (!district.isPresent())
			throw new RecordNotFoundException("id-"+districtId);
		
		return concentrationService.findByDistrictIdAndEndDateBetween(districtId, startDate, endDate);
	}
	
	@DeleteMapping("/concentration/{concentrationId}")
	public void deleteConcentration(@PathVariable(name="concentrationId") Long concentrationId) {
		Optional<Concentration> concentration = concentrationService.getConcentration(concentrationId);
		if (!concentration.isPresent())
			throw new RecordNotFoundException("id-"+concentrationId);		
		concentrationService.deleteConcentration(concentrationId);
	}
	
	@PutMapping("/concentration/{concentrationId}")
	public void updateConcentration(@Valid @RequestBody ConcentrationDTO concentrationDTO, @PathVariable(name="concentrationId") Long concentrationId) {
		Optional<Concentration> concentrate = concentrationService.getConcentration(concentrationId);
		if (!concentrate.isPresent())
			throw new RecordNotFoundException("id-"+concentrationId);	
		ModelMapper modelMapper = new ModelMapper();
		Concentration concentration = modelMapper.map(concentrationDTO, Concentration.class);
		concentrationService.saveConcentration(concentration);
	}
	
	
}
