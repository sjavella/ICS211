/**
 * IndianPaleAle.java
 * Copyright (C) Simplicio Javellana-Samonte 2018
 */

package edu.ics211.h01;

/**
 * Represents an Indian Pale Ale object.
 * 
 * @author Simplicio Javellana-Samonte
 *
 */
public class IndiaPaleAle extends Beer {
  
  /**
   * Create an India Pale Ale.
   * @param name Name of IPA
   * @param ibu value of ibu
   * @param abv value of abv
   */
  public IndiaPaleAle(String name, Integer ibu, Double abv) {
    super(name, "India Pale Ale", checkIndiaIbu(ibu), checkIndiaAbv(abv));
  }
  
  /**
   * Create an India Pale Ale with a random ibu and abv.
   * @param name Name of India Pale Ale
   */
  public IndiaPaleAle(String name) {
    super(name, "India Pale Ale", indianPaleAleIbu(), indianPaleAleAbv());
    
  }

}
