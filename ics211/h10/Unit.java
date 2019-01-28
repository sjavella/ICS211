package edu.ics211.h10;

import java.util.Random;

/**
 * Represents a Unit.
 *
 * @author Cam Moore
 *
 */
public enum Unit {
  OZ, CUP, PINT, TSP, TBSP, LB, DASH, DROP, PART, PIECE, SCOOP, SPLASH, SPRIG, STICK;
  
  /**
   * @return a random Unit.
   */
  public static Unit getRandomUnit() {
    Random random = new Random();
    return values()[random.nextInt(values().length)];
  }
}
