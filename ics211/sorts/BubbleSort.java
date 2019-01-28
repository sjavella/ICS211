package edu.ics211.sorts;

import java.util.Comparator;

/**
 * Bubble Sort.
 * @author Paul Snieder
 * @param <E> generic
 */
public class BubbleSort<E> implements Sort<E> {
  
  /**
   * Sorts the array using bubble sort algorithm.
   * @param data the data
   * @param comp comparator
   */
  public void sort(E[] data, Comparator<E> comp) {
    int pass = 1;
    boolean flag = false;
    do {
      flag = false;
      for (int i = 0; i < data.length - pass; i++) {
        if (comp.compare(data[i], data[i + 1]) > 0) {
          swap(data, i, i + 1);
          flag = true;
        }
      }
      pass++;
    } while (flag);
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
