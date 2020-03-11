package com.meritamerica.assignment3;

/*
 * @author Reuben Pena
 * @date 3/5/2020
 * @description CDAccounts class used to store CDOffering
 * class instances as well as Account information
 */

public class CDAccount extends BankAccount {
    public CDOffering offering = new CDOffering(1, 0.01);

    public CDAccount(CDOffering offering, double openingBalance){
        super(openingBalance, offering.getInterestRate());
        this.offering = offering;
    }

    public int getTerm(){
        return this.offering.getTerm();
    }
    
    // override from BankAccount withdraw , deposit
    public boolean withdraw(double amount){
        return false;
    }
	
	public boolean deposit(double amount) {
        return false;
    }
}
