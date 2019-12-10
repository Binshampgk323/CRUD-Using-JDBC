package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	public Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=null; //connection object
		
		con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/application","root","");
		
		if(con!=null) //check connection
		{
			return con;
		}
		else
		{
			return null;
		}
	}

}
