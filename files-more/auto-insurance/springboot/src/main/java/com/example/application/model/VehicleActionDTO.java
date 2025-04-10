//Here is the converted DTO in Spring Boot format:


package com.example.application.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Vehicle {
    @NotNull(message = "Vehicle type is required")
    private String type;

    @NotBlank(message = "Model is required")
    @Size(min = 2, max = 20, message = "Model must be between 2 and 20 characters")
    private String model;

    @NotBlank(message = "Make is required")
    @Size(min = 2, max = 20, message = "Make must be between 2 and 20 characters")
    private String make;

    @NotBlank(message = "Registration number is required")
    @Pattern(regexp = "^[A-Z]{2}[0-9]{1,2}[A-Z]{2}$", message = "Registration number must be in the format XX99XX")
    private String regNo;

    @NotBlank(message = "Policy type is required")
    private String policyType;

    @NotBlank(message = "Policy amount is required")
    @Pattern(regexp = "^\\$?[0-9]+(\\.[0-9][0-9])?$", message = "Policy amount must be a valid currency amount")
    private String policyAmount;

    @NotBlank(message = "Manufacturing year is required")
    @Pattern(regexp = "^[0-9]{4}$", message = "Manufacturing year must be in the format YYYY")
    private String mfYear;

    @Min(value = 0, message = "Total accidents must be at least 0")
    @Max(value = 10, message = "Total accidents must be at most 10")
    private int totalAccident;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public String getPolicyAmount() {
        return policyAmount;
    }

    public void setPolicyAmount(String policyAmount) {
        this.policyAmount = policyAmount;
    }

    public String getMfYear() {
        return mfYear;
    }

    public void setMfYear(String mfYear) {
        this.mfYear = mfYear;
    }

    public int getTotalAccident() {
        return totalAccident;
    }

    public void setTotalAccident(int totalAccident) {
        this.totalAccident = totalAccident;
    }

    @Override
    public String toString() {
        return "Vehicle [type=" + type + ", model=" + model + ", make=" + make + ", regNo=" + regNo + ", policyType="
                + policyType + ", policyAmount=" + policyAmount + ", mfYear=" + mfYear + ", totalAccident="
                + totalAccident + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((make == null) ? 0 : make.hashCode());
        result = prime * result + ((model == null) ? 0 : model.hashCode());
        result = prime * result + ((mfYear == null) ? 0 : mfYear.hashCode());
        result = prime * result + ((policyAmount == null) ? 0 : policyAmount.hashCode());
        result = prime * result + ((policyType == null) ? 0 : policyType.hashCode());
        result = prime * result + ((regNo == null) ? 0 : regNo.hashCode());
        result = prime * result + totalAccident;
        result = prime * result + ((type == null) ? 0 : type.hashCode());
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
        Vehicle other = (Vehicle) obj;
        if (make == null) {
            if (other.make != null)
                return false;
        } else if (!make.equals(other.make))
            return false;
        if (model == null) {
            if (other.model != null)
                return false;
        } else if (!model.equals(other.model))
            return false;
        if (mfYear == null) {
            if (other.mfYear != null)
                return false;
        } else if (!mfYear.equals(other.mfYear))
            return false;
        if (policyAmount == null) {
            if (other.policyAmount != null)
                return false;
        } else if (!policyAmount.equals(other.policyAmount))
            return false;
        if (policyType == null) {
            if (other.policyType != null)
                return false;
        } else if (!policyType.equals(other.policyType))
            return false;
        if (regNo == null) {
            if (other.regNo != null)
                return false;
        } else if (!regNo.equals(other.regNo))
            return false;
        if (totalAccident != other.totalAccident)
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        return true;
    }

}