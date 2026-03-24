package com.bed.doc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bed.doc.domain.Media;
import com.bed.doc.domain.MediaType;
import com.bed.doc.domain.Patient;
import com.bed.doc.domain.Professional;

@Repository
public interface MediaRepository extends JpaRepository<Media, Long> {

	List<Media> findByProfessionalId(final Long professionalId);
	
	List<Media> findByProfessionalIdAndPatientId(final Long professionalId, final Long patientId);

	List<Media> findByProfessionalAndPatientAndMediaType(final Professional professional, final Patient patient,
			final MediaType mediaType);

}
