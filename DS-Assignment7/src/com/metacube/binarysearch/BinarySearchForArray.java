package com.metacube.binarysearch;

import java.util.Arrays;

/**
 * @author Preeti Kumawat
 * Class Name: BinarySearchForArray
 *
 * This class provide methods for binary search
 */
public class BinarySearchForArray {
    
    /**
     * This method is to initiate iterative search 
     * by passing initial value to the iterativeSearch method
     * 
     * @param array
     * @param key
     * @return int index (-1 if element not found)
     */
    public int iterativeSearch(int[] array, int key) {
        Arrays.sort(array);
        return iterativeSearch(array, 0, array.length - 1, key);
    }
    
    /**
     * This is a private overloaded method for finding element iteratively
     * @param array
     * @param left
     * @param right
     * @param key
     * @return int index (-1 if element not found)
     */
    private int iterativeSearch(int[] array, int left, int right, int key){
        while(left < right){
            int mid = ( left + right ) / 2;
            if(key <= array[mid]){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        if(array[left] == key){
            return left;
        }
        else{
            return -1;
        }
    }
    
    /**
     * This method is to initiate recursive search 
     * by passing initial value to the recursiveSearch method
     * @param array
     * @param key
     * @return int index (-1 if element not found)
     */
    public int recursiveSearch(int[] array, int key) {
        Arrays.sort(array);
        return recursiveSearch(array, 0, array.length - 1, key);
    }
    
    /**
     * This is a private overloaded method for finding element recursively
     * @param array
     * @param left
     * @param right
     * @param key
     * @return int index (-1 if element not found)
     */
    private int recursiveSearch(int[] array, int left, int right, int key){
        if(left < right){
            int mid = ( left + right ) / 2;
            if(key <= array[mid]){
                return recursiveSearch(array, left, mid, key);
            }
            else{
                return recursiveSearch(array, mid + 1, right, key);
            }
        }
        else{
            if(array[left] == key){
                return left;
            }
            else{
                return -1;
            }
        }
    }
}
