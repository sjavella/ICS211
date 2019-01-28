package edu.ics211.sorts;

import java.util.Comparator;

/**
 * Selection Sort.
 * @author Paul Snieder
 * @param <E> generic
 */
public class SelectionSort<E> implements Sort<E> {
  
  /**
   * Sorts the array using selection sort algorithm.
   * @param data the data
   * @param comp comparator
   */
  public void sort(E[] data, Comparator<E> comp) {
    int n = data.length;
    for (int fill = 0; fill < n - 1; fill++) {
      int posMin = fill;
      for (int next = fill + 1; next < n; next++) {
        if (comp.compare(data[next], data[posMin]) < 0) {
          posMin = next;
        }
      }
      swap(data, fill, posMin);
    }
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
