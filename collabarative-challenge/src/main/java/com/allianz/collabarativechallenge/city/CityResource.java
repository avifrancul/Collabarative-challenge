package com.allianz.collabarativechallenge.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.allianz.collabarativechallenge.exception.CityNotFoundException;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class CityResource {

    //retrieveAllCities

    //retrieveCity
    @Autowired
    private CityDaoService service;

    @GetMapping("/cities")
    public List<City> retrieveAllCities(){
        return service.findAll();
    }
    @GetMapping("/cities/{id}")
    public City retrieveCity(@PathVariable int id){
      City city=service.findOne(id);
      if (city==null)
          throw new CityNotFoundException("id-"+id);
      return city;
    }

    //request- details of the user
    //response - Created & Returned the created URI
    @PostMapping("/cities")
    public  ResponseEntity<Object> createCity(@Valid @RequestBody City city){
     City savedCity =  service.save(city);
      URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedCity.getId()).toUri();
        return ResponseEntity.created(location).build();


    }


    @DeleteMapping("/cities/{id}")
    public void deleteCity(@PathVariable int id){
        City city=service.deleteById(id);
        if (city==null)
            throw new CityNotFoundException("id-"+id);

    }









}
