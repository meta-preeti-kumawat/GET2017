package com.metacube.queue.dao;

import com.metacube.queue.model.College;
import com.metacube.queue.utility.ArrayList;

/**
 * 
 * @author Preeti Kumawat
 * Class Name: InMemoryCollegeDAO
 *
 */
public class InMemoryCollegeDAO implements CollegeDAO{

    private static InMemoryCollegeDAO inMemoryCollegeDAO = null;
    private ArrayList<College> collegeList;
    
    private InMemoryCollegeDAO(){
        collegeList = new ArrayList<College>();
        
        College college1 = new College("101", "ABC", 1, 2);
        College college2 = new College("102", "X", 3, 1);
        College college3 = new College("103", "Y", 2, 1);
        College college4 = new College("104", "Z", 5, 0);
        College college5 = new College("105", "P", 4, 1);
        
        collegeList.add(college1);
        collegeList.add(college2);
        collegeList.add(college3);
        collegeList.add(college4);
        collegeList.add(college5);
    }
    
    /**
     * This is used to create class singleton and get available instance
     * @return InMemoryCollegeDAO
     */
    synchronized public static InMemoryCollegeDAO getInstance(){
        if(inMemoryCollegeDAO == null){
            inMemoryCollegeDAO = new InMemoryCollegeDAO();
        }
        return inMemoryCollegeDAO;
    }
    
    /**
     * override clone method of object class (for the purpose of creating singleton class)
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    @Override
    public ArrayList<College> getAll(){
        return collegeList;
    }

    
    @Override
    public void create(College entity){
        String id = generateId();
        entity.setId(id);
        collegeList.add(entity);
    }

    @Override
    public void update(College entity){
        for (int index = 0; index < collegeList.length(); index++) {
            if(collegeList.get(index).getId().equals(entity.getId())){
                collegeList.removeElementAtIndex(index);
                collegeList.add(entity); 
            }
        }
    }

    @Override
    public void remove(College entity) throws Exception{
         collegeList.removeElement(entity); 
    }

    @Override
    public College getCollege(String id) {
        College college = null;
        for (int index = 0; index < collegeList.length(); index++) {
            if(collegeList.get(index).getId().equals(id)){
                college = collegeList.get(index);
            }
        }
        return college;
    }
    
    /**
     * auto generates an id
     * @return
     */
    public String generateId() {
        int id = (int) Math.random();
        String idStr = "C" + Integer.toString(id);
        if(getCollege(idStr) != null){
            idStr = generateId();
        }
        return idStr;
    }
}
