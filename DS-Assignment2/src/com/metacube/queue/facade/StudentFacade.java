package com.metacube.queue.facade;

import java.io.IOException;

import com.metacube.queue.dao.BaseDao;
import com.metacube.queue.dao.DaoFactory;
import com.metacube.queue.enums.DBType;
import com.metacube.queue.enums.EntityName;
import com.metacube.queue.model.Student;
import com.metacube.queue.utility.ArrayList;
import com.metacube.queue.utility.Queue;

public class StudentFacade {
    private static StudentFacade studentFacade;
    private static ArrayList<Student> studentList;
    private static BaseDao<Student> studentDao;
    
    @SuppressWarnings("unchecked")
    private StudentFacade() {
         studentList = new ArrayList<Student>();
         studentDao = (BaseDao<Student>) DaoFactory.getDaoForEntity(EntityName.STUDENT, DBType.IN_MEMORY);    
    }
    
     /**
     * This is used to create class singleton and get available instance
     * @return StudentFacade
     * @throws IOException 
     */
    synchronized public static StudentFacade getInstance() throws IOException{
        if(studentFacade == null){
            studentFacade = new StudentFacade();
        }
        return studentFacade;
    }
    
    /**
     * override clone method of object class (for the purpose of creating singleton class)
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public Queue<Student> getQueueOrderByRank() {
        Queue<Student> students = new Queue<Student>();
        studentList = studentDao.getAll();
        
        studentList.sort();
        for (int index = 0; index < studentList.length(); index++) {
            students.enqueue(studentList.get(index));
        }
        
        return students;
    }

    public ArrayList<Student> showAllStudentsWithAllotedCollege() {
        studentList = studentDao.getAll();
        ArrayList<Student> allotedStudents = new ArrayList<Student>();
        for (int index = 0; index < studentList.length(); index++) {
            if(studentList.get(index).getCollege() != null){
                allotedStudents.add(studentList.get(index));
            }
        }
        return allotedStudents;
    }
}
