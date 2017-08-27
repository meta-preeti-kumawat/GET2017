package com.metacube.queue;

import java.util.LinkedList;

/**
 * 
 * @author Preeti Kumawat
 * Class Name: Queue
 * @param <E>
 */
public class Queue<E> {
    private LinkedList<E> list = new LinkedList<E>();
         
    /**
     * This method adds element at the end of queue
     * @param element
     */
    public void enqueue(E element){
        list.addLast(element);
    }
    
    /**
     * Removes first element of the queue
     * @return removed element
     */
    public E dequeue(){
        return list.poll();
    }

    /**
     * @return element at index 0
     */
    public E getFront() {
        return list.peek();
    }
    
    /**
     * @return int size of queue
     */
    public int size(){
        return list.size();
    }
    
    /**
     * @return true if queue is empty else false
     */
    public boolean isEmpty(){
        return list.isEmpty();
    }
    
    /**
     * Adds elements of a new queue to this queue
     * @param newQueue
     */
    public void addItems(Queue<? extends E> newQueue){
        while(!newQueue.isEmpty()){
            this.enqueue(newQueue.dequeue());
        }
    }
}
