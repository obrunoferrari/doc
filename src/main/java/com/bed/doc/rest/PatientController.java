package com.bed.doc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bed.doc.domain.Patient;
import com.bed.doc.rest.request.PatientRequest;
import com.bed.doc.rest.response.PatientResponse;
import com.bed.doc.service.PatientService;
import com.bed.doc.validator.PatientValidator;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/paciente")
@SecurityRequirement(name = "bearerAuth")
public class PatientController {

    @Autowired
    private PatientService service;

    @Autowired
    private PatientValidator validator;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Patient create(@RequestBody PatientRequest request) {
        validator.validate(request);
        return service.create(request);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Patient update(@RequestBody PatientRequest request) {
        validator.validate(request);
        return service.update(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public PatientResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }
    
}