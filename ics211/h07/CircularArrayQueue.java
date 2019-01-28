/**
 * CircularArrayQueue.java
 * Copyright (C) Simplicio Javellana-Samonte 2018
 */

package edu.ics211.h07;

import java.util.NoSuchElementException;

/**
 * A Circular Array Queue.
 * @author Simplicio Javellana-Samonte
 * @param <E>
 *
 */
public class CircularArrayQueue<E> implements Queue211<E> {
  private static final int CAPACITY = 10;
  private int front;
  private int rear;
  private int size;
  private E[] data;
  
  /**
   * CAQ Constructor.
   */
  
  public CircularArrayQueue() {
    front = 0;
    rear = CAPACITY - 1;
    size = 0;
    data = (E[]) new Object[CAPACITY];
  }
  /**
   * Adds an object to the CAQ.
   * @param entry Object being added to CAQ.
   * @return true once added to front.
   */
  
  public boolean add(E entry) {
    if (size == data.length) {
      throw new IllegalStateException();
    }
    rear = (rear + 1) % data.length;
    data[rear] = entry;
    size++;
    return true;
  }

  /**
   * Retrieves an object.
   * @return E element
   */
  public E element() {
    if (size == 0) {
      throw new NoSuchElementException();
    }
    return data[front];
  }

  /**
   * Adds an object to the CAQ, in a try catch block.
   * @param entry Object being added to CAQ.
   * @return add, or false if not valid entry.
   */
  public boolean offer(E entry) {
    try {
      return add(entry);
    } catch (IllegalStateException ise) {
      return false;
    }
  }

  /**
   * Retrieves an object but doesnt move it, in a try catch block.
   * @return the element or null if no element.
   */
  public E peek() {
    try {
      return element();
    } catch (NoSuchElementException nse) {
      return null;
    }
  }

  /**
   * Remove an object, in a try catch block.
   * @return removed object or bull if no object.
   */
  public E poll() {
    try {
      return remove();
    } catch (NoSuchElementException nse) {
      return null;
    }
  }

  /**
   * Remove an object.
   * @return removed object.
   */
  public E remove() {
    if (size == 0) {
      throw new NoSuchElementException();
    }
    E result = data[front];
    front = (front + 1) % CAPACITY;
    size--;
    return result;
  }

  /**
   * Return the size.
   * @return size The size of CAQ
   */
  public int size() {
    return size;
  }

}
