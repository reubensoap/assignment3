package com.meritamerica.assignment3;

import java.text.DecimalFormat;

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
        super(0.00, 0.001);
    }

    public CheckingAccount(double checkingB){
        super(checkingB, 0.001);
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
}
