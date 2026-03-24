package com.bed.doc.rest.request;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;

public class ProfessionalRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "id")
	private Long id;

	@JsonProperty(value = "especialidade")
	private Long expertiseId;

	@JsonProperty(value = "localidade")
	private Long locationId;

	@Column(name = "nome", nullable = false)
	private String name;

	public final Long getId() {
		return id;
	}

	public ProfessionalRequest withId(final Long id) {
		this.id = id;
		return this;
	}

	public final void setId(final Long id) {
		this.id = id;
	}

	public final Long getExpertiseId() {
		return expertiseId;
	}

	public ProfessionalRequest withExpertiseId(final Long expertiseId) {
		this.expertiseId = expertiseId;
		return this;
	}

	public final void setExpertiseId(final Long expertiseId) {
		this.expertiseId = expertiseId;
	}

	public final Long getLocationId() {
		return locationId;
	}

	public ProfessionalRequest withLocationId(final Long locationId) {
		this.locationId = locationId;
		return this;
	}

	public final void setLocationId(final Long locationId) {
		this.locationId = locationId;
	}

	public final String getName() {
		return name;
	}

	public ProfessionalRequest withName(final String name) {
		this.name = name;
		return this;
	}

	public final void setName(final String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, expertiseId, locationId, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProfessionalRequest other = (ProfessionalRequest) obj;
		return Objects.equals(id, other.id)
				&& Objects.equals(expertiseId, other.expertiseId)
				&& Objects.equals(locationId, other.locationId)
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "ProfessionalRequest [id=" + id + ", expertiseId=" + expertiseId + ", locationId=" + locationId
				+ ", name=" + name + "]";
	}
}
