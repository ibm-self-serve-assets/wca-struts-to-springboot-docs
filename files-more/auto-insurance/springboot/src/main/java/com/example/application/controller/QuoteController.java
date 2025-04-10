//Here is a sample Spring Boot REST Controller that implements the requirements:


package com.pks.insurance.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

import com.pks.insurance.domain.Quote;
import com.pks.insurance.service.PremiumManager;

@RestController
@RequestMapping("/quote")
public class QuoteController {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(QuoteController.class);
	@Autowired
	private PremiumManager premiumManager;

	@GetMapping("/{ssn}")
	public ResponseEntity<Quote> getQuote(@PathVariable("ssn") String ssn) {
		Quote quote = premiumManager.getQuote(ssn);
		if (quote != null) {
			return ResponseEntity.ok(quote);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Quote> generateQuote(
			@RequestParam("ssn") @Valid String ssn,
			@RequestParam("age") @Valid int age,
			@RequestParam("gender") @Valid String gender,
			@RequestParam("sumAssured") @Valid double sumAssured,
			@RequestParam("inceptionDate") @Valid String inceptionDate,
			HttpServletRequest request) {
		Quote quote = premiumManager.generateQuote(ssn, age, gender,
				sumAssured, inceptionDate);
		if (quote != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(quote);
		}
		return ResponseEntity.badRequest().build();
	}
}


Note that this is a very basic example and does not cover all possible error handling or validation scenarios. You may need to add additional methods and error handling to properly address your requirements.