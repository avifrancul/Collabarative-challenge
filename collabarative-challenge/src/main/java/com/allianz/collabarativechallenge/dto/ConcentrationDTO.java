package com.allianz.collabarativechallenge.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;


public class ConcentrationDTO {
	
	@NotNull
    private Long id;
	@NotNull
	private Double reading;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@NotNull
	private Date entryDate; 
	
	private DistrictDTO district;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getReading() {
		return reading;
	}
	public void setReading(Double reading) {
		this.reading = reading;
	}
	public Date getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	public DistrictDTO getDistrict() {
		return district;
	}
	public void setDistrict(DistrictDTO district) {
		this.district = district;
	}
	@Override
	public String toString() {
		return "Concentration [id=" + id + ", reading=" + reading + ", entryDate=" + entryDate + ", district="
				+ district + "]";
	}

}
