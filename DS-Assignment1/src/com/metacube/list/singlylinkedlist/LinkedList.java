package com.metacube.list.singlylinkedlist;

/**
 * 
 * @author Preeti Kumawat
 * Class name; LinkedList
 * @param <E>
 */
public class LinkedList<E>{
    private Node<E> head = new Node<E>();
    
    /**
     * adds new element at end
     * @param element
     */
    public void add(E element){
        Node<E> node = new Node<E>(element, null);
        Node<E> currentNode = head;
        while(currentNode.getNext() != null){
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(node);
    }
    
    /**
     * checks if list is empty
     * @return true if empty
     */
    public boolean isEmpty(){
        return head.getNext() == null;
    }
    
    /**
     * @return length of linked list
     */
    public int length(){
        int length = 0;
        Node<E> currentNode = head;
        while(currentNode.getNext() != null){
            length++;
            currentNode = currentNode.getNext();
        }
        return length;
    }
    
    /**
     * adds element at given index
     * @param index
     * @param element
     */
    public void add(int index, E element){
        Node<E> node = new Node<E>(element, null);
        if(index < 0){
            throw new NegativeArraySizeException("Element cannot be assigned to a negative index location");
        }
        else if( this.length() >= index){
            Node<E> currentNode = head;
            int loop = 0;
            while(loop < index){
                currentNode = currentNode.getNext();
                loop++;
            }
            node.setNext(currentNode.getNext());
            currentNode.setNext(node);
        }
        else{
            throw new IndexOutOfBoundsException("Index out of bound");
        }
    }
    
    /**
     * finds element at given index
     * @param element
     * @return
     */
    public int indexOf(E element){
        int index = -1;
        boolean check = false;
        Node<E> currentNode = head.getNext();
        while(currentNode != null){
            index++;
            if(currentNode.getData().equals(element)){
                check = true;
                break;
            }
            currentNode = currentNode.getNext();
        }
        if(check == false){
            index = -1;
        }
        return index;
    }
    
    /**
     * finds data at given index
     * @param index
     * @return data
     */
    public E get(int index){
        if(!isEmpty()){
            Node<E> currentNode = head.getNext();
            if(index < this.length()){
                int loop = -1;
                while(loop < index - 1){
                    loop++;
                    currentNode = currentNode.getNext();
                }
                return currentNode.getData();
            }
            else{
                throw new IndexOutOfBoundsException("Index not available");
            }
        }
        else{
            throw new NullPointerException("Index not available");
        }
        
    }
    
    /**
     * removes element at given index
     * @param index
     */
    public void removeElementAtIndex(int index){
        if(index < this.length()){
            int loop = -1;
            Node<E> currentNode = head;
            while(loop < index - 1){
                currentNode = currentNode.getNext();
                loop++;
            }
            currentNode.setNext(currentNode.getNext().getNext());
        }
        else {
            throw new IndexOutOfBoundsException("Index not available");
        }
    }
    
    /**
     * removes given element from list
     * @param element
     */
    public void removeElement(E element){
        int indexOfElement = indexOf(element);
        if(indexOfElement != -1){
            removeElementAtIndex(indexOfElement);
        }
        else{
            throw new NullPointerException("Element does not exist");
        }
    }
    
    /**
     * reverse the list
     */
    public void reverse(){
        if(!this.isEmpty()){
            Node<E> previous = null;
            Node<E> currentNode = head.getNext();
            Node<E> next = null;
            while(currentNode != null){
                next = currentNode.getNext();
                currentNode.setNext(previous);
                previous = currentNode;
                currentNode = next;
            }
            head.setNext(previous);
        }
        else{
            throw new NullPointerException("List not available");
        }
    }
    
    /**
     * sorts the list
     */
    public void sort(){
        if(!this.isEmpty()){
            Node<E> currentNode = head.getNext();
            Node<E> next = null;
            
            while(currentNode.getNext() != null){
                next = currentNode.getNext();
                while(next != null){
                    if( next.getData().toString().compareTo(currentNode.getData().toString()) < 0){
                        E element = next.getData();
                        next.setData(currentNode.getData());
                        currentNode.setData(element);
                    }
                    else{;
                        next = next.getNext();
                    }
                }
                currentNode = currentNode.getNext();
            }
        }
    }
}
