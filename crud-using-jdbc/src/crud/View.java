package crud;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class View {

	ConnectionManager con=new ConnectionManager();
	public void view() throws ClassNotFoundException, SQLException {
		Statement st=con.getConnection().createStatement();
		ResultSet rs=st.executeQuery("select * from firstapplication");//execute query
		while(rs.next())
		{
			System.out.println(rs.getString(1)+" "+rs.getInt(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
		}
		FirstApp fp=new FirstApp();
		fp.choice();
		
	}

}
