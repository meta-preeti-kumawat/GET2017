package com.metacube.utility;

import java.util.Arrays;

/**
 * 
 * @author Preeti Kumawat
 * Class Name: ArrayList
 * @param <Type>
 */
public class ArrayList<Type extends Object>{
    private Object[] list;
    private int length = 0;
    
    public ArrayList() {
        list = new Object[0];
        length = 0;
    }

    public int length(){
        return length;
    }
    /**
     * add element to array list
     * @param element
     */
    public void add(Type element){
        list = Arrays.copyOf(list, length + 1);
        list[length++] = element;
    }
    
    /**
     * add element at specific index
     * @param index
     * @param element
     */
    public void add(int index, Type element){
        if(index < length){
            list = Arrays.copyOf(list, length);
            int lastIndex = length - 1;
            while(lastIndex > index){
                list[lastIndex] = list[lastIndex - 1];
                lastIndex--;
            }
            list[index] = element;
        }
        else {
            throw new IndexOutOfBoundsException("Index is invalid");
        }
    }
    
    /**
     * update element at specific index
     * @param index
     * @param element
     */
    public void update(int index, Type element){
        if(index < length){
            list[index] = element;
        }
        else {
            throw new IndexOutOfBoundsException("Index is invalid");
        }
    }
    /**
     * Add a new list to existing list
     * @param newList
     * @return ArrayList
     */
    public ArrayList<Type> addList(ArrayList<Type> newList){
        for (int loop = 0; loop < newList.getAll().length; loop++) {
            add(newList.get(loop));
        }
        
        return this;
    }
    
    /**
     * get element at given index
     * @param index
     * @return element
     */
    @SuppressWarnings("unchecked")
    public Type get(int index) {
        Type element = null;
        if(index < 0){
            throw new NegativeArraySizeException("Exception: Negative Array size");
        }
        else if(index < length){
            element = (Type) list[index];
        }
        else {
            throw new ArrayIndexOutOfBoundsException("Exception: Array index out of bound");
        }
        return element;
    }
    
    /**
     * get index of given element
     * @param element
     * @return int index
     * @throws Exception
     */
    public int indexOf(Type element) throws Exception{
        int index = -1;
        for(int loop = 0; loop < length; loop++ ){
            if(list[loop].equals(element)){
                index = loop;
                break;
            }
        }
        if(index == -1){
            throw new NegativeArraySizeException("Element not found");
        }
        return index;
    }
    
    /**
     * Remove element at given index
     * @param index
     * @return element
     */
    @SuppressWarnings("unchecked")
    public Type removeElementAtIndex(int index){
        if(index < length){
            Type element = (Type) list[index];
            int shiftIndex = index;
            while(shiftIndex < length - 1){
                list[shiftIndex] = list[shiftIndex + 1];
                shiftIndex++;
            }
            list = Arrays.copyOf(list, length - 1);
            length--;
            return element;
        }
        throw new ArrayIndexOutOfBoundsException("Array index unavailable");
    }
    
    /**
     * remove given element
     * @param element
     * @return element
     * @throws Exception
     */
    public Type removeElement(Type element) throws Exception{
        return removeElementAtIndex(indexOf(element));
    }
    
    /**
     * clear array list
     */
    public void clear(){
        list = Arrays.copyOf(list, 0);
        length = 0 ;
    }
    
    /**
     * reverse an array list
     */
    @SuppressWarnings("unchecked")
    public void reverse(){
        for(int index = 0 ; index < length/2 ; index++){
            Type swap = (Type) list[index];
            list[index ] = list[length - index - 1];
            list[length - index - 1] = swap;
        }
    }

    /**
     * sort array list
     */
    public void sort() {
        Arrays.sort(list);
    }
    
    @SuppressWarnings("unchecked")
    public Type[] getAll() {
        return (Type[]) list;
    }
    
    public String toString() {
        return Arrays.toString(list);
    }
}
