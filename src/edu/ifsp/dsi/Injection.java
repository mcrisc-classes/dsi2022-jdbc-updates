package edu.ifsp.dsi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Injection {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		try (Connection conn = ConnectionProvider.getConnection()) {
		
			System.out.println("Descrição: ");
			String desc = sc.nextLine();

			String query = "SELECT id, descricao, preco "
					+ "FROM produtos WHERE "
					+ "descricao LIKE '" + desc + "%';";
			
			try (Statement stmt = conn.createStatement();) {

				ResultSet rs = stmt.executeQuery(query);
				
				
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




