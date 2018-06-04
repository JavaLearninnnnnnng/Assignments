package com.Bank_Name.Domain;

import java.util.Scanner;

import com.bank.bankproject.dao.BankRepository;

public class BankManagement {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankRepository objBkRps = new BankRepository();
		Patron objPatron = new Patron(126, "Vamsi1", null);
		Bank objBank = new Bank(16, "ABCD");
		Account objAccount = new Account(101, objBank, objPatron);
		Transaction objTransaction = new Transaction(111, objAccount, 1000, AccountType.CREDIT);
		System.out.println("Adding a bank");
		System.out.println("Removing a bank");
		objBkRps.remove(objBank);
		System.out.println("Removing Patron");
		objBkRps.remove(objPatron);
		objBkRps.remove(objPatron);
		objBkRps.add(objBank);
		System.out.println("Executing the below actions a. Adding a Patron\tb.Removing a Patron\tc.Search for a Patron by id"
				+ "\td.Searching for a patron using name\te.Recording a transaction\tf.Adding a bank"
				+ "\tg.Removing a bank\th.Updating a bank\ti.Finding a bank by id\tj.Adding an account"
				+ "\tk.Updating an account\tl.Deleting an account\tm.Finding an account by id");
			System.out.println("Adding Patron");
			objBkRps.add(objPatron);

		System.out.println("Recording a transaction");
		objBkRps.transact(objTransaction);
		
		System.out.println("Updating a bank");
		objBkRps.update(objBank);
		
		System.out.println("Searching for Patron by id");
		objBkRps.findPatron(objPatron.getId());
		System.out.println("Searching for a patron using name");
		objBkRps.findPatron(objPatron.getName());
		
		System.out.println("Finding a bank by id");
		objBkRps.findBank(objBank);
		
		System.out.println("Finding a bank by name");
		objBkRps.findBank(objBank.getName());
		
		System.out.println("Adding an account");
		objBkRps.add(objAccount);
		
		System.out.println("Updating an account");
		objBkRps.update(objAccount);
		System.out.println("Finding an account by id"); 
		objBkRps.findAccount(objAccount.getId());
		
		System.out.println("Removing a bank");
		objBkRps.remove(objBank);
		System.out.println("Removing Patron");
		objBkRps.remove(objPatron);
	}

}
