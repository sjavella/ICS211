/**
 * ManoaBrewing.java
 * Copyright (C) Simplicio Javellana-Samonte 2018
 */

package edu.ics211.h01;

/**
 * Represents the Manoa Brewery, its alright I guess.
 * 
 * @author Simplicio Javellana-Samonte
 *
 */
public class ManoaBrewing implements IBrewery {
  private static ManoaBrewing instance;


  private ManoaBrewing() {
  }


  /**
   * Gets an instance of the ManoaBrewing.
   * @return instance if there is none
   */
  
  public static ManoaBrewing getInstance() {

    if (instance == null) {
      instance = new ManoaBrewing();
    }
    return instance;
  }


  /**
   * Brews a Beer.
   * @param name Name of Beer
   * @param type Type of Beer
   * @return Beer or IllegalArgumentException.
   */
  public Beer brewBeer(String name, String type) { 
    
    if (type == IBrewery.PILSNER) { 
      return new Pilsner(name);
    } else if (type == IBrewery.BOHEMIAN_PILSNER) {
      return new BohemianPilsner(name);     
    } else if (type == IBrewery.INDIA_PALE_ALE) {
      return new IndiaPaleAle(name);     
    } else {       
      throw new IllegalArgumentException();     
    }   
  }
  /**
   * Brew a Pilsner.
   * @param name Name of Pilsner
   * @param ibu ibu of Pilsner
   * @param abv abv of Pilsner
   * @return o Returns the Pilsner
   */
 
  public Beer brewPilsner(String name, Integer ibu, Double abv) {
    Beer o = new Pilsner(name, ibu, abv);
    return o;
  }
  /**
   * Brew a Bohemian Pilsner.
   * @param name Name of BP
   * @param ibu ibu of BP
   * @param abv abv of BP
   * @return o Returns the BP
   */
  
  public Beer brewBohemianPilsner(String name, Integer ibu, Double abv) {
    Beer o = new BohemianPilsner(name, ibu, abv);
    return o;
  }

  /**
   * Brew an India Pale Ale.
   * @param name Name of IPA
   * @param ibu ibu of IPA
   * @param abv abv of IPA
   * @return o Returns the IPA
   */
  
  public Beer brewIndiaPaleAle(String name, Integer ibu, Double abv) {
    Beer o = new IndiaPaleAle(name, ibu, abv);
    return o;
  }

}
