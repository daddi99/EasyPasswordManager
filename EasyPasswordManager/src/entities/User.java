package entities;

public class User {

	private String name;
	private String surname;
	private String masterPassword;
	private String email;
	
	//Constructor
	public User(String name, String surname, String masterPassword, String email) {
		super();
		this.name = name;
		this.surname = surname;
		this.masterPassword = masterPassword;
		this.email = email;
	}

	//Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getMasterPassword() {
		return masterPassword;
	}

	public void setMasterPassword(String masterPassword) {
		this.masterPassword = masterPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
