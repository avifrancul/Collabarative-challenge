package com.allianz.collabarativechallenge.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.allianz.collabarativechallenge.entity.Concentration;

@Repository
public interface ConcentrationRepository extends JpaRepository<Concentration, Long> {

	List<Concentration> findByDistrictId(String districtId);
	
	@Query("select c from Concentration c where c.district.id=:dId and c.entryDate BETWEEN :start AND :end ")
	List<Concentration> findByDistrictIdAndEntryDateBetween(@Param("dId") String districtId, @Param("start") Date startDate,@Param("end") Date endDate);
	
}
