package edu.ics211.sorts;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

/**
 * ComplexSortsTest.
 * @author Paul Snieder
 */
public class TimedSortTest {
  
  /**
   * Integer comparator.
   * @author Paul Snieder
   */
  private class IntComp implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
      return o1 - o2;
    }  
  }
  
  private TimedSort<Integer> sorter;
  private Integer[] data;
  private Comparator<Integer> comp;
  
  /** Sets up sorter. */
  @Before
  public void initialize() {
    sorter = new TimedSort<Integer>();
    data = randomIntArray(100000);
    comp = new IntComp();
  }
  
  /** Test method for InsertionSort. */
  @Test
  public void testInsertionSort() {
    Integer[] copy = Arrays.copyOf(data, data.length);
    System.out.println("\nUnsorted Data");
    sorter.timedSort(SortAlgorithm.INSERTION, copy, comp);
    assertTrue("Not sorted", isSorted(copy, comp));
    System.out.println("\nSorted Data");
    sorter.timedSort(SortAlgorithm.INSERTION, copy, comp);
    assertTrue("Not sorted", isSorted(copy, comp));
  }
  
  /** Test method for BubbleSort. */
  @Test
  public void testBubbleSort() {
    Integer[] copy = Arrays.copyOf(data, data.length);
    System.out.println("\nUnsorted Data");
    sorter.timedSort(SortAlgorithm.BUBBLE, copy, comp);
    assertTrue("Not sorted", isSorted(copy, comp));
    System.out.println("\nSorted Data");
    sorter.timedSort(SortAlgorithm.BUBBLE, copy, comp);
    assertTrue("Not sorted", isSorted(copy, comp));
  }
  
  /** Test method for SelectionSort. */
  @Test
  public void testSelectionSort() {
    Integer[] copy = Arrays.copyOf(data, data.length);
    System.out.println("\nUnsorted Data");
    sorter.timedSort(SortAlgorithm.SELECTION, copy, comp);
    assertTrue("Not sorted", isSorted(copy, comp));
    System.out.println("\nSorted Data");
    sorter.timedSort(SortAlgorithm.SELECTION, copy, comp);
    assertTrue("Not sorted", isSorted(copy, comp));
  }
  
  /** Test method for ShellSort. */
  @Test
  public void testShellSort() {
    Integer[] copy = Arrays.copyOf(data, data.length);
    System.out.println("\nUnsorted Data");
    sorter.timedSort(SortAlgorithm.SHELL, copy, comp);
    assertTrue("Not sorted", isSorted(copy, comp));
    System.out.println("\nSorted Data");
    sorter.timedSort(SortAlgorithm.SHELL, copy, comp);
    assertTrue("Not sorted", isSorted(copy, comp));
  }
  
  /** Test method for HeapSort. */
  @Test
  public void testHeapSort() {
    Integer[] copy = Arrays.copyOf(data, data.length);
    System.out.println("\nUnsorted Data");
    sorter.timedSort(SortAlgorithm.HEAP, copy, comp);
    assertTrue("Not sorted", isSorted(copy, comp));
    System.out.println("\nSorted Data");
    sorter.timedSort(SortAlgorithm.HEAP, copy, comp);
    assertTrue("Not sorted", isSorted(copy, comp));
  }
  
  /** Test method for QuickSort. */
  @Test
  public void testQuickSort() {
    Integer[] copy = Arrays.copyOf(data, data.length);
    System.out.println("\nUnsorted Data");
    sorter.timedSort(SortAlgorithm.QUICK, copy, comp);
    assertTrue("Not sorted", isSorted(copy, comp));
    System.out.println("\nSorted Data");
    sorter.timedSort(SortAlgorithm.QUICK, copy, comp);
    assertTrue("Not sorted", isSorted(copy, comp));
  }
  
  /** Test method for MergeSort. */
  @Test
  public void testMergeSort() {
    Integer[] copy = Arrays.copyOf(data, data.length);
    System.out.println("\nUnsorted Data");
    sorter.timedSort(SortAlgorithm.MERGE, copy, comp);
    assertTrue("Not sorted", isSorted(copy, comp));
    System.out.println("\nSorted Data");
    sorter.timedSort(SortAlgorithm.MERGE, copy, comp);
    assertTrue("Not sorted", isSorted(copy, comp));
  }
  
  /** Print Time Complexities in a table. */
  @AfterClass
  public static void printComplexities() {
    System.out.println();
    System.out.printf("%-17s%-13s%-15s%-13s\n", "Algorithm", "Best", "Expected", "Worst");
    System.out.print("-----------------------------------------------------\n");
    System.out.printf("%-17s%-13s%-15s%-13s\n", "Insertion Sort", "O(n)", "O(n^2)", "O(n^2)");
    System.out.print("-----------------------------------------------------\n");
    System.out.printf("%-17s%-13s%-15s%-13s\n", "Bubble Sort", "O(n)", "O(n^2)", "O(n^2)");
    System.out.print("-----------------------------------------------------\n");
    System.out.printf("%-17s%-13s%-15s%-13s\n", "Selection Sort", "O(n^2)", "O(n^2)", "O(n^2)");
    System.out.print("-----------------------------------------------------\n");
    System.out.printf("%-17s%-13s%-15s%-13s\n", "Shell Sort", "O(nlogn)", "O(n(logn)^2)", "O(n^2)");
    System.out.print("-----------------------------------------------------\n");
    System.out.printf("%-17s%-13s%-15s%-13s\n", "Heap Sort", "O(nlogn)", "O(nlogn)", "O(nlogn)");
    System.out.print("-----------------------------------------------------\n");
    System.out.printf("%-17s%-13s%-15s%-13s\n", "Merge Sort", "O(nlogn)", "O(nlogn)", "O(nlogn)");
    System.out.print("-----------------------------------------------------\n");
    System.out.printf("%-17s%-13s%-15s%-13s\n", "Quick Sort", "O(nlogn)", "O(nlogn)", "O(n^2)");
  }
  
  /** Creates a random Integer array of a given size. */
  private Integer[] randomIntArray(int size) {
    Integer[] intArray = new Integer[size];
    for (int i = 0; i < size; i++) {
      intArray[i] = (int)(Math.random() * 1000000) + 1;
    }
    return intArray;
  }
  
  /** Returns true if data is sorted, false otherwise. */
  private boolean isSorted(Integer[] data, Comparator<Integer> comp) {
    for (int i = 0; i < data.length - 1; i++) {
      if (comp.compare(data[i], data[i + 1]) > 0) {
        return false;
      }
    }
    return true;
  }

}