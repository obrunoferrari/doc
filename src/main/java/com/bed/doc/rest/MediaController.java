package com.bed.doc.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bed.doc.rest.request.MediaRequest;
import com.bed.doc.rest.response.MediaResponse;
import com.bed.doc.rest.response.PatientResponse;
import com.bed.doc.service.MediaService;
import com.bed.doc.validator.MediaValidator;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/media")
@SecurityRequirement(name = "bearerAuth")
public class MediaController {

	@Autowired
	private MediaService service;

	@Autowired
	private MediaValidator validator;

	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public MediaResponse create(@RequestPart("data") MediaRequest request, @RequestPart("file") MultipartFile file) {
		validator.validate(request);
		return service.create(request, file);
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public MediaResponse findById(@PathVariable Long id) {
		MediaResponse response = service.findById(id);
		return response;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<MediaResponse> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/professional/{professionalId}")
	@ResponseStatus(HttpStatus.OK)
	public List<PatientResponse> findMediaPatientsByProfessional(@PathVariable Long professionalId){
		return service.findMediaPatientsByProfessional(professionalId);
	}

	@GetMapping("/{professionalId}/{patientId}")
	@ResponseStatus(HttpStatus.OK)
	public List<MediaResponse> findByProfessionalAndPatient(@PathVariable Long professionalId,
			@PathVariable Long patientId) {
		return service.findByProfessionalAndPatient(professionalId, patientId);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}

}
