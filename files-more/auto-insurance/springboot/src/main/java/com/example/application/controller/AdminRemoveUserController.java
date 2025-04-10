//Here is a sample Spring Boot REST Controller that implements the requirements:


package com.pks.insurance.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/{ssn}")
	public ResponseEntity<User> getUser(@PathVariable String ssn) {
		User user = userManager.getUser(ssn);
		if (user == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(user);
	}
	
	@GetMapping
	public ResponseEntity<Iterable<User>> getUsers() {
		Iterable<User> users = userManager.getUsers();
		if (users == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(users);
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User createdUser = userManager.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
	}
	
	@PutMapping("/{ssn}")
	public ResponseEntity<User> updateUser(@PathVariable String ssn, @Valid @RequestBody User user) {
		User updatedUser = userManager.updateUser(ssn, user);
		if (updatedUser == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(updatedUser);
	}
	
	@DeleteMapping("/{ssn}")
	public ResponseEntity<Void> deleteUser(@PathVariable String ssn) {
		boolean deleted = userManager.deleteUser(ssn);
		if (!deleted) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}
}


Note that this is just a sample and does not include all possible error handling or security considerations. You should always implement proper error handling and security measures when building a production-grade application.