package com.bed.doc.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bed.doc.domain.Location;
import com.bed.doc.repository.LocationRepository;
import com.bed.doc.rest.response.LocationResponse;

@Service
public class LocationService {

	@Autowired
	private LocationRepository repository;

	/**
	 * Retorna a lista de especialidades cadastradas.
	 * 
	 * @return
	 */
	public List<LocationResponse> getLocationList() {

		final List<Location> locations = repository.findAll();

		final List<LocationResponse> locationList = locations.stream().map(l -> {
			return new LocationResponse().withId(l.getId()).withCity(l.getCity()).withProvince(l.getProvince());
		}).collect(Collectors.toList());

		return locationList;

	}

}
