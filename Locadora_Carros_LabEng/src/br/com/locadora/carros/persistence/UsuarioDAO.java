package br.com.locadora.carros.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import br.com.locadora.carros.model.Cliente;
import br.com.locadora.carros.model.Usuario;

public class UsuarioDAO {
	public final IConnectionJDBC conexao;
	Long idRetorno = null;
	
	public UsuarioDAO() throws SQLException, ClassNotFoundException{
		this.conexao = new ConectionMySqlJDBC();
	}
	
	public void cadastrarUsuario(Usuario user) throws SQLException, ClassNotFoundException{
		String sqlQuery = "INSERT INTO Usuario (login, senha, perfil) VALUES (?, ?, ?)";
		
		try {
			PreparedStatement prepStatement = (PreparedStatement) this.conexao.getConnection().prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
			prepStatement.setString(1, user.getLogin());
			prepStatement.setString(2, user.getSenha());
			prepStatement.setString(3, user.getPerfil());
			prepStatement.executeUpdate();
			
			this.conexao.commit();
			
		}catch (SQLException ex) {
			this.conexao.rollback();
			throw ex;
		}
	}
	
	public Usuario buscarUsuario(String login, String senha) throws SQLException {
		String sqlQuery = "SELECT login, senha, perfil FROM Usuario WHERE login = ? AND senha = ?";
		
		Usuario usuarioRetorno = new Usuario();
		try {
			
			PreparedStatement prepStatement = (PreparedStatement) this.conexao.getConnection().prepareStatement(sqlQuery);
			prepStatement.setString(1, login);
			prepStatement.setString(2, senha);
			ResultSet resultSet = prepStatement.executeQuery();
			
			if(resultSet.next()) {
				usuarioRetorno.setLogin(resultSet.getString(1));
				usuarioRetorno.setSenha(resultSet.getString(2));
				usuarioRetorno.setPerfil(resultSet.getString(3));
			}
			
		}catch (SQLException ex) {
			this.conexao.rollback();
			throw ex;
		}
		
		return usuarioRetorno;
	}
}
