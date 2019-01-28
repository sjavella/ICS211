/**
 * PotionComparator.java
 * Copyright (C) Simplicio Javellana-Samonte 2018
 */

package edu.ics211.h10;

import java.util.Comparator;

/**
 * A Potion Comparator.
 * @author Simplicio Javellana-Samonte
 */
public class PotionComparator implements Comparator<Potion> {
  
  /**
   * Potion comparator needed for MediumPotionBag.
   * @param p1 potion 1
   * @param p2 potion 2
   * @return hashcode
   */
  public int compare(Potion p1, Potion p2) {
    return p1.hashCode() - p2.hashCode();
  }
}
