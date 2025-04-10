package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class RegPerInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
	private String password;

    @NotBlank
    private String address;

    @NotBlank
    private String balance;

    // Add proper JPA annotations if needed

    // Add validation annotations

    // Maintain all fields and methods

    // Add proper equals/hashCode/toString

    // Add proper JavaDoc
}