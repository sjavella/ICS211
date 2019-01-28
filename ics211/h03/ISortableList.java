/**
 * ISortableList.java
 * Copyright (C) Simplicio Javellana-Samonte 2018
 */

package edu.ics211.h03;

import java.util.Comparator;

/**
 * An ISortable List.
 * @author Simplicio Javellana-Samonte
 * @param <E> A generic object
 */
public interface ISortableList<E> {
  /**
   * Insertion style sort.
   * @param compare comparison of objects within index
   */
  
  void insertionSort(Comparator<E> compare);
  /**
   * Bubble style sort.
   * @param compare comparison of objects within index
   */
  
  void bubbleSort(Comparator<E> compare);
  /**
   * Selection style sort.
   * @param compare comparison of objects within index
   */
  
  void selectionSort(Comparator<E> compare);
  /**
   * Gets the number of swaps.
   * @return the number of swaps as an int
   */
  
  int getNumberOfSwaps();
  /**
   * Gets the number of comparisons.
   * @return the number of comparisons as an int
   */
  
  int getNumberOfComparisons();
  /**
   * Gets the sort time.
   * @return the sort time as a double 
   */
  
  double getSortTime();
}
