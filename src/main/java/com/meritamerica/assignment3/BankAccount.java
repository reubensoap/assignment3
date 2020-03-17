package com.meritamerica.assignment3;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BankAccount {
	// Variables
	private double balance;
	private double interestRate;
	private java.util.Date accountOpenedOn; 
	private long accountNumber;
	
	//Constructors
	public BankAccount(double balance, double interestRate) {
		this.balance = balance;
		this.interestRate = interestRate;
		this.accountOpenedOn = new java.util.Date();
	}
	
	public BankAccount(double balance, double interestRate
			, java.util.Date accountOpenedOn) {
		this.balance = balance;
		this.interestRate = interestRate;
		this.accountOpenedOn = accountOpenedOn;
	}
	
	public BankAccount(long accountNumber, double balance, double interestRate
			, java.util.Date accountOpenedOn) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.interestRate = interestRate;
		this.accountOpenedOn = accountOpenedOn;
	}
	
	// Getters and Setters
	public long getAccountNumber() {
		return this.accountNumber;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public double getInterestRate() {
		return this.interestRate;
	}
	
	public java.util.Date getOpenedOn(){
		return this.accountOpenedOn;
	}
	
	public void setAccountNumber(long accountNum) {
		this.accountNumber = accountNum;
	}
	
	//Methods
	public boolean withdraw(double amount){
        if (amount < 0){
            System.out.println("Unable to withdraw a negative amount. Try again.");
            return false;
        } else {
            if((this.getBalance() - amount) < 0){
                System.out.println("Not enough funds in the account.");
                return false;
            } else {
                double newB = this.getBalance() - amount;
                this.balance = newB;
                return true;
            }
        }

    }
	
	public boolean deposit(double amount){
        if(amount <= 0){
            System.out.println("Unable to deposit negative funds. Try again.");
            return false;
        } else {
            this.balance = this.getBalance() + amount;
            return true;
        }
    }
	
	public double futureValue(int years){
        double pv = this.getBalance();
        double fv = pv * (Math.pow((1 + this.getInterestRate()), years));
        return fv;
    }
	
	// Has to redo this code
	public String toString(){
        DecimalFormat format = new DecimalFormat("##.00");
        return "\nChecking Account Balance: $" + format.format(this.getBalance()) + "\n"
                + "Checking Account Interest Rate: " + this.getInterestRate() + "\n"
                + "Checking Account Balance in 3 years: $" + format.format(this.futureValue(3));
    }
	
	static BankAccount readFromString(String accountData) {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    	try {
    	String array1[] = accountData.split(",");
    	int fAccount = Integer.parseInt(array1[0]);
    	double fBalance = Double.parseDouble(array1[1]);
    	double fInterest = Double.parseDouble(array1[2]);
    	Date fDate = dateFormatter.parse(array1[3]);
    	
    	BankAccount banks = new BankAccount(fAccount, fBalance
    			, fInterest, fDate);
    	return banks;
    	} catch (ParseException e) {
    		return null;
    	}
    }
	
	public String writeToString() {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
    	return this.accountNumber + "," + this.balance + "," + this.interestRate
    			+ "," + dateFormatter.format(this.accountOpenedOn);
    }
}
