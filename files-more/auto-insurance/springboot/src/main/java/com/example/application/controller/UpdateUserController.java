//Here is a sample Spring Boot REST Controller that implements the requirements:


package com.pks.insurance.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pks.insurance.domain.User;
import com.pks.insurance.form.UserActionForm;
import com.pks.insurance.service.UserManager;

@RestController
@RequestMapping("/api/users")
public class UpdateUserAction {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(UpdateUserAction.class);
	@Autowired
	private UserManager userManager;

	@PutMapping("/{ssn}")
	public ResponseEntity<User> updateUser(@PathVariable("ssn") String ssn,
			@Valid @RequestBody User user) {
		try {
			userManager.updateUser(user);
			return new ResponseEntity<>(user, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}



Note that the code is a bit longer than the original Struts Action, but it meets all the requirements and follows best practices for a Spring Boot REST Controller.