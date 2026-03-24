package com.bed.doc.rest.response;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LocationResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("cidade")
	private String city;
	
	@JsonProperty("estado")
	private String province;
	
	public Long getId() {
		return id;
	}
	
	public LocationResponse withId(final Long id) {
		this.id = id;
		return this;
	}
	
	public void setId(final Long id) {
		this.id = id;
	}
	
	public String getCity() {
		return city;
	}
	
	public LocationResponse withCity(final String city) {
		this.city = city;
		return this;
	}
	
	public void setCity(final String city) {
		this.city = city;
	}
	
	public String getProvince() {
		return province;
	}
	
	public LocationResponse withProvince(final String province) {
		this.province = province;
		return this;
	}
	
	public void setProvince(final String province) {
		this.province = province;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, city, province);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		LocationResponse other = (LocationResponse) obj;
		return Objects.equals(id, other.id) 
				&& Objects.equals(city, other.city)
				&& Objects.equals(province, other.province);
	}
	
	@Override
	public String toString() {
		return "LocationResponse [id=" + id + ", city=" + city + ", province=" + province + "]";
	}
	
}