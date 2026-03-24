package com.bed.doc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bed.doc.domain.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

	List<Location> findByProvince(final String province);

}
