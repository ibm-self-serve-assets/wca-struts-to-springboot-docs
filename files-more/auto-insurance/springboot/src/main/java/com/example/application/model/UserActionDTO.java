//Here is the completed DTO in Spring Boot format:


package com.example.application.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {
    @NotNull(message = "SSN is required")
    @Pattern(regexp = "^\\d{9}$", message = "SSN must be 9 digits")
    private String ssn;

    @NotNull(message = "Password is required")
    @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
    private String password;

    @NotNull(message = "Confirm password is required")
    @Size(min = 8, max = 20, message = "Confirm password must be between 8 and 20 characters")
    private String confirmPassword;

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotBlank(message = "Gender is required")
    private String gender;

    @NotNull(message = "Mobile number is required")
    @Pattern(regexp = "^\\d{10}$", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @NotNull(message = "Email is required")
    @Email(message = "Email address is invalid")
    private String email;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "Blood group is required")
    private String bloodGroup;

    @NotBlank(message = "Driving licence is required")
    private String drivingLicence;

    @NotNull(message = "Date of birth is required")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Date of birth must be in YYYY-MM-DD format")
    private String dateOfBirth;

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getDrivingLicence() {
        return drivingLicence;
    }

    public void setDrivingLicence(String drivingLicence) {
        this.drivingLicence = drivingLicence;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "User [ssn=" + ssn + ", password=" + password + ", confirmPassword=" + confirmPassword + ", firstName="
                + firstName + ", lastName=" + lastName + ", gender=" + gender + ", mobileNumber=" + mobileNumber
                + ", email=" + email + ", city=" + city + ", bloodGroup=" + bloodGroup + ", drivingLicence="
                + drivingLicence + ", dateOfBirth=" + dateOfBirth + "]";
    }
}



Note that the package name has been changed to com.example.application.model and the class name has been changed to User. Additionally, the validation annotations have been added to each field and the validation messages have been added. Finally, the toString method has been overridden to display all the fields in the correct order.