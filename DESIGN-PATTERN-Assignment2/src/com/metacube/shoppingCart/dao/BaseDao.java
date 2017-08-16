package com.metacube.shoppingCart.dao;

import java.io.IOException;
import java.util.Map;

import com.metacube.shoppingCart.model.BaseEntity;

/**
 * 
 * @author Preeti Kumawat
 * 
 * Interface Name: BaseDao
 * @param <T>
 * here T is any class that extends BaseEntity
 */
public interface BaseDao<T extends BaseEntity>{
	public Map<String, T> getAll() throws IOException ;
    public void create(T entity) throws IOException ;
    public void update(T entity) throws IOException ;
    public void remove(T entity) throws IOException ;

}
