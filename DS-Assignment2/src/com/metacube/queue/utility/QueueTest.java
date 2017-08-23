package com.metacube.queue.utility;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class QueueTest {
    private Queue<Integer> integerQueue = new Queue<Integer>();
    private Queue<String> stringQueue = new Queue<String>();
    
    @Before
    public void initialize(){
        integerQueue.enqueue(1);
        integerQueue.enqueue(2);
        integerQueue.enqueue(3);

        stringQueue.enqueue("A");
        stringQueue.enqueue("B");
        stringQueue.enqueue("C");
    }
    
    @Test
    public void testIntegerEnqueue(){
        integerQueue.enqueue(4);
        assertEquals("Error: Front is not 1", new Integer(1), integerQueue.getFront());
    }
    
    @Test
    public void testStringEnqueue(){
        stringQueue.enqueue("A");
        assertEquals("Error: Front is not A", "A", stringQueue.getFront());
    }

    @Test
    public void testIntegerDequeue(){
        assertEquals("Error: Removed element is not 1", new Integer(1), integerQueue.dequeue());
    }
    
    @Test
    public void testStringDequeue(){
        assertEquals("Error: Removed element is not A", "A", stringQueue.dequeue());
    }
    
    @Test(expected = NullPointerException.class)
    public void testClear() {
        integerQueue.makeEmpty();
        assertNull("Error: Queue is not cleared", integerQueue.getFront());
    }
    
}
