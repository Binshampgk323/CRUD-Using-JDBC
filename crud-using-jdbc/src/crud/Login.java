package crud;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Login {
	ConnectionManager con=new ConnectionManager();
	public void login() throws ClassNotFoundException, SQLException {
		Scanner s=new Scanner(System.in);
		System.out.println("Welcome to login");
		System.out.println("Enter your name");
		String name=s.next();
		System.out.println("Enter roll number");
		int roll=s.nextInt();
		Statement st=con.getConnection().createStatement();
		ResultSet rs=st.executeQuery("select name,RollNo from firstapplication");
		String n="";
		int r=0,f=0;
		while(rs.next())
		{
			 n=rs.getString(1);
			 r=rs.getInt(2);
			 if(n.contentEquals(name)&&r==roll)
				{
				 	f=1;
				 	break;
				}
				else
				{
					f=0;
				}
				
		}
		
		 if(f==1)
			{
			 
				System.out.println("Hi "+n);
			}
			else
			{
				System.out.println("Incorrect name and id");
			}
		
		
		
		
	}
	

}
