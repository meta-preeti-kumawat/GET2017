package com.metacube.list.arraylist;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayListTest {
    
    @Test
    public void testIntegerAdd(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        Integer[] expectedOutput = {2};
        assertArrayEquals("Arrays should be equal", expectedOutput, list.getAll());
    }
    @Test
    public void testIntegerAddAtIndex(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(4);
        list.add(1,3);
        Integer[] expectedOutput = {2,3,4};
        assertArrayEquals("3 should be inserted at index 1", expectedOutput, list.getAll());
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testIntegerAddAtIndexWithException(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2, 2);
        Integer[] expectedOutput = {};
        assertArrayEquals("Index out of bound exception", expectedOutput, list.getAll());
    }
    
    @Test
    public void testIntegerGet(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(4);
        list.add(6);
        Integer expectedOutput = 4;
        assertEquals("Index should be 1 for Integer 4", expectedOutput, list.get(1));
    }
    
    @Test(expected = NegativeArraySizeException.class)
    public void testIntegerGetWithExceptionNegativeArraySize(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(4);
        list.add(6);
        Integer expectedOutput = 0;
        assertEquals("Negative Array Size Exception", expectedOutput, list.get(-1));
    }
    
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testIntegerGetWithExceptionArrayIndexOutOfBound(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(4);
        list.add(6);
        Integer expectedOutput = 0;
        assertEquals("Array Index Out Of Bounds Exception", expectedOutput, list.get(6));
    }
    
    @Test
    public void testIntegerIndexOf() throws Exception{
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(4);
        list.add(6);
        int expectedOutput = 1;
        assertEquals("Index should be 1 for Integer 4", expectedOutput, list.indexOf(4));
    }
    
    @Test(expected = Exception.class)
    public void testIntegerIndexOfWithException() throws Exception{
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(4);
        list.add(6);
        int expectedOutput = -1;
        assertEquals("Index should be -1 for Integer 5", expectedOutput, list.indexOf(5));
    }
    

    @Test
    public void testIntegerRemoveElementAtIndex(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(4);
        list.add(6);
        Integer expectedOutput = 4;
        assertEquals("It should remove element 4 from list", expectedOutput, list.removeElementAtIndex(1));
    }
    
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testIntegerRemoveElementAtIndexWithException(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(4);
        list.add(6);
        Integer expectedOutput = -1;
        assertEquals("Index should be -1 for Integer 5", expectedOutput, list.removeElementAtIndex(8));
    }
    
    @Test
    public void testIntegerRemoveElement() throws Exception{
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(4);
        list.add(6);
        Integer expectedOutput = 4;
        assertEquals("It should remove element 4 from list", expectedOutput, list.removeElement(4));
    }
    
    @Test(expected = Exception.class)
    public void testIntegerRemoveElemenWithException() throws Exception{
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(4);
        list.add(6);
        Integer expectedOutput = -1;
        assertEquals("Exception as element is not found", expectedOutput, list.removeElement(3));
    }
    
    @Test
    public void testIntegerClear(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(4);
        list.add(6);
        list.clear();
        Integer[] expectedOutput = {};
        assertArrayEquals("It should remove all elements from list", expectedOutput, list.getAll());
    }
    
    @Test
    public void testIntegerReverse(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(4);
        list.add(6);
        list.reverse();
        Integer[] expectedOutput = {6, 4, 2};
        assertArrayEquals("It should rreverse the list", expectedOutput, list.getAll());
    }
    
    @Test
    public void testIntegerSort(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(6);
        list.add(4);
        list.sort();
        Integer[] expectedOutput = {2, 4, 6};
        assertArrayEquals("It should reverse the list", expectedOutput, list.getAll());
    }
    
    @Test
    public void testStringSort(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("a");
        list.add("z");
        list.add("f");
        list.sort();
        String[] expectedOutput = {"a", "f", "z"};
        assertArrayEquals("It should reverse the list", expectedOutput, list.getAll());
    }
    
    @Test
    public void testIntegerAddList(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(6);
        list.add(4); 
        ArrayList<Integer> newList = new ArrayList<Integer>();
        newList.add(1);
        newList.add(3);
        list.addList(newList);
        Integer[] expectedOutput = {2, 6, 4, 1, 3};
        assertArrayEquals("It should append the list with elements of new List", expectedOutput, list.getAll());
    }
    
    @Test
    public void testStringAdd(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("ABC");
        String[] expectedOutput = {"ABC"};
        assertArrayEquals("It should insert in String array", expectedOutput, list.getAll());
    }
    
    
}
