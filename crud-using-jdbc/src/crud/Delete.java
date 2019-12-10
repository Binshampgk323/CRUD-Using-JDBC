package crud;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete {

	ConnectionManager con=new ConnectionManager();
	public void delete() throws ClassNotFoundException, SQLException {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter your id(Roll Number)");
		int id=s.nextInt();
		PreparedStatement pr=con.getConnection().prepareStatement("DELETE FROM firstapplication WHERE RollNo = ?");
		pr.setInt(1,id);
		pr.executeUpdate();
		System.out.println("Data deleted");
		FirstApp fp=new FirstApp();
		fp.choice();
	}

}
