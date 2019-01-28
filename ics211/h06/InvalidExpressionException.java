package edu.ics211.h06;

/**
 * Represents a InvalidExpressionException.
 *
 * @author Cam Moore
 *
 */
public class InvalidExpressionException extends Exception {

  /** Default constructor. */
  public InvalidExpressionException() {
    super();
  }
  
  /**
   * @param message the error message.
   */
  public InvalidExpressionException(String message) {
    super(message);
  }

  /** Holds the serialVersionUID value a long. */
  private static final long serialVersionUID = -5121813737929147074L;

}
