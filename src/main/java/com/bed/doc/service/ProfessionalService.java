package com.bed.doc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.bed.doc.domain.Expertise;
import com.bed.doc.domain.Location;
import com.bed.doc.domain.Professional;
import com.bed.doc.repository.ExpertiseRepository;
import com.bed.doc.repository.LocationRepository;
import com.bed.doc.repository.ProfessionalRepository;
import com.bed.doc.rest.request.ProfessionalRequest;

@Service
public class ProfessionalService {

	@Autowired
	private ProfessionalRepository repository;

	@Autowired
	private LocationRepository locationRepository;

	@Autowired
	private ExpertiseRepository expertiseRepository;

	public void update(final ProfessionalRequest request) {

		final Professional professional = repository.findById(request.getId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						"Profissional não encontrado com id " + request.getId()));

		final Expertise expertise = expertiseRepository.findById(request.getExpertiseId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						"Especialidade não encontrada com id " + request.getExpertiseId()));

		final Location location = locationRepository.findById(request.getLocationId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						"Localidade não encontrada com id " + request.getLocationId()));

		professional.setLocation(location);
		professional.setExpertise(expertise);
		professional.setName(request.getName());

		this.repository.save(professional);

	}

}
