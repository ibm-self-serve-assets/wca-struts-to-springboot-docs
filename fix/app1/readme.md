# Changes required for WCA generated Springboot code

This documentation explains about the quick changes needed in the Springboot code generated using watsonx Code Assistant API.

A Struts application containing a Customer module with CRED operations has been migrated to Spring Boot. Once the code is migrated, few changes to be done in the migrated code. This document explains about the chnanges required to done.

**Source Code References :** <a href="./struts">Struts Code</a>  |  <a href="./springboot-org">Generated Springboot Code</a>    |   <a href="./springboot-fixed">Fixed Springboot Code</a>

**Migration Process :** See the document <a href="https://github.com/ibm-self-serve-assets/wca-struts-to-springboot-docs">here</a> for more information on migration.

## 1. Common files changes

Changes required commonly for the entire project.

### 1.1 MyApp.Java
    
Path : src/main/java/com/example/application/MyApp.java

#### Create file

1. Create this file with the content as like <a href="./springboot-fixed/src/main/java/com/example/application/MyApp.java">this</a>

### 1.2 pom.xml
    
Path : pom.xml

#### Update file

1. Add the depedency entries for `h2` and `thymeleaf` as like <a href="./springboot-fixed/pom.xml">this</a>

### 1.3 application.properties
    
Path : /resources/application.properties

#### Create file

1. Create this file.
2. Add the entries for `h2`  like <a href="./springboot-fixed/src/main/resources/application.properties">this</a>


## 2. Module specific changes

For each module/screen/entities, classes like Controller, DTO, Entity, Repository and Service are generated. For one module (Customer), the changes required are explained here. You may need to repeat the changes for each module.

### 2.1 CustomerAction.java

1. Delete the file src/main/java/com/example/application/service/CustomerAction.java

### 2.2 CustomerController.java

Path : /src/main/java/com/example/application/controller/CustomerController.java

#### Package

1. Change the package `package com.example.app.controller;` into `package com.example.application.controller;`
2. Change the import `import com.example.app.service.CustomerService;` into `import com.example.application.service.CustomerService;`
3. Change the import `import com.example.app.form.CustomerForm;` into `import com.example.application.model.Customer;`
4. Find and replace the `CustomerForm;` into `Customer;`
5. Add the import `import com.example.app.model.Customer;`
6. Add this `@Autowired`
```
    @Autowired
    private CustomerService customerService;
```
7. Comment the `customerService` instance as like this.
```
    public CustomerController() {
        //customerService = new CustomerService();
    }
```
8. Comment the some help text generated at the bottom of the file.

### 2.3 Customer.java

Path : src/main/java/com/example/application/model/Customer.java

#### Package

1. Change the package `package com.example.app.model;` into `package com.example.application.model;`

### 2.4 CustomerDTO.java

Path : src/main/java/com/example/application/model/CustomerDTO.java

#### Package

1. Find and replace the package `import jakarta.validation` into `import javax.validation`

#### Id

1. Replace the `private Integer id;` with `private Long id;`
2. Replace the `public Integer getId() { return id; }` with `public Long getId() { return id; }`
3. Replace the `public void setId(Long id) { this.id = id; }` with `public void setId(Long id) { this.id = id; }`
4. Comment the below lines.
```
        customer.setRegistrationDate(this.registrationDate);


        customer.setDiscountPercent(this.discountPercent);
        customer.setEligibleForUpgrade(this.eligibleForUpgrade);
```

### 2.5 CustomerRepository.java

Path : src/main/java/com/example/application/repository/CustomerRepository.java

#### Create file

1. Create this file with the content as like <a href="./springboot-fixed/src/main/java/com/example/application/repository/CustomerRepository.java">this</a>

### 2.6 CustomerService.java

Path : src/main/java/com/example/application/service/CustomerService.java

1. Remove the import `import com.example.app.form.CustomerForm;`
2. Add the import `import com.example.application.repository.CustomerRepository;`
3. Comment the lines with the `PreAuthorize` text
4. Replace `CustomerForm` with `Customer`
5. Comment the some help text generated at the bottom of the file.
