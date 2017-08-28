package com.metacube.hash;

import java.lang.reflect.Array;

public class HashTable<E> {
    private int memoryBlocks;
    private E[] table;
    Status status = new Status();
    
    @SuppressWarnings("unchecked")
    public HashTable(Class<E> type, int size) {
        memoryBlocks = size;
        setTable((E[])Array.newInstance(type, size + 1));
    }
    
    public boolean isMemoryAvailale(){
        for (int index = 1; index < table.length; index++) {
            if(table[index] == null){
                return true;
            }
        }
        return false;
    }
    
    public int hashCode(int number){
        return (number % memoryBlocks) + 1;
    }

    public E[] getTable() {
        return table;
    }

    public void setTable(E[] table) {
        this.table = table;
    }
    
    public Status add(E element, int key){
        int index = hashCode(key);
        if(table[index] == null){
            table[index] = element;
            status.setSuccess(true);
            status.setMessage("Alloted space at "+index);
            return status;
        }
        else{
            if(isMemoryAvailale()){
                index = openAddressing(key);
                add(element, index);
            }
            else{
                status.setSuccess(false);
                status.setError("No more space is available");
                return status;
            }
        }
        return status;
    }

    private int openAddressing(int key) {
        return hashCode(key) + 3;
    }
}
