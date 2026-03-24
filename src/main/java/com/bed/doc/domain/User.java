package com.bed.doc.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(schema = "public", name = "usuario")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_id_usuario_seq")
	@SequenceGenerator(name = "usuario_id_usuario_seq", sequenceName = "usuario_id_usuario_seq", allocationSize = 1)
	@Column(name = "id_usuario", nullable = false)
	private Long id;

	@OneToOne
	@JoinColumn(name = "id_profissional", nullable = false)
	private Professional professional;

	@Column(name = "usuario", nullable = false)
	private String username;

	@Column(name = "senha", nullable = false)
	private String password;

	public Long getId() {
		return id;
	}

	public User withId(final Long id) {
		this.id = id;
		return this;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public Professional getProfessional() {
		return professional;
	}

	public User withProfessional(final Professional professional) {
		this.professional = professional;
		return this;
	}

	public void setProfessional(final Professional professional) {
		this.professional = professional;
	}

	public String getUsername() {
		return username;
	}

	public User withUsername(final String username) {
		this.username = username;
		return this;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public User withPassword(final String password) {
		this.password = password;
		return this;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, password, professional, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id) && Objects.equals(password, other.password)
				&& Objects.equals(professional, other.professional) && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", professional=" + professional + ", username=" + username + ", password=" + password
				+ "]";
	}

}
