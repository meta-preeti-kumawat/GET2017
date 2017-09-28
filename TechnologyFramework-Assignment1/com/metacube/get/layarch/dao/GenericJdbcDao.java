package com.metacube.get.layarch.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.metacube.get.layarch.enums.Status;
import com.metacube.get.layarch.model.Product;

/**
 * This is a abstract class to perform general project
 */
public abstract class GenericJdbcDao<T, ID extends Serializable> implements AbstractDao<T,ID>
{
    JdbcConnectionFactory connectionFactory = new JdbcConnectionFactory();

    protected abstract String getTableName();
    protected abstract T extractResultSetRow(ResultSet resultSet);
    protected abstract String getPrimaryKeyColoumnName();
    
    /**
     * Method is used to save the new product to list
     */
    public <S extends T> Status save(S entity) {
        Status result = Status.SUCCESS;
        Product product = (Product)entity;
        try {
            Connection connection = connectionFactory.getConnection();
            Statement stmt = connection.createStatement();
            String query = "INSERT INTO " + getTableName() + " (name,price)"+" VALUES ('" +product.getName() +"','"+ product.getPrice() + "');";
            stmt.executeUpdate(query);
        } catch(Exception e) {
            e.printStackTrace();
            result = Status.ERROR_OCCURED;
        }
        return result;
    }

    /**
     * Method is used to find product by id
     */
    public T findOne(final ID primaryKey)
    {
        try {
            Connection connection = connectionFactory.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM " + getTableName() + " where " + getPrimaryKeyColoumnName() +" = '" + primaryKey + "'");
            while(resultSet.next()) {
                return extractResultSetRow(resultSet);
            }
            return null;
        } catch (Exception e) {
            //TODO - Logging
            return null;
        }
    }

    /**
     * Method is used to return list of products available
     */
    public Iterable<T> findAll ()
    {
        try {
            Connection connection = connectionFactory.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM " + getTableName());
            List<T> userList = new ArrayList<>();
            while(resultSet.next()) {
                userList.add(extractResultSetRow(resultSet));
            }
            return userList;

        } catch (Exception e) {
            //TODO - Logging
            return Collections.emptyList();
        }

    }
    
    
    /**
     * Method is used to delete product by id
     */
    public Status deleteById(ID primaryKey) {
        Status result = Status.SUCCESS;
        try {
            Connection connection = connectionFactory.getConnection();
            Statement stmt = connection.createStatement();
            String query = "DELETE FROM " + getTableName() + " where " + getPrimaryKeyColoumnName() +" = '" + primaryKey + "'";
            stmt.executeUpdate(query);
        } catch(Exception e) {
            e.printStackTrace();
            result = Status.ERROR_OCCURED;
        }
        return result;
    }
    
    /**
     * Edit the detail 
     * @param product
     *             product to edit
     * @param primaryKey
     *             primary key of table
     * @return
     *             status of operation
     */
    public Status edit(Product product,ID primaryKey) {
        Status result = Status.SUCCESS;
        try {
            Connection connection = connectionFactory.getConnection();
            Statement stmt = connection.createStatement();
            String query = "UPDATE " + getTableName() + " SET name = '"+ product.getName() + "' , price = " + product.getPrice()+" where " + getPrimaryKeyColoumnName() +" = " + primaryKey + " ;";
            stmt.executeUpdate(query);
        } catch(Exception e) {
            e.printStackTrace();
            result = Status.ERROR_OCCURED;
        }
        return result;
    }
}
