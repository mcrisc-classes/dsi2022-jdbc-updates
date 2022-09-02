package edu.ifsp.dsi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	/* As constantes a seguir são parâmetros da 
	 * conexão. Altere-as conforme a necessidade. */
	private static final String HOST = "localhost";
	private static final String DB_NAME = "world";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		final String url = String.format("jdbc:mysql://%s/%s", HOST, DB_NAME);
		return DriverManager.getConnection(url, USER, PASSWORD);		
	}		
}