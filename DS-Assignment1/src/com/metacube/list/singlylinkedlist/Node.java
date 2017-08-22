package com.metacube.list.singlylinkedlist;

public class Node<E>{
    private E data;
    private Node<E> next;
    
    public Node(E element, Node<E> next) {
        data = element;
        this.next = next;
    }
    public Node() {
        data = null;
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
    public void copy(Node<E> node){
        this.setData(node.getData());
        this.setNext(node.getNext());
    }
}
