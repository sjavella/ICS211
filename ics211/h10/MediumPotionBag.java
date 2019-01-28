/**
 * MediumPotionBag.java
 * Copyright (C) Simplicio Javellana-Samonte 2018
 */

package edu.ics211.h10;

import java.util.TreeMap;

/**
 * MediumPotionBag.
 *
 * @author Simplicio Javellana-Samonte
 *
 */
public class MediumPotionBag implements PotionBag {
  private static MediumPotionBag instance;
  private TreeMap<Potion, Potion> potions = new TreeMap<Potion, Potion>(new PotionComparator());

  
  /**
   * Empty class.
   */
  private MediumPotionBag() {
  }
  
  /**
   * Get instances.
   * @return return instance
   */
  public static MediumPotionBag getInstance() {
    if (instance == null) {
      instance = new MediumPotionBag();
    }
    return instance;
  }

  /**
   * Stores the given Potion in the PotionBag.
   * 
   * @param p the Potion to store.
   */
  public void store(Potion p) {
    potions.put(p, p);
  }

  /**
   * Returns the number of nanoseconds it took to store a potion.
   * 
   * @param p the potion to store.
   * @return the duration in nanoseconds it took to store a potion.
   */
  public long timedStore(Potion p) {
    long startTime = System.nanoTime();
    store(p);
    long endTime = System.nanoTime();
    return endTime - startTime;
  }

  /**
   * Retrieves the Potion from the bag.
   * 
   * @param p the Potion to retrieve.
   * @return the Potion or null if the Potion was not in the bag.
   */
  public Potion retrieve(Potion p) {
    return potions.remove(p);
  }

  /**
   * Returns the number of nanoseconds to takes to retrieve a potion.
   * 
   * @param p the potion to retrieve.
   * @return the number of nanoseconds it takes to retrieve a potion.
   */
  public long timedRetrieve(Potion p) {
    long startTime = System.nanoTime();
    retrieve(p);
    long endTime = System.nanoTime();
    return endTime - startTime;
  }

  /**
   * Returns the number of Potions in the bag.
   * 
   * @return the number of Potions in the bag.
   */
  public int size() {
    return potions.size();
  }
}
