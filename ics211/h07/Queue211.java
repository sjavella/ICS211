/**
 * Queue211.java
 * Copyright (C) Simplicio Javellana-Samonte 2018
 */

package edu.ics211.h07;

/**
 * Queue211 interface.
 * @author Simplicio Javellana-Samonte
 * @param <E> generic object.
 */

public interface Queue211<E> {
  /**
   * add object to CAQ.
   * @param e the object
   * @return true if added to rear.
   */
  
  boolean add(E e);  // adds e to the end of the queue. 
  // May throw an IllegalStateException if the queue is full.
  /**
   * get the object of head of queue.
   * @return object head of queue
   */
  
  E element(); // Retrieves, but doesn't remove the head of the queue. 
  //Throws NoSuchElementException if queue is empty.
  /**
   * add the object to CAQ in try catch statement.
   * @param e the object
   * @return true if added to rear.
   */
  
  boolean offer(E e); // adds e to the end of the queue. 
  // Returns false if the queue is full. TRY CATCH
  /**
   * get the object of head of queue in a try catch statement.
   * @return object head of queue
   */
  
  E peek(); // Retrieves, but doesn't remove the head of the queue. 
  // Return null if queue is empty. TRY CATCH
  /**
   * removes head of queue in a try catch statement.
   * @return removed object.
   */
  
  E poll(); // Retrieves and removes the head of the queue. 
  // Returns null if the queue is empty. TRY CATCH
  /**
   * removes head of queue in a try catch statement.
   * @return removed object.
   */
  
  E remove(); // Retrieves and removes the head of the queue. 
  // Throws NoSuchElementException if queue is empty.
  /**
   * returns the size.
   * @return int size.
   */
  
  int size(); // Returns the size of the queue.
}