package com.metacube.get.layarch.dao;

import java.io.Serializable;

import com.metacube.get.layarch.enums.Status;

/**
 * This is a interface of abstract dao classes .
 */
public interface AbstractDao<T, ID extends Serializable>
{/**
     * Save.
     *
     * @param <S> the generic type
     * @param entity the entity
     * @return the status
     */
    <S extends T> Status save(S entity);
    
    /**
     * Find one product by id.
     *
     * @param primaryKey the primary key
     * @return the product
     */
    T findOne(ID primaryKey);
    
    /**
     * Find all producrts.
     *
     * @return the iterable object
     */
    Iterable<T> findAll();
    
    
    /**
     * Delete the product by id.
     *
     * @param primaryKey the primary key
     * @return the status
     */
    Status deleteById(ID primaryKey);
    
    /**
     * Edits the.product
     *
     * @param primaryKey the primary key
     * @return the status
     */
    <S extends T>Status edit(S entity,ID primaryKey);
    
}
