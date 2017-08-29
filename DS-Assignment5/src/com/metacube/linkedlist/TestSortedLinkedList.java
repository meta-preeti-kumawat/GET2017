package com.metacube.linkedlist;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestSortedLinkedList {
    SortedLinkedList<Integer> list = new SortedLinkedList<Integer>();
    
    @Test
    public void testAdd(){
        list.add(10);
        list.add(7);
        list.add(5);
        assertEquals(new Integer(5), list.getFirst());
    }
}
