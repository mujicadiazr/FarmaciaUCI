package uci.cu.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {

	private static String driver = DAOProperties.getString("driver");

	private static String url = DAOProperties.getString("url");

	private static String user = DAOProperties.getString("user");

	private static String password = DAOProperties.getString("password");

	private static Connection connection = null;

	public static Connection getConnection(String driver, String url, String user, String password) throws Exception {
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static Connection getConnection() throws Exception {
		if (connection != null && !connection.isClosed()) {
			return connection;
		} else {
			connection = getConnection(driver, url, user, password);
			return connection;
		}

	}
}
