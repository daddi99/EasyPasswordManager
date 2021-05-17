package controller;

import java.util.ArrayList;

import dao.*;
import entities.Credentials;
import entities.User;
import gui.*;

public class Controller {
	
	//ATTRIBUTES
	UserDAO userDAO;
	CredentialsDAO credentialsDAO;
	
	LoginWindow loginWindow;
	RegisterWindow registerWindow;
	MainWindow mainWindow;
	
	//CONSTRUCTOR
	public Controller(UserDAO userDAO, CredentialsDAO credentialsDAO) 
	{
		this.userDAO = userDAO;
		this.credentialsDAO = credentialsDAO;
	}

	//METHODS
	
	//if the user already exists opens the login windows, otherwise the register window
	public void startSoftware() 
	{
		if(userDAO.checkUserExistence()) 
		{
			System.out.println("User found in the database, waiting for the login...\n");
			loginWindow = new LoginWindow(this);
			loginWindow.setVisible(true);
		}
		else if(!userDAO.checkUserExistence()) 
		{
			registerWindow = new RegisterWindow(this);
			registerWindow.setVisible(true);
			System.out.println("User not found in the database, starting the registration process...\n");
		}
			
	}
	
	//Create the user to start using the software
	public boolean createUser(User newUser) 
	{
		return userDAO.insertNewUser(newUser);
	}
	
	//Switch from the registration windows to the login window
	public void openLoginWindow() 
	{
		registerWindow.setVisible(false);
		
		loginWindow = new LoginWindow(this);
		loginWindow.setVisible(true);
	}
	
	//Switch from the login window to the main window
	public void openMainWindow() 
	{
		loginWindow.setVisible(false);
		
		mainWindow = new MainWindow(this);
		mainWindow.setVisible(true);
	}
	
	//Get the name of the user
	public String getUserFirstName() 
	{
		return userDAO.getUserFirstName();
	}
	
	public boolean login(String insertedMasterPassword) 
	{
		return userDAO.login(insertedMasterPassword);
	}
	
	public boolean insertNewCredentials(Credentials newCredentials) 
	{
		return credentialsDAO.insertNewCredential(newCredentials);
	}
	
	public ArrayList<Credentials> getAllCredentials()
	{
		return credentialsDAO.getAllCredentials();
	}
}
