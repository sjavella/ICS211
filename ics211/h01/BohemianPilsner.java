/**
 * BohemianPilsner.java
 * Copyright (C) Simplicio Javellana-Samonte 2018
 */

package edu.ics211.h01;

/**
 * Represents a Bohemian Pilsner object.
 * 
 * @author Simplicio Javellana-Samonte
 *
 */
public class BohemianPilsner extends Pilsner {
  /**
   * Create a Pilsner with name, ibu, & abv.
   * 
   * @param name Name of Pilsner
   * @param ibu Pilsner ibu value
   * @param abv Pilsner abv value
   */

  public BohemianPilsner(String name, Integer ibu, Double abv) {
    super(name, checkBohemianIbu(ibu), checkBohemianAbv(abv));
  }


  /**
   * Create a Pilsner with a name, and set a random ibu and random abv.
   * 
   * @param name Name of Pilsner
   */

  public BohemianPilsner(String name) {
    super(name, bohemianPilsnerIbu(), bohemianPilsnerAbv());

  }

}
