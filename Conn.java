package bankmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conn {
	
	Connection con;
	Statement s;
	
	public Conn() throws SQLException {
		String url="jdbc:mysql://localhost:3306/bankmanagementsystem";
		String userName="root";
		String password="Anuse@243";
		con = DriverManager.getConnection(url,userName,password);
		s = con.createStatement();
	}

}
