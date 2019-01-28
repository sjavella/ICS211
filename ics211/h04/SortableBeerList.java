/**
 * SortableBeerList.java
 * Copyright (C) Simplicio Javellana-Samonte 2018
 */

package edu.ics211.h04;

import edu.ics211.h01.Beer;
import java.util.Comparator;


/**
 * A sortable Beer list.
 * @author Simplicio Javellana-Samonte
 *
 */

public class SortableBeerList implements IList211<Beer> {
  private SortableList<Beer> beer;
  private Comparator<Beer> compare;

  /**
   * A sortable Beer list.
   * @param c comparator
   */
  
  public SortableBeerList(Comparator<Beer> c) {
    beer = new SortableList<Beer>();
    compare = c;
  }
  /**
   * Gets the object of the beer based on index.
   * @param index index of beer
   * @return object of beer
   */
  
  public Beer get(int index) {
    return beer.get(index);
  }
  /**
   * Set the beer.
   * @param index index of beer
   * @param element element of beer
   * @return b Beer object
   */
  
  public Beer set(int index, Beer element) {
    Beer b = beer.set(index, element);
    beer.bubbleSort(compare);
    return b;
  }
  /**
   * Add a beer.
   * @param index index of beer
   * @param element element of beer
   */
  
  public void add(int index, Beer element) {
    beer.add(index, element);
    beer.bubbleSort(compare);
  }
  
  /**
   * Add a beer.
   * @param e object of Beer
   * @return boolean
   */
  
  public boolean add(Beer e) {
    boolean b = beer.add(e);
    beer.bubbleSort(compare);
    return b;
  }


  /**
   * Get the index of an object.
   * @param obj beer where you want to get the index from
   * @return number of index
   */
  
  public int indexOf(Object obj) {
    return beer.indexOf(obj);
  }
  /**
   * Get the size of the items in the array.
   * @return int 
   */
  
  public int size() {
    return beer.size();
  }
  /**
   * Remove a beer.
   * @param index index of the beer
   * @return old beer object
   */
  
  public Beer remove(int index) {
    return beer.remove(index);
  }

  

}
