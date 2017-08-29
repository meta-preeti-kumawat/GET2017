package com.metacube.binarysearch;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BinarySearchTest {
    private BinarySearchTree binarySearchTree = new BinarySearchTree();
    private BinarySearchForArray binarySearchForArray = new BinarySearchForArray();
    int[] array = {4, 2, 4, 2, 2, 1, 2};
    
    @Before 
    public void initialize(){
        binarySearchTree.addNode(5);
        binarySearchTree.addNode(6);
        binarySearchTree.addNode(2);
        binarySearchTree.addNode(1);
        binarySearchTree.addNode(2);
    }
    
    @Test
    public void searchAvailableNode(){
        assertNotNull("Error: Unable to search node", binarySearchTree.search(2));
    }
    @Test
    public void searchUnavailableNode(){
        assertNull("Error: Result should be null", binarySearchTree.search(3));
    }
    @Test
    public void iterativeSearchAvailableElementInArray(){
        assertEquals("Error: Unable to search element", 1, binarySearchForArray.iterativeSearch(array, 2));
    }
    @Test
    public void iterativeSearchUnavailableElementInArray(){
        assertEquals("Error: Result is not -1", -1, binarySearchForArray.iterativeSearch(array, 3));
    }
    @Test
    public void recursiveSearchAvailableElementInArray(){
        assertEquals("Error: Unable to search element", 1, binarySearchForArray.recursiveSearch(array, 2));
    }
    @Test
    public void recursiveSearchUnavailableElementInArray(){
        assertEquals("Error: Result is not -1", -1, binarySearchForArray.recursiveSearch(array, 3));
    }
}
