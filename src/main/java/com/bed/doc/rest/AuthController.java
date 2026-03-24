package com.bed.doc.rest;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bed.doc.domain.User;
import com.bed.doc.rest.request.LoginRequest;
import com.bed.doc.rest.response.LoginResponse;
import com.bed.doc.security.JwtUtil;
import com.bed.doc.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	@ResponseStatus(HttpStatus.OK)
	public LoginResponse login(@RequestBody LoginRequest request) {

		final User user = userService.authenticate(request.getUsername(), request.getPassword());

		if (!Objects.isNull(user)) {
			final String token = jwtUtil.generateToken(request.getUsername());
			return new LoginResponse().withProfessionalId(user.getProfessional().getId()).withToken(token);
		} else {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciais inválidas.");
		}
		
	}

}
