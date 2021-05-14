import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionManager {
	
	static Connection currentConnection = null;
	
	public static Connection getDatabaseConnection() 
	{
		try 
		{
			if(currentConnection == null || currentConnection.isClosed()) 
			{
				currentConnection = DriverManager.getConnection("jdbc:sqlite::resource:easyPasswordManager.db");
				System.out.println("Successfully connected to the database\n");
			}
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return currentConnection;
	}
}
