package com.bed.doc.rest.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Objects;

public class LoginRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("username")
	private String username;

	@JsonProperty("password")
	private String password;

	public String getUsername() {
		return username;
	}

	public LoginRequest withUsername(final String username) {
		this.username = username;
		return this;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public LoginRequest withPassword(final String password) {
		this.password = password;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LoginRequest that = (LoginRequest) o;
		return Objects.equals(username, that.username) && Objects.equals(password, that.password);
	}

	@Override
	public int hashCode() {
		return Objects.hash(username, password);
	}

	@Override
	public String toString() {
		return "LoginRequest{" + "username='" + username + '\'' + ", password='[PROTECTED]'" + '}';
	}
}