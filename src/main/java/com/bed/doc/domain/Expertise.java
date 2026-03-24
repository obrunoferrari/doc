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
@Table(schema = "public", name = "especialidade")
public class Expertise implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "especialidade_id_especialidade_seq")
	@SequenceGenerator(name = "especialidade_id_especialidade_seq", sequenceName = "especialidade_id_especialidade_seq", allocationSize = 1)
	@Column(name = "id_especialidade", nullable = false)
	private Long id;

	@Column(name = "nome", nullable = false)
	private String name;

	public Long getId() {
		return id;
	}

	public Expertise withId(final Long id) {
		this.id = id;
		return this;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public Expertise withName(final String name) {
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
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Expertise other = (Expertise) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Expertise [id=" + id + ", name=" + name + "]";
	}

}
