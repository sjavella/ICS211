/**
 * AbvComparator.java
 * Copyright (C) Simplicio Javellana-Samonte 2018
 */

package edu.ics211.h01;

import java.util.Comparator;

/**
 * Compare abv values of two beers.
 * @author Simplicio Javellana-Samonte
 *
 */

public class AbvComparator implements Comparator<Beer> {

  /** 
   * Compares the two beer abv values.
   * @param o1 first beer
   * @param o2 second beer
   * @return 1 if o1 is greater, if not, return 0.
   */
  public int compare(Beer o1, Beer o2) {
    if (o1.getAbv() > o2.getAbv()) {
      return 1;
    } else if (o1.getAbv() < o2.getAbv()) {
      return -1;
    }
    return 0;
  }

}
