package com.bed.doc.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bed.doc.rest.response.LocationResponse;
import com.bed.doc.service.LocationService;

@RestController
@RequestMapping("/localidade")
public class LocationController {

	@Autowired
	private LocationService service;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<LocationResponse> getLocationList() {
		return service.getLocationList();
	}
	
}
