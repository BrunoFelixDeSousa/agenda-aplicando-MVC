package model;

import java.sql.Connection;

import conexaoJDBC.SingleConnetcion;

public class DAO {
	
	private Connection connection;
	
	public DAO() {
		connection = SingleConnetcion.getConnection();
	}

}
