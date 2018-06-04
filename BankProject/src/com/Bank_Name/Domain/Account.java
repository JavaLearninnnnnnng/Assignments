package com.Bank_Name.Domain;

public class Account {
	private int id;
	private Bank bank;
	private Patron patron;
	public int getId() {
		return id;
	}
	public Bank getBank() {
		return bank;
	}
	public Patron getPatron() {
		return patron;
	}
	public Account() {
		
	}
	public Account(int id, Bank bank, Patron patron) {
		this.id = id;
		this.bank = bank;
		this.patron = patron;
	}
	
}
