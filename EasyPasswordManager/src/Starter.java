import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

import controller.Controller;
import dao.UserDAO;
import gui.LoginWindow;

public class Starter {

	public static void main(String[] args) {
		
		//Sets default settings for the UI
		UIManager.put("Button.focus", new ColorUIResource(new Color(0, 0, 0, 0)));
		UIManager.put("OptionPane.messageFont", new Font("Consolas", Font.PLAIN, 15));
		
		//Get the connection to the database
		Connection currentConnection = DbConnectionManager.getDatabaseConnection();
		
		//Inizialize the DAO classes to comunicate with the database
		UserDAO userDAO = new UserDAO(currentConnection);
		
		//Inizialize the controller of the software
		Controller softwareController = new Controller(userDAO);
		
		//userDAO.clearUserTable();
		
		softwareController.startSoftware();
	
		//userDAO.showUserTable();
	}

}
