//Here is a sample Spring Boot REST Controller that implements the requirements:


package com.pks.insurance.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pks.insurance.domain.Vehicle;
import com.pks.insurance.form.VehicleActionForm;
import com.pks.insurance.service.UserManager;

@RestController
@RequestMapping("/vehicle")
public class RegisterVehicleAction {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(RegisterVehicleAction.class);

	@Autowired
	private UserManager userManager;

	@PostMapping("/register")
	public ResponseEntity<Vehicle> registerVehicle(
			@Valid @RequestBody Vehicle vehicle, BindingResult result) {
		if (result.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		HttpSession session = request.getSession(false);
		vehicle.setSsn((String) session.getAttribute("ssn"));
		vehicle.setQuoteDate(new Date());
		LOGGER.info(":vehicleDto:" + vehicle);
		Vehicle registeredVehicle = userManager.saveVehicle(vehicle);
		LOGGER.info("::::vehicleRegistered::::" + vehicle);
		return new ResponseEntity<>(registeredVehicle, HttpStatus.OK);
	}
}



Note that this is a very basic example and does not cover all possible scenarios or handle all possible errors. You may need to add additional methods, handle authentication and authorization, and other details specific to your application.