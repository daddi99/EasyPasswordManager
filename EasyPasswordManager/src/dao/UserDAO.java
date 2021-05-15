package dao;

import java.sql.*;

import javax.swing.JOptionPane;

import entities.User;

public class UserDAO {

	//ATTRIBUTES
	Connection currentConnection;	
	PreparedStatement insertUserPS;

	//CONSTRUCTOR
	public UserDAO(Connection databaseConnection)
	{
		currentConnection = databaseConnection;
	}

	//METHODS
	
	//Returns true if the user already exists, false otherwise
	public boolean checkUserExistence() 
	{
		boolean flag = false;
		try 
		{
			Statement stmt = currentConnection.createStatement();
			
			//if the table user_info has at least one row this means that the user is already registered
			ResultSet result = stmt.executeQuery("SELECT count(*) as rows FROM User_Info");

			result.next();
			
			if(result.getInt("rows") == 1)
				flag = true;
				
		} catch (SQLException e) 
		{
			e.printStackTrace();
			System.out.println("Exception in UserDAO.checkUserCreated\n");
		} 
		
		return flag;
	}
	
	public boolean insertNewUser(User newUser) 
	{
		boolean flag = false;
		try 
		{
			PreparedStatement insertNewUserPS = currentConnection.prepareStatement("INSERT INTO User_Info VALUES(?,?,?,?)");
			insertNewUserPS.setString(1, newUser.getName());
			insertNewUserPS.setString(2, newUser.getSurname());
			insertNewUserPS.setString(3, newUser.getMasterPassword());
			insertNewUserPS.setString(4, newUser.getEmail());
			
			int result = insertNewUserPS.executeUpdate();
			
			if(result == 1) 
			{
				System.out.println("New user created");
				flag = true;
			}
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return flag;
	}
	
	//Return the first name of the user
	public String getUserFirstName() 
	{
		String firstName = null;
		try 
		{
			Statement stmt = currentConnection.createStatement();
			
			ResultSet result = stmt.executeQuery("SELECT name FROM User_Info");
			
			result.next();
			 
			firstName = result.getString("name");
			
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return firstName;
	}
	
	//Compare the master password inserted to the master password in the database, return true if it corrisponds false otherwise
	public boolean login(String insertedMasterPassword) 
	{
		boolean flag = false;
		try 
		{
			Statement stmt = currentConnection.createStatement();
			
			ResultSet result = stmt.executeQuery("SELECT masterPassword FROM User_Info");
			
			result.next();
			
			String correctMasterPassword = result.getString("masterPassword");
			
			if(insertedMasterPassword.equals(correctMasterPassword)) 
			{
				flag = true;
				System.out.println("Login done...\n");
			}	
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return flag;
	}
	
	//DEBUG METHODS
	
	//show all the rows in the table User_Info (should be only one)
	public void showUserTable() 
	{
		try 
		{
			Statement stmt = currentConnection.createStatement();
			
			ResultSet result = stmt.executeQuery("SELECT * FROM User_Info");
			
			System.out.println("User_Info table rows:\nNAME | SURNAME | MASTERPASSWORD | EMAIL\n");
			
			while(result.next())
				System.out.println(result.getString("name") + " | " + result.getString("surname") + " | " + result.getString("masterPassword") + " | " + result.getString("email"));
			
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Remove all the rows from User_Info table
	public void clearUserTable() 
	{
		try 
		{
			Statement stmt = currentConnection.createStatement();
			
			int result = stmt.executeUpdate("DELETE FROM User_Info");
			
			if(result == 1)
				System.out.println("User table cleared\n");
			
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
