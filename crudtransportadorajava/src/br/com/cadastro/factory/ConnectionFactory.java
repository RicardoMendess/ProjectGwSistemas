package br.com.cadastro.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	// Usuário do banco de dados
	private static final String USERNAME = "root";
	
	// Senha do banco de dados
	private static final String PASSWORD = "";
	
	// Caminho para se conectar com o banco de dados
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/cadastro";

	// Conexão com o banco de dados
	public static Connection createConnectionToMySQL () throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Cria a conexão com o banco de dados
		Connection connection = DriverManager.getConnection (DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
		
	}
	
	/*public static void GetDriver () throws SQLException {
		DriverManager.getDriver(DATABASE_URL);
	}*/
	
	public static void main (String [] args) throws Exception {
		// Recuperar uma conexão com banco de dados
		Connection con = createConnectionToMySQL ();
		
		// Tesar se a conexão é nula
		if (con != null) {
			System.out.println ("Conexão obtida com sucesso!");
			con.close();
		}
	}
}
