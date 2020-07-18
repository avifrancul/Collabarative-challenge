package com.allianz.collabarativechallenge.city;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class CityDaoService {

    private static List<City> cities = new ArrayList<>();

    private static int citiesCount =4;

    static {
        cities.add(new City(1,"Kerala",new Date()));
        cities.add(new City(2,"TamilNadu",new Date()));
        cities.add(new City(3,"Bihar",new Date()));
        cities.add(new City(4,"AndraPradesh",new Date()));
    }

    public List <City> findAll(){
    return cities;
    }

    public City save(City city){
        if (city.getId() == null) {
            city.setId(++citiesCount);
        }
        cities.add(city);
        return city;
    }


    public City findOne(int id) {
        for (City city : cities) {
            if (city.getId() == id) {
                return city;
            }
        }
        return null;
    }

    public City deleteById(int id) {
        Iterator<City> iterator = cities.iterator();
        while(iterator.hasNext()){
            City city = iterator.next();
            if (city.getId()== id){
                iterator.remove();
                return city;
            }
        }

        return null;
    }




}
