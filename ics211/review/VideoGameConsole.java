package edu.ics211.review;
/**
 * A Video Game Console.
 * @author Simplicio Javellana-Samonte
 *
 */

public abstract class VideoGameConsole {
  
  private String manufacturer;
  private String model;
  private String submodel;
  private double price;
  /**
   * Video Game Console Constructor.
   * @param manufacturer The manufacturer of the console
   * @param model The model of the console
   * @param submodel sub-model of the console
   * @param price How much the console costs
   */
  
  public VideoGameConsole(String manufacturer, String model, String submodel, double price) {
    this.manufacturer = manufacturer;
    this.model = model;
    this.submodel = submodel;
    this.price = price;
  }
  /**
   * Gets the manufacturer variable of the Video Game Console object.
   * @return manufacturer
   */
  
  public String getManufacturer() {
    return this.manufacturer;
  }
  /**
   * Gets the model variable of the Video Game Console object.
   * @return model 
   */
  
  public String getModel() {
    return this.model;
  }
  
  /**
   * Gets the sub-model variable of the Video Game Console object.
   * @return submodel
   */
  
  public String getSubmodel() {
    return this.submodel;
  }
  /**
   * Gets the price variable of the Video Game Console object.
   * @return price
   */
  
  public double getPrice() {
    return this.price;
  }

}
