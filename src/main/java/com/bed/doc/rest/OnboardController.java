package com.bed.doc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bed.doc.rest.request.OnboardRequest;
import com.bed.doc.service.OnboardService;
import com.bed.doc.validator.OnboardValidator;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/onboard")
@SecurityRequirement(name = "bearerAuth")
public class OnboardController {

	@Autowired
	private OnboardService service;
	
	@Autowired
	private OnboardValidator validator;
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void execute(@RequestBody final OnboardRequest request) {
		validator.validate(request);
		service.submit(request);
	}
	
}
