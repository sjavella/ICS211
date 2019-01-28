package edu.ics211.review;

/**
 * Represents a Playstation.
 * @author Paul Snieder
 */
public class Playstation extends VideoGameConsole {
  
  /**
   * Constructor.
   * @param model model of the Playstation
   * @param submodel submodel of the Playstation
   * @param price price of the Playstation
   */
  public Playstation(String model, String submodel, double price) {
    super("Sony", model, submodel, price);
  }

}
