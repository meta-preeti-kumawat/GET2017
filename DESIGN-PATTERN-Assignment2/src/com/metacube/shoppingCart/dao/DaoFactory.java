package com.metacube.shoppingCart.dao;

import java.io.IOException;

import com.metacube.shoppingCart.enums.DBType;
import com.metacube.shoppingCart.enums.EntityName;

/**
 * 
 * @author Preeti Kumawat
 * Class Name: DaoFactory
 * 
 * This class creates an instance of required dao class 
 *
 */
public class DaoFactory {
    
    /**
     * @param entityName
     * @param dbType
     * @return BaseDao
     * @throws IOException
     * Creates required Dao class
     */
    public static BaseDao<?> getDaoForEntity(EntityName entityName, DBType dbType) throws IOException{
        BaseDao<?> baseDao = null;
        switch(entityName){
        case PRODUCT:
            switch(dbType){
            case IN_MEMORY:
                baseDao = InMemoryProductDao.getInstance();
                break;
                
            //add more cases if required
                
            default:
                break;
            }
            break;

        case CART:
            switch(dbType){
            case IN_MEMORY:
                baseDao = InMemoryCartDao.getInstance();
                break;
                
            //add more cases if required
                
            default:
                break;
            }
            break;

        default:
            break;
        }
        return baseDao;
    }
}
