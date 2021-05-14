package controller;

import dao.*;
import entities.User;
import gui.*;

public class Controller {
	
	//ATTRIBUTES
	UserDAO userDAO;
	LoginWindow loginWindow;
	RegisterWindow registerWindow;
	MainWindow mainWindow;
	
	//CONSTRUCTOR
	public Controller(UserDAO userDAO) 
	{
		this.userDAO = userDAO;
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
	
	public void openMainWindow() 
	{
		loginWindow.setVisible(false);
		
		mainWindow = new MainWindow();
		mainWindow.setVisible(true);
	}
	
	public String getUserFirstName() 
	{
		return userDAO.getUserFirstName();
	}
	
	public boolean login(String insertedMasterPassword) 
	{
		return userDAO.login(insertedMasterPassword);
	}
	//DEBUG METHODS
}
