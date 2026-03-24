package com.bed.doc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bed.doc.domain.Expertise;

@Repository
public interface ExpertiseRepository extends JpaRepository<Expertise, Long>{
	
}
