package com.bed.doc.rest.request;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MediaRequest implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("id_profissional")
	private Long professionalId;
	
	@JsonProperty("id_paciente")
	private Long patientId;
	
	@JsonProperty("tipo")
	private Integer mediaType;
	
	public Long getProfessionalId() {
		return professionalId;
	}
	
	public MediaRequest withProfessionalId(final Long professionalId) {
		this.professionalId = professionalId;
		return this;
	}
	
	public void setProfessionalId(final Long professionalId) {
		this.professionalId = professionalId;
	}
	
	public Long getPatientId() {
		return patientId;
	}
	
	public MediaRequest withPatientId(final Long patientId) {
		this.patientId = patientId;
		return this;
	}
	
	public void setPatientId(final Long patientId) {
		this.patientId = patientId;
	}
	
	public Integer getMediaType() {
		return mediaType;
	}
	
	public MediaRequest withMediaType(final Integer mediaType) {
		this.mediaType = mediaType;
		return this;
	}
	
	public void setMediaType(final Integer mediaType) {
		this.mediaType = mediaType;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(professionalId, patientId, mediaType);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		MediaRequest other = (MediaRequest) obj;
		return Objects.equals(professionalId, other.professionalId)
				&& Objects.equals(patientId, other.patientId) 
				&& Objects.equals(mediaType, other.mediaType);
	}
	
}