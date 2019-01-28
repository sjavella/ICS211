package edu.ics211.h01;

/**
 * The IBrewery interface. All good breweries should implement this interface.
 *
 * @author Cam Moore
 *
 */
public interface IBrewery {
  public static final String BOHEMIAN_PILSNER = "Bohemian Pilsner";
  public static final String INDIA_PALE_ALE = "India Pale Ale";
  public static final String PILSNER = "Pilsner";

  /**
   * Brews the beer with the given type.
   * 
   * @param name the name of the beer.
   * @param type the type of the beer.
   * @return the beer.
   */
  Beer brewBeer(String name, String type);
  

  /**
   * Brews a Pilsner with the given name, ibu and abv.
   * 
   * @param name the name of the beer.
   * @param ibu The International Bitterness Units.
   * @param abv The alcohol by volume.
   * @return a Pilsner.
   */
  Beer brewPilsner(String name, Integer ibu, Double abv);


  /**
   * Brews a Bohemian Pilsner with the given name, ibu and abv.
   * 
   * @param name the name of the beer.
   * @param ibu The International Bitterness Units.
   * @param abv The alcohol by volume.
   * @return a Bohemian Pilsner.
   */
  Beer brewBohemianPilsner(String name, Integer ibu, Double abv);


  /**
   * Brews an India Pale Ale with the given ibu and abv.
   * 
   * @param name the name of the beer.
   * @param ibu The International Bitterness Units.
   * @param abv The alcohol by volume.
   * @return an India Pale Ale.
   */
  Beer brewIndiaPaleAle(String name, Integer ibu, Double abv);
}
