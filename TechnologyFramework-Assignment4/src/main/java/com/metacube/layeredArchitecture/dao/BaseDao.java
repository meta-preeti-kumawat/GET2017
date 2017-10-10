package main.java.com.metacube.layeredArchitecture.dao;

import java.util.List;

import main.java.com.metacube.layeredArchitecture.enums.Status;
import main.java.com.metacube.layeredArchitecture.model.BaseModel;
import main.java.com.metacube.layeredArchitecture.model.Product;

public interface BaseDao<T extends BaseModel> {
	T getById(int primaryKey);
	List<T> getAll();
	Status create(T t);
	Status deleteById(int primaryKey);
	Status update(Product product, int primaryKey);
}