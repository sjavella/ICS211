/**
 * SearchTree.java
 * Copyright (C) Simplicio Javellana-Samonte 2018
 */

package edu.ics211.h09;

/**
 * SearchTree interface.
 * @author Simplicio Javellana-Samonte
 * @param <E> 
 * 
 */
public interface SearchTree<E> {
  /**
   * Inserts item into where it belongs in the tree.
   * @param item the item being inserted
   * @return true if item is inserted, false if item is already in tree.
   */
  boolean add(E item);
  /**
   * Checks if item is in the tree.
   * @param item the item being checked
   * @return true if item is in the tree, false otherwise.
   */
  
  boolean contains(E item);
  
  /**
   * Finds item in tree and returns that item.
   * @param target the target of the item trying to be found
   * @return a reference to the target if found, null if target isn't in the tree.
   */
  E find(E target);
  /**
   * Removes target from the tree.
   * @param target item being deleted
   * @return a reference to the target if found, null if target isn't in the tree.
   */
  
  E delete(E target);
  /**
   * Removes target from the tree.
   * @param target item being removed
   * @return true if target was in the tree, false otherwise.
   */
  
  boolean remove(E target);
}
