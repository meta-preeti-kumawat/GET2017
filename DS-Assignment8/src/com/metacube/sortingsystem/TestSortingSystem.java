package com.metacube.sortingsystem;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestSortingSystem {
    SortingSystem sortingSystem;
    
    @Before 
    public void initialize() {
        sortingSystem = new SortingSystem();
    }
    
    @Test
    public void testSortForBubbleSort() {
        int array[] = new int[] {4, 3, 5, 6, 1, 2};
        sortingSystem.sort(array, Choice.COMPARISON_SORT);
        int expectedOutput[] = new int[] {1, 2, 3, 4, 5, 6};
        assertArrayEquals(expectedOutput, array);
        assertEquals("Bubble Sort", sortingSystem.getWayToSort());
    }
    
    @Test
    public void testSortForQuickSort() {
        int array[] = new int[] {4, 3, 5, 6, 1, 2, 10, 9, 7, 8, 11, 0};
        sortingSystem.sort(array, Choice.COMPARISON_SORT);
        int expectedOutput[] = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        
        assertArrayEquals(expectedOutput, array);
        assertEquals("Quick Sort", sortingSystem.getWayToSort());
    }

    @Test
    public void testSortForCountingSort() {
        int array[] = new int[] {4, 3, 5, 6, 1, 2, 10, 9, 7, 8, 11, 0};
        sortingSystem.sort(array, Choice.LINEAR_SORT);
        int expectedOutput[] = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        assertArrayEquals(expectedOutput, array);
        assertEquals("Counting Sort", sortingSystem.getWayToSort());
    }

    @Test
    public void testSortForRadixSort() {
        int array[] = new int[] {100,1000,10,0};
        sortingSystem.sort(array, Choice.LINEAR_SORT);
        int expectedOutput[] = new int[] {0, 10, 100, 1000};
        assertArrayEquals(expectedOutput, array);
        assertEquals("Radix Sort", sortingSystem.getWayToSort());
    }
}
