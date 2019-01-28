/**
 * IbuComparator.java
 * Copyright (C) Simplicio Javellana-Samonte 2018
 */

package edu.ics211.h01;

import java.util.Comparator;

/**
 * Compares ibu values between two beers.
 * @author Simplicio Javellana-Samonte
 *
 */

public class IbuComparator implements Comparator<Beer> {

  /** 
   * Compares the two beer ibu values.
   * @param o1 first beer
   * @param o2 second beer
   * @return 1 if o1 is greater, if not, return 0.
   */
  public int compare(Beer o1, Beer o2) {
    if (o1.getIbu() > o2.getIbu()) {
      return 1;
    } else if (o1.getIbu() < o2.getIbu()) {
      return -1;
    }
    return 0;
  }

}
