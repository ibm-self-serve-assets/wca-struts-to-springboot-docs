//Here is a sample Spring Boot REST Controller that implements the requirements:


package com.pks.insurance.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pks.insurance.domain.User;
import com.pks.insurance.helper.UserLevels;
import com.pks.insurance.service.UserManager;

@Controller
@RequestMapping("/login")
public class LoginAction {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(LoginAction.class);

	@Autowired
	private UserManager userManager;

	@GetMapping
	public String login() {
		return "login";
	}

	@PostMapping
	public ResponseEntity<String> login(
			@Valid @ModelAttribute("user") User user, Errors errors,
			@RequestParam(required = false) String admin) {
		if (errors.hasErrors()) {
			return new ResponseEntity<String>("Invalid login credentials",
					HttpStatus.BAD_REQUEST);
		}

		int authResult = userManager.authenticateUser(user);
		LOGGER.info("authResult: " + authResult);

		// For Normal Valid User
		if (authResult == UserLevels.VALID_USER) {
			return new ResponseEntity<String>("Login successful",
					HttpStatus.OK);

		} else if (authResult == UserLevels.VALID_ADMIN) {
			// For Admin user
			// Retrive list of all the users
			// request.setAttribute("customers", userManager.getUsers());
			return new ResponseEntity<String>("Login successful",
					HttpStatus.OK);
		} else {
			// Display Error Message to the user for incorrect login credentials
			return new ResponseEntity<String>(
					"The username or password you entered is incorrect.",
					HttpStatus.BAD_REQUEST);
		}
	}

}



Note that this is a simplified version of the actual code, with only the relevant parts included. Also, the code assumes that the login form is handled by a separate controller or view, and the login action only handles the authentication logic.