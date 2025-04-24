package com.example.application;

import com.example.application.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyApp  {

    @Autowired

    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
    }

}
