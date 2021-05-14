package gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import controller.Controller;
import entities.User;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class RegisterWindow extends JFrame {

	private JPanel contentPane;
	private JTextField nameTextField;
	private JTextField surnameTextField;
	private JTextField emailTextField;
	private JPasswordField passwordField;
	
	private Controller softwareController;

	public RegisterWindow(Controller softwareController) {
		this.softwareController = softwareController;
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegisterWindow.class.getResource("/icone/password_16.png")));
		setTitle("Easy Password Manager - Create Account");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel welcomeLabel = new JLabel("Welcome to Easy Password Manager!");
		welcomeLabel.setIconTextGap(20);
		welcomeLabel.setIcon(new ImageIcon(RegisterWindow.class.getResource("/icone/passwordManager_64.png")));
		welcomeLabel.setFont(new Font("Consolas", Font.PLAIN, 25));
		welcomeLabel.setBounds(111, 11, 605, 83);
		contentPane.add(welcomeLabel);
		
		JLabel createAccountLabel = new JLabel("Enter your info to get started");
		createAccountLabel.setIconTextGap(20);
		createAccountLabel.setIcon(null);
		createAccountLabel.setFont(new Font("Consolas", Font.PLAIN, 20));
		createAccountLabel.setBounds(215, 89, 338, 43);
		contentPane.add(createAccountLabel);
		
		nameTextField = new JTextField();
		nameTextField.setHorizontalAlignment(SwingConstants.CENTER);
		nameTextField.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		nameTextField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		nameTextField.setBounds(47, 216, 131, 20);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setFont(new Font("Consolas", Font.PLAIN, 15));
		nameLabel.setBounds(88, 198, 46, 14);
		contentPane.add(nameLabel);
		
		surnameTextField = new JTextField();
		surnameTextField.setHorizontalAlignment(SwingConstants.CENTER);
		surnameTextField.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		surnameTextField.setColumns(10);
		surnameTextField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		surnameTextField.setBounds(318, 216, 131, 20);
		contentPane.add(surnameTextField);
		
		JLabel surnameLabel = new JLabel("Surname");
		surnameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		surnameLabel.setFont(new Font("Consolas", Font.PLAIN, 15));
		surnameLabel.setBounds(346, 198, 70, 14);
		contentPane.add(surnameLabel);
		
		emailTextField = new JTextField();
		emailTextField.setHorizontalAlignment(SwingConstants.CENTER);
		emailTextField.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		emailTextField.setColumns(10);
		emailTextField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		emailTextField.setBounds(585, 216, 131, 20);
		contentPane.add(emailTextField);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setHorizontalAlignment(SwingConstants.CENTER);
		emailLabel.setFont(new Font("Consolas", Font.PLAIN, 15));
		emailLabel.setBounds(626, 198, 46, 14);
		contentPane.add(emailLabel);
		
		JLabel lblMasterPassword = new JLabel("Master Password");
		lblMasterPassword.setToolTipText("");
		lblMasterPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblMasterPassword.setFont(new Font("Consolas", Font.PLAIN, 17));
		lblMasterPassword.setBounds(304, 266, 159, 31);
		contentPane.add(lblMasterPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		passwordField.setBounds(322, 296, 124, 20);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Go!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//Create a new user object from the text fields 
				User newUser = new User(nameTextField.getText(),surnameTextField.getText(),passwordField.getText(),emailTextField.getText());

				//if all the textfields are not empty insert the new user in the database
				if(!nameTextField.getText().isBlank() && !surnameTextField.getText().isBlank() && !passwordField.getText().isBlank() && !emailTextField.getText().isBlank()) 
				{
					boolean result = softwareController.createUser(newUser);
					
					if(result) 
					{
						JOptionPane.showMessageDialog(null, "User successfully created");
						
						softwareController.openLoginWindow();
					}
					else
						JOptionPane.showMessageDialog(null, "ERROR: User not created");
				}
				//if at least one field is empty the user is not inserted and an error is shown
				else if(nameTextField.getText().isBlank() || surnameTextField.getText().isBlank() || passwordField.getText().isBlank() || emailTextField.getText().isBlank()) 
				{
					JOptionPane.showMessageDialog(null, "All the text fields have to be compiled","Unable to create a new User",JOptionPane.ERROR_MESSAGE);
					clearTextFields();
				}
			}
		});
		
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnNewButton.setBounds(345, 380, 78, 31);
		contentPane.add(btnNewButton);
	}
	
	//OTHER METHODS
		private void clearTextFields()
		{
			nameTextField.setText("");
			surnameTextField.setText("");
			passwordField.setText("");
			emailTextField.setText("");
		}
}

