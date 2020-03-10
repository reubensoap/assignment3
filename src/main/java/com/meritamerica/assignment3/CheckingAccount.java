package com.meritamerica.assignment3;

import java.text.DecimalFormat;

/*
 * @author Reuben Pena
 * @date 3/5/2020
 * @description Checking Account Class used to hold information on account holders
 * checking information.
 */

public class CheckingAccount {
	//Variables
    private double balance;
    private static double interest = 0.01;
    private long accountNumber = 0;

    //Constructors
    public CheckingAccount(){
        this.balance = 0.0;
    }

    public CheckingAccount(double checkingB){
        this.balance = checkingB;
    }

    //Getters
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

    // Stores future values of checking account with interest over a
    // set amount of years.
    public double futureValue(int years){
        double pv = this.getBalance();
        double fv = pv * (Math.pow((1 + this.getInterestRate()), years));
        return fv;
    }

    // Used to determine if the withdraw amount is not a negative number
    // or puts the checking account balance under $0.00 and then
    // takes away amount from checking account balance.
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
    // and then adds amount to checking account balance
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
        return "\nChecking Account Balance: $" + format.format(this.getBalance()) + "\n"
                + "Checking Account Interest Rate: " + this.getInterestRate() + "\n"
                + "Checking Account Balance in 3 years: $" + format.format(this.futureValue(3));
    }
}
