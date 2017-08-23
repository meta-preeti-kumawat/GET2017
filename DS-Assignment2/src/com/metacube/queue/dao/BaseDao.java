package com.metacube.queue.dao;

import com.metacube.queue.model.BaseEntity;
import com.metacube.queue.utility.ArrayList;

/**
 * 
 * @author Preeti Kumawat
 * 
 * Interface Name: BaseDao
 * @param <T>
 * here T is any class that extends BaseEntity
 * @param <BaseEntity>
 */
public interface BaseDao<T extends BaseEntity>{
    public ArrayList<T> getAll();
    public void create(T entity);
    public void update(T entity);
    public void remove(T entity) throws Exception;

}
