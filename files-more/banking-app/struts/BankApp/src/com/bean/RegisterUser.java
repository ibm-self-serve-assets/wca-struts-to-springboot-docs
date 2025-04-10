package com.bean;

public class RegisterUser {
	String name;
	String password;
	String address;
	String initDeposit;
	
	public RegisterUser(String name, String password, String address, String initDeposit) {
		this.name = name;
		this.password = password;
		this.address = address;
		this.initDeposit = initDeposit;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getInitDeposit() {
		return initDeposit;
	}
	public void setInitDeposit(String initDeposit) {
		this.initDeposit = initDeposit;
	}
}
