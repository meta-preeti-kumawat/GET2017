package com.metacube.binarysearch;

/**
 * 
 * @author Preeti Kumawat
 * Class Name: BinarySearchTree
 * 
 * This class hold information about a BST
 *
 */
public class BinarySearchTree {
    private Node root = null;
    
    /**
     * @return root of BST
     */
    public Node getRoot() {
        return root;
    }
    
    /**
     * @return true if tree is empty
     */
    public boolean isEmpty(){
        return root == null;
    }
    
    /**
     * Initialize addNode method for a given element
     * @param element
     */
    public void addNode(int element){
        root = add(root, element);
    }

    /**
     * This is a private method used recursively to add element at appropriate location
     * @param node
     * @param element
     * @return Node
     */
    private Node add(Node node, int element) {
        if(node == null){
            node = new Node(element);
        }
        else{
            if(node.getData() < element){
                node.setRight(add(node.getRight(), element));
            }
            else{
                node.setLeft(add(node.getLeft(), element));
            }
        }
        return node;
    }
    
    /**
     * Initiate search method using root
     * @param key
     * @return Node | null if node is unavailable
     */
    public Node search(int key){
        Node node = search(root, key);
        return node;
    }
    
    /**
     * This is a private method which performs search operation recursively
     * @param node
     * @param key
     * @return Node | null if node is unavailable
     */
    private Node search(Node node, int key){
        if(node != null){
            if(key == node.getData()){
                return node;
            }
            else if(key < node.getData()){
                return search(node.getLeft(), key);
            }
            else{
                return search(node.getRight(), key);
            }
        }
        return null;
    }
}
