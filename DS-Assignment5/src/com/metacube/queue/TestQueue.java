package com.metacube.queue;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestQueue {
    Queue<Integer> queue = new Queue<Integer>();
    
    @Test
    public void testEnqueue(){
        queue.enqueue(1);
        assertEquals("Error: Front is not 1", new Integer(1), queue.getFront());
    }
    @Test
    public void testDequeue(){
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals("Error: Element is not removed", new Integer(1), queue.dequeue());
    }
    @Test
    public void testDequeueForEmptyQueue(){
        assertNull("Error: Queue is not empty", queue.dequeue());
    }
    @Test
    public void testEmpty(){
        assertTrue("Error: Queue is not empty", queue.isEmpty());
    }
    @Test
    public void testNonEmpty(){
        queue.enqueue(2);
        assertFalse("Error: Queue is empty", queue.isEmpty());
    }
    @Test
    public void testAddItems(){
        queue.enqueue(1);
        Queue<Integer> newQueue = new Queue<Integer>();
        newQueue.enqueue(2);
        newQueue.enqueue(3);
        queue.addItems(newQueue);
        assertEquals("Error: Queue size is not 3", 3, queue.size() );
    }
    
}
