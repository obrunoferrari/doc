package com.bed.doc.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.bed.doc.domain.Expertise;
import com.bed.doc.domain.Location;
import com.bed.doc.domain.Professional;
import com.bed.doc.domain.User;
import com.bed.doc.repository.ExpertiseRepository;
import com.bed.doc.repository.LocationRepository;
import com.bed.doc.repository.ProfessionalRepository;
import com.bed.doc.repository.UserRepository;
import com.bed.doc.rest.request.OnboardRequest;

@Service
public class OnboardService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private LocationRepository locationRepository;

	@Autowired
	private ExpertiseRepository expertiseRepository;

	@Autowired
	private ProfessionalRepository professionalRepository;

	/**
	 * Executa o processo completo de "onboarding" na plataforma.
	 * 
	 * @param request
	 */
	public void submit(final OnboardRequest request) {

		final Location location = locationRepository.findById(request.getLocationId().longValue())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						"Location não encontrada com id " + request.getLocationId()));

		final Expertise expertise = expertiseRepository.findById(request.getExpertiseId().longValue())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						"Expertise não encontrada com id " + request.getExpertiseId()));

		final Professional professional = new Professional().withExpertise(expertise).withLocation(location)
				.withName(request.getName()).withOnboardDate(LocalDate.now());

		professionalRepository.save(professional);

		final User user = new User().withProfessional(professional).withUsername(request.getUsername())
				.withPassword(request.getPassword());

		userRepository.save(user);

	}

}
