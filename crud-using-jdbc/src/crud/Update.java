package crud;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Update {

	ConnectionManager con=new ConnectionManager();
	public void update() throws ClassNotFoundException, SQLException {
		Scanner s=new Scanner(System.in);
		
		String Name = "[A-Z][a-z]*";
		Pattern namepattern=Pattern.compile(Name);
		
		String de="[A-Za-z]*";
		Pattern depattern=Pattern.compile(de);
		
		String add="[A-Za-z0-9]*";
		Pattern addpattern=Pattern.compile(add);
		
		System.out.println("Enter your id");
		int id=s.nextInt();
		System.out.println("Do you want to update all data(y/n)");
		String str=s.next();
		str=str.toLowerCase();
		if(str.contentEquals("y"))
		{
			System.out.println("Enter name");
			String name=s.next();
			Matcher namemat=namepattern.matcher(name);
				
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
							PreparedStatement pr=con.getConnection().prepareStatement("update firstapplication set Name=?,Department=?,Year=?,Address=? where RollNo=?;");
							pr.setString(1, name);
							pr.setString(2, dpmt);
							pr.setInt(3, y);
							pr.setString(4, address);
							pr.setInt(5, id);
							pr.executeUpdate();
						}
						else{System.out.println("Invalid address");}
				}
				else{System.out.println("Invalid department");}	
		}
		else{System.out.println("Invalid Name");}
					
		}
		else if(str.contentEquals("n"))
		{
			System.out.println("Which field you want to update");
			String field=s.next();
			field=field.toLowerCase();
			if(field.contentEquals("name"))
			{
				System.out.println("Enter name");
				String name=s.next();
				Matcher namemat=namepattern.matcher(name);
				if(namemat.matches())
				{
					PreparedStatement pr=con.getConnection().prepareStatement("update firstapplication set Name=? where RollNo=?;");
					pr.setString(1, name);
					pr.setInt(2, id);
					pr.executeUpdate();
				}
				else {System.out.println("Invalid Name");}
			}
			else if(field.contentEquals("department"))
			{
				System.out.println("Enter department");
				String dpt=s.next();
				Matcher demat=depattern.matcher(dpt);
				if(demat.matches())
				{
					PreparedStatement pr=con.getConnection().prepareStatement("update firstapplication set Department=? where RollNo=?;");
					pr.setString(1, dpt);
					pr.setInt(2, id);
					pr.executeUpdate();
				}
				else {System.out.println("Invalid Department");}
			}
			else if(field.contentEquals("year"))
			{
				System.out.println("Enter year");
				int y=s.nextInt();
				PreparedStatement pr=con.getConnection().prepareStatement("update firstapplication set Year=? where RollNo=?;");
				pr.setInt(1, y);
				pr.setInt(2, id);
				pr.executeUpdate();
		
			}
			else if(field.contentEquals("address"))
			{
				System.out.println("Enter address");
				String ad=s.next();
				Matcher addmat=addpattern.matcher(ad);
				if(addmat.matches())
				{
					PreparedStatement pr=con.getConnection().prepareStatement("update firstapplication set Address=? where RollNo=?;");
					pr.setString(1, ad);
					pr.setInt(2, id);
					pr.executeUpdate();
				}	
				else {System.out.println("Invalid Address");}
			}
		}
		con.getConnection().close();
			System.out.println("Data updated");
			FirstApp fp=new FirstApp();
			fp.choice();
		
		
		
	}

}
