package autovoting.java;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class sqlConnection {
	Connection conn=null;
	public static Connection dbConnector() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","system","ankit");
			return conn;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,e+" Connection Unsuccesful");
			return null;
		}
	}
}
