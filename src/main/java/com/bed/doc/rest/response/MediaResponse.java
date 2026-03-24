package com.bed.doc.rest.response;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MediaResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("profissional")
	private ProfessionalResponse professional;
	
	@JsonProperty("paciente")
	private PatientResponse patient;
	
	@JsonProperty("tipo")
	private Integer mediaType;
	
	@JsonProperty("data_inclusao")
	private LocalDate uploadDate;
	
	@JsonProperty("hora_inclusao")
	private LocalTime uploadTime;
	
	@JsonProperty("url")
	private String url;
	
	public Long getId() {
		return id;
	}
	
	public MediaResponse withId(final Long id) {
		this.id = id;
		return this;
	}
	
	public void setId(final Long id) {
		this.id = id;
	}
	
	public ProfessionalResponse getProfessional() {
		return professional;
	}
	
	public MediaResponse withProfessional(final ProfessionalResponse professional) {
		this.professional = professional;
		return this;
	}
	
	public void setProfessional(final ProfessionalResponse professional) {
		this.professional = professional;
	}
	
	public PatientResponse getPatient() {
		return patient;
	}
	
	public MediaResponse withPatient(final PatientResponse patient) {
		this.patient = patient;
		return this;
	}
	
	public void setPatient(final PatientResponse patient) {
		this.patient = patient;
	}
	
	public Integer getMediaType() {
		return mediaType;
	}
	
	public MediaResponse withMediaType(final Integer mediaType) {
		this.mediaType = mediaType;
		return this;
	}
	
	public void setMediaType(final Integer mediaType) {
		this.mediaType = mediaType;
	}
	
	public LocalDate getUploadDate() {
		return uploadDate;
	}
	
	public MediaResponse withUploadDate(final LocalDate uploadDate) {
		this.uploadDate = uploadDate;
		return this;
	}
	
	public void setUploadDate(final LocalDate uploadDate) {
		this.uploadDate = uploadDate;
	}
	
	public LocalTime getUploadTime() {
		return uploadTime;
	}
	
	public MediaResponse withUploadTime(final LocalTime uploadTime) {
		this.uploadTime = uploadTime;
		return this;
	}
	
	public void setUploadTime(final LocalTime uploadTime) {
		this.uploadTime = uploadTime;
	}
	
	public String getUrl() {
		return url;
	}
	
	public MediaResponse withUrl(final String url) {
		this.url = url;
		return this;
	}
	
	public void setUrl(final String url) {
		this.url = url;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, professional, patient, mediaType, uploadDate, uploadTime, url);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		MediaResponse other = (MediaResponse) obj;
		return Objects.equals(id, other.id) 
				&& Objects.equals(professional, other.professional)
				&& Objects.equals(patient, other.patient) 
				&& Objects.equals(mediaType, other.mediaType)
				&& Objects.equals(uploadDate, other.uploadDate) 
				&& Objects.equals(uploadTime, other.uploadTime)
				&& Objects.equals(url, other.url);
	}
	
	@Override
	public String toString() {
		return "MediaResponse [id=" + id + ", professional=" + professional + ", patient=" + patient 
				+ ", mediaType=" + mediaType + ", uploadDate=" + uploadDate + ", uploadTime=" + uploadTime 
				+ ", url=" + url + "]";
	}
	
}