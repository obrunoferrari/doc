package com.bed.doc.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(schema = "public", name = "paciente")
public class Patient implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paciente_id_paciente_seq")
	@SequenceGenerator(name = "paciente_id_paciente_seq", sequenceName = "paciente_id_paciente_seq", allocationSize = 1)
	@Column(name = "id_paciente", nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_localidade", nullable = false)
	private Location location;

	@Column(name = "nome", nullable = false)
	private String name;

	@Column(name = "data_nascimento", nullable = true)
	private LocalDate birthDate;

	@Column(name = "data_cadastro", nullable = false)
	private LocalDate onboardDate;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "genero", nullable = false)
	private Gender gender;

	public Long getId() {
		return id;
	}
	
	public Patient withId(final Long id) {
		this.id = id;
		return this;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public Location getLocation() {
		return location;
	}
	
	public Patient withLocation(final Location location) {
		this.location = location;
		return this;
	}

	public void setLocation(final Location location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}
	
	public Patient withName(final String name) {
		this.name = name;
		return this;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}
	
	public Patient withBirthDate(final LocalDate birthDate) {
		this.birthDate = birthDate;
		return this;
	}

	public void setBirthDate(final LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public LocalDate getOnboardDate() {
		return onboardDate;
	}
	
	public Patient withOnboardDate(final LocalDate onboardDate) {
		this.onboardDate = onboardDate;
		return this;
	}

	public void setOnboardDate(final LocalDate onboardDate) {
		this.onboardDate = onboardDate;
	}

	public Gender getGender() {
		return gender;
	}
	
	public Patient withGender(final Gender gender) {
		this.gender = gender;
		return this;
	}

	public void setGender(final Gender gender) {
		this.gender = gender;
	}

	@Override
	public int hashCode() {
		return Objects.hash(birthDate, gender, id, location, name, onboardDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		return Objects.equals(birthDate, other.birthDate) && gender == other.gender && Objects.equals(id, other.id)
				&& Objects.equals(location, other.location) && Objects.equals(name, other.name)
				&& Objects.equals(onboardDate, other.onboardDate);
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", location=" + location + ", name=" + name + ", birthDate=" + birthDate
				+ ", onboardDate=" + onboardDate + ", gender=" + gender + "]";
	}

}
