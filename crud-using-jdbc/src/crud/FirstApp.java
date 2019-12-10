package crud;

import java.sql.SQLException;
import java.util.Scanner;

public class FirstApp {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		FirstApp fa=new FirstApp();
		fa.choice();
	}

	public void choice() throws ClassNotFoundException, SQLException {
		Scanner s=new Scanner(System.in);
		System.out.println("1.Insert\n2.View\n3.Update\n4.Delete\n5.Login\n6.Exit");
		System.out.println("Enter your choice");
		int ch=s.nextInt();
		switch(ch)
		{
			case 1:Insert i=new Insert();
				i.insert();
			break;
			case 2:View v=new View();
				v.view();
			break;
			case 3: Update u=new Update();
				u.update();
			break;
			case 4:Delete d=new Delete();
				d.delete();
			case 5:Login l=new Login();
				l.login();
			break;
			case 6:System.exit(0);
			break;
			default:System.out.println("Invalid Option");
				
		}
	}

	

}
