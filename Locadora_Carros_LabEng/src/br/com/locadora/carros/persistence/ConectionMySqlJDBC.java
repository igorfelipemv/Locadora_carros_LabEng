package br.com.locadora.carros.persistence;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.Connection;

public class ConectionMySqlJDBC implements IConnectionJDBC{
	private Connection connection = null; //Conector

	public ConectionMySqlJDBC() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		
		//Passagem de parametros usuario e senha
		Properties properties = new Properties();
		properties.put("user", "root");
		properties.put("password", "123456");
		
		String url = "jdbc:mysql://localhost:3306/locadora_carros?useTimezone=true&serverTimezone=UTC"; //URL de conexão com a porta do banco e o nome do banco
		this.connection = (Connection) DriverManager.getConnection(url, properties); //Atribui a conexão passando os paremetros de usuario e senha do banco
		this.connection.setAutoCommit(false); //Setando commit automatico como false
	}
	
	//Retorna a conexão com o banco para classe que o chamar
	@Override
	public Connection getConnection() {
		return this.connection; 
	}

	//Fecha a conexão de quem o chamar
	@Override
	public void close() {
		if(this.connection != null) {
			try {
				this.connection.close();
				
			} catch (SQLException ex) {
				Logger.getLogger(ConectionMySqlJDBC.class.getName()).log(Level.SEVERE, null, ex); //Em caso de exception, jogar no log do TOMCAT
				
			}
		}
	}

	//Se o commit der certo, fecha a conexão. Caso contrario é lançado um SQLException
	@Override
	public void commit() throws SQLException {
		this.connection.commit();
		this.close();
	}
	
	
	@Override
	public void rollback() {
		if(this.connection != null) {
			try {
				this.connection.rollback();
				
			} catch (SQLException ex) {
				Logger.getLogger(ConectionMySqlJDBC.class.getName()).log(Level.SEVERE, null, ex); //Em caso de exception, jogar no log do TOMCAT
				
			} finally {
				this.close(); //fecha a conexão independente se deu ou não Exception
				
			}
		}
	}
	
}
