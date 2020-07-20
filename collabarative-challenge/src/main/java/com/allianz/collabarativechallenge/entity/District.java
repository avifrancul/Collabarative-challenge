package com.allianz.collabarativechallenge.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class District {
	@Id
	String id;
	@NotNull
	@Size(min=2, message = "district Name should have atleast 4 characters")
	String districtName;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="CITY_ID", nullable = false)
	@OnDelete(action=OnDeleteAction.CASCADE)
	@JsonIgnore
	private City city;
	
	@OneToMany(mappedBy ="district", cascade={CascadeType.ALL})
	private List<Concentration> concentration;

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

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<Concentration> getConcentration() {
		return concentration;
	}

	public void setConcentration(List<Concentration> concentration) {
		this.concentration = concentration;
	}

	@Override
	public String toString() {
		return "District [id=" + id + ", districtName=" + districtName + ", city=" + city + ", concentration="
				+ concentration + "]";
	}

}
