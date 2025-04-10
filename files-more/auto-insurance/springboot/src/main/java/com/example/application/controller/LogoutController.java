//Here is a sample Spring Boot REST Controller that implements the requirements:


package com.pks.insurance.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logout")
public class LogoutAction {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(LogoutAction.class);

	@GetMapping
	public ResponseEntity<String> logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return new ResponseEntity<String>("Logged out successfully", HttpStatus.OK);
	}
}


Note that this is a very basic example and does not handle session management or authentication. It is recommended to implement proper security measures and handle errors and exceptions properly.