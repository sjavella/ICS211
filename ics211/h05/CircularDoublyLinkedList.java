/**
 * CircularDoublyLinkedList.java
 * Copyright (C) Simplicio Javellana-Samonte 2018
 */

package edu.ics211.h05;

import java.util.ListIterator;
import java.util.NoSuchElementException;


/**
 * Circularly Doubly Linked List.
 * @author Simplicio Javellana-Samonte
 * @param <E> Generic E object.
 */
public class CircularDoublyLinkedList<E> implements IList211<E> , Iterable<E> {
  private DLinkedNode head;
  private DLinkedNode tail;
  private int size;
  /**
   * Circular Double Linked List constructor.
   * 
   */
  
  public CircularDoublyLinkedList() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }
  /**
   * Circular Double Linked List constructor.
   * @param item The object within the list.
   */
  
  public CircularDoublyLinkedList(E[] item) {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }
  /**
   * A DLinkedNode.
   * @author Simplicio Javellana-Samonte
   *
   */
  
  private class DLinkedNode {
    E item;
    DLinkedNode next;
    DLinkedNode prev;
      
    public DLinkedNode(E element, DLinkedNode nextRef, DLinkedNode prevRef) {
      this.item = element;
      this.next = nextRef;
      this.prev = prevRef;
    }
  }
  /**
   * Circular Doubly Linked List Iterator.
   * @author Simplicio Javellana-Samonte
   *
   */
  
  private class CircularDoublyLinkedListIterator implements ListIterator<E> {
      
    private DLinkedNode nextNode;
    private DLinkedNode lastNodeReturn;
    private int lastReturnedIndex;
    private int nextIndex;
      
    public CircularDoublyLinkedListIterator() {
      this.nextNode = head;
      this.nextIndex = 0;
      this.lastNodeReturn = null;
      this.lastReturnedIndex = -1;
    }

    /**
     * Checks if there is an index in the next position.
     */
    
    public boolean hasNext() {
      return nextNode != null;
    }

    /**
     * Directs to the next object in the list.
     */
    
    public E next() {
      if (hasNext()) {
        E temp = nextNode.item;
        nextNode = nextNode.next;
        return temp;
      }
      throw new NoSuchElementException();
    }
    /**
     * Checks if there is an index in the previous position.
     */
    
    public boolean hasPrevious() {
      return nextNode != null;
    }
    /**
     * Directs to the previous object in the list.
     */
    
    public E previous() {
      if (hasPrevious()) {
        E temp = nextNode.item;
        nextNode = nextNode.prev;
        return temp;
      }
      throw new NoSuchElementException();
    }

    /**
     * Returns the number of the next index of the list.
     */
    public int nextIndex() {
      if (hasNext()) {
        return indexOf(nextNode.item);
      }
      throw new IndexOutOfBoundsException();
    }


    /**
     * Returns the number of the previous index of the list.
     */
    public int previousIndex() {
      if (hasPrevious()) {
        return indexOf(nextNode.item);
      }
      throw new IndexOutOfBoundsException();
    }

    /**
     * Remove a part of the list.
     */
    public void remove() {
      if (lastNodeReturn == null) {
        throw new IllegalStateException();
      }
      DLinkedNode x = lastNodeReturn.prev;
      DLinkedNode y = lastNodeReturn.next;
      x.next = y;
      y.prev = x;
      size--;
      lastNodeReturn = null;
    }


    /**
     * Set an object.
     */
    public void set(E e) {
      if (lastNodeReturn == null) {
        throw new IllegalStateException();
      }
      lastNodeReturn.item = nextNode.item;
    }


    /**
    * Add an object to the list.
    */
    public void add(E e) {
 //     DLinkedNode x = current.prev;
 //     DLinkedNode y;
 //     DLinkedNode z = current;
 //     y.item = next.item;
 //     x.next = y;
 //     y.next = z;
 //     z.prev = y;
 //     y.prev = x;
      size++;
      lastNodeReturn = null;
    }

  }
  
  /**
   * A list iterator.
   * @return iterator
   */
  public ListIterator<E> iterator() {
    ListIterator<E> listIterator = new CircularDoublyLinkedListIterator();
    return listIterator;
  }

  @Override
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

  @Override
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

  @Override
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

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean add(E e) {
    this.add(size, e);
    return true;
  }

  @Override
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

  @Override
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

}
