package com.allianz.collabarativechallenge.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class CityJPAResource {

    @Autowired
    private CityDaoService service;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private DistrictRepository districtRepository;

    @GetMapping("/concapp/cities")
    public List<City> retrieveAllCities(){
        return cityRepository.findAll();
    }

    @GetMapping("/concapp/cities/{id}")
    public Optional<City> retrieconcappveCity(@PathVariable int id){
        Optional<City> city=cityRepository.findById(id);
        if (!city.isPresent())
            throw new CityNotFoundException("id-"+id);
        return city;
    }

    //request- details of the user
    //response - Created & Returned the created URI
    @PostMapping("/concapp/cities")
    public ResponseEntity<Object> createCity(@Valid @RequestBody City city){
        City savedCity =  cityRepository.save(city);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedCity.getId()).toUri();
        return ResponseEntity.created(location).build();


    }


    @DeleteMapping("/concapp/cities/{id}")
    public void deleteCity(@PathVariable int id){
        cityRepository.deleteById(id);


    }

    @GetMapping("/concapp/cities/{id}/districts")
    public List<District> retrieveAllDistricts(@PathVariable int id){
        Optional<City>cityOptional = cityRepository.findById(id);
        if (!cityOptional.isPresent())
            throw new CityNotFoundException("id-"+id);
        return cityOptional.get().getDistricts();

    }

    @PostMapping("/concapp/cities/{id}/districts")
    public ResponseEntity<Object> createDistrict(@PathVariable int id,@RequestBody District district){

        Optional<City>cityOptional = cityRepository.findById(id);
        if (!cityOptional.isPresent())
            throw new CityNotFoundException("id-"+id);


       City city = cityOptional.get();
       district.setCity(city);
       districtRepository.save(district);

        City savedCity =  cityRepository.save(city);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(district.getId()).toUri();
        return ResponseEntity.created(location).build();


    }





}
