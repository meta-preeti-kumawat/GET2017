package com.metacube.binarysearch;

/**
 * @author Preeti Kumawat
 * Class Name: Node
 */
public class Node {
    private Node left;
    private int data;
    private Node right;

    public Node(int element, Node left, Node right) {
        data = element;
        this.left = left;
        this.right = right;
    }
    public Node(int element) {
        data = element;
        left = null;
        right = null;
    }
    public Node getLeft() {
        return left;
    }
    public void setLeft(Node left) {
        this.left = left;
    }
    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
    public Node getRight() {
        return right;
    }
    public void setRight(Node right) {
        this.right = right;
    }
}
