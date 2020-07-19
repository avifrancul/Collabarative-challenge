package com.allianz.collabarativechallenge.dto;


import javax.validation.constraints.Size;



public class DistrictDTO {
	
	String id;
	@Size(min=2, message = "district Name should have atleast 4 characters")
	String districtName;	

	private CityDTO city;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public CityDTO getCity() {
		return city;
	}

	public void setCity(CityDTO city) {
		this.city = city;
	}

}
