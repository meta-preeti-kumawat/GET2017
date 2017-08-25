package com.metacube.utility;


public class Queue<E> {
    private ArrayList<E> queue = new ArrayList<E>();
    
    public void enqueue(E item){
        queue.add(item);
    }
    
    public E dequeue(){
        if(queue.length() > 0){
            return queue.removeElementAtIndex(0);
        }
        throw new NullPointerException("Exception: You are trying to remove an element from empty queue");
    }
    
    public void makeEmpty(){
        queue.clear();
    }
    
    public E getFront(){
        if(queue.length() > 0){
            return queue.get(0);
        }
        throw new NullPointerException("Exception: You are trying to get an element from empty queue");
    }
    
    public int getQueueSize(){
        return queue.length();
    }
}
