package com.bed.doc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bed.doc.domain.User;
import com.bed.doc.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	/**
	 * Valida a compatibilidade e a existência das credenciais.
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public User authenticate(final String username, final String password) {
		return repository.findByUsernameAndPassword(username, password).orElse(null);
	}

}
