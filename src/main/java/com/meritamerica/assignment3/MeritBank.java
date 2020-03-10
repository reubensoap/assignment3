package com.meritamerica.assignment3;

/*
 * @author Reuben Pena
 * @date 3/5/2020
 * @description MeritBank static class, used to Hold all accountHolders
 * as well as test CDOffering choices
 */

public class MeritBank {
	static int accountHolderNum = 0;
    static int cdOfferingNum = 0;
    static AccountHolder accountHolder[] = new AccountHolder[50];
    static CDOffering cdOfferingHolder[] = new CDOffering[50];

    static void addAccountHolder(AccountHolder accountHolderx){
        accountHolder[accountHolderNum] = accountHolderx;
        accountHolderNum++;
    }

    static AccountHolder[] getAccountHolders(){
        return accountHolder;
    }

    static CDOffering[] getCDOfferings(){
        return cdOfferingHolder;
    }

    static CDOffering getBestCDOffering(double depositAmount){
        int best = 0;
        double tv;
        double fv;
        if (cdOfferingNum < 2){
            System.out.println("Unable to complete action. Need more CD Offers.");
            return cdOfferingHolder[0];
        }
        for(int x = 0; x < cdOfferingHolder.length; x++){
            double pv = depositAmount;
            tv = pv * (Math.pow((1 + cdOfferingHolder[x].getInterestRate()), cdOfferingHolder[x].getTerm()));
            fv = pv * (Math.pow((1 + cdOfferingHolder[best].getInterestRate()), cdOfferingHolder[best].getTerm()));
            if (tv > fv){
                best = x;
            }
        }
        return cdOfferingHolder[best];
    }

    static CDOffering getSecondBestCDOffering(double depositAmount){
        int best = 0;
        int second = 0;
        double tv;
        double fv;
        double sv;
        if (cdOfferingNum < 2){
            System.out.println("Unable to complete action. Need more CD Offers.");
            return null;
        }
        for(int x = 0; x < cdOfferingHolder.length; x++){
            double pv = depositAmount;
            tv = pv * (Math.pow((1 + cdOfferingHolder[x].getInterestRate()), cdOfferingHolder[x].getTerm()));
            fv = pv * (Math.pow((1 + cdOfferingHolder[best].getInterestRate()), cdOfferingHolder[best].getTerm()));
            sv = pv * (Math.pow((1 + cdOfferingHolder[second].getInterestRate()), cdOfferingHolder[second].getTerm()));
            if (tv > fv){
                second = best;
                best = x;
            }
            else if(tv > sv && tv != fv){
                second = x;
            }
        }
        return cdOfferingHolder[second];
    }

    static void clearCDOfferings(){
        CDOffering newArr[] = null;
        cdOfferingHolder = newArr;
        cdOfferingNum = 0;
    }

    static void setCDOfferings(CDOffering[] offerings){
        cdOfferingHolder = offerings;
        cdOfferingNum = offerings.length;
    }

    static double totalBalances(){
        double tBalance = 0;
        for(int x = 0; x < accountHolderNum; x++){
            tBalance += accountHolder[x].getCombinedBalance();
        }
        return tBalance;
    }

    static long getNextAccountNumber(){
    	int countA = 0;
    	if(accountHolderNum == 0) {
    		return 1;
    	} else {
    		for(int x = 0; x < accountHolderNum; x++) {
        		countA += accountHolder[x].getNumberOfCheckingAccounts();
        	}
        	for(int x = 0; x < accountHolderNum; x++) {
        		countA += accountHolder[x].getNumberOfSavingsAccounts();
        	}
        	for(int x = 0; x < accountHolderNum; x++) {
        		countA += accountHolder[x].getNumberOfCDAccounts();
        	}
            return countA + 1;
    	}
    }

    /*
    * Did not use method. Should have been used in getBestCDOffering method, not needed.
    static double futureValue(double presentValue, double interestRate, int term){}
    */
}
