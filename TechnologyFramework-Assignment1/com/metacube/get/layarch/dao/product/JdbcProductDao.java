package com.metacube.get.layarch.dao.product;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.metacube.get.layarch.dao.GenericJdbcDao;
import com.metacube.get.layarch.model.Product;

/**
 *This is product dao to extract the data from products list
 */
public class JdbcProductDao extends GenericJdbcDao<Product, Integer> implements ProductDao
{
    /**
     *  Override the method to get name
     */
    @Override protected String getTableName()
    {
        return "Product";
    }
    
    /**
     * Method is used to extract product by aplying filter
     */
    @Override protected Product extractResultSetRow(final ResultSet resultSet)
    {
        Product product = new Product();
        try
        {
            product.setPrice(resultSet.getDouble("price"));
            product.setName(resultSet.getString("name"));
            product.setId(resultSet.getInt("id"));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    return product;
    }

    /**
     * Method is used to get product by its column id
     */
    @Override protected String getPrimaryKeyColoumnName()
    {
        return "id";
    }

}
