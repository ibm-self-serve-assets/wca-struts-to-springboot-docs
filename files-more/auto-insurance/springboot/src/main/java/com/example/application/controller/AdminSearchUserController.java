//Here is a sample Spring Boot REST Controller that implements the requirements:


package com.pks.insurance.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pks.insurance.domain.User;
import com.pks.insurance.service.UserManager;

@RestController
@RequestMapping("/api/users")
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserManager userManager;
	
	@GetMapping
	public ResponseEntity<Iterable<User>> getAllUsers() {
		return ResponseEntity.ok(userManager.getUsers());
	}
	
	@GetMapping("/{ssn}")
	public ResponseEntity<User> getUserBySsn(@PathVariable String ssn) {
		User user = userManager.getUser(ssn);
		if (user == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(user);
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@Valid User user) {
		User createdUser = userManager.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
	}
}


Note that this is just a sample and does not include all possible error handling or security considerations. You should always implement proper error handling and security measures when building production-grade applications.