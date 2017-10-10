package main.java.com.metacube.layeredArchitecture.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnectionFactory {
	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping_cart", "cart_user", "get_pwd");
		return con;
	}
}