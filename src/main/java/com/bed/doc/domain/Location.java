package com.bed.doc.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(schema = "public", name = "localidade")
public class Location implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "localidade_id_localidade_seq")
	@SequenceGenerator(name = "localidade_id_localidade_seq", sequenceName = "localidade_id_localidade_seq", allocationSize = 1)
	@Column(name = "id_localidade", nullable = false)
	private Long id;

	@Column(name = "cidade", nullable = false)
	private String city;

	@Column(name = "estado", nullable = false)
	private String province;

	public Long getId() {
		return id;
	}

	public Location withId(final Long id) {
		this.id = id;
		return this;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public Location withCity(final String city) {
		this.city = city;
		return this;
	}

	public void setCity(final String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public Location withProvince(final String province) {
		this.province = province;
		return this;
	}

	public void setProvince(final String province) {
		this.province = province;
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, id, province);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		return Objects.equals(city, other.city) && Objects.equals(id, other.id)
				&& Objects.equals(province, other.province);
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", city=" + city + ", province=" + province + "]";
	}

}