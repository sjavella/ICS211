/**
 * ContactComparator.java
 * Copyright (C) Simplicio Javellana-Samonte 2018
 */

package edu.ics211.h09;

import java.util.Comparator;

/**
 * A Contact Comparator based on last and first name.
 * @author Simplicio Javellana-Samonte
 * @param <E> contact objects from the Contact class
 */

public class ContactComparator<E> implements Comparator<Contact> {

  /**
   * Compares two contacts by last name and first name.
   * @param o1 a contact for comparison
   * @param o2 another contact for comparison
   * @return 1, 0, -1 depending on the outcome. 
   */
  
  public int compare(Contact o1, Contact o2) {
    if (o1.getLastName().equals(o2.getLastName())) {
      return o1.getFirstName().compareTo(o2.getFirstName());
    } else {
      return o1.getLastName().compareTo(o2.getLastName());
    }
  }
}
