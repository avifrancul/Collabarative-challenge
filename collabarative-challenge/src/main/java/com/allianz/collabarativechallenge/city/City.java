package com.allianz.collabarativechallenge.city;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@ApiModel(description = "All details about the City")
@Entity
public class City {
    @Id
    @GeneratedValue
    private Integer id;
    @Size(min=2, message = "city Name should have atleast 4 characters")
    @ApiModelProperty(notes = "city Name should have atleast 4 characters")
    private String cityName;
    @ApiModelProperty(notes = "entry date should be in the past")
    private Date entryDate;

    @OneToMany(mappedBy="city")
    private List<District> districts;

    public City(Integer id, String cityName, Date entryDate) {
        this.id = id;
        this.cityName = cityName;
        this.entryDate = entryDate;
    }

    public City() {
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

    public List<District> getDistricts() {
        return districts;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
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
