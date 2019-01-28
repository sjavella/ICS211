/**
 * SlowPotionBag.java
 * Copyright (C) Simplicio Javellana-Samonte 2018
 */

package edu.ics211.h10;

/**
 * A Slow Potion Bag.
 * @author Simplicio Javellana-Samonte
 *
 */
public class SlowPotionBag implements PotionBag {
  private static SlowPotionBag instance;
  private Potion[] potions = new Potion[100001];
  
  /**
   * Empty class.
   */
  private SlowPotionBag() {
  }
  
  /**
   * Get instances.
   * @return return instance
   */
  public static SlowPotionBag getInstance() {
    if (instance == null) {
      instance = new SlowPotionBag();
    }
    return instance;
  }
  
  /**
   * Stores the given Potion in the PotionBag.
   * 
   * @param p the Potion to store.
   */
  public void store(Potion p) {
    for (int i = 0; i < potions.length; i++) {
      if (potions[i] == null) {
        potions[i] = p;
        break;
      }
    }
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
    for (int i = 0; i < potions.length; i++) {
      if (potions[i] == null) {
        return null;
      }
      if (potions[i].equals(p)) {
        return potions[i];
      }
    }
    return null;
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
    for (int i = 0; i < potions.length; i++) {
      if (potions[i] == null) {
        return i;
      }
    }
    return potions.length;
  }
}