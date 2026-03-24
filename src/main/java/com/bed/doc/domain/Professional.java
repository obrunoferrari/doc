package com.bed.doc.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(schema = "public", name = "profissional")
public class Professional implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profissional_id_profissional_seq")
	@SequenceGenerator(name = "profissional_id_profissional_seq", sequenceName = "profissional_id_profissional_seq", allocationSize = 1)
	@Column(name = "id_profissional", nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_especialidade", nullable = false)
	private Expertise expertise;

	@ManyToOne
	@JoinColumn(name = "id_localidade", nullable = false)
	private Location location;

	@Column(name = "nome", nullable = false)
	private String name;

	@Column(name = "data_cadastro", nullable = false)
	private LocalDate onboardDate;

	public Long getId() {
		return id;
	}

	public Professional withId(final Long id) {
		this.id = id;
		return this;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public Expertise getExpertise() {
		return expertise;
	}

	public Professional withExpertise(final Expertise expertise) {
		this.expertise = expertise;
		return this;
	}

	public void setExpertise(final Expertise expertise) {
		this.expertise = expertise;
	}

	public Location getLocation() {
		return location;
	}

	public Professional withLocation(final Location location) {
		this.location = location;
		return this;
	}

	public void setLocation(final Location location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public Professional withName(final String name) {
		this.name = name;
		return this;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public LocalDate getOnboardDate() {
		return onboardDate;
	}

	public Professional withOnboardDate(final LocalDate onboardDate) {
		this.onboardDate = onboardDate;
		return this;
	}

	public void setOnboardDate(final LocalDate onboardDate) {
		this.onboardDate = onboardDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(expertise, id, location, name, onboardDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professional other = (Professional) obj;
		return Objects.equals(expertise, other.expertise) && Objects.equals(id, other.id)
				&& Objects.equals(location, other.location) && Objects.equals(name, other.name)
				&& Objects.equals(onboardDate, other.onboardDate);
	}

	@Override
	public String toString() {
		return "Professional [id=" + id + ", expertise=" + expertise + ", location=" + location + ", name=" + name
				+ ", onboardDate=" + onboardDate + "]";
	}

}
