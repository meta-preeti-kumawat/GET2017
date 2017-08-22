package com.metacube.list.doublylinkedlist;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DoublyLinkedListTest {
    DoublyLinkedList<Integer> linkedListInteger = new DoublyLinkedList<Integer>();
    DoublyLinkedList<String> linkedListString = new DoublyLinkedList<String>();
    
    @Before
    public void inititalize(){
        linkedListInteger.add(2);
        linkedListInteger.add(1);
        linkedListInteger.add(5);
        linkedListInteger.add(4);
        linkedListInteger.add(3);
        
        linkedListString.add("A");
        linkedListString.add("E");
        linkedListString.add("B");
        linkedListString.add("D");
        linkedListString.add("C");
    }
    @Test
    public void testIntegerLength(){
        assertEquals(5, linkedListInteger.length());
    }
    
    @Test
    public void testIntegerIndexOf(){
        assertEquals(2, linkedListInteger.indexOf(5));
    }
    
    @Test
       public void testIntegerRemoveElement(){
        linkedListInteger.removeElement(5);
        assertEquals(-1, linkedListInteger.indexOf(5));
       }
    
    @Test (expected = IndexOutOfBoundsException.class)
    public void testGetWithException(){
        assertNull("Index Out Of Bounds Exception", linkedListInteger.get(7));
    }
    
    @Test
    public void testIntegerAddAtIndex(){
        String expectedOutput = "";
        String output = "";
        linkedListInteger.add(2, 7);
        for(int loop = 0; loop < linkedListInteger.length(); loop++){
            output += linkedListInteger.get(loop) + " ";
        }
        expectedOutput = "2 1 7 5 4 3 ";
        assertEquals(expectedOutput, output);
    }
    
    @Test
    public void testIntegerReverse(){
        String expectedOutput = "";
        String output = "";
        linkedListInteger.reverse();
        for(int loop = 0; loop < linkedListInteger.length(); loop++){
            output += linkedListInteger.get(loop) + " ";
        }
        expectedOutput = "3 4 5 1 2 ";
        assertEquals(expectedOutput, output);
    }
    @Test
    public void testStringReverse(){
        String expectedOutput = "";
        String output = "";
        linkedListString.reverse();
        for(int loop = 0; loop < linkedListString.length(); loop++){
            output += linkedListString.get(loop) + " ";
        }
        expectedOutput = "C D B E A ";
        assertEquals(expectedOutput, output);
    }
    @Test
    public void testIntegerSort(){
        String expectedOutput = "";
        String output = "";
        linkedListInteger.sort();
        for(int loop = 0; loop < linkedListInteger.length(); loop++){
            output += linkedListInteger.get(loop) + " ";
        }
        expectedOutput = "1 2 3 4 5 ";
        assertEquals(expectedOutput, output);
    }
    @Test
    public void testStringSort(){
        String expectedOutput = "";
        String output = "";
        linkedListString.sort();
        for(int loop = 0; loop < linkedListString.length(); loop++){
            output += linkedListString.get(loop) + " ";
        }
        expectedOutput = "A B C D E ";
        assertEquals(expectedOutput, output);
    }
}
