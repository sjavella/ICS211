package edu.ics211.sorts;

import java.util.Comparator;

/**
 * Shell Sort.
 * @author Paul Snieder
 * @param <E> generic
 */
public class ShellSort<E> implements Sort<E> {
  
  /**
   * Sorts the array using shell sort algorithm.
   * @param data the data
   * @param comp comparator
   */
  public void sort(E[] data, Comparator<E> comp) {
    int gap = data.length / 2;
    while (gap > 0) {
      for (int nextPos = gap; nextPos < data.length; nextPos++) {
        insert(data, nextPos, gap, comp);
      }
      if (gap == 2) {
        gap = 1;
      } else {
        gap = (int)(gap / 2.2);
      }
    }
  }
  
  /** Insert method for shellSort. */
  private void insert(E[] data, int nextPos, int gap, Comparator<E> comp) {
    E nextVal = data[nextPos];
    while (nextPos > gap - 1 && comp.compare(nextVal, data[nextPos - gap]) < 0) {
      data[nextPos] = data[nextPos - gap];
      nextPos -= gap;
    }
    data[nextPos] = nextVal;
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
