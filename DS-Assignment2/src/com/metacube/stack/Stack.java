package com.metacube.stack;

public class Stack<E> {
	private LinkedList<E> data = new LinkedList<E>();

	public void push(E element){
		data.add(0, element);
	}

	public boolean isEmpty(){
		return data.isEmpty();
	}
	
	public E pop(){
		if(data.isEmpty()){
			throw new NullPointerException("Cannot pop from an empty Stack : underflow situation");
		}
		return data.removeElementAtIndex(0);
	}
	
	public void clear(){
		data = null;
	}
	
	public E getPeek() {
		return data.get(0);
	}
}
