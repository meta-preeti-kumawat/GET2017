package main.java.com.metacube.layeredArchitecture.dao.product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;

import main.java.com.metacube.layeredArchitecture.dao.GenericJdbcDao;
import main.java.com.metacube.layeredArchitecture.dao.JdbcConnectionFactory;
import main.java.com.metacube.layeredArchitecture.enums.Status;
import main.java.com.metacube.layeredArchitecture.model.Product;

@Component("productDao")
public class JdbcProductDao extends GenericJdbcDao<Product> implements ProductDao {

	JdbcConnectionFactory connectionFactory = new JdbcConnectionFactory();
	
	protected String getTableName() {
		return "product";
	}

	protected Product extractResultSetRow(ResultSet resultSet) {
		Product product = new Product();
		try {
			product.setId(resultSet.getInt("id"));
			product.setName(resultSet.getString("name"));
			product.setPrice(resultSet.getFloat("price"));
			product.setDescription(resultSet.getString("description"));
			product.setImageUrl(resultSet.getString("imageUrl"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return product;
	}

	protected String getPrimaryKeyColoumnName() {
		return "id";
	}
	
	public Status create(Product product) {
		try {
			System.out.println("creating");
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			String query = "INSERT INTO " + getTableName() +" ( name, price, description, imageUrl ) VALUES ( '" + product.getName() + "', " + product.getPrice() + ", '" + product.getDescription() +"', '" + product.getImageUrl() + "');";
			stmt.executeUpdate(query);
			ResultSet rs = stmt.executeQuery("select last_insert_id() as last_id from products");
			rs.first();
			return Status.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return Status.FAILURE;
		}
	}

	public Status update(Product product, int primaryKey) {
		try {
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			String query = "UPDATE " + getTableName() + " SET name = '" + product.getName() + "', price = "
					+ product.getPrice() + ", description = '" + product.getDescription() + "', imageUrl = '"
					+ product.getImageUrl() + "' "
					+ " WHERE " + getPrimaryKeyColoumnName() + " = "
					+ primaryKey + " ;";
			stmt.executeUpdate(query);
			return Status.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return Status.FAILURE;
		}
	}
}