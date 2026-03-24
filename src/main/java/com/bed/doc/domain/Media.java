package com.bed.doc.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
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
@Table(schema = "public", name = "midia")
public class Media implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "midia_id_midia_seq")
	@SequenceGenerator(name = "midia_id_midia_seq", sequenceName = "midia_id_midia_seq", allocationSize = 1)
	@Column(name = "id_midia", nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_profissional", nullable = false)
	private Professional professional;

	@ManyToOne
	@JoinColumn(name = "id_paciente", nullable = false)
	private Patient patient;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "tipo", nullable = false)
	private MediaType mediaType;

	@Column(name = "data_inclusao", nullable = false)
	private LocalDate uploadDate;

	@Column(name = "hora_inclusao", nullable = false)
	private LocalTime uploadTime;

	@Column(name = "url", nullable = false)
	private String url;

	public Long getId() {
		return id;
	}

	public Media withId(final Long id) {
		this.id = id;
		return this;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public Professional getProfessional() {
		return professional;
	}

	public Media withProfessional(final Professional professional) {
		this.professional = professional;
		return this;
	}

	public void setProfessional(final Professional professional) {
		this.professional = professional;
	}

	public Patient getPatient() {
		return patient;
	}

	public Media withPatient(final Patient patient) {
		this.patient = patient;
		return this;
	}

	public void setPatient(final Patient patient) {
		this.patient = patient;
	}

	public MediaType getMediaType() {
		return mediaType;
	}

	public Media withMediaType(final MediaType mediaType) {
		this.mediaType = mediaType;
		return this;
	}

	public void setMediaType(final MediaType mediaType) {
		this.mediaType = mediaType;
	}

	public LocalDate getUploadDate() {
		return uploadDate;
	}

	public Media withUploadDate(final LocalDate uploadDate) {
		this.uploadDate = uploadDate;
		return this;
	}

	public void setUploadDate(final LocalDate uploadDate) {
		this.uploadDate = uploadDate;
	}

	public LocalTime getUploadTime() {
		return uploadTime;
	}

	public Media withUploadTime(final LocalTime uploadTime) {
		this.uploadTime = uploadTime;
		return this;
	}

	public void setUploadTime(final LocalTime uploadTime) {
		this.uploadTime = uploadTime;
	}

	public String getUrl() {
		return url;
	}

	public Media withUrl(final String url) {
		this.url = url;
		return this;
	}

	public void setUrl(final String url) {
		this.url = url;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, mediaType, patient, professional, uploadDate, uploadTime, url);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Media other = (Media) obj;
		return Objects.equals(id, other.id) && mediaType == other.mediaType && Objects.equals(patient, other.patient)
				&& Objects.equals(professional, other.professional) && Objects.equals(uploadDate, other.uploadDate)
				&& Objects.equals(uploadTime, other.uploadTime) && Objects.equals(url, other.url);
	}

	@Override
	public String toString() {
		return "Media [id=" + id + ", professional=" + professional + ", patient=" + patient + ", mediaType="
				+ mediaType + ", uploadDate=" + uploadDate + ", uploadTime=" + uploadTime + ", url=" + url + "]";
	}

}
