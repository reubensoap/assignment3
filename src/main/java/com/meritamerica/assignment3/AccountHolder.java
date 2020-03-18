package com.meritamerica.assignment3;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class AccountHolder implements Comparable<AccountHolder> {
	// Variables of Class
    private String firstName;
    private String middleName;
    private String lastName;
    private String ssn;
    public CheckingAccount checking[] = new CheckingAccount[1];
    public SavingsAccount savings[] = new SavingsAccount[1];
    public CDAccount cdAccount[] = new CDAccount[1];


    // Constructors
    public AccountHolder() {
        this.firstName = "John";
        this.middleName = "M";
        this.lastName = "Doe";
        this.ssn = "n/a";
    }

    public AccountHolder(String fn, String mn, String ln, String sn){
        this.firstName = fn;
        this.middleName = mn;
        this.lastName = ln;
        this.ssn = sn;
    }

    // Setters and Getters
    public void setFirstName(String fn){
        this.firstName = fn;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setMiddleName(String mn){
        this.middleName = mn;
    }

    public String getMiddleName(){
        return this.middleName;
    }

    public void setLastName(String ln){
        this.lastName = ln;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setSSN(String sn){
        this.ssn = sn;
    }

    public String getSSN(){
        return this.ssn;
    }

    // Methods

    /* ******************************************
     *********************************************
     * Code from Assignment 2
     *********************************************
     *********************************************
     */

    public CheckingAccount addCheckingAccount(double checkingB){
        double tBalance = 0;
        double tChecking = 0;
        double tSaving = 0;
        tChecking = this.getCheckingBalance();
        tSaving = this.getSavingsBalance();
        double testAdd = checkingB;
        tBalance = tChecking + tSaving + testAdd;
        if (tBalance > 250000){
            System.out.println("Unable to Complete Action, Accounts Exceed Balance Limit.");
            return checking[checking.length - 1];
        } else {
            checking[checking.length - 1] = new CheckingAccount(checkingB);
            CheckingAccount arrayTemp[] = new CheckingAccount[checking.length + 1];
            for(int x = 0; x < checking.length; x++) {
            	arrayTemp[x] = checking[x];
            }
            checking = arrayTemp;
            return checking[checking.length - 2];
        }
    }

    public CheckingAccount addCheckingAccount(CheckingAccount checkingAccountX){
        double tBalance = 0;
        double tChecking = 0;
        double tSaving = 0;
        tChecking = this.getCheckingBalance();
        tSaving = this.getSavingsBalance();
        double testAdd = checkingAccountX.getBalance();
        tBalance = tChecking + tSaving + testAdd;
        if (tBalance > 250000){
            System.out.println("Unable to Complete Action, Accounts Exceed Balance Limit.");
            return checking[checking.length - 1];
        } else {
            checking[checking.length - 1] = checkingAccountX;
            CheckingAccount arrayTemp[] = new CheckingAccount[checking.length + 1];
            for(int x = 0; x < checking.length; x++) {
            	arrayTemp[x] = checking[x];
            }
            checking = arrayTemp;
            return checking[checking.length - 2];
        }
    }

    public CheckingAccount[] getCheckingAccounts(){
        return this.checking;
    }

    public int getNumberOfCheckingAccounts(){
        return this.checking.length - 1;
    }

    public double getCheckingBalance(){
        double tBalance = 0;
        for(int x = 0; x < checking.length - 1; x++){
            tBalance += checking[x].getBalance();
        }
        return tBalance;
    }

    public SavingsAccount addSavingsAccount(double openingBalance){
        double tBalance = 0;
        double tChecking = 0;
        double tSaving = 0;
        tChecking = this.getCheckingBalance();
        tSaving = this.getSavingsBalance();
        double testAdd = openingBalance;
        tBalance = tChecking + tSaving + testAdd;
        if (tBalance > 250000){
            System.out.println("Unable to Complete Action, Accounts Exceed Balance Limit.");
            return savings[savings.length - 1];
        } else {
            savings[savings.length - 1] = new SavingsAccount(openingBalance);
            SavingsAccount arrayTemp[] = new SavingsAccount[savings.length + 1];
            for(int x = 0; x < savings.length; x++) {
            	arrayTemp[x] = savings[x];
            }
            savings = arrayTemp;
            return savings[savings.length - 2];
        }
    }

    public SavingsAccount addSavingsAccount(SavingsAccount savingsAccountX){
        double tBalance = 0;
        double tChecking = 0;
        double tSaving = 0;
        tChecking = this.getCheckingBalance();
        tSaving = this.getSavingsBalance();
        double testAdd = savingsAccountX.getBalance();
        tBalance = tChecking + tSaving + testAdd;
        if (tBalance > 250000){
            System.out.println("Unable to Complete Action, Accounts Exceed Balance Limit.");
            return savings[savings.length - 1];
        } else {
        	savings[savings.length - 1] = savingsAccountX;
            SavingsAccount arrayTemp[] = new SavingsAccount[savings.length + 1];
            for(int x = 0; x < savings.length; x++) {
            	arrayTemp[x] = savings[x];
            }
            savings = arrayTemp;
            return savings[savings.length - 2];
        }
    }

    public SavingsAccount[] getSavingsAccounts(){
        return this.savings;
    }

    public int getNumberOfSavingsAccounts(){
        return this.savings.length - 1;
    }

    public double getSavingsBalance(){
        double tBalance = 0;
        for(int x = 0; x < savings.length - 1; x++){
            tBalance += savings[x].getBalance();
        }
        return tBalance;
    }

    public CDAccount addCDAccount(CDOffering offering, double openingBalance){
        cdAccount[cdAccount.length - 1] = new CDAccount(offering, openingBalance);
        CDAccount arrayTemp[] = new CDAccount[cdAccount.length + 1];
        for(int x = 0; x < cdAccount.length; x++) {
        	arrayTemp[x] = cdAccount[x];
        }
        cdAccount = arrayTemp;
        return cdAccount[cdAccount.length - 2];
    }

    public CDAccount addCDAccount(CDAccount cdAccountX) {
        if(cdAccount.equals(null)){
            System.out.println("Unable to Complete Action, Null CD Offer.");
            return null;
        }
        cdAccount[cdAccount.length - 1] = cdAccountX;
        CDAccount arrayTemp[] = new CDAccount[cdAccount.length + 1];
        for(int x = 0; x < cdAccount.length; x++) {
        	arrayTemp[x] = cdAccount[x];
        }
        cdAccount = arrayTemp;
        return this.cdAccount[cdAccount.length - 2];
    }

    public CDAccount[] getCDAccounts(){
        return this.cdAccount;
    }

    public int getNumberOfCDAccounts(){
        return this.cdAccount.length - 1;
    }

    public double getCDBalance(){
        double tBalance = 0;
        for(int x = 0; x < this.cdAccount.length - 1; x++) {
            tBalance += cdAccount[x].getBalance();
        }
        return tBalance;
    }

    public double getCombinedBalance(){
        double tBalance;
        tBalance = this.getCheckingBalance();
        tBalance += this.getSavingsBalance();
        tBalance += this.getCDBalance();
        return tBalance;
    }

    public String toString(){
        DecimalFormat format = new DecimalFormat("##.00");
        return "Name: " + this.firstName + " " + this.middleName + " " + this.lastName + "\n"
                + "SSN: " + this.ssn + "\n";
    }
    
    @Override
    public int compareTo(AccountHolder otherAccount) {
    	if(this.getCombinedBalance() > otherAccount.getCombinedBalance()) {
    		return 1;
    	} else
    		return -1;
    }
    
    public String writeToString() {
    	return this.lastName + "," + this.middleName + "," + this.firstName + ","
    			+ this.ssn;
    }
    
    static AccountHolder readFromString(String accountData) {
    	String array1[] = accountData.split(",");
    	try {
    	AccountHolder ah = new AccountHolder(array1[2], array1[1]
    			, array1[0], array1[3]);
    	return ah;
    	} catch (Exception e) {
    		return null;
    	}
    }

    /*
    * Was going to override both methods however decided not to edit
    * from default.
    * */
}
