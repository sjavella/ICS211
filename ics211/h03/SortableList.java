/**
 * SortableList.java
 * Copyright (C) Simplicio Javellana-Samonte 2018
 */

package edu.ics211.h03;

import java.util.Arrays;
import java.util.Comparator;

/**
 * A sortable List.
 * @author Simplicio Javellana-Samonte
 * @param <E>
 *
 */
public class SortableList<E> implements IList211<E>, ISortableList<E> {

  private static final int INITIAL_CAPACITY = 10;
  private E[] data;
  private int size;
  private int capacity;
  static long startTime;
  static long estimatedTime;
  static int comparison;
  static int swaps;


  /**
   * Sortable List constructor.
   */

  public SortableList() {
    this.capacity = INITIAL_CAPACITY;
    this.data = (E[]) new Object[capacity];
    this.size = 0;
  }
  
  /**
   * Insertion style sort.
   * @param compare comparison of objects within index
   */

  public void insertionSort(Comparator<E> compare) {
    startTime = System.nanoTime();
    comparison = 0;
    swaps = 0;
    for (int i = 1; i < size; i++) {
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
    System.out.println("Estimated time : " + estimatedTime);
    System.out.println("Number of comparisons : " + comparison);
    System.out.println("Number of swaps : " + swaps);
  }
  /**
   * Bubble style sort.
   * @param compare comparison of objects within index
   */

  public void bubbleSort(Comparator<E> compare) {
    comparison = 0;
    swaps = 0;
    startTime = System.nanoTime();
    boolean exchange = false;
    int pass = 0;

    do {
      exchange = false;

      for (int i = 1; i < size - pass; i++) {
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
    System.out.println("Estimated time : " + estimatedTime);
    System.out.println("Number of comparisons : " + comparison);
    System.out.println("Number of swaps : " + swaps);
  }
  /**
   * Selection style sort.
   * @param compare comparison of objects within index
   */
  
  public void selectionSort(Comparator<E> compare) {
    comparison = 0;
    swaps = 0;
    startTime = System.nanoTime();
    int min;
    for (int i = 0; i < size; i++) {
      min = i;
      for (int j = i + 1; j < size; j++) {
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
    System.out.println("Estimated time : " + estimatedTime);
    System.out.println("Number of comparisons : " + comparison);
    System.out.println("Number of swaps : " + swaps);
  }
  /**
   * Gets the number of swaps.
   * @return the number of swaps as an int
   */
  
  public int getNumberOfSwaps() {
    return swaps;
  }
  /**
   * Gets the number of comparisons.
   * @return the number of comparisons as an int
   */
  
  public int getNumberOfComparisons() {
    return comparison;
  }
  /**
   * Gets the sort time.
   * @return the sort time as a double 
   */

  public double getSortTime() {
    return estimatedTime;
  }
  /**
   * Gets the object.
   * @param index the index of the object
   * @return object
   */
  
  public E get(int index) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }
    return data[index];
  }
  /**
   * Sets the object.
   * @param index the index of the object
   * @param element element of the object
   * @return The object before the change.
   */

  public E set(int index, E element) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    data[index] = element;
    return data[index];
  }
  /**
   * Get the index of the object.
   * @param obj the object.
   * @return the index #
   */

  public int indexOf(Object obj) {
    for (int i = 0; i < size; i++) {
      if (data[i].equals(obj)) {
        return i;
      }
    }
    return -1;
  }
  /**
   * Get the size of the array.
   * @return size of the array (integer).
   */
  
  public int size() {
    
    return size;
  }
  /**
   * Add in an object to an array.
   * @param element the object
   * @return true if within the array
   */

  public boolean add(E element) {
    if (size == data.length) {
      reallocate();
    }
    data[size] = element;
    size++;
    return true;
  }
  /**
   * Adds an object into the index.
   * @param index index of the object
   * @param element object
   */
  
  public void add(int index, E element) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }
    if (size == data.length) {
      reallocate();
    }
    for (int i = size; i > index; i--) {
      data[i] = data[i - 1];
    }
    data[index] = element;
    size++;
  }
  /**
   * Remove an object from the index.
   * @param index index of the object you want removed
   * @return removal of the object.
   */

  public E remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    E temp = data[index];
    for (int i = size; i >= index; i--) {
      data[i] = data[i - 1];
    }
    size--;
    return temp;
  }
  /**
   * Reallocates data.
   */
  
  private void reallocate() {
    capacity = 2 * capacity;
    data = Arrays.copyOf(data, capacity);
  }
}
