package com.allianz.collabarativechallenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.allianz.collabarativechallenge.entity.District;

@Repository
public interface DistrictRepository extends JpaRepository<District, String> {

	List<District> findByCityId(String cityId);
}
