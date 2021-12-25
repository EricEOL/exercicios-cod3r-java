package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultarPessoas2 {
	
	public static void main(String[] args) throws SQLException {

		Connection conexao = FabricaDeConexao.getConexao();
		
		Scanner pesquisa = new Scanner(System.in);
		System.out.print("Informe o termo de pesquisa: ");
		String termoDePesquisa = pesquisa.next();
		
		String sql = "SELECT * FROM pessoas WHERE nome LIKE (?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, "%" + termoDePesquisa + "%");
		ResultSet resultado = stmt.executeQuery();
		
		List<Pessoa> pessoas = new ArrayList<>();
		
		while(resultado.next()) {
			
			pessoas.add(new Pessoa(resultado.getInt("codigo"), resultado.getString("nome")));
		}
		
		for(Pessoa p: pessoas) {
			System.out.println(p.getCodigo() + ": " + p.getNome());
			System.out.println("------------");
		}

		stmt.close();
		conexao.close();
		pesquisa.close();
	}
}
