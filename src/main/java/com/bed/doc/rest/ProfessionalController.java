package com.bed.doc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bed.doc.rest.request.ProfessionalRequest;
import com.bed.doc.service.ProfessionalService;
import com.bed.doc.validator.ProfessionalValidator;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/profissional")
@SecurityRequirement(name = "bearerAuth")
public class ProfessionalController {

	@Autowired
	private ProfessionalService service;
	
	@Autowired
	private ProfessionalValidator validator;
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody final ProfessionalRequest request) {
		validator.validate(request);
		service.update(request);
	}
	
}
