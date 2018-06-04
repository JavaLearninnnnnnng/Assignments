package com.bank.bankproject.dao;
import java.sql.*;  


public class QueryString_MSSQL {

	Result connectingToDatabase(String SQLstatement){  

		// Create a variable for the connection string.  
		String connectionUrl = "jdbc:sqlserver://localhost:1433;" +  
				"databaseName=Bank; user=sa; password = 123";

		// Declare the JDBC objects.  
		Connection con = null;  
		Statement stmt = null;  
		Result r = Result.fail;
		try {  
			// Establish the connection.  
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
			con = DriverManager.getConnection(connectionUrl);  
			// Create and execute an SQL statement that returns some data.  
			stmt = con.createStatement();  
			r = (stmt.execute(SQLstatement)) ? Result.Success : Result.fail;
		}  
		catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) {  
			e.printStackTrace(); 
		}  
		finally {  
			if (stmt != null) try { stmt.close(); } catch(Exception e) {}  
			if (con != null) try { con.close(); } catch(Exception e) {}  
		}  
		return r;
	}  


	//Over loading the function to return result set to display
	ResultSet connectingToDatabase(String SQLstatement,  int i){  
		// Create a variable for the connection string.  
		String connectionUrl = "jdbc:sqlserver://localhost:1433;" +  
				"databaseName=Bank; user=sa; password = 123";

		// Declare the JDBC objects.  
		Connection con = null;  
		Statement stmt = null;  
		ResultSet rs = null;  
		try {  
			// Establish the connection.  
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
			con = DriverManager.getConnection(connectionUrl);  

			// Create and execute an SQL statement that returns some data.  
			stmt = con.createStatement();  
			rs = stmt.executeQuery(SQLstatement);  
			return rs;
		}
		catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}
		// Handle any errors that may have occurred.  
		catch (Exception e) {  
			e.printStackTrace(); 
		}  
		finally {  
			if (stmt != null) try { stmt.close(); } catch(Exception e) {}  
			if (con != null) try { con.close(); } catch(Exception e) {}  
		}  
		return rs;
	} 
}  