package br.com.locadora.carros.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import br.com.locadora.carros.model.Cliente;

public class ClienteDAO {
	
	public final IConnectionJDBC conexao;
	Long idRetorno = null;
	
	public ClienteDAO() throws SQLException, ClassNotFoundException{
		this.conexao = new ConectionMySqlJDBC();
	}
	
	public Long insertCliente(Cliente cliente) throws SQLException, ClassNotFoundException{
		String sqlQuery = "INSERT INTO Cliente (nome, sobrenome, rg, cpf, telefone) VALUES (?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement prepStatement = (PreparedStatement) this.conexao.getConnection().prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
			prepStatement.setString(1, cliente.getNome());
			prepStatement.setString(2, cliente.getSobrenome());
			prepStatement.setString(3, cliente.getRg());
			prepStatement.setString(4, cliente.getCpf());
			prepStatement.setString(5, cliente.getTelefone());
			prepStatement.executeUpdate();
			
			ResultSet resultSet = prepStatement.getGeneratedKeys();
			if(resultSet.next()) {
				idRetorno = resultSet.getLong(1);
				cliente.setId(idRetorno);
			}
			
			this.conexao.commit();
			
		}catch (SQLException ex) {
			this.conexao.rollback();
			throw ex;
		}
		
		return idRetorno;
	}
	
	public List<Cliente> getAllClientes() throws SQLException, ClassNotFoundException {
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		String sqlQuery = "SELECT id, nome, sobrenome, rg, cpf, telefone FROM Cliente";
		
		try {
			PreparedStatement prepStatement = (PreparedStatement) this.conexao.getConnection().prepareStatement(sqlQuery);
			ResultSet resultSet = prepStatement.executeQuery();
			while (resultSet.next()) {
				Cliente cliente = new Cliente();
				cliente.setId((long) resultSet.getInt(1));
				cliente.setNome(resultSet.getString(2));
				cliente.setSobrenome(resultSet.getString(3));
				cliente.setRg(resultSet.getString(4));
				cliente.setCpf(resultSet.getString(5));
				cliente.setTelefone(resultSet.getString(6));
				
				listaClientes.add(cliente);
			}
		}catch (SQLException ex) {
			this.conexao.rollback();
			throw ex;
		}
		
		return listaClientes;
		
	}
	
	public String removeCliente(Cliente cliente) throws SQLException {
		String sqlQuery = "DELETE FROM Cliente WHERE id = ?";
		
		try {
			PreparedStatement prepStatement = (PreparedStatement) this.conexao.getConnection().prepareStatement(sqlQuery);
			prepStatement.setLong(1, cliente.getId());
			prepStatement.executeUpdate();
			this.conexao.commit();
			
		}catch (SQLException ex) {
			this.conexao.rollback();
			throw ex;
		}
		
		return "Cliente Removido com sucesso!";
	}
	
	public String updateCliente(Cliente cliente) throws SQLException {
		String sqlQuery = "UPDATE Cliente SET nome = ?, sobrenome = ?, rg = ?, cpf = ?, telefone = ? WHERE id = ?";
		try {
			PreparedStatement prepStatement = (PreparedStatement) this.conexao.getConnection().prepareStatement(sqlQuery);
			prepStatement.setString(1, cliente.getNome());
			prepStatement.setString(2, cliente.getSobrenome());
			prepStatement.setString(3, cliente.getRg());
			prepStatement.setString(4, cliente.getCpf());
			prepStatement.setString(5, cliente.getTelefone());
			prepStatement.setLong(6, cliente.getId());
			prepStatement.executeUpdate();
			this.conexao.commit();
			
		}catch (SQLException ex) {
			this.conexao.rollback();
			throw ex;
		}
		
		return "Cliente modificado com sucesso!";
	}
	
	public Cliente findCliente(Cliente cliente) throws SQLException {
		String sqlQuery = "SELECT id, nome, sobrenome, rg, cpf, telefone FROM Cliente WHERE id = ?";
		Cliente clienteRetorno = new Cliente();
		
		try {
			PreparedStatement prepStatement = (PreparedStatement) this.conexao.getConnection().prepareStatement(sqlQuery);
			prepStatement.setLong(1, cliente.getId());
			
			ResultSet resultSet = prepStatement.executeQuery();
			if(resultSet.next()) {
				clienteRetorno.setId(resultSet.getLong(1));
				clienteRetorno.setNome(resultSet.getString(2));
				clienteRetorno.setSobrenome(resultSet.getString(3));
				clienteRetorno.setRg(resultSet.getString(4));
				clienteRetorno.setCpf(resultSet.getString(5));
				clienteRetorno.setTelefone(resultSet.getString(6));
			}
			
			//this.conexao.commit();
		}catch (SQLException ex) {
			this.conexao.rollback();
			throw ex;
		}
		
		return clienteRetorno;
	}
	
	public List<Cliente> getClientesByNameLike(String nome) throws SQLException {
		String sqlQuery = "SELECT id, nome, sobrenome, rg, cpf, telefone FROM Cliente WHERE nome Like ?";
		//Cliente clienteRetorno = new Cliente();
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		
		try {
			PreparedStatement prepStatement = (PreparedStatement) this.conexao.getConnection().prepareStatement(sqlQuery);
			prepStatement.setString(1, nome+'%');
			ResultSet resultSet = prepStatement.executeQuery();
			
			while(resultSet.next()) {
				Cliente cliente = new Cliente();
				cliente.setId((long) resultSet.getInt(1));
				cliente.setNome(resultSet.getString(2));
				cliente.setSobrenome(resultSet.getString(3));
				cliente.setRg(resultSet.getString(4));
				cliente.setCpf(resultSet.getString(5));
				cliente.setTelefone(resultSet.getString(6));
				
				listaClientes.add(cliente);
			}
			
			//this.conexao.commit();
		}catch (SQLException ex) {
			this.conexao.rollback();
			throw ex;
		}
		
		return listaClientes;
	}
	
}
