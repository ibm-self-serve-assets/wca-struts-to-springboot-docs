//Here is a sample Spring Boot REST Controller that implements the requirements:


package com.pks.insurance.action;

import java.text.ParseException;
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
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pks.insurance.domain.User;
import com.pks.insurance.form.UserActionForm;
import com.pks.insurance.service.UserManager;

@Controller
@RequestMapping("/userRegister")
public class RegisterUserAction {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(RegisterUserAction.class);

	@Autowired
	private UserManager userManager;

	@GetMapping
	public String showRegistrationForm(
			@ModelAttribute("userForm") UserActionForm userForm) {
		return "register";
	}

	@PostMapping
	public ResponseEntity<String> registerUser(
			@Valid @ModelAttribute("userForm") UserActionForm userForm,
			Errors errors, HttpServletRequest request) {
		if (errors.hasErrors()) {
			return new ResponseEntity<String>("Invalid input, please try again",
					HttpStatus.BAD_REQUEST);
		}

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-M-dd");
		Date dateOfBirth = null;
		try {
			dateOfBirth = dateFormat.parse(userForm.getDateOfBirthString());
		} catch (ParseException e) {
			LOGGER.error(e.getMessage());
		}

		User user = new User();
		try {
			BeanUtils.copyProperties(user, userForm);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return new ResponseEntity<String>(
					"An error occurred, please try again later",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		user.setDateOfBirth(dateOfBirth);

		boolean userExistsFlag = userManager.isUser(user);
		if (userExistsFlag) {
			return new ResponseEntity<String>(
					"SSN already registered, you can login directly",
					HttpStatus.BAD_REQUEST);
		}
		LOGGER.info("regDto:" + user);
		user = userManager.saveUser(user);
		LOGGER.info("isUserReg: " + user);

		// Set ssn in session and open home page
		HttpSession session = request.getSession(false);
		session.setAttribute("ssn", user.getSsn());
		return new ResponseEntity<String>("Registration successful",
				HttpStatus.OK);
	}

}


Note that the form handling and validation is done using the @Valid annotation and Errors object, while the session handling is done using the standard Spring Session API. Additionally, the controller methods return ResponseEntity objects with appropriate status codes and error messages, which can be easily handled by the client.