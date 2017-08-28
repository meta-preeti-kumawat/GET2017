package com.metacube.queue.facade;

import java.io.IOException;

import com.metacube.queue.dao.BaseDao;
import com.metacube.queue.dao.CollegeDAO;
import com.metacube.queue.dao.DaoFactory;
import com.metacube.queue.enums.DBType;
import com.metacube.queue.enums.EntityName;
import com.metacube.queue.model.College;
import com.metacube.queue.model.Student;
import com.metacube.queue.utility.ArrayList;
public class CollegeFacade {
    private static CollegeFacade collegeFacade;
    private BaseDao<College> collegeDao;
    
    @SuppressWarnings("unchecked")
    private CollegeFacade() {
        collegeDao = (BaseDao<College>) DaoFactory.getDaoForEntity(EntityName.COLLEGE, DBType.IN_MEMORY);    
    }
    
     /**
     * This is used to create class singleton and get available instance
     * @return CollegeFacade
     * @throws IOException 
     */
    synchronized public static CollegeFacade getInstance() throws IOException{
        if(collegeFacade == null){
            collegeFacade = new CollegeFacade();
        }
        return collegeFacade;
    }
    
    /**
     * override clone method of object class (for the purpose of creating singleton class)
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public ArrayList<College> getList() {
        return collegeDao.getAll();
    }

    public int getAvailableNumberOfSeats() {
        int seatsAvailable = 0;
        ArrayList<College> colleges = new ArrayList<College>();
        colleges = getList();
        for (int index = 0; index < colleges.length(); index++) {
            seatsAvailable += colleges.get(index).getSeats();
        }
        return seatsAvailable;
    }

    public College getCollegeById(String id) {
        return ((CollegeDAO) collegeDao).getCollege(id);
    }

    public void reduceSeat(College college) {
        college.setSeats(college.getSeats()-1);
    }

    public void addStudentToCollege(Student student, String id) {
        College college = ((CollegeDAO) collegeDao).getCollege(id);
        college.addStudent(student);
        student.setCollege(college);
        reduceSeat(college);
    }

    public boolean haveSeats(String id) {
        College college = ((CollegeDAO) collegeDao).getCollege(id);
        if(college.getSeats() != 0){
            return true;
        }
        return false;
    }
    
}
