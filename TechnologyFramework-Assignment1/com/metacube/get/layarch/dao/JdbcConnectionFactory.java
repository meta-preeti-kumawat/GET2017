package com.metacube.get.layarch.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * This class is used to create connection with database.
 */
public class JdbcConnectionFactory
{
    Connection getConnection() throws Exception
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping_cart", "cart_user", "get_pwd");
            return con;
        }
        catch (Exception e)
        {
            System.out.println(e);
            throw e;
        }
    }
}
