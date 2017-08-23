package com.metacube.list.doublylinkedlist;

public class Node<E>{
    private Node<E> prev;
    private E data;
    private Node<E> next;
    
    public Node(E element, Node<E> prev, Node<E> next) {
        data = element;
        this.prev = prev;
        this.next = next;
    }
    public Node() {
        data = null;
        prev = null;
        next = null;
    }
    public E getData() {
        return data;
    }
    public void setData(E data) {
        this.data = data;
    }
    public Node<E> getNext() {
        return next;
    }
    public void setNext(Node<E> next) {
        this.next = next;
    }
    public Node<E> getPrev() {
        return prev;
    }
    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }
}
