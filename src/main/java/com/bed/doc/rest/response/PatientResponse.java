package com.bed.doc.rest.response;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PatientResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("localidade")
	private LocationResponse location;
	
	@JsonProperty("nome")
	private String name;
	
	@JsonProperty("data_nascimento")
	private LocalDate birthDate;
	
	@JsonProperty("data_cadastro")
	private LocalDate onboardDate;
	
	@JsonProperty("genero")
	private Integer gender;
	
	public Long getId() {
		return id;
	}
	
	public PatientResponse withId(final Long id) {
		this.id = id;
		return this;
	}
	
	public void setId(final Long id) {
		this.id = id;
	}
	
	public LocationResponse getLocation() {
		return location;
	}
	
	public PatientResponse withLocation(final LocationResponse location) {
		this.location = location;
		return this;
	}
	
	public void setLocation(final LocationResponse location) {
		this.location = location;
	}
	
	public String getName() {
		return name;
	}
	
	public PatientResponse withName(final String name) {
		this.name = name;
		return this;
	}
	
	public void setName(final String name) {
		this.name = name;
	}
	
	public LocalDate getBirthDate() {
		return birthDate;
	}
	
	public PatientResponse withBirthDate(final LocalDate birthDate) {
		this.birthDate = birthDate;
		return this;
	}
	
	public void setBirthDate(final LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	public LocalDate getOnboardDate() {
		return onboardDate;
	}
	
	public PatientResponse withOnboardDate(final LocalDate onboardDate) {
		this.onboardDate = onboardDate;
		return this;
	}
	
	public void setOnboardDate(final LocalDate onboardDate) {
		this.onboardDate = onboardDate;
	}
	
	public Integer getGender() {
		return gender;
	}
	
	public PatientResponse withGender(final Integer gender) {
		this.gender = gender;
		return this;
	}
	
	public void setGender(final Integer gender) {
		this.gender = gender;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, location, name, birthDate, onboardDate, gender);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		PatientResponse other = (PatientResponse) obj;
		return Objects.equals(id, other.id) 
				&& Objects.equals(location, other.location)
				&& Objects.equals(name, other.name) 
				&& Objects.equals(birthDate, other.birthDate)
				&& Objects.equals(onboardDate, other.onboardDate) 
				&& Objects.equals(gender, other.gender);
	}
	
	@Override
	public String toString() {
		return "PatientResponse [id=" + id + ", location=" + location + ", name=" + name 
				+ ", birthDate=" + birthDate + ", onboardDate=" + onboardDate + ", gender=" + gender + "]";
	}
	
}