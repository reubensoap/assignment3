package com.meritamerica.assignment3;

/*
 * @author Reuben Pena
 * @date 3/5/2020
 * @description CDAccounts class used to store CDOffering
 * class instances as well as Account information
 */

public class CDAccount {
	private double balance;
    private String startDate;
    private long accountNumber = 0;
    public CDOffering offering = new CDOffering(1, 0.01);
    public java.util.Date date = new java.util.Date();

    public CDAccount(CDOffering offering, double openingBalance){
        this.balance = openingBalance;
        this.offering = offering;
        this.accountNumber = MeritBank.getNextAccountNumber();
    }

    public double getBalance(){
        return this.balance;
    }

    public double getInterestRate(){
        return this.offering.getInterestRate();
    }

    public int getTerm(){
        return this.offering.getTerm();
    }

    public java.util.Date getStartDate(){
        return this.date;
    }

    public long getAccountNumber(){
        return this.accountNumber;
    }
    
    public void setAccountNumber(long accountN) {
    	this.accountNumber = accountN;
    }

    public double futureValue(){
        double pv = this.getBalance();
        double fv = pv * (Math.pow((1 + this.getInterestRate()), this.getTerm()));
        return fv;
    }
}
