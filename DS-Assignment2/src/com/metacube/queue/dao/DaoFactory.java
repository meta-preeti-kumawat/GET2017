package com.metacube.queue.dao;

import java.io.IOException;

import com.metacube.queue.enums.DBType;
import com.metacube.queue.enums.EntityName;

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
    public static BaseDao<?> getDaoForEntity(EntityName entityName, DBType dbType){
        BaseDao<?> baseDao = null;
        switch(entityName){
        case STUDENT:
            switch(dbType){
            case IN_MEMORY:
                baseDao = InMemoryStudentDAO.getInstance();
                break;
                
            //add more cases if required
                
            default:
                break;
            }
            break;

        case COLLEGE:
            switch(dbType){
            case IN_MEMORY:
                baseDao = InMemoryCollegeDAO.getInstance();
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
