package com.Bank_Name.Domain;

public class Bank {
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Bank(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
}
