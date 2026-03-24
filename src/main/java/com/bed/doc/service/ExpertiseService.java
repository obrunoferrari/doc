package com.bed.doc.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bed.doc.domain.Expertise;
import com.bed.doc.repository.ExpertiseRepository;
import com.bed.doc.rest.response.ExpertiseResponse;

@Service
public class ExpertiseService {

	@Autowired
	private ExpertiseRepository repository;

	/**
	 * Retorna a lista de espcialidades cadastradas.
	 * 
	 * @return
	 */
	public List<ExpertiseResponse> getExpertiseList() {

		final List<Expertise> expertises = repository.findAll();

		final List<ExpertiseResponse> expertiseList = expertises.stream().map(e -> {
			return new ExpertiseResponse().withId(e.getId()).withName(e.getName());
		}).collect(Collectors.toList());

		return expertiseList;

	}

}
