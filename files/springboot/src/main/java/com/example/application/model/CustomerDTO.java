//Here is the completed Spring Boot DTO with all fields and validations:

package com.example.application.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

public class CustomerDTO {
    private Integer id;

    @NotBlank(message = "Name is required")
    @Size(max = 50, message = "Name must be less than 50 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;

    @NotBlank(message = "Address is required")
    private String address;

    @NotBlank(message = "Phone is required")
    @Pattern(regexp = "^\\+?[0-9-() ]*$", message = "Phone must be valid")
    private String phone;

    @NotNull(message = "Registration date is required")
    private Date registrationDate;

    @NotBlank(message = "Customer type is required")
    private String type;

    private boolean active;

    @NotNull(message = "Credit limit is required")
    @Min(value = 0, message = "Credit limit must be greater than or equal to 0")
    private BigDecimal creditLimit;

    @Min(value = 0, message = "Loyalty points must be greater than or equal to 0")
    private int loyaltyPoints;

    private String notes;

    private Date lastPurchaseDate;

    @NotBlank(message = "Preferred contact method is required")
    private String preferredContactMethod;

    @Min(value = 0, message = "Discount percent must be greater than or equal to 0")
    @Max(value = 100, message = "Discount percent must be less than or equal to 100")
    private int discountPercent;

    private boolean eligibleForUpgrade;

    // Default constructor
    public CustomerDTO() {}

    // Constructor from Customer entity
    public CustomerDTO(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.email = customer.getEmail();
        this.address = customer.getAddress();
        this.phone = customer.getPhone();
        this.registrationDate = customer.getRegistrationDate();
        this.type = customer.getType().name();
        this.active = customer.isActive();
        this.creditLimit = customer.getCreditLimit();
        this.loyaltyPoints = customer.getLoyaltyPoints();
        this.notes = customer.getNotes();
        this.lastPurchaseDate = customer.getLastPurchaseDate();
        this.preferredContactMethod = customer.getPreferredContactMethod();
        this.discountPercent = customer.getDiscountPercent();
        this.eligibleForUpgrade = customer.isEligibleForUpgrade();
    }

    // Convert to Customer entity
    public Customer toCustomer() {
        Customer customer = new Customer();
        customer.setId(this.id);
        customer.setName(this.name);
        customer.setEmail(this.email);
        customer.setAddress(this.address);
        customer.setPhone(this.phone);
        customer.setRegistrationDate(this.registrationDate);
        customer.setType(CustomerType.valueOf(this.type));
        customer.setActive(this.active);
        customer.setCreditLimit(this.creditLimit);
        customer.setLoyaltyPoints(this.loyaltyPoints);
        customer.setNotes(this.notes);
        customer.setLastPurchaseDate(this.lastPurchaseDate);
        customer.setPreferredContactMethod(this.preferredContactMethod);
        customer.setDiscountPercent(this.discountPercent);
        customer.setEligibleForUpgrade(this.eligibleForUpgrade);
        return customer;
    }

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    
    public Date getRegistrationDate() { return registrationDate; }
    public void setRegistrationDate(Date registrationDate) { this.registrationDate = registrationDate; }
    
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
    
    public BigDecimal getCreditLimit() { return creditLimit; }
    public void setCreditLimit(BigDecimal creditLimit) { this.creditLimit = creditLimit; }
    
    public int getLoyaltyPoints() { return loyaltyPoints; }
    public void setLoyaltyPoints(int loyaltyPoints) { this.loyaltyPoints = loyaltyPoints; }
    
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
    
    public Date getLastPurchaseDate() { return lastPurchaseDate; }
    public void setLastPurchaseDate(Date lastPurchaseDate) { this.lastPurchaseDate = lastPurchaseDate; }
    
    public String getPreferredContactMethod() { return preferredContactMethod; }
    public void setPreferredContactMethod(String preferredContactMethod) { 
        this.preferredContactMethod = preferredContactMethod; 
    }
    
    public int getDiscountPercent() { return discountPercent; }
    public void setDiscountPercent(int discountPercent) { this.discountPercent = discountPercent; }
    
    public boolean isEligibleForUpgrade() { return eligibleForUpgrade; }
    public void setEligibleForUpgrade(boolean eligibleForUpgrade) { this.eligibleForUpgrade = eligibleForUpgrade; }

    @Override
    public String toString() {
        return "CustomerDTO [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", phone="
                + phone + ", registrationDate=" + registrationDate + ", type=" + type + ", active=" + active
                + ", creditLimit=" + creditLimit + ", loyaltyPoints=" + loyaltyPoints + ", notes=" + notes
                + ", lastPurchaseDate=" + lastPurchaseDate + ", preferredContactMethod=" + preferredContactMethod
                + ", discountPercent=" + discountPercent + ", eligibleForUpgrade=" + eligibleForUpgrade + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CustomerDTO other = (CustomerDTO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}