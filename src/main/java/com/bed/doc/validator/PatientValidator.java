package com.bed.doc.validator;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.bed.doc.rest.request.PatientRequest;

@Component
public class PatientValidator {

	public void validate(final PatientRequest request) {

		if (request == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Requisição inválida (objeto nulo).");
		}
		if (request.getLocationId() == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O campo 'localidade' é obrigatório.");
		}
		if (request.getName() == null || request.getName().trim().isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O campo 'nome' é obrigatório.");
		}
		if (request.getGender() == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O campo 'genero' é obrigatório.");
		}

	}

}
