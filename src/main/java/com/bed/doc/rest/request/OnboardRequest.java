package com.bed.doc.rest.request;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OnboardRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "nome")
	private String name;

	@JsonProperty(value = "localidade")
	private Integer locationId;

	@JsonProperty(value = "especialidade")
	private Integer expertiseId;

	@JsonProperty(value = "usuario")
	private String username;

	@JsonProperty(value = "senha")
	private String password;

	public final String getName() {
		return name;
	}

	public OnboardRequest withName(final String name) {
		this.name = name;
		return this;
	}

	public final void setName(final String name) {
		this.name = name;
	}

	public final Integer getLocationId() {
		return locationId;
	}

	public OnboardRequest withLocationId(final Integer locationId) {
		this.locationId = locationId;
		return this;
	}

	public final void setLocationId(final Integer locationId) {
		this.locationId = locationId;
	}

	public final Integer getExpertiseId() {
		return expertiseId;
	}

	public OnboardRequest withExpertiseId(final Integer expertiseId) {
		this.expertiseId = expertiseId;
		return this;
	}

	public final void setExpertiseId(final Integer expertiseId) {
		this.expertiseId = expertiseId;
	}

	public final String getUsername() {
		return username;
	}

	public OnboardRequest withUsername(final String username) {
		this.username = username;
		return this;
	}

	public final void setUsername(final String username) {
		this.username = username;
	}

	public final String getPassword() {
		return password;
	}

	public OnboardRequest withPassword(final String password) {
		this.password = password;
		return this;
	}

	public final void setPassword(final String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(expertiseId, locationId, name, password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OnboardRequest other = (OnboardRequest) obj;
		return Objects.equals(expertiseId, other.expertiseId) && Objects.equals(locationId, other.locationId)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "OnboardRequest [name=" + name + ", locationId=" + locationId + ", expertiseId=" + expertiseId
				+ ", username=" + username + ", password=" + password + "]";
	}

}
