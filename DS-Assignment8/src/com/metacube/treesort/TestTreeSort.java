package com.metacube.treesort;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class TestTreeSort {
    BinarySearchTree<Student> students = new BinarySearchTree<Student>();
    Set<Student> studentSet = new LinkedHashSet<Student>();
    
    @Before
    public void initialize(){
        studentSet.add(new Student(11,"A"));
        studentSet.add(new Student(2,"B"));
        studentSet.add(new Student(7,"C"));
        studentSet.add(new Student(1,"D"));
        studentSet.add(new Student(1,"E"));
        System.out.println(studentSet);

        students.addSet(studentSet);
    }
    @Test
    public void testSorting(){
        List<Student> expectedSortedList = new ArrayList<Student>();
        expectedSortedList.add(new Student(1,"D"));
        expectedSortedList.add(new Student(2,"B"));
        expectedSortedList.add(new Student(7,"C"));
        expectedSortedList.add(new Student(11,"A"));
        assertEquals("Error: Unable to sort as expected", expectedSortedList, students.treeSort());
    }
    
}
