package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entities.Credentials;


public class CredentialsDAO {

	//ATTRIBUTES
	Connection currentConnection;
	
	//CONSTRUCTOR
	public CredentialsDAO(Connection databaseConnection) 
	{
		currentConnection = databaseConnection;
	}
	
	//Returns true if the new credentials are succesfully inserted in the database, false otherwise.
	public boolean insertNewCredential(Credentials newCredentials) 
	{
		boolean flag = false;
		
		try 
		{
			PreparedStatement insertNewCredentialPS = currentConnection.prepareStatement("INSERT INTO Credentials VALUES(?,?,?,?)");
			insertNewCredentialPS.setString(1, newCredentials.getWebsite());
			insertNewCredentialPS.setString(2, newCredentials.getEmail());
			insertNewCredentialPS.setString(3, newCredentials.getUsername());
			insertNewCredentialPS.setString(4, newCredentials.getPassword());
			
			int result = insertNewCredentialPS.executeUpdate();
			
			if(result == 1) 
			{
				System.out.println("New credentials inserted succesfully\n");
				flag = true;
			}		
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return flag;
	}
	
	//DEBUG METHODS
	
	//Show all the rows in Credentials table of the Database
	public void showCredentialsTable() 
	{
		try 
		{
			Statement stmt = currentConnection.createStatement();
			
			ResultSet result = stmt.executeQuery("SELECT * FROM Credentials");
			
			System.out.println("Credentials table rows:\nWEBSITE | EMAIL | USERNAME | PASSWORD\n");
			
			while(result.next())
				System.out.println(result.getString("website") + " | " + result.getString("email") + " | " + result.getString("username") + " | " + result.getString("pass"));
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	//Remove all the rows from Credentials table
	public void clearCredentialsTable() 
	{
		try 
		{
			Statement stmt = currentConnection.createStatement();
			
			int result = stmt.executeUpdate("DELETE FROM Credentials");
			
			if(result >= 1)
				System.out.println("Credentials table cleared\n");
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
