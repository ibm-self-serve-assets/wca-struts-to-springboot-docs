package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "BankUserInfo.Information")
public class SetPerInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID")
    private int userID;

    @NotNull
    @Column(name = "name")
    private String userName;

    @NotNull
    @Column(name = "address")
    private String address;

    @NotNull
    @Column(name = "balance")
    private int balance;

    @NotNull
    @Column(name = "password")
    private String password;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SetPerInfo that = (SetPerInfo) o;

        if (userID != that.userID) return false;
        if (balance != that.balance) return false;
        if (!userName.equals(that.userName)) return false;
        if (!address.equals(that.address)) return false;
        return password.equals(that.password);
    }

    @Override
    public int hashCode() {
        int result = userID;
        result = 31 * result + userName.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + balance;
        result = 31 * result + password.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "SetPerInfo{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", address='" + address + '\'' +
                ", balance=" + balance +
                ", password='" + password + '\'' +
                '}';
    }
}