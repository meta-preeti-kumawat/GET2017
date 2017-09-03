package com.metacube.sortingsystem;

/**
 * 
 * @author Preeti Kumawat
 * Class Name: SortingSystem
 * 
 * This class is used to implement an intelligent system for sorting 
 * which selects appropriate sorting algorithm according to given input
 */
public class SortingSystem {
    private int array[];
    private String wayToSort;
    
    /**
     * This method calls the type of sorting algorithm provided as input
     * @param input
     * @param choice (COMPARISON_SORT, LINEAR_SORT)
     */
    public void sort(int[] input, Choice choice){
        array = input;
        
        switch(choice) {
        case COMPARISON_SORT:
            comparisonSort();
            break;
        case LINEAR_SORT:
            linearSort();
        }
    }
    
    /**
     * This method select appropriate method among Radix sort and Counting sort
     * Radix sort is used if numbers have more than 2 digits else counting sort is used
     */
    private void linearSort() {
        if(findMax()/100 > 0) {
            setWayToSort("Radix Sort");
            radixSort();
        } else {
            setWayToSort("Counting Sort");
            countingSort();
        }
    }

    /**
     * This method is used to implement counting sort
     */
    private void countingSort() {
        int count[] = new int[findMax() + 1];
        for (int index = 0; index < array.length; index++) {
            count[array[index]]++;
        }
        
        // Sum of count array.
        for (int index = 1; index < count.length; index++) {
            count[index] += count[index - 1];
        }
        
        int output[] = new int[array.length];
        for (int index = array.length - 1; index >= 0 ; index--) {
            output[--count[array[index]]] = array[index];
        }
        
        // Assign values of output to actual array
        for (int index = 0; index < output.length; index++) {
            array[index] = output[index];
        }
    }

    /**
     * This method is used to implement radix sort
     */
    private void radixSort() {
        int max = findMax();
        
        for (int position = 1; max / position > 0; position *= 10) {
            extendedCountingSort(position);
        }
    }

    /**
     * This is extended method for count sort
     * which does digit by digit sorting
     * @param position
     */
    private void extendedCountingSort(int position) {
        int output[] = new int[array.length];
        int count[] = new int[10];
        
        for (int index = 0; index < array.length; index++) {
            count[(array[index] / position) % 10]++;
        }
        
        // Sum of count array.
        for (int index = 1; index < count.length; index++) {
            count[index] += count[index - 1];
        }
        
        for (int index = array.length - 1; index >= 0; index--) {
            output[--count[(array[index] / position) % 10]] = array[index];
        }
        
        // Assign values of output to actual array
        for (int index = 0; index < output.length; index++) {
            array[index] = output[index];
        }
    }

    /**
     * This method returns the maximum element from input array
     * @return int max
     */
    private int findMax() {
        int max = array[0];
        for (int index = 1; index < array.length; index++) {
            if(max < array[index]) {
                max = array[index];
            }
        }
        
        return max;
    }

    /**
     * This method select appropriate method among Bubble sort and Quick sort
     * Bubble sort is used if size of array is up to 10 else Quick sort is used
     */
    private void comparisonSort() {
        if(array.length <= 10) {
            setWayToSort("Bubble Sort");
            bubbleSort();
        } else {
            setWayToSort("Quick Sort");
            quickSort();
        }
    }

    /**
     * This method implements algorithm for bubble sort
     */
    private void bubbleSort() {
        for (int outerIndex = 0; outerIndex < array.length - 1; outerIndex++) {
            for (int innerIndex = 0; innerIndex < array.length - outerIndex - 1; innerIndex++) {
                if(array[innerIndex] > array[innerIndex + 1]) {
                    swapElementsOfArrayAt(innerIndex, innerIndex + 1);
                }
            }
        }
    }

    /**
     * This method swaps the elements at given indices
     * @param indexOne
     * @param indexTwo
     */
    private void swapElementsOfArrayAt(int indexOne, int indexTwo) {
        int swapVariable = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = swapVariable;
    }

    private void quickSort() {
        quickSort(0, array.length - 1);
    }

    /**
     * @param startIndex int
     * @param endIndex int
     */
    private void quickSort(int startIndex, int endIndex) {
        int pivotIndex;
        if (startIndex < endIndex) {
            pivotIndex = partitionArray(startIndex, endIndex);
            
            quickSort(startIndex, pivotIndex - 1);  //Recursion for elements smaller than pivot element
            quickSort(pivotIndex + 1, endIndex);      //Recursion for elements larger than pivot element
        }
    }
    
    /**
     * Partitions the array according to the pivotIndex element
     * @param startIndex int
     * @param endIndex int
     * @return int pivotIndex
     * pivot element is the first element of respective array
     */
    private int partitionArray(int startIndex, int endIndex) {
        int pivotIndex = startIndex;
        int flag;
        int minIndex = startIndex + 1;
        int maxIndex = endIndex;
        
        while (minIndex <= maxIndex) {
            flag = 0;
            if (array[minIndex] < array[pivotIndex] && minIndex <= endIndex) {
                //increment minimum index until a greater value than pivot is encountered 
                minIndex++;
                flag = 1;
            }
            
            if (array[maxIndex] > array[pivotIndex] && maxIndex >= startIndex) {
                //decrement maximum index until a smaller value than pivot is encountered
                maxIndex--;
                flag = 1;
            }
            
            if (flag == 0 && maxIndex > minIndex) {
                //swap element at Min Index with element at Max Index if min Index is less than Max Index
                swapElementsOfArrayAt(minIndex, maxIndex);
            }
        }
        
        //swap pivot element and element at Max index when minimum index is greater than maximum Index
        swapElementsOfArrayAt(pivotIndex, maxIndex);
        
        //return new index of pivot element
        return maxIndex;
    }

    public String getWayToSort() {
        return wayToSort;
    }

    private void setWayToSort(String wayToSort) {
        this.wayToSort = wayToSort;
    }
}