package com.bed.doc.validator;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.bed.doc.rest.request.MediaRequest;

@Component
public class MediaValidator {

	public void validate(final MediaRequest request) {
		
		if (request == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Requisição inválida (objeto nulo).");
		}
		
		if (request.getProfessionalId() == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O campo 'id_profissional' é obrigatório.");
		}
		
		if (request.getPatientId() == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O campo 'id_paciente' é obrigatório.");
		}
		
		if (request.getMediaType() == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O campo 'tipo' é obrigatório.");
		}
		
	}
}