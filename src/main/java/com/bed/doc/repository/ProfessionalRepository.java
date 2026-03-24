package com.bed.doc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bed.doc.domain.Expertise;
import com.bed.doc.domain.Location;
import com.bed.doc.domain.Professional;

@Repository
public interface ProfessionalRepository extends JpaRepository<Professional, Long> {

	List<Professional> findByLocation(final Location location);
	
	List<Professional> findByExpertise(final Expertise expertise);
	
	List<Professional> findByNameContainingIgnoreCase(final String name);
	
}
