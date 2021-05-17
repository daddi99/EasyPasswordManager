package entities;


public class Credentials {

	//ATTRIBUTES
	private String website;
	private String email;
	private String username;
	private String password;
	
	
	//CONSTRUCTOR
	public Credentials(String website, String email, String username, String password) 
	{
		super();
		this.website = website;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	
	//GETTERS AND SETTERS
	public String getWebsite() {
		return website;
	}


	public void setWebsite(String website) {
		this.website = website;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return website;
	}

	
}
