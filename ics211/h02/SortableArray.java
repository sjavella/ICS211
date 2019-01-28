/**
 * SortableArray.java
 * Copyright (C) Simplicio Javellana-Samonte 2018
 */

package edu.ics211.h02;

import java.util.Comparator;

/**
 * Sorts the array into 3 different types.
 * @author Simplicio Javellana-Samonte
 * @param <E>
 *
 */

public interface SortableArray<E> {
  /**
   * Sort the Array by insertion sort.
   * @param data data of the beer.
   * @param compare what you're comparing (ibu / abv)
   */
  void insertionSort(E[] data, Comparator<E> compare);
  
  /**
   * Sort the Array by bubble sort.
   * @param data data of the beer.
   * @param compare what you're comparing (ibu / abv)
   */
  
  void bubbleSort(E[] data, Comparator<E> compare);
  
  /**
   * Sort the Array by selection sort.
   * @param data data of the beer.
   * @param compare what you're comparing (ibu / abv)
   */
  
  void selectionSort(E[] data, Comparator<E> compare);
  
  /**
   * Get the number of swaps.
   * @return int
   */
  
  int getNumberOfSwaps();
  
  /**
   * Get the number of Comparisons.
   * @return int
   */
  
  int getNumberOfComparisons();
  
  /**
   * Get the sort time.
   * @return double
   */
  
  double getSortTime();

}
