package edu.ifsp.dsi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoBD {
	public static void main(String[] args) {
		
		try (Connection conn = ConnectionProvider.getConnection()) {
					
			try (Statement stmt = conn.createStatement();) {

				ResultSet rs = stmt.executeQuery(
						"SELECT code, name, indepyear FROM country "
						+ "WHERE indepyear > 1990;");
				
				while (rs.next()) {
					String code = rs.getString("code");
					String name = rs.getString("name");
					int indepYear = rs.getInt("indepyear");
					
					System.out.printf("%s\t%s\t%d\n", 
							code, name, indepYear);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}




