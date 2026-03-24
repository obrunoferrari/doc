package com.bed.doc.service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.bed.doc.domain.Media;
import com.bed.doc.domain.MediaType;
import com.bed.doc.domain.Patient;
import com.bed.doc.domain.Professional;
import com.bed.doc.repository.MediaRepository;
import com.bed.doc.repository.PatientRepository;
import com.bed.doc.repository.ProfessionalRepository;
import com.bed.doc.rest.request.MediaRequest;
import com.bed.doc.rest.response.ExpertiseResponse;
import com.bed.doc.rest.response.LocationResponse;
import com.bed.doc.rest.response.MediaResponse;
import com.bed.doc.rest.response.PatientResponse;
import com.bed.doc.rest.response.ProfessionalResponse;
import com.bed.doc.service.aws.S3Service;

@Service
public class MediaService {

	private final MediaRepository mediaRepository;
	private final PatientRepository patientRepository;
	private final ProfessionalRepository professionalRepository;
	private final S3Service s3Service;

	public MediaService(MediaRepository mediaRepository, PatientRepository patientRepository,
			ProfessionalRepository professionalRepository, S3Service s3Service) {
		this.mediaRepository = mediaRepository;
		this.patientRepository = patientRepository;
		this.professionalRepository = professionalRepository;
		this.s3Service = s3Service;
	}

	@Transactional
	public MediaResponse create(MediaRequest request, MultipartFile file) {
		
		try {
			Patient patient = patientRepository.findById(request.getPatientId())
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
							"Paciente não encontrado com id " + request.getPatientId()));

			Professional professional = professionalRepository.findById(request.getProfessionalId())
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
							"Profissional não encontrado com id " + request.getProfessionalId()));

			String fileUrl = s3Service.uploadFile(file);

			Media media = new Media();
			media.setPatient(patient);
			media.setProfessional(professional);
			media.setMediaType(MediaType.values()[request.getMediaType()]);
			media.setUploadDate(LocalDate.now());
			media.setUploadTime(LocalTime.now());
			media.setUrl(fileUrl);

			Media savedMedia = mediaRepository.save(media);

			return toMediaResponse(savedMedia);

		} catch (IOException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Erro ao fazer upload do arquivo: " + e.getMessage());
		}
		
	}

	public MediaResponse findById(Long id) {
		Media media = mediaRepository.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mídia não encontrada com id " + id));
		return toMediaResponse(media);
	}

	public List<MediaResponse> findAll() {
		return mediaRepository.findAll().stream().map(this::toMediaResponse).collect(Collectors.toList());
	}

	public List<MediaResponse> findByProfessionalAndPatient(final Long professionalId, final Long patientId) {
		return mediaRepository.findByProfessionalIdAndPatientId(professionalId, patientId).stream()
				.map(this::toMediaResponse).collect(Collectors.toList());
	}
	
	public List<PatientResponse> findMediaPatientsByProfessional(final Long professionalId) {
		return mediaRepository.findByProfessionalId(professionalId).stream()
	            .map(Media::getPatient)
	            .distinct()
	            .sorted(Comparator.comparing(Patient::getName))
	            .map(this::toPatientResponse)
	            .collect(Collectors.toList());
	}

	@Transactional
	public void delete(Long id) {
		Media media = mediaRepository.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mídia não encontrada com id " + id));

		try {
			s3Service.deleteFile(media.getUrl());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Erro ao deletar arquivo do S3: " + e.getMessage());
		}

		mediaRepository.delete(media);
	}

	private MediaResponse toMediaResponse(Media media) {
		LocationResponse patientLocation = null;
		if (media.getPatient().getLocation() != null) {
			patientLocation = new LocationResponse().withId(media.getPatient().getLocation().getId())
					.withCity(media.getPatient().getLocation().getCity())
					.withProvince(media.getPatient().getLocation().getProvince());
		}

		PatientResponse patientResponse = new PatientResponse().withId(media.getPatient().getId())
				.withLocation(patientLocation).withName(media.getPatient().getName())
				.withBirthDate(media.getPatient().getBirthDate()).withOnboardDate(media.getPatient().getOnboardDate())
				.withGender(media.getPatient().getGender() != null ? media.getPatient().getGender().ordinal() : null);

		ExpertiseResponse expertiseResponse = null;
		if (media.getProfessional().getExpertise() != null) {
			expertiseResponse = new ExpertiseResponse().withId(media.getProfessional().getExpertise().getId())
					.withName(media.getProfessional().getExpertise().getName());
		}

		LocationResponse professionalLocation = null;
		if (media.getProfessional().getLocation() != null) {
			professionalLocation = new LocationResponse().withId(media.getProfessional().getLocation().getId())
					.withCity(media.getProfessional().getLocation().getCity())
					.withProvince(media.getProfessional().getLocation().getProvince());
		}

		ProfessionalResponse professionalResponse = new ProfessionalResponse().withId(media.getProfessional().getId())
				.withExpertise(expertiseResponse).withLocation(professionalLocation)
				.withName(media.getProfessional().getName()).withOnboardDate(media.getProfessional().getOnboardDate());

		return new MediaResponse().withId(media.getId()).withProfessional(professionalResponse)
				.withPatient(patientResponse).withMediaType(media.getMediaType().ordinal())
				.withUploadDate(media.getUploadDate()).withUploadTime(media.getUploadTime()).withUrl(media.getUrl());
	}
	
	private PatientResponse toPatientResponse(final Patient patient) {
	    
		LocationResponse locationResponse = null;
	    
		if (patient.getLocation() != null) {
	        locationResponse = new LocationResponse()
	                .withId(patient.getLocation().getId())
	                .withCity(patient.getLocation().getCity())
	                .withProvince(patient.getLocation().getProvince());
	    }
	    
	    return new PatientResponse()
	            .withId(patient.getId())
	            .withLocation(locationResponse)
	            .withName(patient.getName())
	            .withBirthDate(patient.getBirthDate())
	            .withOnboardDate(patient.getOnboardDate())
	            .withGender(patient.getGender() != null ? patient.getGender().ordinal() : null);
	    
	}

}