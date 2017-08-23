package com.metacube.queue.dao;

import com.metacube.queue.model.Student;

public interface StudentDAO extends BaseDao<Student> {

    public Student getStudentById(String id);

}
