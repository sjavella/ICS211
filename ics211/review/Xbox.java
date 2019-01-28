package edu.ics211.review;

/**
 * Represents an Xbox.
 * @author Paul Snieder
 */
public class Xbox extends VideoGameConsole {
  
  /**
   * Constructor.
   * @param model model of the Xbox
   * @param submodel submodel of the Xbox
   * @param price price of the Xbox
   */
  public Xbox(String model, String submodel, double price) {
    super("Microsoft", model, submodel, price);
  }

}
