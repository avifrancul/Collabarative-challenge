package com.allianz.collabarativechallenge.city;

import javax.validation.constraints.Size;
import java.util.Date;

public class City {

    private Integer id;
    @Size(min=2, message = "city Name should have atleast 4 characters")
    private String cityName;
    private Date entryDate;

    public City(Integer id, String cityName, Date entryDate) {
        this.id = id;
        this.cityName = cityName;
        this.entryDate = entryDate;
    }



    public Integer getId() {
        return id;
    }

    public String getCityName() {
        return cityName;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    @Override
    public String toString() {
        return "City{" +
                "id='" + id + '\'' +
                ", cityName='" + cityName + '\'' +
                ", entryDate=" + entryDate +
                '}';
    }
}
