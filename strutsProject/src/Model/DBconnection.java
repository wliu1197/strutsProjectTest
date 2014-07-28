package Model;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;


public class DBconnection {
	public static Connection getConnection(){
			
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("Where is your PostgreSQL JDBC Driver?");
				e.printStackTrace();
				return null;
			}
			String Schema_name="User_Tables";
		 	String User_name="postgres";
		 	String Password="root";
			Connection connection = null;
			try {
				connection = (Connection) DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+Schema_name,User_name, Password);
				return connection;
			} catch (SQLException e) {
				System.out.println("Connection Failed! Check output console");
				e.printStackTrace();
				return null;
			}
		
	}
}
