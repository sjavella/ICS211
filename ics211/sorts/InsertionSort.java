package edu.ics211.sorts;

import java.util.Comparator;

/**
 * Insertion Sort.
 * @author Paul Snieder
 * @param <E> generic
 */
public class InsertionSort<E> implements Sort<E> {
  
  /**
   * Sorts the array using insertion sort algorithm.
   * @param data the data
   * @param comp comparator
   */
  public void sort(E[] data, Comparator<E> comp) {
    for (int i = 1; i < data.length; i++) {
      int j = i;
      E temp = data[i];
      while (j > 0 && comp.compare(temp, data[j - 1]) < 0) {
        data[j] = data[j - 1];
        j--;
      }
      if (i != j) {
        data[j] = temp;
      }
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

}
