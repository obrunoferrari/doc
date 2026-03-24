package com.bed.doc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bed.doc.domain.Professional;
import com.bed.doc.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsername(final String userName);

	Optional<User> findByProfessional(final Professional professional);
	
	Optional<User> findByUsernameAndPassword(final String username, final String password);

	boolean existsByUsernameAndPassword(final String username, final String password);

}
