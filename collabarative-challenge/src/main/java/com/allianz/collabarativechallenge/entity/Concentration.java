package com.allianz.collabarativechallenge.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Concentration {
	@Id
    private Long id;
	@NotNull
	private Double reading;
	@NotNull
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date entryDate; 
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="DISTRICT_ID", nullable = false)
	@OnDelete(action=OnDeleteAction.CASCADE)
	@JsonIgnore
	private District district;
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
	public District getDistrict() {
		return district;
	}
	public void setDistrict(District district) {
		this.district = district;
	}
	@Override
	public String toString() {
		return "Concentration [id=" + id + ", reading=" + reading + ", entryDate=" + entryDate + ", district="
				+ district + "]";
	}

}
