package edu.ifsp.dsi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consultas {
	public static void main(String[] args) {
		
		try (Connection conn = ConnectionProvider.getConnection()) {
					
			try (Statement stmt = conn.createStatement();) {

				ResultSet rs = stmt.executeQuery(
						"SELECT id, descricao, preco "
						+ "FROM produtos WHERE preco < 3000;");
				
				while (rs.next()) {
					long id = rs.getLong("id"); 
					String descricao = rs.getString("descricao");
					double preco = rs.getDouble("preco");
					
					System.out.printf("%d\t%s\t%.2f\n", 
							id, descricao, preco);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}




