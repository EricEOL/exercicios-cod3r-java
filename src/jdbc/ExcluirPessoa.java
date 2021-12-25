package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExcluirPessoa {

	public static void main(String[] args) throws SQLException {
		
		Connection conexao = FabricaDeConexao.getConexao();
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o c�digo da pessoa que deseja excluir: ");
		Integer codigo = entrada.nextInt();
		
		String sql = "DELETE FROM pessoas WHERE codigo = (?)";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, codigo);
		
		if(stmt.executeUpdate() > 0) {
			System.out.println("Pessoa exclu�da com sucesso.");
		} else {
			System.out.println("Esse c�digo n�o existe.");
		}
		
		
		entrada.close();
		conexao.close();
		
		
	}

}
