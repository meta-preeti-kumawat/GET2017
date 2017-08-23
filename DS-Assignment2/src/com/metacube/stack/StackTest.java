package com.metacube.stack;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class StackTest {
	private Stack<Integer> integerStack = new Stack<Integer>();
	private Stack<String> stringStack = new Stack<String>();
	
    @Before
    public void initialize(){
    	integerStack.push(1);
    	integerStack.push(2);
    	integerStack.push(3);

    	stringStack.push("A");
    	stringStack.push("B");
    	stringStack.push("C");
    }
	
    @Test
    public void testIntegerPush(){
        integerStack.push(4);
        assertEquals("Top should be 4", new Integer(4), integerStack.getPeek());
    }
    
    @Test
    public void testStringAdd(){
    	stringStack.push("D");
        assertEquals("Top should be D", "D", stringStack.getPeek());
    }

    @Test
    public void testIntegerPop(){
        
        assertEquals("Top should be 2", new Integer(2), integerStack.pop());
    }
    
    @Test
    public void testStringPop(){
    	
        assertEquals("Top should be B", "B", stringStack.pop());
    }
    
    
}
