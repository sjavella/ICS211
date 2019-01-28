package edu.ics211.sorts;

import java.util.Comparator;

/**
 * Sorting Interface.
 * @author Paul Snieder
 * @param <E> generic
 */
public interface Sort<E> {
  
  /**
   * Sorts the data.
   * @param data the data
   * @param comp comparator
   */
  public void sort(E[] data, Comparator<E> comp);
  
  /**
   * Sorts the data and returns the time it took, in seconds.
   * @param data the data
   * @param comp comparator
   * @return time it took to run the sort, in seconds
   */
  public double timedSort(E[] data, Comparator<E> comp);

}
