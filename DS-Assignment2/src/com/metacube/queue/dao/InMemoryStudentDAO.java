package com.metacube.queue.dao;

import com.metacube.queue.model.Student;
import com.metacube.queue.utility.ArrayList;

/**
 * 
 * @author Preeti Kumawat
 * Class Name: InMemoryStudentDAO
 *
 */
public class InMemoryStudentDAO implements StudentDAO{

    private static InMemoryStudentDAO inMemoryStudentDAO = null;
    private static ArrayList<Student> dataList;
    
    private InMemoryStudentDAO(){
         dataList = new ArrayList<Student>();
         
         Student student1 = new Student("1", "A", 100);
         Student student2 = new Student("2", "B", 50);
         Student student3 = new Student("3", "C", 152);
         Student student4 = new Student("4", "D", 110);
         Student student5 = new Student("5", "E", 504);
         Student student6 = new Student("6", "F", 12);

         dataList.add(student1);
         dataList.add(student2);
         dataList.add(student3);
         dataList.add(student4);
         dataList.add(student5);
         dataList.add(student6);
    }
    
    /**
     * This is used to create class singleton and get available instance
     * @return InMemoryStudentDAO
     */
    synchronized public static InMemoryStudentDAO getInstance(){
        if(inMemoryStudentDAO == null){
            inMemoryStudentDAO = new InMemoryStudentDAO();
        }
        return inMemoryStudentDAO;
    }
    
    /**
     * override clone method of object class (for the purpose of creating singleton class)
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
    
    /**
     * getAll() method returns map
     */
    @Override
    public ArrayList<Student> getAll(){
        return dataList;
    }

    /**
     * adds a new student to map
     */
    @Override
    public void create(Student entity){
        String id = generateId();
        entity.setId(id);
        dataList.add(entity);
    }

    /**
     * get student object by code
     */
    @Override
    public Student getStudentById(String id) {
        Student student = null;
        for (int index = 0; index < dataList.length(); index++) {
            if(dataList.get(index).getId().equals(id)){
                student = dataList.get(index);
            }
        }
        return student;
    }

    /**
     * updates a student in map
     */
    @Override
    public void update(Student entity){
        for (int index = 0; index < dataList.length(); index++) {
            if(dataList.get(index).getId().equals(entity.getId())){
                dataList.add(entity); 
            }
        }
    }

    /**
     * removes a student from map
     * @throws Exception 
     */
    @Override
    public void remove(Student entity) throws Exception{
        dataList.removeElement(entity); 
    }
    
    /**
     * auto generates an id
     * @return
     */
    public String generateId() {
        int id = (int) Math.random();
        String idStr = Integer.toString(id);
        if(getStudentById(idStr) != null){
            idStr = generateId();
        }
        return idStr;
    }
}
