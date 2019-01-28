package edu.ics211.review;

import java.util.LinkedList;

/**
 * Represents a Gamestop.
 * @author Paul Snieder
 */
public class GameStop {
  
  private LinkedList<VideoGameConsole> consoleInventory;
  
  private VideoGameConsole x1x = new Xbox("Xbox One", "X", 499.99);
  private VideoGameConsole x1s = new Xbox("Xbox One", "S", 299.99);
  private VideoGameConsole ps4pro = new Playstation("Playstation 4", "Pro", 399.99);
  
  /**
   * Constructor.
   */
  public GameStop() {
    this.consoleInventory = new LinkedList<VideoGameConsole>();
    this.consoleInventory.add(x1x);
    this.consoleInventory.add(x1s);
    this.consoleInventory.add(ps4pro);
  }
  
  /**
   * Returns the inventory.
   * @return the inventory
   */
  public LinkedList<VideoGameConsole> getConsoleInventory() {
    return this.consoleInventory;
  }

}
