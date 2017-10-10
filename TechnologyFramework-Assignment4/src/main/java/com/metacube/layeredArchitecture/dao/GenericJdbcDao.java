package main.java.com.metacube.layeredArchitecture.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import main.java.com.metacube.layeredArchitecture.enums.Status;
import main.java.com.metacube.layeredArchitecture.model.BaseModel;

public abstract class GenericJdbcDao<T extends BaseModel> implements BaseDao<T> {
	JdbcConnectionFactory connectionFactory = new JdbcConnectionFactory();
	
	protected abstract String getTableName();
	protected abstract T extractResultSetRow(ResultSet resultSet);
	protected abstract String getPrimaryKeyColoumnName();
	
	public T getById(int primaryKey) {
		try {
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery
					("SELECT * FROM " 
							+ getTableName() 
							+ " where " + getPrimaryKeyColoumnName() 
							+" = '" + primaryKey + "'");
			while(resultSet.next()) {
				return extractResultSetRow(resultSet);
			}
			return null;
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<T> getAll ()
	{
		try {
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM " + getTableName());
			List<T> productList = new ArrayList<>();
			while(resultSet.next()) {
				productList.add(extractResultSetRow(resultSet));
			}
			return productList;

		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}
	
	public void delete(T t) {
		
	}
	
	public Status deleteById(int primaryKey) {
		try {
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			String query = "DELETE FROM " + getTableName() + " where "
					+ getPrimaryKeyColoumnName() + " = '" + primaryKey + "'";
			stmt.executeUpdate(query);
			return Status.SUCCESS;
		} catch (Exception e) {
			
			e.printStackTrace();
			return Status.FAILURE;
		}
	}
}