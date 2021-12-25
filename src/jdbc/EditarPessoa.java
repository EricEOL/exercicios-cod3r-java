package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class EditarPessoa {

	public static void main(String[] args) throws SQLException {
		
		Connection conexao = FabricaDeConexao.getConexao();
		
		Scanner pesquisa = new Scanner(System.in);
		System.out.println("Qual/Quais usuário(s) você deseja: ");
		String termoDePesquisa = pesquisa.next();
		
		String sql = "SELECT * FROM pessoas WHERE nome LIKE (?)";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, "%" + termoDePesquisa + "%");
		ResultSet resultado = stmt.executeQuery();
		
		
		
		ArrayList<Pessoa> usuarios = new ArrayList();
		
		while(resultado.next()) {
			usuarios.add(new Pessoa(resultado.getInt("codigo"), resultado.getString("nome")));
		}
		
		for(Pessoa p: usuarios) {
			System.out.println("id: " + p.getCodigo() + " | Nome: "+ p.getNome());
		}
		
		Scanner codigoDoUsuario = new Scanner(System.in);
		System.out.println("Digite o id do usuário que você deseja alterar: ");
		String codigo = codigoDoUsuario.next();
		
		Scanner novoNome = new Scanner(System.in);
		System.out.println("Digite o novo nome do usuario: ");
		String nome = novoNome.next();
		
		String sqlEdicaoDoNome = "UPDATE pessoas SET nome = (?) WHERE codigo = (?)";
		PreparedStatement stmt2 = conexao.prepareStatement(sqlEdicaoDoNome);
		stmt2.setString(1, nome);
		stmt2.setInt(2, Integer.parseInt(codigo));
		stmt2.execute();
		
		System.out.println("Usuário alterado com sucesso!");
		
		pesquisa.close();
		stmt.close();
		codigoDoUsuario.close();
		novoNome.close();
		stmt2.close();
		conexao.close();
	}

}
