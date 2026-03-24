package com.bed.doc.validator;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.bed.doc.rest.request.ProfessionalRequest;

@Component
public class ProfessionalValidator {

    public void validate(final ProfessionalRequest request) {
        
    	if (request == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Requisição inválida (objeto nulo).");
        }

        if (request.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O campo 'id' é obrigatório.");
        }

        if (request.getName() == null || request.getName().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O campo 'nome' é obrigatório.");
        }

        if (request.getExpertiseId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O campo 'especialidade' é obrigatório.");
        }

        if (request.getLocationId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O campo 'localidade' é obrigatório.");
        }
        
    }
    
}
