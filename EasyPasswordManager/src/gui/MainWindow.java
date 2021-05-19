package gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;

import org.eclipse.ui.internal.handlers.NewEditorHandler;

import controller.Controller;
import entities.Credentials;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JTextField websiteTextField;
	private JTextField emailTextField;
	private JTextField usernameTextField;
	private JTextField passwordTextField;
	private JTextField emailFakeLabel;
	private JTextField usernameFakeLabel;
	private JTextField passwordFakeLabel;

	public MainWindow(Controller softwareController) 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/icone/password_16.png")));
		setTitle("Easy Password Manager");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel easyPasswordManagerLabel = new JLabel("Easy Password Manager");
		easyPasswordManagerLabel.setIconTextGap(50);
		easyPasswordManagerLabel.setIcon(null);
		easyPasswordManagerLabel.setFont(new Font("Consolas", Font.PLAIN, 25));
		easyPasswordManagerLabel.setBounds(487, 11, 300, 48);
		contentPane.add(easyPasswordManagerLabel);
		
		JLabel newCredentialsLabel = new JLabel("Add new login credentials:");
		newCredentialsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		newCredentialsLabel.setFont(new Font("Consolas", Font.PLAIN, 25));
		newCredentialsLabel.setBounds(10, 101, 603, 41);
		contentPane.add(newCredentialsLabel);
		
		JLabel findCredentialsLabel = new JLabel("Find existing credentials:");
		findCredentialsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		findCredentialsLabel.setFont(new Font("Consolas", Font.PLAIN, 25));
		findCredentialsLabel.setBounds(661, 101, 603, 41);
		contentPane.add(findCredentialsLabel);
		
		websiteTextField = new JTextField();
		websiteTextField.setHorizontalAlignment(SwingConstants.CENTER);
		websiteTextField.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		websiteTextField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		websiteTextField.setBounds(240, 217, 150, 20);
		contentPane.add(websiteTextField);
		websiteTextField.setColumns(10);
		
		JLabel websiteNameLabel = new JLabel("Website Name");
		websiteNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		websiteNameLabel.setFont(new Font("Consolas", Font.PLAIN, 13));
		websiteNameLabel.setBounds(240, 196, 150, 20);
		contentPane.add(websiteNameLabel);
		
		emailTextField = new JTextField();
		emailTextField.setHorizontalAlignment(SwingConstants.CENTER);
		emailTextField.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		emailTextField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		emailTextField.setColumns(10);
		emailTextField.setBounds(240, 290, 150, 20);
		contentPane.add(emailTextField);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setHorizontalAlignment(SwingConstants.CENTER);
		emailLabel.setFont(new Font("Consolas", Font.PLAIN, 13));
		emailLabel.setBounds(240, 269, 150, 20);
		contentPane.add(emailLabel);
		
		usernameTextField = new JTextField();
		usernameTextField.setHorizontalAlignment(SwingConstants.CENTER);
		usernameTextField.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		usernameTextField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		usernameTextField.setColumns(10);
		usernameTextField.setBounds(240, 369, 150, 20);
		contentPane.add(usernameTextField);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usernameLabel.setFont(new Font("Consolas", Font.PLAIN, 13));
		usernameLabel.setBounds(240, 348, 150, 20);
		contentPane.add(usernameLabel);
		
		passwordTextField = new JTextField();
		passwordTextField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordTextField.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		passwordTextField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		passwordTextField.setColumns(10);
		passwordTextField.setBounds(240, 444, 150, 20);
		contentPane.add(passwordTextField);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setFont(new Font("Consolas", Font.PLAIN, 13));
		passwordLabel.setBounds(240, 423, 150, 20);
		contentPane.add(passwordLabel);
	
		JLabel selectWebsiteLabel = new JLabel("Select Website");
		selectWebsiteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		selectWebsiteLabel.setFont(new Font("Consolas", Font.PLAIN, 13));
		selectWebsiteLabel.setBounds(889, 196, 150, 20);
		contentPane.add(selectWebsiteLabel);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblEmail.setBounds(889, 270, 150, 20);
		contentPane.add(lblEmail);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblUsername.setBounds(889, 354, 150, 20);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblPassword.setBounds(889, 445, 150, 20);
		contentPane.add(lblPassword);
		
		emailFakeLabel = new JTextField();
		emailFakeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		emailFakeLabel.setText("My email");
		emailFakeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		emailFakeLabel.setFont(new Font("Consolas", Font.PLAIN, 20));
		emailFakeLabel.setEditable(false);
		emailFakeLabel.setColumns(10);
		emailFakeLabel.setBorder(null);
		emailFakeLabel.setBounds(781, 291, 372, 29);
		contentPane.add(emailFakeLabel);
		
		usernameFakeLabel = new JTextField();
		usernameFakeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		usernameFakeLabel.setText("My Username");
		usernameFakeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usernameFakeLabel.setFont(new Font("Consolas", Font.PLAIN, 20));
		usernameFakeLabel.setEditable(false);
		usernameFakeLabel.setColumns(10);
		usernameFakeLabel.setBorder(null);
		usernameFakeLabel.setBounds(781, 377, 372, 29);
		contentPane.add(usernameFakeLabel);
		
		passwordFakeLabel = new JTextField();
		passwordFakeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		passwordFakeLabel.setText("My Password");
		passwordFakeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordFakeLabel.setFont(new Font("Consolas", Font.PLAIN, 20));
		passwordFakeLabel.setEditable(false);
		passwordFakeLabel.setColumns(10);
		passwordFakeLabel.setBorder(null);
		passwordFakeLabel.setBounds(781, 473, 372, 29);
		contentPane.add(passwordFakeLabel);
		
		JComboBox<Credentials> websiteComboBox = new JComboBox<Credentials>();
		websiteComboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		websiteComboBox.setFont(new Font("Consolas", Font.PLAIN, 12));
		websiteComboBox.setBackground(Color.WHITE);
		websiteComboBox.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		websiteComboBox.setBounds(873, 214, 178, 22);
		websiteComboBox.setUI(new BasicComboBoxUI());
		websiteComboBox.setModel(new DefaultComboBoxModel<Credentials>());
		
		websiteComboBox.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		        int selectedIndex = websiteComboBox.getSelectedIndex();
		    	
		    	emailFakeLabel.setText(websiteComboBox.getItemAt(selectedIndex).getEmail());
		    	usernameFakeLabel.setText(websiteComboBox.getItemAt(selectedIndex).getUsername());
		    	passwordFakeLabel.setText(websiteComboBox.getItemAt(selectedIndex).getPassword());
		    }
		});
		
		//Populate the website comboBox with the data from the database
		for(Credentials c: softwareController.getAllCredentials())
			websiteComboBox.addItem(c);
		
		contentPane.add(websiteComboBox);
		
		JButton addButton = new JButton("Add");
		addButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				addButton.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				addButton.setBackground(Color.WHITE);
			}
		});
		addButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//If all the text fields are compiled
				if(!websiteTextField.getText().isBlank() && !emailTextField.getText().isBlank() && !usernameTextField.getText().isBlank() && !passwordTextField.getText().isBlank())
				{
					//Create a new credentials object from the text fields
					Credentials newCredentials = new Credentials(websiteTextField.getText(), emailTextField.getText(), usernameTextField.getText(), passwordTextField.getText());
					
					//insert the credentials in the database
					boolean result = softwareController.insertNewCredentials(newCredentials);
					
					if(result) 
					{
						JOptionPane.showMessageDialog(null, "New credentials added");
					}
					else 
						JOptionPane.showMessageDialog(null,"Error adding these new credentials!\nCheck if you already have saved them","Error", JOptionPane.ERROR_MESSAGE);
				
					clearCredentialsFields();
					
					//Refresh the window to update the comboBox
					softwareController.refreshMainWindow(MainWindow.this);
				}
				
				//If at least one text field is blank then display en error
				else if(websiteTextField.getText().isBlank() || emailTextField.getText().isBlank() || usernameTextField.getText().isBlank() || passwordTextField.getText().isBlank())
					JOptionPane.showMessageDialog(null, "All the fields must be compiled", "Error", JOptionPane.ERROR_MESSAGE);

				
			}
		});
		addButton.setBackground(Color.WHITE);
		addButton.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		addButton.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		addButton.setBounds(286, 505, 59, 33);
		contentPane.add(addButton);
		
		JLabel createdByLabel = new JLabel("Created By Davide Soldatini");
		createdByLabel.setHorizontalAlignment(SwingConstants.LEFT);
		createdByLabel.setFont(new Font("Consolas", Font.PLAIN, 13));
		createdByLabel.setBounds(10, 660, 290, 20);
		contentPane.add(createdByLabel);
		
		JLabel versionLabel = new JLabel("v2.0");
		versionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		versionLabel.setFont(new Font("Consolas", Font.PLAIN, 13));
		versionLabel.setBounds(970, 660, 280, 20);
		contentPane.add(versionLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBorder(new LineBorder(Color.LIGHT_GRAY));
		separator.setBounds(636, 168, 1, 369);
		contentPane.add(separator);
	}
	
	//OTHER METHODS
	private void clearCredentialsFields() 
	{
		websiteTextField.setText("");
		emailTextField.setText("");
		usernameTextField.setText("");
		passwordTextField.setText("");
	}
}
