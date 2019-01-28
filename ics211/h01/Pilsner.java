/**
 * Pilsner.java
 * Copyright (C) Simplicio Javellana-Samonte 2018
 */

package edu.ics211.h01;

import java.util.Random;

/**
 * Represents a Pilsner.
 * 
 * @author Simplicio Javellana-Samonte Worked with Micah Kim and Matthew Kim for checking values.
 * 
 */

public class Pilsner extends Beer {

  /**
   * Generate a Pilsner.
   * 
   * @param name The name
   * @param ibu The ibu
   * @param abv The abv
   */

  public Pilsner(String name, Integer ibu, Double abv) {
    // used this
    // https://stackoverflow.com/questions/38381133/check-conditions-in-subclass-before-calling-superclass-constructor-method
    super(name, "Pilsner", checkIbu(ibu), checkAbv(abv));

  }


  /**
   * Generate a Pilsner.
   * 
   * @param name Name of Pilsner
   */

  public Pilsner(String name) {
    super(name, "Pilsner", pilsnerIbu(), pilsnerAbv());

  }


  /**
   * Checks the ibu.
   * 
   * @param ibu ibu of Beer
   * @return IllegalArgumentException
   */
  public static int checkIbu(int ibu) {
    if (ibu < 25 || ibu > 45) {
      throw new IllegalArgumentException("Not a valid ibu value.");
    }
    return ibu;
  }


  /**
   * Checks the abv.
   * 
   * @param abv abv of Beer
   * @return IllegalArgumentException
   */

  public static Double checkAbv(Double abv) {
    if (abv < 4.0 || abv > 6.2) {
      throw new IllegalArgumentException("Not a valid abv value.");
    }
    return abv;
  }


  /**
   * Roll a Bohemian Pilsner ibu.
   * 
   * @return Bohemian Pilsner ibu.
   */
  public static int bohemianPilsnerIbu() {

    Random ibuRoll = new Random();
    int ibu = ibuRoll.nextInt(10) + 35;
    return ibu;
  }


  /**
   * Roll a Bohemian Pilsner abv.
   * 
   * @return Bohemian Pilsner abv
   */

  public static Double bohemianPilsnerAbv() {
    Random abvRoll = new Random();
    Double abv = 4.2 + (5.4 - 4.2) * abvRoll.nextDouble();
    return abv;
  }


  /**
   * Checks Bohemian ibu.
   * 
   * @param ibu the Bohemian ibu value
   * @return IllegalArgException if not valid value.
   */
  public static int checkBohemianIbu(int ibu) {
    if (ibu < 35 || ibu > 45) {
      throw new IllegalArgumentException("Not a valid ibu value.");
    }
    return ibu;
  }


  /**
   * Checks Bohemian abv value.
   * 
   * @param abv abv of Bohemian
   * @return IllegalArgumentException if not a valid abv value within parameters.
   */

  public static Double checkBohemianAbv(Double abv) {
    if (abv < 4.2 || abv > 5.4) {
      throw new IllegalArgumentException("Not a valid abv value.");
    }
    return abv;
  }
}
