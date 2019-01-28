/**
 * SortableList.java
 * Copyright (C) Simplicio Javellana-Samonte 2018
 */

package edu.ics211.h04;

import java.util.Comparator;

/**
 * SortableList Represents an List.
 * 
 * @author Simplicio Javellana-Samonte
 *         Worked with Matthew Kim, Micah Kim, and Richard Harmer.
 * @param <E> A generic variable.
 */
public class SortableList<E> implements IList211<E>, ISortableList<E> {
  /**
   * A DLinkedNode constructor.
   * @author Simplicio Javellana-Samonte
   *
   */
  private class DLinkedNode {
    E item;
    DLinkedNode next;
    DLinkedNode prev;
    
    public DLinkedNode(E item, DLinkedNode nextRef, DLinkedNode prevRef) {
      this.item = item;
      this.next = nextRef;
      this.prev = prevRef;
    }
  }
  
  private DLinkedNode head;
  private DLinkedNode tail;
  private int size;
  private E[] data;
  private static long estimatedTime;
  private static int swaps;
  private static int comparison;
  private static long startTime;
  private static long endTime;
  
  /**
   * A SortableList constructor.
   */
  
  public SortableList() {
    this.head = null;  
    this.tail = null; 
    this.data = (E[]) new Object[10000]; 
    this.size = 0;
  }

  /**
   * Returns the item in the element at position index.
   * @param index The position.
   * @return the item.
   */
  public E get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    DLinkedNode temp = head;
    if (index == size - 1) {    
      return tail.item;
    }
    for (int i = 0; i < index; i++) {
      temp = temp.next;
    }
    return temp.item;
  }

  /**
   * Sets an object to a position in the index.
   * @param index The position.
   * @param element The reference to be added.
   * @return the old reference formerly at position index.
   */
  public E set(int index, E element) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    DLinkedNode temp = head;
    for (int i = 0; i < index; i++) {   
      temp = temp.next;
    }
    E val = temp.item;
    temp.item = element;
    return val;
  }

  /**
   * Finds the index of an object.
   * @param obj The target to be found.
   * @return position index of item's first occurrence.
   */
  public int indexOf(Object obj) {
    DLinkedNode temp = head;
    for (int index = 0; index < size; index++) {
      if (temp.item == obj) {
        return index;
      }
      temp = temp.next;
    }
    return -1;
  }

  /**
   * Returns the size of the list.
   * @return the size.
   */
  public int size() {
    return size;
  }

  /**
   * Add boolean method.
   * @param e The reference element to be added.
   * @return true
   */
  public boolean add(E e) {
    this.add(size, e);
    return true;
    
  }

  
  /**
   * Adds a reference to anEntry, inserting it before the item at position index.
   * 
   * @param index The specified position.
   * @param element The reference to be added.
   */
  public void add(int index, E element) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }
    if (size == 0) {
      head = new DLinkedNode(element, null, null);
      tail = head;
    } else if (index == 0) {
      head.prev = new DLinkedNode(element, head, null);
      head = head.prev;
    } else if (index == size) {
      tail.next = new DLinkedNode(element, null, tail);
      tail = tail.next;
    } else {
      DLinkedNode temp = head;
      for (int i = 0; i < index - 1; i++) {
        temp = temp.next;
      }   
      temp.next = new DLinkedNode(element, temp.next, temp);
      temp.next.next.prev = temp.next;
    }
    size++;
  }
  
  /**
   * Removes the entry at position index and returns it.
   * 
   * @param index The specified position.
   * @return The removed entry
   */
  public E remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    DLinkedNode temp = head;
    if (size == 1) {
      head = null;
      tail = null;
    } else if (index == 0) {
      head = head.next;
      head.prev = null;
    } else if (index == size - 1) {
      temp = tail;
      temp.prev.next = null;
      tail = temp.prev;
    } else {
      for (int i = 0; i < index; i++) {
        temp = temp.next;
      }
      temp.prev.next = temp.next;
      temp.next.prev = temp.prev;
    }
    size--;
    return temp.item;
  }
  
  /**
   * Sorts the Linkedlist through insertion sort.
   * @param compare The comparator object.
   */  
  public void insertionSort(Comparator<E> compare) {
    startTime = System.nanoTime();
    swaps = 0;
    comparison = 0;
    
    DLinkedNode tempNode = head;
    for (int i = 0; i < size; i++) {
      data[i] = tempNode.item;
      tempNode = tempNode.next;
    }
    boolean doInsert = false;
    for (int newValue = 1; newValue < size; newValue++) {
      E nextValue = data[newValue];
      int indexCount = newValue;
      while (indexCount > 0 && compare.compare(nextValue, data[indexCount - 1]) < 0) {
        comparison++;
        data[indexCount] = data[indexCount - 1];
        swaps++;
        indexCount--;
        doInsert = true;
      }
      if (doInsert) {
        data[indexCount] = nextValue;
      }
      if (indexCount > 0) {
        comparison++;
      }
    }
    endTime = System.nanoTime();
    estimatedTime = endTime - startTime;
    tempNode = head;
    for (int i = 0; i < size; i++) {
      tempNode.item = data[i];
      tempNode = tempNode.next;
    }   
  }

  /**
   * Implements the bubble sort algorithm.
   * 
   * @param compare The comparator object that can utilize the compare() function.
   */
  public void bubbleSort(Comparator<E> compare) {
    startTime = System.nanoTime();
    swaps = 0;
    comparison = 0;
    
    DLinkedNode tempNode = head;
    for (int i = 0; i < size; i++) {
      data[i] = tempNode.item;
      tempNode = tempNode.next;
    }
    boolean isSorted = true;
    int nextValue = 0;
    do {
      isSorted = false;
      for (int indexCount = 0; indexCount < size - 1 - nextValue; indexCount++) {
        if (compare.compare(data[indexCount], data[indexCount + 1]) > 0) {
          E temp = data[indexCount];
          data[indexCount] = data[indexCount + 1];
          data[indexCount + 1] = temp;
          swaps++;
          isSorted = true;
        }
        comparison++;
      }
      nextValue++;
    } while (isSorted);
    endTime = System.nanoTime();
    estimatedTime = endTime - startTime;
    tempNode = head;
    for (int i = 0; i < size; i++) {
      tempNode.item = data[i];
      tempNode = tempNode.next;
    }
  }

  /**
   * Implements the selection sort algorithm.
   * 
   * @param compare The comparator object that can utilize the compare() function.
   */
  public void selectionSort(Comparator<E> compare) {
    startTime = System.nanoTime();
    swaps = 0;
    comparison = 0;
    DLinkedNode tempNode = head;
    for (int i = 0; i < size; i++) {
      data[i] = tempNode.item;
      tempNode = tempNode.next;
    }
    for (int fill = 0; fill < size - 1; fill++) {
      int posMin = fill;
      boolean doSwap = false;
      for (int next = fill + 1; next < size; next++) {
        if (compare.compare(data[next], data[posMin]) < 0) {
          posMin = next;
          doSwap = true;
        }
        comparison++;
      }
      if (doSwap) {
        E temp = data[fill];
        data[fill] = data[posMin];
        data[posMin] = temp;
        swaps++;
      }
    }
    endTime = System.nanoTime();
    estimatedTime = endTime - startTime;
    tempNode = head;
    for (int i = 0; i < size; i++) {
      tempNode.item = data[i];
      tempNode = tempNode.next;
    }  
  }

  
  /**
   * Counts the number of swaps.
   * 
   * @return the number of swaps.
   */
  public int getNumberOfSwaps() {
    return swaps;
  }


  /**
   * Counts the number of comparisons.
   * 
   * @return the number of comparisons.
   */
  public int getNumberOfComparisons() {
    return comparison;
  }


  /**
   * Tracks sorting time.
   * 
   * @return the sorting time.
   */
  public double getSortTime() {
    return estimatedTime;
  }
}
