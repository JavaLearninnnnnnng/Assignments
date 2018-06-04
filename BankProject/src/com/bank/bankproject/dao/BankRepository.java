package com.bank.bankproject.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.Bank_Name.Domain.Account;
import com.Bank_Name.Domain.AccountType;
import com.Bank_Name.Domain.Bank;
import com.Bank_Name.Domain.Patron;
import com.Bank_Name.Domain.Transaction;


enum Result {Success, fail};

public class BankRepository 
{
	ResultSet rs = null;  
	String strDummy = null;
	QueryString_MSSQL objQueryString = new QueryString_MSSQL();
	Patron objPatron = new Patron();
	//	Adds a new record in the Patron table.
  public Result add(Patron objPatron)
	{
		strDummy = "insert into Patron values ("+objPatron.getId() +",'"+objPatron.getName() +"', null)";
		return objQueryString.connectingToDatabase(strDummy);
		
	}
	//	Deletes a record from the Patron table.
  public Result remove(Patron objPatron) 
	{
		strDummy = "delete from Patron where id = "+objPatron.getId();
		return objQueryString.connectingToDatabase(strDummy);
	}
	//Updates a record in the Patron table.
  public Result update(Patron objPatron) {
		strDummy = "delete from Patron where name = "+objPatron.getName();
		return objQueryString.connectingToDatabase(strDummy);
	}
	
	//	Finds a patron by id	
  public Patron findPatron(int id) {
		strDummy = "Select * from Patron  where id = "+id;
		rs = objQueryString.connectingToDatabase(strDummy,1);
		// Iterate through the data in the result set and display it.  
		try {
			while (rs.next()) 
			{  
				if(rs.getString(2)!= null && rs.getBytes(3)!= null) {
				objPatron = new Patron(rs.getInt(1), rs.getString(2), rs.getBytes(3));
				System.out.println(objPatron.getId() + objPatron.getName() + objPatron.getImage());  
				}
				else
					System.out.println("Not found");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objPatron;  
	}
	//Finds a patron by name
	
  public List<Patron> findPatron(String name)
	{
		strDummy = "Select * from Patron where name = " +name;
		List<Patron> objList = new LinkedList<Patron>();
		rs = objQueryString.connectingToDatabase(strDummy,1);
		// Iterate through the data in the result set and display it.  
		try {
			while (rs.next()) 
			{  
				if(rs.getString(2)!= null && rs.getBytes(3)!= null) {
				objPatron = new Patron(rs.getInt("id"), rs.getString("name"), rs.getBytes("patron_Image"));
				objList.add(objPatron);
				System.out.println(rs.getString(1) + " " + rs.getString(3));
				}
				else
					System.out.println("Not found");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objList; 		
	}
	
	//Adds a record to the transaction table.
  public Result transact(Transaction objTransaction) {
		strDummy = "insert into trans values ("+objTransaction.getId() +","+objTransaction.getAccount().getId()+","+objTransaction.getAmount()+", 'CREDIT')";
		return objQueryString.connectingToDatabase(strDummy);
	}
	
	//Finds a transaction record by id
  public Transaction findTransaction(int id) {
		strDummy = "Select * from trans where id = "+id;
		Transaction objTransaction = new Transaction();
		rs = objQueryString.connectingToDatabase(strDummy,1);
		// Iterate through the data in the result set and display it.  
		try {
			while (rs.next()) 
			{  
				objTransaction = new Transaction(rs.getInt("id"), findAccount(id), 
						rs.getDouble("amount"), rs.getString("transType") == "CREDIT" ?  AccountType.CREDIT : AccountType.DEBIT);
				System.out.println(rs.getString(1) + " " + rs.getString(3));  
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objTransaction; 
	}
	//	Adds a record to the bank table
  public Result add(Bank objBank) 
	{
		strDummy = "insert into Bank values ("+objBank.getId() +",'"+objBank.getName() +"')";
		return objQueryString.connectingToDatabase(strDummy);
	}
	//	Deletes a record from the bank table
  public Result remove(Bank objBank) {
		strDummy = "Delete from Bank where  id = "+objPatron.getId() +";";
		return objQueryString.connectingToDatabase(strDummy);
	}
	//	Updates a record in the Bank table.
  public Result update(Bank objBank) {
		strDummy = "update bank set name = '"+ objBank.getName() +"'where id = 1;";
		return objQueryString.connectingToDatabase(strDummy);
	}
	//	Finds a bank by id
  public Bank findBank(Bank objBank) {
		strDummy = "Select * from Bank where id = "+ objBank.getId();
		rs = objQueryString.connectingToDatabase(strDummy,1);
		// Iterate through the data in the result set and display it.  
		try {
			while (rs.next()) 
			{  
				objBank = new Bank(rs.getInt("id"), rs.getString("name"));
				System.out.println(objBank.getName());  
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objBank;  
	}
	//	Returns a list of bank by name	
  public List<Bank> findBank(String name){
		strDummy = "Select * from Bank where name = "+ name;
		List<Bank> lstBank = new LinkedList<Bank>();
		rs = objQueryString.connectingToDatabase(strDummy,1);
		// Iterate through the data in the result set and display it.  
		try {
			while (rs.next()) 
			{  
				Bank objBank = new Bank(rs.getInt("id"), rs.getString("name"));
				System.out.println(objBank.getName());  
				lstBank.add(objBank);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lstBank;  
	}
	//	Adds a record in the Account table
  public Result add(Account objAccount) {
		strDummy = "insert into Account values ("+objAccount.getId() +","+objAccount.getBank() +","+ objAccount.getPatron()+")";
		return objQueryString.connectingToDatabase(strDummy);
	}
	//	Updates a record in the Account table
  public Result update(Account objAccount) {
		strDummy = "update Account set bank_id = "+ objAccount.getBank()+", patron_id =" +objAccount.getPatron()+"where id ="+objAccount.getId()+")";
		return objQueryString.connectingToDatabase(strDummy);
	}
	//	Deletes a record in the Account table
  public Result delete(Account objAccount) {
		strDummy = "Delete from Account where id = "+objAccount.getId() +")";
		return objQueryString.connectingToDatabase(strDummy);
	}
	//	Finds an account by id.
  public Account findAccount(int id) 
	{
		Account objAccount = new Account();
		strDummy = "Select * from Account where id = "+ id;
		rs = objQueryString.connectingToDatabase(strDummy,1);
		// Iterate through the data in the result set and display it.  
		try {
			while (rs.next()) 
			{  
				int pId = rs.getInt("patron_id");
				int bId = rs.getInt("bank_id");
				objAccount =  new Account(rs.getInt("id"), (Bank) findBank(new Bank(bId," ")), (Patron) findPatron(pId));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objAccount;  
}
}
