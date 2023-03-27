package br.produto.com.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {

	public static void main(String[] args) throws SQLException {
		Connection conexao = null;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco_teste_automacao", "root", "root");
			ResultSet rsMassas = conexao.createStatement().executeQuery("SELECT NAME_PRODUCT from massas");
			while (rsMassas.next()) {
			System.out.println("Nome do produto: " + rsMassas.getString("NAME_PRODUCT"));
			}
			
		} catch (ClassNotFoundException ex) {
			System.out.println("Driver do banco de dados não localizado");
		} catch (SQLException ex) {
			System.out.println("Ocorreu um erro ao acessar o banco: " + ex.getMessage());
		} finally {
			if (conexao != null) {
				conexao.close();
			}
		}

	}
}