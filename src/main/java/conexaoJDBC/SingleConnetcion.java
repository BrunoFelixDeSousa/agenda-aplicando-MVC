package conexaoJDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnetcion {
	
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://127.0.0.1:3306/dbagenda";
	private static String user = "root";
	private static String password = "root";
	private static Connection connection = null;
	
	static {
		conectar();
	}
	
	public SingleConnetcion() {
		conectar();
	}
	
	private static void conectar() {
		
		try {
			if ( connection == null ) {
				Class.forName(driver);
				connection = DriverManager.getConnection(url, user, password);
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}
	

}
