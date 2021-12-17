package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {
	public static void main(String[] args) throws SQLException {
		
		final String url = "jdbc:mysql://localhost?verifyServerCertificate=false&useSSL=true";
		final String usuario = "root";
		final String password = "admin";
		
		Connection conexao = DriverManager
				.getConnection(url, usuario, password);
		
		System.out.println("Conexão efetuada com sucesso!");
		conexao.close();
	}
}
