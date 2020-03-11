package com.meritamerica.assignment3;

import java.text.DecimalFormat;

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
}
