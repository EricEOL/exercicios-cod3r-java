package jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class FabricaDeConexao {
	
	public static Connection getConexao(){
		try {
			Properties prop = getProperties();
;			final String url = prop.getProperty("banco.url");
			final String usuario = prop.getProperty("banco.usuario");
			final String password = prop.getProperty("banco.senha");
			
			Connection conexao = DriverManager
					.getConnection(url, usuario, password);
			
			System.out.println("Conexão bem sucedida.");
			
			return conexao;
			
		} catch(SQLException | IOException exception) {
			throw new RuntimeException(exception);
		}
	}
	
	private static Properties getProperties() throws IOException {
		Properties prop = new Properties();
		String caminho = "/conexao.properties";
		
		prop.load(FabricaDeConexao.class.getResourceAsStream(caminho));
		
		return prop;
	}
	
}