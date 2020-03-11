package com.meritamerica.assignment3;

/*
 * @author Reuben Pena
 * @date 3/5/2020
 * @description CDOffering class used to store information
 * regarding CDOffering methods / variables
 */

public class CDOffering {
	private int term;
    private double interestRate;

    public CDOffering(int term, double interestRate){
        this.term = term;
        this.interestRate = interestRate;
    }

    public int getTerm(){
        return this.term;
    }

    public double getInterestRate(){
        return this.interestRate;
    }

    public String toString(){
        return "Term: " + this.getTerm() + " Interest Rate: " + this.getInterestRate();
    }
}
