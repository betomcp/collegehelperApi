package connectionfactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConnectionFactory {

	private String schema = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
	//private String schema = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "rm86750";
	private String password = "060900";
	
	public Connection connect() {
		try {
			return DriverManager.getConnection(schema,user,password);
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
