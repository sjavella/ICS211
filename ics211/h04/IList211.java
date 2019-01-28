/**
 * IList211.java
 * Copyright (C) Simplicio Javellana-Samonte 2018
 */

package edu.ics211.h04;

/**
 * An IList List.
 * @author Simplicio Javellana-Samonte
 * @param <E> A generic object
 */
public interface IList211<E> {
  /**
   * Gets the object.
   * @param index the index of the object
   * @return object
   */
  E get(int index);
  
  /**
   * Sets the object.
   * @param index the index of the object
   * @param element element of the object
   * @return The object before the change.
   */
  E set(int index, E element);
  /**
   * Get the index of the object.
   * @param obj the object.
   * @return the index #
   */
  
  int indexOf(Object obj);
  /**
   * Get the size of the array.
   * @return size of the array (integer).
   */
  
  int size();
  /**
   * Add in an object to an array.
   * @param e the object
   * @return true if within the array
   */
  
  boolean add(E e);
  /**
   * Adds an object into the index.
   * @param index index of the object
   * @param element object
   */
  
  void add(int index, E element);
  /**
   * Remove an object from the index.
   * @param index index of the object you want removed
   * @return removal of the object.
   */
  
  E remove(int index);
}
