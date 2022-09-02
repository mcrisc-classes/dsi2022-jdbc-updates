package edu.ifsp.dsi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Consultas {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		try (Connection conn = ConnectionProvider.getConnection()) {
		
			System.out.println("Digite 0 (zero) para sair.");
			System.out.println("Preço máximo: ");
			double precoMaximo = sc.nextInt();

			while (precoMaximo > 0) {
				try (Statement stmt = conn.createStatement();) {
	
					ResultSet rs = stmt.executeQuery(
							"SELECT id, descricao, preco "
							+ "FROM produtos WHERE preco < " + precoMaximo + ";");
					
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




