package com.meritamerica.assignment3;

public class BankAccount {
	private double balance;
	private double interestRate;
	private java.util.Date accountOpenedOn; 
	private long accountNumber;
	
	public BankAccount(double balance, double interestRate) {
		this.balance = balance;
		this.interestRate = interestRate;
		this.accountOpenedOn = new java.util.Date();
	}
}
