package edu.ics211.sorts;

/**
 * Sorts.
 * @author Paul Snieder
 */
public enum SortAlgorithm {
  
  INSERTION {
    /**
     * String representation.
     * @return the string
     */
    public String toString() {
      return "Insertion Sort";
    }
  }, 
  
  BUBBLE {
    /**
     * String representation.
     * @return the string
     */
    public String toString() {
      return "Bubble Sort";
    }
  }, 
  
  SELECTION {
    /**
     * String representation.
     * @return the string
     */
    public String toString() {
      return "Selection Sort";
    }
  }, 
  
  SHELL {
    /**
     * String representation.
     * @return the string
     */
    public String toString() {
      return "Shell Sort";
    }
  }, 
  
  MERGE {
    /**
     * String representation.
     * @return the string
     */
    public String toString() {
      return "Merge Sort";
    }
  }, 
  
  HEAP {
    /**
     * String representation.
     * @return the string
     */
    public String toString() {
      return "Heap Sort";
    }
  }, 
  
  QUICK {
    /**
     * String representation.
     * @return the string
     */
    public String toString() {
      return "Quick Sort";
    }
  }

}