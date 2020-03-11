package com.meritamerica.assignment3;

public class MeritAmericaBankApp {
	public static void main(String[] args) {
		//MeritBank.readFromFile("src/test/testMeritBank_good.txt");
		CheckingAccount ch1 = new CheckingAccount();
		CheckingAccount ch2 = new CheckingAccount(500);
		SavingsAccount sv1 = new SavingsAccount();
		SavingsAccount sv2 = new SavingsAccount(500);
		CDOffering of1 = new CDOffering(1, 0.21);
		CDAccount cda1 = new CDAccount(of1, 500);
		AccountHolder ah1 = new AccountHolder();
		MeritBank.addAccountHolder(ah1);
		ah1.addCDAccount(cda1);
		ah1.addCheckingAccount(ch1);
		ah1.addCheckingAccount(ch2);
		ah1.addSavingsAccount(sv1);
		ah1.addSavingsAccount(sv2);
		AccountHolder ah2 = new AccountHolder();
		MeritBank.addAccountHolder(ah2);
		ah2.addSavingsAccount(sv2);
		AccountHolder ah3 = new AccountHolder();
		MeritBank.addAccountHolder(ah3);
		ah3.addCheckingAccount(5000);
		AccountHolder ah4 = new AccountHolder();
		MeritBank.addAccountHolder(ah4);
		ah4.addCheckingAccount(2000);
		AccountHolder array1[] = MeritBank.getAccountHolders();
		for(int x = 0; x < MeritBank.accountHolderNum; x++) {
			System.out.println(array1[x].getCombinedBalance());
		}
		System.out.println("-----------------------------------");
		MeritBank.sortAccountHolders();
		array1 = MeritBank.getAccountHolders();
		for(int x = 0; x < MeritBank.accountHolderNum; x++) {
			System.out.println(array1[x].getCombinedBalance());
		}
	}
}