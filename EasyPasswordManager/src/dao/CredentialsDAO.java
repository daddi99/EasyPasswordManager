package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
	
	//Returns all the rows of the credentials table as an ArrayList<Credentials>
	public ArrayList<Credentials> getAllCredentials()
	{
		ArrayList<Credentials> credentialsArray = new ArrayList<Credentials>();
		
		try 
		{
			Statement stmt = currentConnection.createStatement();
			
			ResultSet result = stmt.executeQuery("SELECT * FROM Credentials");
			
			//For each row of the table create a temp Credentials object and adds it to the arraylist
			while(result.next()) 
			{
				String website = result.getString("website");
				String email = result.getString("email");
				String username = result.getString("username");
				String password = result.getString("pass");
				
				Credentials tmpCredentials = new Credentials(website, email, username, password);
				
				credentialsArray.add(tmpCredentials);
			}	
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return credentialsArray;
	}
	
	//Remove a single row of the credentials table
	public boolean removeCredentials(Credentials credentialsToRemove) 
	{
		boolean flag = false;
		
		try 
		{
			PreparedStatement removeCredentialsPS = currentConnection.prepareStatement("DELETE FROM Credentials WHERE website = ? AND email = ? AND username = ? AND pass = ?");

			removeCredentialsPS.setString(1, credentialsToRemove.getWebsite());
			removeCredentialsPS.setString(2, credentialsToRemove.getEmail());
			removeCredentialsPS.setString(3, credentialsToRemove.getUsername());
			removeCredentialsPS.setString(4, credentialsToRemove.getPassword());
			
			int result = removeCredentialsPS.executeUpdate();
			
			if(result == 1) 
			{
				flag = true;
				System.out.println("Credentials deleted\n");
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
