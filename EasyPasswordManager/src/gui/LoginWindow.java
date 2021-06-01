package gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;

import controller.Controller;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class LoginWindow extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	
	public LoginWindow(Controller softwareController) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginWindow.class.getResource("/icone/password_16.png")));
		setTitle("Easy Password Manager - Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		String userFirstName = softwareController.getUserFirstName();
				
		JLabel hiLabel = new JLabel("Hi, " + userFirstName);
		hiLabel.setHorizontalAlignment(SwingConstants.CENTER);
		hiLabel.setFont(new Font("Consolas", Font.PLAIN, 30));
		hiLabel.setBounds(10, 36, 694, 49);
		contentPane.add(hiLabel);
		
		JLabel masterPasswordLabel = new JLabel("Master Password");
		masterPasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		masterPasswordLabel.setFont(new Font("Consolas", Font.PLAIN, 15));
		masterPasswordLabel.setBounds(260, 186, 197, 34);
		contentPane.add(masterPasswordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("Consolas", Font.PLAIN, 13));
		passwordField.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		passwordField.setBounds(279, 215, 156, 20);
		contentPane.add(passwordField);
		
		JButton loginButton = new JButton("Login");
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				loginButton.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				loginButton.setBackground(Color.WHITE);
			}
		});
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean loginCheck = softwareController.login(passwordField.getText());
				
				if(loginCheck) 
				{
					softwareController.openMainWindow();
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Incorrect Master Password, try again","Login Failed",JOptionPane.ERROR_MESSAGE);
					passwordField.setText("");
				}
			}
		});
		loginButton.setBackground(Color.WHITE);
		loginButton.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		loginButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		loginButton.setBounds(317, 333, 79, 25);
		contentPane.add(loginButton);
		
		JButton showPasswordButton = new JButton("");
		showPasswordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		showPasswordButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) 
			{
				//Show the content of the password field
				passwordField.setEchoChar((char)0);
			}
			@Override
			public void mouseReleased(MouseEvent e) 
			{
				passwordField.setEchoChar('*');
			}
		});
		showPasswordButton.setContentAreaFilled(false);
		showPasswordButton.setBackground(Color.WHITE);
		showPasswordButton.setBorder(null);
		showPasswordButton.setIcon(new ImageIcon(LoginWindow.class.getResource("/icone/showpass_24.png")));
		showPasswordButton.setBounds(440, 215, 53, 23);
		contentPane.add(showPasswordButton);
	}
}
