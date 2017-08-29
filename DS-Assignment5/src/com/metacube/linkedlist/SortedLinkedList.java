package com.metacube.linkedlist;

import java.util.LinkedList;

/**
 * 
 * @author Preeti Kumawat
 * Class Name: SortedLinkedList
 *
 * @param <E>
 */
@SuppressWarnings("serial")
public class SortedLinkedList<E extends Comparable<E>> extends LinkedList<E>{

	/**
	 * adds element in sorted order
	 */
	@Override
    public boolean add(E element){
        if (!isEmpty()) {
            int index = 0;
            if(this.contains(element)){
                index = lastIndexOf(element) + 1;
            }
            return findIndex(index, element);    
        }
        else{
            addFirst(element);
        }
        return true;
    }

	/**
	 * finds specific index for new element 
	 * @param index
	 * @param element
	 * @return boolean true
	 */
    private boolean findIndex(int index, E element) {
        if (this.size() > index && element.compareTo(get(index)) > 0) {
            return findIndex(index + 1, element);
        }
        else{
            add(index, element);
            return true;
        }
    }
}
