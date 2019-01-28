/**
 * PostFixCalculator.java
 * Copyright (C) Simplicio Javellana-Samonte 2018
 */

package edu.ics211.h06;

import java.util.Scanner;
import java.util.Stack;

/**
 * A calculator that solves equations using post-fix method.
 * @author Simplicio Javellana-Samonte
 *
 */
public class PostFixCalculator {
  private static PostFixCalculator instance;

  
  private PostFixCalculator(){
    
  }
  
  /**
   * Gets an instance of PostFixCalculator.
   * @return instance if none
   */
  public static PostFixCalculator getInstance() {

    if (instance == null) {
      instance = new PostFixCalculator();
    }
    return instance;
  }
  /**
   * Calculates an expression.
   * @param exp a String of the postfix expression
   * @return result of the equation as a Number
   * @throws InvalidExpressionException if expression isn't valid postfix
   */
  
  public Number calculate(String exp) throws InvalidExpressionException {
    Stack<Number> s = new Stack<Number>();
    Scanner tokens = new Scanner(exp);
    
    while (tokens.hasNext()) { 
      //takes in integer values, casts as Number object, and pushes them into the Number stack.
      if (tokens.hasNextInt()) {
        s.push((Number)tokens.nextInt()); 
        System.out.println("took " + s.peek());
      //takes in double values, casts as Number object, and pushes them into the Number stack.
      } else if (tokens.hasNextDouble()) {
        s.push((Number)tokens.nextDouble());
        System.out.println("took " + s.peek());
      //detects operators, sees if the operand is an int or a double, analyzes what operator it is.
      } else if (s.peek() instanceof Double) { 
        String op = tokens.next();
        double double2 = (double) s.pop();
        //tried to put if statement here in hopes that if the next pop is an int then you are able
        //to operate between a double and an integer; long story short it didnt work lol
        if (s.peek() instanceof Integer) {
          int num1 = (int) s.pop();
          if (op.equals("+")) {
            s.push(double2 + num1);
          } else if (op.equals("-")) {
            s.push(double2 - num1);
          } else if (op.equals("*")) {
            s.push(double2 * num1);
          } else if (op.equals("/")) {
            s.push(num1 / double2);
          } else {
            s.push(double2 % num1);
          }
          System.out.println("answer " + s.peek());
          return s.pop();
        }
        double double1 = (double) s.pop();

  

        if (op.equals("+")) {
          s.push(double1 + double2);
        } else if (op.equals("-")) {
          s.push(double1 - double2);
        } else if (op.equals("*")) {
          s.push(double1 * double2);
        } else if (op.equals("/")) {
          s.push(double1 / double2);
        } else {
          s.push(double1 % double2);
        }
      } else if (s.peek() instanceof Integer) {
        
        String op = tokens.next();
        int num2 = (int) s.pop();
        System.out.println("popped " + num2 + ", assigned to num2");
        if (s.peek() instanceof Double) {
          double double1 = (double) s.pop();
          System.out.println("double detected after int! pop " + double1 + ", assigned to double1");
          if (op.equals("+")) {
            s.push(num2 + double1);
          } else if (op.equals("-")) {
            s.push(num2 + double1);
          } else if (op.equals("*")) {
            s.push(num2 + double1);
          } else if (op.equals("/")) {
            s.push(num2 + double1);
          } else {
            s.push(num2 + double1);
          }
          System.out.println("solution " + s.peek());
        }
        int num1 = (int) s.pop();
        System.out.println("popped " + num1 + ", assigned to num1");

        if (op.equals("+")) {
          s.push(num1 + num2);
          System.out.println("added " + num1 + " & " + num2);
        } else if (op.equals("-")) {
          s.push(num1 - num2);
        } else if (op.equals("*")) {
          s.push(num1 * num2);
        } else if (op.equals("/")) {
          s.push(num1 / num2);
        } else {
          s.push(num1 % num2);
        }
        System.out.println("gave " + s.peek());
      }
    }
    System.out.println("returned " + s.peek());
    return s.pop();
  }
}

