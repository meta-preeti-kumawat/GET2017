package com.metacube.treesort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author Preeti Kumawat
 * Class Name: BinarySearchTree
 * 
 * This class hold information about a BST
 *
 */
public class BinarySearchTree<E extends Comparable<E>> {
    private Node<E> root = null;
    private List<E> inOrderList = new ArrayList<E>();
    /**
     * @return root of BST
     */
    public Node<E> getRoot() {
        return root;
    }
    
    /**
     * @return true if tree is empty
     */
    public boolean isEmpty(){
        return root == null;
    }
    
    public void addSet(Set<E> elementSet){
        for (Iterator<E> iterator = elementSet.iterator(); iterator.hasNext();) {
            E element = (E) iterator.next();
            addNode(element);
        }
    }
    
    /**
     * Initialize addNode method for a given element
     * @param element
     */
    public void addNode(E element){
        root = add(root, element);
    }

    /**
     * This is a private method used recursively to add element at appropriate location
     * @param node
     * @param element
     * @return Node
     */
    private Node<E> add(Node<E> node, E element) {
        if(node == null){
            node = new Node<E>(element);
        }
        else{
            if(node.getData().compareTo(element) < 0){
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
    public Node<E> search(E key){
        Node<E> node = search(root, key);
        return node;
    }
    
    /**
     * This is a private method which performs search operation recursively
     * @param node
     * @param key
     * @return Node | null if node is unavailable
     */
    private Node<E> search(Node<E> node, E key){
        if(node != null){
            if(key == node.getData()){
                return node;
            }
            else if(key.compareTo(node.getData()) < 0){
                return search(node.getLeft(), key);
            }
            else{
                return search(node.getRight(), key);
            }
        }
        return null;
    }
    /**
     * this method initializes tree sort 
     * @return List of elements in sorted order
     */
    public List<E> treeSort() {
        inOrder(root);
        return inOrderList;
    }

    private void inOrder(Node<E> node) {
        if(node != null){
            inOrder(node.getLeft());
            inOrderList.add(node.getData());
            inOrder(node.getRight());
        }
    }
}
