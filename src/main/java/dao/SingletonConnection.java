package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
	
	private static Connection connection;
	private final static String URL="jdbc:mysql://localhost:3309/productdb";
	private final static String USER="root";
	private final static String PASSWORD="123456";
	
	static {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection=DriverManager.getConnection(URL,USER,PASSWORD);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public static Connection getConnection() {
		return connection;
	}
	
}
