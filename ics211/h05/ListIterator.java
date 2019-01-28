/**
 * ListIterator.java
 * Copyright (C) Simplicio Javellana-Samonte 2018
 */
package edu.ics211.h05;

/**
 * ListIterator interface.
 * @author Simplicio Javellana-Samonte
 * @param <E> Generic object
 */
public interface ListIterator<E> {
  /**
   * Checks if there is an object in the next node.
   * @return true if this list iterator has more elements while traversing in the forward direction.
   */
  boolean hasNext(); 
  /**
   * Checks if there is an object in the previous node.
   * @return true if this list iterator has more elements while traversing in the reverse direction.
   */
  boolean hasPrevious(); // Returns true if this list iterator has more elements while traversing in the reverse direction.
  E next(); // Returns the next Element.
  int nextIndex(); // Returns the index of the next element.
  E previous(); // Returns the previous Element
  int previousIndex(); // Returns the index of the previous element.
  void remove(); // Removes from the list the last element that was returned.
  void set(E e); // Replaces the last element returned. (Optional for this assignment)
}
