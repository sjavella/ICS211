/**
 * PostFixCalculatorUserInput.java
 * Copyright (C) Simplicio Javellana-Samonte 2018
 */

package edu.ics211.h06;

import java.util.Scanner;

/**
 * Takes a user input for the PostFixCalculator.
 * @author Simplicio Javellana-Samonte
 *
 */
public class PostFixCalculatorUserInput {
  /**
   * Takes user input.
   * @param args User input
   * @throws InvalidExpressionException if user input is not a valid postfix equation.
   */
  
  public static void main(String[] args) throws InvalidExpressionException {
    PostFixCalculator c = PostFixCalculator.getInstance();
    System.out.println("Hi im a postfix calculator, insert a postfix equation here: ");
    Scanner inputEquation = new Scanner(System.in);
    c.calculate(inputEquation.nextLine());
  }

}
