/**
 * Beer.java
 * Copyright (C) Simplicio Javellana-Samonte 2018
 */

package edu.ics211.h01;

import java.util.Random;

/**
 * Represents a Beer.
 * 
 * @author Simplicio Javellana-Samonte
 *
 */
public class Beer implements Comparable<Beer> {

  private String name;
  private String type;
  private Integer ibu;
  private Double abv;
  

  
  /**
   * Creates a Beer with the given name and type.
   * @param name The name of the Beer.
   * @param type The type of the Beer.
   */
  
  
  public Beer(String name, String type) {
    this.name = name;
    this.type = type;
    
  }
  
  /**
   * Creates a Beer with the given name and type.
   * @param name The name of the Beer.
   * @param type The type of the Beer.
   * @param ibu The ibu of the Beer.
   * @param abv The abv of the beer
   */
  public Beer(String name, String type, Integer ibu, Double abv) {
    this.name = name;
    this.type = type;
    this.ibu = ibu;
    this.abv = abv;
    
  }
  /**
   * Sets the name of the Beer.
   * @param name - Input new name here.
   */
  
  public void setName(String name) {
    this.name = name;
  }
  
  /**
   * Gets the name of the Beer.
   * @return Name of the Beer.
   */
  public String getName() {
    return name;
  }
  /**
   * Gets the type of the Beer.
   * @return Type of the Beer.
   */
  
  public String getType() {
    return type;
  }
  /**
   * Gets the ibu of the Beer.
   * @return ibu of the Beer.
   */
  
  public Integer getIbu() {
    return ibu;
  }
  /**
   * Gets the abv of the Beer.
   * @return abv of the Beer.
   */
  
  public Double getAbv() {
    return abv;
  }
  
  /**
   * Checks the Beer ibu.
   * @param ibu The ibu value of beer
   * @return ibu
   */
  public static int checkIbu(int ibu) {
    if (ibu < 25 || ibu > 45) {
      throw new IllegalArgumentException("Not a valid ibu value.");
    }
    return ibu;
  }
  
  /**
   * Checks the Beer abv.
   * @param abv the abv value of beer
   * @return abv
   */
  public static Double checkAbv(Double abv) {
    if (abv < 4.0 || abv > 6.2) {
      throw new IllegalArgumentException("Not a valid abv value.");
    }
    return abv;
  }
  
  /**
   * Roll a Pilsner ibu.
   * @return ibu
   */
  public static int pilsnerIbu() {
    Random ibuRoll = new Random();
    int ibu = ibuRoll.nextInt(20) + 25;
    return ibu;
  }
  
  /**
   * Roll a Pilsner abv.
   * @return abv
   */
  public static Double pilsnerAbv() {
    Random abvRoll = new Random();
    Double abv = 4.2 + (6.0 - 4.2) * abvRoll.nextDouble();
    return abv;
  }
  
  /**
   * Roll an IPA ibu.
   * @return ibu
   */
  public static int indianPaleAleIbu() {
    Random ibuRoll = new Random();
    int ibu = ibuRoll.nextInt(60) + 40;
    return ibu;
  }
  
  /**
   * Roll a random abv for India Pale Ale.
   * @return abv
   */
  public static Double indianPaleAleAbv() {
    Random abvRoll = new Random();
    Double abv = 5.0 + (10.0 - 5.0) * abvRoll.nextDouble();
    return abv;
  }
  
  /**
   * Checks the India Pale Ale ibu.
   * @param ibu The ibu value of the IPA
   * @return ibu
   */
  
  public static int checkIndiaIbu(int ibu) {
    if (ibu < 40 || ibu > 100) {
      throw new IllegalArgumentException("Not a valid ibu value.");
    }
    return ibu;
  }
  /**
   * Checks the India Pale Ale abv.
   * @param abv The abv value of the IPA
   * @return abv
   */
  
  public static Double checkIndiaAbv(Double abv) {
    if (abv < 5.0 || abv > 10.0) {
      throw new IllegalArgumentException("Not a valid abv value.");
    }
    return abv;
  }
 


  @Override
  public int compareTo(Beer anotherBeer) {
    if (!(anotherBeer instanceof Beer)) {
      throw new ClassCastException("A Beer object expected.");
    }
    return this.name.compareTo(anotherBeer.name);
    
  }
    
  
  

}
