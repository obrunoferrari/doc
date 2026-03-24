package com.bed.doc.rest.response;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExpertiseResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("nome")
	private String name;
	
	public Long getId() {
		return id;
	}
	
	public ExpertiseResponse withId(final Long id) {
		this.id = id;
		return this;
	}
	
	public void setId(final Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public ExpertiseResponse withName(final String name) {
		this.name = name;
		return this;
	}
	
	public void setName(final String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		ExpertiseResponse other = (ExpertiseResponse) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}
	
	@Override
	public String toString() {
		return "ExpertiseResponse [id=" + id + ", name=" + name + "]";
	}
	
}