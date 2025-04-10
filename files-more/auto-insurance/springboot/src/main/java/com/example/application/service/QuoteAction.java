//Here is the Spring Boot service that encapsulates the business logic from the original Struts Action:


package com.example.application.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.application.form.QuoteForm;
import com.example.application.repository.PersonRepository;
import com.pks.insurance.domain.Person;

@Service
@Transactional
public class QuoteService {
    private static final Logger LOGGER = LoggerFactory.getLogger(QuoteService.class);

    private final PersonRepository personRepository;

    @Autowired
    public QuoteService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person getPerson(HttpServletRequest request) {
        String ssn = (String) request.getSession().getAttribute("ssn");
        if (ssn == null || ssn.isEmpty()) {
            return null;
        }
        return personRepository.findBySsn(ssn);
    }

    public void validateForm(QuoteForm form) {
        // TODO: Implement form validation logic
    }

    public double calculatePremium(Person person) {
        // TODO: Calculate premium based on person's information
        return 0.0;
    }
}



Note that this is just a sample implementation and does not cover all possible business rules or error handling. You will need to add additional methods and logic to meet your specific requirements.