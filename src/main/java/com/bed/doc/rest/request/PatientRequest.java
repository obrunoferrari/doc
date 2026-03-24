package com.bed.doc.rest.request;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PatientRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	private Long id;

	@JsonProperty("localidade")
	private Long locationId;

	@JsonProperty("nome")
	private String name;

	@JsonProperty("data_nascimento")
	private LocalDate birthDate;

	@JsonProperty("genero")
	private Integer gender;

	public Long getId() {
		return id;
	}

	public PatientRequest withId(final Long id) {
		this.id = id;
		return this;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public Long getLocationId() {
		return locationId;
	}

	public PatientRequest withLocationId(final Long locationId) {
		this.locationId = locationId;
		return this;
	}

	public void setLocationId(final Long locationId) {
		this.locationId = locationId;
	}

	public String getName() {
		return name;
	}

	public PatientRequest withName(final String name) {
		this.name = name;
		return this;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public PatientRequest withBirthDate(final LocalDate birthDate) {
		this.birthDate = birthDate;
		return this;
	}

	public void setBirthDate(final LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Integer getGender() {
		return gender;
	}

	public PatientRequest withGender(final Integer gender) {
		this.gender = gender;
		return this;
	}

	public void setGender(final Integer gender) {
		this.gender = gender;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, locationId, name, birthDate, gender);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		PatientRequest other = (PatientRequest) obj;
		return Objects.equals(id, other.id) && Objects.equals(locationId, other.locationId)
				&& Objects.equals(name, other.name) && Objects.equals(birthDate, other.birthDate)
				&& Objects.equals(gender, other.gender);
	}

	@Override
	public String toString() {
		return "PatientRequest [id=" + id + ", locationId=" + locationId + ", name=" + name + ", birthDate=" + birthDate
				+ ", gender=" + gender + "]";
	}
	
	
	
}
