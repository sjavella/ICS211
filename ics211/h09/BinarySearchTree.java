/**
 * BinarySearchTree.java
 * Copyright (C) Simplicio Javellana-Samonte 2018
 */

package edu.ics211.h09;

import java.util.Comparator;
import java.util.List;

/**
 * A Binary Search Tree.  
 * @author Simplicio Javellana-Samonte
 * @param <E> object
 */
public class BinarySearchTree<E> implements SearchTree<E> {
  public Comparator<E> comparator;
  protected boolean addReturn;
  protected boolean removalSuccessful;
  protected E deleteReturn;
  private BinaryNode<E> root;

  /**
   * Constructs a BST that orders its items according to the
   * given comparator.
   * @param c comparator
   */
  
  public BinarySearchTree(Comparator<E> c) {
    this.comparator = c;
    this.root = null;
  }
  
  /**
   * A binary node class.
   * @param <E> object
   */
  
  private static class BinaryNode<E> {
    E data;
    BinaryNode<E> left;
    BinaryNode<E> right;
    
    /** 
     * Constructor to build a node with no subtrees.
     * @param the value to be stored by this node
     */
    private BinaryNode(E item) {
      data = item;
      left = null;
      right = null;
    }
  }
  
  /**
   * Binary Node add helper method.
   * @return a node
   */
  
  private BinaryNode<E> add(BinaryNode<E> localRoot, E item) {
    if (localRoot == null) {
      addReturn = true;
      return new BinaryNode<E>(item);
    }
    int comp = comparator.compare(item, localRoot.data);
    if (comp == 0) {
      addReturn = false;
      return localRoot;
    } else if (comp < 0) {
      localRoot.left = add(localRoot.left, item);
      return localRoot;
    } else {
      localRoot.right = add(localRoot.right, item);
      return localRoot;
    }
  }
  
  /**
   * Inserts item into where it belongs in the tree.
   * @param item the item being inserted
   * @return true if item is inserted, false if item is already in tree.
   */
  
  public boolean add(E item) {
    root = add(root, item);
    return addReturn;
  }


  private BinaryNode<E> delete(BinaryNode<E> localRoot, E item) {
    if (localRoot == null) {
      deleteReturn = null;
      removalSuccessful = false;
      return localRoot;
    }
    int comp = comparator.compare(item, localRoot.data);
    if (comp < 0) {
      localRoot.left = delete(localRoot.left, item);
      return localRoot;
    } else if (comp > 0) {
      localRoot.right = delete(localRoot.right, item);
      return localRoot;
    } else {
      return replaceNode(localRoot);
    }
  }

  /**
   * Removes target from the tree.
   * @param target item being deleted
   * @return a reference to the target if found, null if target isn't in the tree.
   */
  
  public E delete(E target) {
    root = delete(root, (E) target);
    return deleteReturn;
  }


  private BinaryNode<E> replaceNode(BinaryNode<E> localRoot) {
    deleteReturn = localRoot.data;
    if (localRoot.left == null) {
      return localRoot.right;
    } else if (localRoot.right == null) {
      return localRoot.left;
    } else {
      if (localRoot.left.right == null) {
        localRoot.data = localRoot.left.data;
        localRoot.left = localRoot.left.left;
        return localRoot;
      } else {
        localRoot.data = find(localRoot.left.data);
        return localRoot;
      }
    }
  }

  /**
   * Checks if item is in the tree.
   * @param item the item being checked
   * @return true if item is in the tree, false otherwise.
   */
  
  public boolean contains(E item) {
    if (find(item) != null) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Finds item in tree and returns that item.
   * @param target the target of the item trying to be found
   * @return a reference to the target if found, null if target isn't in the tree.
   */
  
  public E find(E target) {
    return find(root, target);
  }
  
  private E find(BinaryNode<E> localRoot, E target) {
    if (localRoot == null) {
      return null;
    }
    int comp = comparator.compare(target, localRoot.data);
    if (comp == 0) {
      return localRoot.data;
    } else if (comp < 0) {
      return find(localRoot.left, target);    
    } else {
      return find(localRoot.right, target);
    }
  }

  /**
   * Removes target from the tree.
   * @param target item being removed
   * @return true if target was in the tree, false otherwise.
   */
  
  public boolean remove(E target) {
    removalSuccessful = true;
    root = delete(root,target);
    return removalSuccessful;
  }

  /**
   * Takes the tree nodes and puts them into a list in their order.
   * @return a list of contacts.
   */
  public List<Contact> inorder() {
    //I had no idea how to code this but ima type it in steps
    //to see if I was going in the right direction
    //Create a list called "contactList"
    //Take all the nodes from the tree and somehow migrate the contact data to linked list
    //Return the list
    return null;
  }

}
