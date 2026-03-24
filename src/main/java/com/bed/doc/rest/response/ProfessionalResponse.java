package com.bed.doc.rest.response;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProfessionalResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	private Long id;

	@JsonProperty("especialidade")
	private ExpertiseResponse expertise;

	@JsonProperty("localidade")
	private LocationResponse location;

	@JsonProperty("nome")
	private String name;

	@JsonProperty("data_cadastro")
	private LocalDate onboardDate;

	public Long getId() {
		return id;
	}

	public ProfessionalResponse withId(final Long id) {
		this.id = id;
		return this;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public ExpertiseResponse getExpertise() {
		return expertise;
	}

	public ProfessionalResponse withExpertise(final ExpertiseResponse expertise) {
		this.expertise = expertise;
		return this;
	}

	public void setExpertise(final ExpertiseResponse expertise) {
		this.expertise = expertise;
	}

	public LocationResponse getLocation() {
		return location;
	}

	public ProfessionalResponse withLocation(final LocationResponse location) {
		this.location = location;
		return this;
	}

	public void setLocation(final LocationResponse location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public ProfessionalResponse withName(final String name) {
		this.name = name;
		return this;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public LocalDate getOnboardDate() {
		return onboardDate;
	}

	public ProfessionalResponse withOnboardDate(final LocalDate onboardDate) {
		this.onboardDate = onboardDate;
		return this;
	}

	public void setOnboardDate(final LocalDate onboardDate) {
		this.onboardDate = onboardDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, expertise, location, name, onboardDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		ProfessionalResponse other = (ProfessionalResponse) obj;
		return Objects.equals(id, other.id) && Objects.equals(expertise, other.expertise)
				&& Objects.equals(location, other.location) && Objects.equals(name, other.name)
				&& Objects.equals(onboardDate, other.onboardDate);
	}

	@Override
	public String toString() {
		return "ProfessionalResponse [id=" + id + ", expertise=" + expertise + ", location=" + location + ", name="
				+ name + ", onboardDate=" + onboardDate + "]";
	}

}