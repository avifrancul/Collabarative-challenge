package com.allianz.collabarativechallenge.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class City {
	@Id
	String id;
	@Size(min=2, message = "city Name should have atleast 4 characters")
	String cityName;
	
	@OneToMany(mappedBy ="city", cascade={CascadeType.ALL})
	private List<District> districts;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public List<District> getDistricts() {
		return districts;
	}

	public void setDistricts(List<District> districts) {
		this.districts = districts;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", cityName=" + cityName + ", districts="
				+ districts + "]";
	}

	
}
