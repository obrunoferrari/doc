package com.bed.doc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bed.doc.domain.Location;
import com.bed.doc.domain.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

	List<Patient> findByLocation(final Location location);
	
	List<Patient> findByNameContainingIgnoreCase(final String name);
	
}
