package br.com.locadora.carros.persistence;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public interface IConnectionJDBC {
	
	public Connection getConnection();
	
	public void close();
	
	public void commit() throws SQLException;
	
	public void rollback();
	
}
