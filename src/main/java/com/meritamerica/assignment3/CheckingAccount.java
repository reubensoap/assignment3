package com.meritamerica.assignment3;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * @author Reuben Pena
 * @date 3/5/2020
 * @description Checking Account Class used to hold information on account holders
 * checking information.
 */

public class CheckingAccount extends BankAccount{
	//Variables
    
    //Constructors
    public CheckingAccount(){
        super(0.00, 0.0001);
    }

    public CheckingAccount(double checkingB){
        super(checkingB, 0.0001);
    }
    
    public CheckingAccount(long accountNumber, double balance, double interestRate
    		, java.util.Date accountOpenedOn) {
    	super(accountNumber, balance, interestRate, accountOpenedOn);
    }

    //Getters
    

    //Methods

    // Stores future values of checking account with interest over a
    // set amount of years.
    public String toString(){
        DecimalFormat format = new DecimalFormat("##.00");
        return "\nChecking Account Balance: $" + format.format(this.getBalance()) + "\n"
                + "Checking Account Interest Rate: " + this.getInterestRate() + "\n"
                + "Checking Account Balance in 3 years: $" + format.format(this.futureValue(3));
    }
    
    /*
    
    static CheckingAccount readFromString(String accountData) throws ParseException {
			SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
	    	
	    	String array1[] = accountData.split(",");
	    	int fAccount = Integer.parseInt(array1[0]);
	    	double fBalance = Double.parseDouble(array1[1]);
	    	double fInterest = Double.parseDouble(array1[2]);
	    	Date fDate = dateFormatter.parse(array1[3]);
	    	
	    	CheckingAccount checking = new CheckingAccount(fAccount, fBalance
	    			, fInterest, fDate);
	    	return checking;
	}
	
	*/
    
    static CheckingAccount readFromString(String accountData) {
    	try {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    	
    	String array1[] = accountData.split(",");
    	int fAccount = Integer.parseInt(array1[0]);
    	double fBalance = Double.parseDouble(array1[1]);
    	double fInterest = Double.parseDouble(array1[2]);
    	Date fDate = dateFormatter.parse(array1[3]);
    	
    	CheckingAccount checking = new CheckingAccount(fAccount, fBalance
    			, fInterest, fDate);
    	return checking;
    	} catch(ParseException e) {
    		return null;
    	}
}
    
    
    
}
