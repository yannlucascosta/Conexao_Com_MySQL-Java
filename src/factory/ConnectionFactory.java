package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/projetojava", "developer", "1234567");
		} catch (SQLException excecao) {
			throw new RuntimeException(excecao);
		}
	}
}