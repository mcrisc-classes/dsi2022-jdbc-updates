package edu.ifsp.dsi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Consultas {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		try (Connection conn = ConnectionProvider.getConnection()) {
		
			System.out.println("Digite 0 (zero) para sair.");
			System.out.println("Preço máximo: ");
			double precoMaximo = sc.nextInt();

			String query = "SELECT id, descricao, preco "
					+ "FROM produtos WHERE preco < ?;";
			
			while (precoMaximo > 0) {
				try (PreparedStatement ps = conn.prepareStatement(query)) {

					ps.setDouble(1, precoMaximo);
					ResultSet rs = ps.executeQuery();
					
					
					while (rs.next()) {
						long id = rs.getLong("id"); 
						String descricao = rs.getString("descricao");
						double preco = rs.getDouble("preco");
						
						System.out.printf("%d\t%s\t%.2f\n", 
								id, descricao, preco);
					}
				}
				
				System.out.println("Preço máximo: ");
				precoMaximo = sc.nextInt();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}




