package com.app.model;

public class Account {
	private String account;
	private double balance;

	public Account(String account) {
		super();
		this.account = account;
	}

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}