package com.metacube.heap;

import com.metacube.utility.ArrayList;
import com.metacube.utility.Queue;

public class Heap<E extends Comparable<E>> {
    private int heapSize = 0;
    Queue<E> priorityQueue = new Queue<E>();
    
    public void heapify(ArrayList<E> queue, int index){
        int left = getLeft(index);
        int right = getRight(index);
        int largest;
        
        if(left < heapSize && queue.get(left).compareTo(queue.get(index)) > 0){
            largest = left;
        }
        else{
            largest = index;
            
        }
        if(right < heapSize && queue.get(right).compareTo(queue.get(largest)) > 0){
            largest = right;
        }
        if(largest != index){
            queue = swap(queue, index, largest);
            heapify(queue, largest);
        }
    }
    
    private ArrayList<E> swap(ArrayList<E> queue, int index1, int index2) {
        E swapVariable = queue.get(index1);
        queue.update(index1, queue.get(index2));
        queue.update(index2, swapVariable);     
        return queue;
    }

    private int getRight(int index) {
        return (2 * index + 2);
    }

    private int getLeft(int index) {
        return (2 * index + 1);
    }

    public void buildHeap(ArrayList<E> queue){
        heapSize = queue.length();
        for (int index = heapSize / 2; index >= 0 ; index--) {
            heapify(queue, index);
        }
    }
    
    public Queue<E> heapSort(ArrayList<E> queue){
        buildHeap(queue);
        
        for (int index = heapSize - 1; index >= 0 ; index-=1) {
            priorityQueue.enqueue(queue.get(0));
            queue = swap(queue, 0, index);
            queue.removeElementAtIndex(heapSize - 1);
            heapSize--;
            heapify(queue, 0);
        }
        return priorityQueue;
    }
}
