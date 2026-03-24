package com.bed.doc.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.bed.doc.domain.Gender;
import com.bed.doc.domain.Location;
import com.bed.doc.domain.Patient;
import com.bed.doc.repository.LocationRepository;
import com.bed.doc.repository.PatientRepository;
import com.bed.doc.rest.request.PatientRequest;
import com.bed.doc.rest.response.LocationResponse;
import com.bed.doc.rest.response.PatientResponse;

@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private LocationRepository locationRepository;

	/**
	 * Cria um novo paciente. A data de cadastro (onboardDate) é preenchida
	 * automaticamente com a data atual.
	 *
	 * @param request objeto com os dados do paciente
	 * @return paciente criado
	 * @throws ResponseStatusException se a localização não for encontrada
	 */
	public Patient create(PatientRequest request) {

		Location location = locationRepository.findById(request.getLocationId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						"Localidade não encontrada com id " + request.getLocationId()));

		Patient patient = new Patient();
		patient.setName(request.getName());
		patient.setLocation(location);
		patient.setBirthDate(request.getBirthDate());
		patient.setOnboardDate(LocalDate.now());
		patient.setGender(Gender.values()[request.getGender()]);

		return patientRepository.save(patient);

	}

	/**
	 * Atualiza um paciente existente. Não altera a data de cadastro.
	 *
	 * @param request objeto com os dados atualizados do paciente
	 * @return paciente atualizado
	 * @throws ResponseStatusException se o paciente ou a localização não forem
	 *                                 encontrados
	 */
	public Patient update(PatientRequest request) {

		Patient patient = patientRepository.findById(request.getId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						"Paciente não encontrado com id " + request.getId()));

		Location location = locationRepository.findById(request.getLocationId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						"Localidade não encontrada com id " + request.getLocationId()));

		patient.setName(request.getName());
		patient.setLocation(location);
		patient.setBirthDate(request.getBirthDate());
		patient.setGender(Gender.values()[request.getGender()]);

		return patientRepository.save(patient);

	}

	/**
	 * Remove um paciente existente.
	 *
	 * @param id identificador do paciente
	 * @throws ResponseStatusException se o paciente não for encontrado
	 */
	public void delete(Long id) {

		Patient patient = patientRepository.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado com id " + id));

		patientRepository.delete(patient);

	}

	/**
	 * Busca um paciente pelo ID.
	 *
	 * @param id identificador do paciente
	 * @return paciente encontrado
	 * @throws ResponseStatusException se o paciente não for encontrado
	 */
	public PatientResponse findById(Long id) {
		Patient patient = patientRepository.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado com id " + id));

		LocationResponse locationResponse = null;
		if (patient.getLocation() != null) {
			locationResponse = new LocationResponse().withId(patient.getLocation().getId())
					.withCity(patient.getLocation().getCity()).withProvince(patient.getLocation().getProvince());
		}

		return new PatientResponse().withId(patient.getId()).withLocation(locationResponse).withName(patient.getName())
				.withBirthDate(patient.getBirthDate()).withOnboardDate(patient.getOnboardDate())
				.withGender(patient.getGender() != null ? patient.getGender().ordinal() : null);

	}
}
