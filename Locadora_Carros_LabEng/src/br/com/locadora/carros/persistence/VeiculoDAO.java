package br.com.locadora.carros.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import br.com.locadora.carros.model.Cliente;
import br.com.locadora.carros.model.Veiculo;

public class VeiculoDAO {
	
	public final IConnectionJDBC conexao;
	Long idRetorno = null;
	
	public VeiculoDAO() throws SQLException, ClassNotFoundException{
		this.conexao = new ConectionMySqlJDBC();
	}
	
	public Long insertVeiculo(Veiculo veiculo) throws SQLException, ClassNotFoundException{
		String sqlQuery = "INSERT INTO Veiculo (marca, modelo, anoModelo, anoFabricacao, placa, cor, valorDiaria) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement prepStatement = (PreparedStatement) this.conexao.getConnection().prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
			prepStatement.setString(1, veiculo.getMarca());
			prepStatement.setString(2, veiculo.getModelo());
			prepStatement.setString(3, veiculo.getAnoModelo());
			prepStatement.setString(4, veiculo.getAnoFabricacao());
			prepStatement.setString(5, veiculo.getPlaca());
			prepStatement.setString(6, veiculo.getCor());
			prepStatement.setDouble(7, veiculo.getValorDiaria());
			prepStatement.executeUpdate();
			
			ResultSet resultSet = prepStatement.getGeneratedKeys();
			if(resultSet.next()) {
				idRetorno = resultSet.getLong(1);
				veiculo.setId(idRetorno);
			}
			
			this.conexao.commit();
			
		}catch (SQLException ex) {
			this.conexao.rollback();
			throw ex;
		}
		
		return idRetorno;
	}
	
	public List<Cliente> getAllVeiculos() throws SQLException, ClassNotFoundException {
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

}
