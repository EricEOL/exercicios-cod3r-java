package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexao {
	
	public static Connection getConexao(){
		try {
			final String url = "jdbc:mysql://localhost/curso_java?verifyServerCertificate=false&useSSL=true";
			final String usuario = "root";
			final String password = "admin";
			
			Connection conexao = DriverManager
					.getConnection(url, usuario, password);
			
			System.out.println("Conexão bem sucedida.");
			
			return conexao;
			
		} catch(SQLException exception) {
			throw new RuntimeException(exception);
		}
	}
	
}
