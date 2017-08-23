package com.metacube.trees;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BinaryTreeTest {
    private    BinaryTree binaryTree =  new BinaryTree();
    
    @Before 
    public void initialize(){
        binaryTree.addNode(5);
        binaryTree.addNode(6);
        binaryTree.addNode(2);
        binaryTree.addNode(4);
        binaryTree.addNode(1);
    }
    
    @Test
    public void testInOrder()
    {
        assertEquals("1 2 4 5 6 ", binaryTree.inOrder());    
    }
    
    @Test
    public void testPreOrder()
    {
        assertEquals("5 2 1 4 6 ", binaryTree.preOrder());    
    }
    
    @Test
    public void testPostOrder()
    {
        assertEquals("1 4 2 6 5 ", binaryTree.postOrder());    
    }
}
