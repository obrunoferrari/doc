package com.bed.doc.rest.response;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("profissional")
	private Long professionalId;

	@JsonProperty("token")
	private String token;

	public final Long getProfessionalId() {
		return professionalId;
	}

	public LoginResponse withProfessionalId(final Long professionalId) {
		this.professionalId = professionalId;
		return this;
	}

	public final void setProfessionalId(final Long professionalId) {
		this.professionalId = professionalId;
	}

	public String getToken() {
		return token;
	}

	public LoginResponse withToken(final String token) {
		this.token = token;
		return this;
	}

	public void setToken(final String token) {
		this.token = token;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LoginResponse that = (LoginResponse) o;
		return Objects.equals(professionalId, that.professionalId) && Objects.equals(token, that.token);
	}

	@Override
	public int hashCode() {
		return Objects.hash(professionalId, token);
	}

	@Override
	public String toString() {
		return "LoginResponse [professionalId=" + professionalId + ", token=" + token + "]";
	}
}