package com.allianz.collabarativechallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.allianz.collabarativechallenge.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, String> {

}
