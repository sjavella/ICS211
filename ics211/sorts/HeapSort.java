package edu.ics211.sorts;

import java.util.Comparator;

/**
 * Heap Sort.
 * @author Paul Snieder
 * @param <E> generic
 */
public class HeapSort<E> implements Sort<E> {
  
  /**
   * Sorts the array using heap sort algorithm.
   * @param data the data
   * @param comp comparator
   */
  public void sort(E[] data, Comparator<E> comp) { 
    int n = data.length - 1;
    heapify(data, n, comp);
    for (int i = n; i > 0; i--) {
      swap(data, 0, i);
      n--;
      reHeap(data, n, 0, comp);
    }   
  }
  
  /** Builds a heap. */
  private void heapify(E[] data, int n, Comparator<E> comp) {
    for (int i = n / 2; i >= 0; i--) {
      reHeap(data, n, i, comp);
    }
  }
  
  /** Re-heaps a heap with array indices 0 -> n. */
  private void reHeap(E[] data, int n, int parent, Comparator<E> comp) {
    //write this method
  }
  
  /**
   * Sorts the data and returns the time it took, in seconds.
   * @param data the data
   * @param comp comparator
   * @return time it took to run the sort, in seconds
   */
  public double timedSort(E[] data, Comparator<E> comp) {
    long start = System.nanoTime();
    sort(data, comp);
    long end = System.nanoTime();
    return (end - start) / 1000000000.0;
  }
  
  /** Swaps 2 elements in an array. */
  private void swap(E[] data, int i, int j) {
    E temp = data[i];
    data[i] = data[j];
    data[j] = temp;
  }

}
