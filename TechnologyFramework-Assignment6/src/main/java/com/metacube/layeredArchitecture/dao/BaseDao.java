/**
 * The interface BaseDao is a base interface for DAO layer.
 */
package main.java.com.metacube.layeredArchitecture.dao;

import java.util.List;

import main.java.com.metacube.layeredArchitecture.enums.Status;
import main.java.com.metacube.layeredArchitecture.model.BaseModel;

public interface BaseDao<T extends BaseModel, ID> {
	T getById(ID primaryKey);

	List<T> getAll();

	void delete(T t);

	ID create(T t);

	Status deleteById(ID primaryKey);

	Status update(T product);
}