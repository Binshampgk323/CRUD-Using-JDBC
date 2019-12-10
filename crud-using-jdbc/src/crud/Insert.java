package crud;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Insert {

	ConnectionManager con=new ConnectionManager();
	
	public void insert() throws ClassNotFoundException, SQLException {
		Scanner s=new Scanner(System.in);
		
		String Name = "[A-Z][a-z]*";
		Pattern namepattern=Pattern.compile(Name);
		
		String de="[A-Za-z]*";
		Pattern depattern=Pattern.compile(de);
		
		String add="[A-Za-z0-9]*";
		Pattern addpattern=Pattern.compile(add);
		
		System.out.println("Enter name");
		String name=s.next();
		Matcher namemat=namepattern.matcher(name);
		
		System.out.println("Enter Roll Number");
		int no=s.nextInt();
			
		System.out.println("Enter Department");
		String dpmt=s.next();
		Matcher demat=depattern.matcher(dpmt);
		
		System.out.println("Enter year");
		int y=s.nextInt();
	
		System.out.println("Enter Address");
		String address=s.next();
		Matcher addmat=addpattern.matcher(address);
		
		if(namemat.matches())
		{
			if(demat.matches())
			{
				if(addmat.matches())
					{
						PreparedStatement pr=con.getConnection().prepareStatement("insert into firstapplication(Name,RollNo,Department,Year,Address)values(?,?,?,?,?);");
						pr.setString(1, name);
						pr.setInt(2, no);
						pr.setString(3, dpmt);
						pr.setInt(4, y);
						pr.setString(5, address);
						pr.executeUpdate();
						con.getConnection().close();
						System.out.println("Data saved");
					}
					else{System.out.println("Invalid address");}
			}
			else{System.out.println("Invalid department");}	
	}
	else{System.out.println("Invalid Name");}
			
		
		
		
		
		FirstApp fp=new FirstApp();
		fp.choice();
	}

}
