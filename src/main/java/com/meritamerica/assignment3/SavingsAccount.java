package com.meritamerica.assignment3;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * @author Reuben Pena
 * @date 3/5/2020
 * @description Savings Account Class used to store information for the account
 * holder in regards to saving account information.
 */


public class SavingsAccount extends BankAccount{
	// Variables

    //Constructors
    public SavingsAccount(){
        super(0.00, 0.01);
    }

    public SavingsAccount(double savingB){
        super(savingB, 0.01);
    }
    
    public SavingsAccount(int accountNum, double balance, double interestRate
    		, java.util.Date accountOpenedOn) {
    	super(accountNum, balance, interestRate, accountOpenedOn);
    }

    //Getters and Setters
    /*public void setAccountNumber(long accountN) {
    	this.accountNumber = accountN;
    }
    */

    //Methods

    public String toString(){
        DecimalFormat format = new DecimalFormat("##.00");
        return "\nSaving Account Balance: $" + format.format(this.getBalance()) + "\n"
                + "Saving Account Interest Rate: " + this.getInterestRate() + "\n"
                + "Saving Account Balance in 3 years: $" + format.format(this.futureValue(3));
    }
    
    static SavingsAccount readFromString(String accountData) {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    	try {
    	String array1[] = accountData.split(",");
    	int fAccount = Integer.parseInt(array1[0]);
    	double fBalance = Double.parseDouble(array1[1]);
    	double fInterest = Double.parseDouble(array1[2]);
    	Date fDate = dateFormatter.parse(array1[3]);
    	
    	SavingsAccount savings = new SavingsAccount(fAccount, fBalance
    			, fInterest, fDate);
    	return savings;
    	} catch (ParseException e) {
    		return null;
    	}
    }
}
