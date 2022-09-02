package edu.ifsp.dsi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {
	public static void main(String[] args) {
		
		try (Connection conn = ConnectionProvider.getConnection()) {
			
			String query = "INSERT INTO produtos (descricao, preco) "
					+ "VALUES (?, ?);";
			
			try (PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
				String produto = "Videocassete JVC";
				double preco = 300;
				
				ps.setString(1, produto);
				ps.setDouble(2, preco);
				
				ps.executeUpdate();
				
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					long id = rs.getLong(1);
					System.out.println("ID: " + id);
				}
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();			
		}
	}
}
