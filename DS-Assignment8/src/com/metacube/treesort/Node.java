package com.metacube.treesort;

/**
 * @author Preeti Kumawat
 * Class Name: Node
 */
public class Node<E extends Comparable<E>> {
    private Node<E> left;
    private E data;
    private Node<E> right;

    public Node(E element, Node<E> left, Node<E> right) {
        data = element;
        this.left = left;
        this.right = right;
    }
    public Node(E element) {
        data = element;
        left = null;
        right = null;
    }
    public Node<E> getLeft() {
        return left;
    }
    public void setLeft(Node<E> left) {
        this.left = left;
    }
    public E getData() {
        return data;
    }
    public void setData(E data) {
        this.data = data;
    }
    public Node<E> getRight() {
        return right;
    }
    public void setRight(Node<E> right) {
        this.right = right;
    }
}
