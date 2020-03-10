package com.meritamerica.assignment3;

import java.text.DecimalFormat;

/*
 * @author Reuben Pena
 * @date 3/5/2020
 * @description Savings Account Class used to store information for the account
 * holder in regards to saving account information.
 */


public class SavingsAccount {
	// Variables
    private double balance;
    private static double interest = 0.01;
    private long accountNumber;

    //Constructors
    public SavingsAccount(){
        this.balance = 0.0;
        this.accountNumber = MeritBank.getNextAccountNumber();
    }

    public SavingsAccount(double savingB){
        this.balance = savingB;
        this.accountNumber = MeritBank.getNextAccountNumber();
    }

    //Getters and Setters
    public double getBalance(){
        return this.balance;
    }

    public double getInterestRate(){
        return interest;
    }

    public long getAccountNumber(){
        return this.accountNumber;
    }
    
    public void setAccountNumber(long accountN) {
    	this.accountNumber = accountN;
    }

    //Methods

    // Stores future values of savings account with interest over a
    // set amount of years.
    public double futureValue(int years){
        double pv = this.getBalance();
        double fv = pv * (Math.pow((1 + this.getInterestRate()), years));
        return fv;
    }

    // Used to determine if the withdraw amount is not a negative number
    // or puts the checking account balance under $0.00 and then
    // takes away amount from savings account balance.
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

    // Used to determine if the deposit amount is not a negative number
    // and then adds amount to savings account balance
    public boolean deposit(double amount){
        if(amount <= 0){
            System.out.println("Unable to deposit negative funds. Try again.");
            return false;
        } else {
            this.balance = this.getBalance() + amount;
            return true;
        }
    }

    public String toString(){
        DecimalFormat format = new DecimalFormat("##.00");
        return "\nSaving Account Balance: $" + format.format(this.getBalance()) + "\n"
                + "Saving Account Interest Rate: " + this.getInterestRate() + "\n"
                + "Saving Account Balance in 3 years: $" + format.format(this.futureValue(3));
    }
}
