/**
 * ArraySorter.java
 * Copyright (C) Simplicio Javellana-Samonte 2018
 */

package edu.ics211.h02;

import java.util.Comparator;

/**
 * Generic class that implements SortableArray interface.
 * @author Simplicio Javellana-Samonte
 * @param <E>
 *
 */
public class ArraySorter<E> implements SortableArray<E> {
  static long startTime;
  static long estimatedTime;
  static int comparison;
  static int swaps;
  /**
   * Sort data using insertion sort method.
   * @param data the data that is being compared
   * @param compare comparing method
   */
  
  public void insertionSort(E[] data, Comparator<E> compare) {
    startTime = System.nanoTime();
    comparison = 0;
    swaps = 0;
    for (int i = 1; i < data.length; i++) {
      E temp = data[i];
      int j = i;
      comparison++;
      while (j > 0 && compare.compare(data[j - 1], temp) > 0) {
        data[j] = data[j - 1];
        j--;
        swaps++;
      }
      data[j] = temp;
    }
    long endTime = System.nanoTime();
    estimatedTime = endTime - startTime;
    System.out.println(estimatedTime);
  }
  /**
   * Sort data using bubble sort method.
   * @param data beers that are being compared
   * @param compare what its comparing
   */
  
  public void bubbleSort(E[] data, Comparator<E> compare) {
    comparison = 0;
    swaps = 0;
    startTime = System.nanoTime();
    boolean exchange = false;
    int pass = 0;

    do {
      exchange = false;

      for (int i = 1; i < data.length - pass; i++) {
        int result = compare.compare(data[i - 1], data[i]);
        comparison++;
        if (result > 0) {
          E temp = data[i];
          data[i] = data[i - 1];
          data[i - 1] = temp;
          exchange = true;
          swaps++;
          
        }
      }
      pass++;
    } while (exchange);
    long endTime = System.nanoTime();
    estimatedTime = endTime - startTime;
    System.out.println(estimatedTime);
  }

  /**
   * Sort data using selection sort method.
   * @param data the beers that is being compared
   * @param compare what its comparing
   */
  
  public void selectionSort(E[] data, Comparator<E> compare) {
    comparison = 0;
    swaps = 0;
    startTime = System.nanoTime();
    int min;
    
    for (int i = 0; i < data.length; i++) {
      min = i;
      for (int j = i + 1; j < data.length; j++) {
        comparison++;
        if (compare.compare(data[j], data[min]) < 0) {
          min = j; 
          swaps++;
        } 
      }
      E temp = data[min];
      data[min] = data[i];
      data[i] = temp;
        
    }
    long endTime = System.nanoTime();
    estimatedTime = endTime - startTime;
    System.out.println(estimatedTime);
  }


  /**
   * Gets number of swaps.
   * @return swaps 
   */
  
  public int getNumberOfSwaps() {
    
    return swaps;
  }
  /**
   * Gets number of comparisons.
   * @return comparisons 
   */
  
  public int getNumberOfComparisons() {
    // TODO Auto-generated method stub
    return comparison;
  }
  /**
   * Gets sort time.
   * @return estimatedTime 
   */
  
  public double getSortTime() {
    return estimatedTime;
  }
}

