package com.allianz.collabarativechallenge.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.allianz.collabarativechallenge.entity.Concentration;

@Repository
public interface ConcentrationRepository extends JpaRepository<Concentration, Long> {

	List<Concentration> findByDistrictId(String districtId);
	List<Concentration> findByDistrictIdAndEntryDateBetween(String districtId, Date startDate, Date endDate);
}
