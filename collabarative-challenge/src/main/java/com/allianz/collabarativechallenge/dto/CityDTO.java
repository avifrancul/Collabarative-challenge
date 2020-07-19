package com.allianz.collabarativechallenge.dto;

import java.util.List;

import javax.validation.constraints.Size;


public class CityDTO {
	String id;
	@Size(min=2, message = "city Name should have atleast 4 characters")
	String cityName;

	private List<DistrictDTO> districts;

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

	public List<DistrictDTO> getDistricts() {
		return districts;
	}

	public void setDistricts(List<DistrictDTO> districts) {
		this.districts = districts;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", cityName=" + cityName + ", districts="
				+ districts + "]";
	}

	
}
