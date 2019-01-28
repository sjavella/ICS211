/**
 * SortableListNotesTest.java
 * Copyright (C) Simplicio Javellana-Samonte 2018
 */

package edu.ics211.h04;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Comparator;
import java.util.Random;
import org.junit.Test;


/**
 * A JUnit test for SortableList.
 * @author Simplicio Javellana-Samonte
 *         Worked with Matthew Kim, Micah Kim, and Richard Harmer.
 */
public class SortableListTest {

  private IntCompare intC;
  private SortableList<Integer> randList;
  private SortableList<Integer> shortSortedList;
  private SortableList<Integer> longSortedList;
  private SortableList<Integer> veryLongSortedList;
  private SortableList<Integer> sizeZero;


  /**
   * IntCompare A Comparator for Integers.
   * 
   * @author Simplicio Javellana-Samonte
   *
   */
  public class IntCompare implements Comparator<Integer> {

    /**
     * Compares two Integers through subtraction.
     * 
     * @author Simplicio Javellana-Samonte
     * @param arg0 input number.
     * @param arg1 input number #2.
     * @return difference of arg0 and arg1.
     */
    public int compare(Integer arg0, Integer arg1) {
      return arg0 - arg1;
    }
  }
  
  /**
   * Creates ArrayLists to test SortableListNotes.
   */
  public SortableListTest() {
    intC = new IntCompare();
    randList = new SortableList<>();
    shortSortedList = new SortableList<>();
    longSortedList = new SortableList<>();
    veryLongSortedList = new SortableList<>();
    sizeZero = new SortableList<Integer>();
    Random random = new Random();
    
    for (int i = 0; i < 100; i++) {
      randList.add(random.nextInt(100));
    }
    shortSortedList.add(0);
    shortSortedList.add(1);
    shortSortedList.add(2);
    for (int i = 0; i < 1000; i++) {
      longSortedList.add(i);
    }
    for (int i = 0; i < 10000; i++) {
      veryLongSortedList.add(i);
    }
  }


  /**
   * Test method for get method.
   */
  @Test
  public void testGet() { 
    assertTrue("Wrong Get", shortSortedList.get(0) == 0);                        
    assertTrue("Wrong Get", shortSortedList.get(1) == 1);                     
    assertTrue("Wrong Get", shortSortedList.get(shortSortedList.size() - 1) == 2);  
    try {
      assertTrue("Wrong Get", shortSortedList.get(shortSortedList.size()) == 3);  
    } catch (IndexOutOfBoundsException e) {
      //expected
    }    
    
    try {
      assertTrue("Wrong Get", shortSortedList.get(-1) == 2);    
    } catch (IndexOutOfBoundsException e) {
      //expected
    }
  }


  /**
   * Test method for set method.
   */
  @Test
  public void testSet() {
    assertTrue("Wrong return", shortSortedList.set(0, 54) == 0);                      
    assertTrue("Wrong Get", shortSortedList.get(0) == 54);
    assertTrue("Wrong return", shortSortedList.set(1, 20) == 1);                    
    assertTrue("Wrong Get", shortSortedList.get(1) == 20);
    assertTrue("Wrong return", shortSortedList.set(2, 73) == 2);                   
    assertTrue("Wrong Get", shortSortedList.get(2) == 73);
    assertTrue("Wrong Get", shortSortedList.get(2) == 73);
    assertTrue("Size should be 3", shortSortedList.size() == 3);                    

    try {
      assertTrue(shortSortedList.set(shortSortedList.size(), 3) == 3);              
    } catch (IndexOutOfBoundsException e) {
      //expected
    }
    try {
      assertTrue(shortSortedList.set(-1, 3) == 3);                                 
    } catch (IndexOutOfBoundsException e) {
      //expected
    }
  }

  
  /**
   * Test method for indexOf.
   */
  @Test
  public void testIndexOf() {
    assertTrue("Should find 0", shortSortedList.indexOf(0) == 0);   
    assertTrue("Should find 1", shortSortedList.indexOf(1) == 1);   
    assertTrue("Should find 2", shortSortedList.indexOf(2) == 2);   
    assertTrue("Shouldn't find 69", shortSortedList.indexOf(69) == -1);  
    try {
      assertTrue("Shouldn't find 1, supposed to be 2.", shortSortedList.indexOf(2) == 1);     
    } catch (AssertionError e) {                                         
      //expected
    }
  }


  /**
   * Test method for the size.
   */
  @Test
  public void testSize() {
    assertEquals("Size should be 3", shortSortedList.size(), 3);
  }


  /**
   * Test method for adding.
   */
  @Test
  public void testAddE() {
    assertTrue("Doesn't return true OR doesn't add e", sizeZero.add(32) == true);    
    assertTrue("Wrong Get", sizeZero.get(0) == 32);
    assertEquals("Wrong Size", sizeZero.size(), 1);     
    
    assertTrue("Doesn't return true OR doesn't add e", shortSortedList.add(5) == true); 
    assertTrue("Wrong Get", shortSortedList.get(0) == 0);  
    assertTrue("Wrong Get", shortSortedList.get(1) == 1);  
    assertTrue("Wrong Get", shortSortedList.get(2) == 2); 
    assertTrue("Wrong Get", shortSortedList.get(3) == 5);
    assertEquals("Size should be 4", 4, shortSortedList.size());  
  }
  /**
   * Test method for adding an int E.
   */
  
  @Test
  public void testAddIntE() {

    sizeZero.add(0, 5);                                
    assertTrue("Wrong Get", sizeZero.get(0) == 5);
    assertEquals("Size should be 1", sizeZero.size(), 1);
    
    shortSortedList.add(0, 87);                      
    shortSortedList.add(2, 56);                        
    shortSortedList.add(shortSortedList.size(), 42);   
    assertTrue("Wrong Get", shortSortedList.get(0) == 87);
    assertTrue("Wrong Get", shortSortedList.get(1) == 0);
    assertTrue("Wrong get", shortSortedList.get(2) == 56);
    assertTrue("Wrong get", shortSortedList.get(3) == 1);
    assertTrue("Wrong Get", shortSortedList.get(4) == 2);
    assertTrue("Wrong Get", shortSortedList.get(shortSortedList.size() - 1) == 42);
    assertEquals("Size should be 6", 6, shortSortedList.size());

    try {
      shortSortedList.add(shortSortedList.size() + 1, 3); 
    } catch (IndexOutOfBoundsException e) {
     //expected
    }
    try {
      shortSortedList.add(-1, 3);
    } catch (IndexOutOfBoundsException e) {
     //expected
    }
  }


  /**
   * Test method for removing.
   */
  @Test
  public void testRemove() {
    sizeZero.add(0, 5); 
    assertTrue("Wrong return value", sizeZero.remove(0) == 5);
    assertEquals("Size should be 0", 0, sizeZero.size());    
    try {
      assertTrue("Wrong Get", sizeZero.get(0) == 5);
    } catch (IndexOutOfBoundsException e) {
      //expected
    }
    
    assertTrue("Wrong return value", shortSortedList.remove(0) == 0); 
    assertTrue("Wrong Get", shortSortedList.get(0) == 1);
    assertTrue("Wrong Get", shortSortedList.get(1) == 2);
    assertEquals("Size should be 2", 2, shortSortedList.size());
    shortSortedList.add(0, 0);   
    
    assertTrue("Wrong return value", shortSortedList.remove(1) == 1); 
    assertTrue("Wrong Get", shortSortedList.get(0) == 0);
    assertTrue("Wrong Get", shortSortedList.get(1) == 2);
    assertEquals("Size should be 2", 2, shortSortedList.size());
    shortSortedList.add(1, 1);   

    assertTrue("Wrong return value", 
        shortSortedList.remove(shortSortedList.size() - 1) == 2);
    assertTrue("Wrong Get", shortSortedList.get(0) == 0);  
    assertTrue("Wrong Get", shortSortedList.get(1) == 1);
    assertEquals("Size should be 2", 2, shortSortedList.size());
    
    try {
      assertTrue(shortSortedList.remove(shortSortedList.size()) == 2);   
    } catch (IndexOutOfBoundsException e) {
      //expected
    }
    try {
      assertTrue(shortSortedList.remove(-1) == 2);      
    } catch (IndexOutOfBoundsException e) {
      //expected
    }
  }


  /**
   * Test method for insertionSort.
   * Tests for sorted/unsorted arrays.
   */
  @Test
  public void testInsertionSort() {
    SortableList<Integer> copyRand = copyOf(randList, randList.size());
    copyRand.insertionSort(intC);
    assertTrue("ArrayList not sorted.", isSorted(copyRand, intC));

    SortableList<Integer> shortSortedCopy = copyOf(shortSortedList, shortSortedList.size());
    shortSortedCopy.insertionSort(intC);
    final double shortTime = shortSortedCopy.getSortTime();
    assertTrue("shortArrayList not sorted.", isSorted(shortSortedCopy, intC));
    assertEquals("Wrong number of comparisons", shortSortedCopy.getNumberOfComparisons(), 
        shortSortedList.size() - 1);
    assertEquals("Wrong number of swaps", shortSortedCopy.getNumberOfSwaps(), 0);

    SortableList<Integer> longSortedCopy = copyOf(longSortedList, longSortedList.size());
    longSortedCopy.insertionSort(intC);
    final double longTime = longSortedCopy.getSortTime();
    assertTrue("Bad timing", longTime > shortTime);
    SortableList<Integer> veryLongSortedCopy;
    veryLongSortedCopy = copyOf(veryLongSortedList, veryLongSortedList.size());
    veryLongSortedCopy.insertionSort(intC);
    final double veryLongTime = veryLongSortedCopy.getSortTime();
    assertTrue("Bad timing", veryLongTime > longTime);
  }


  /**
   * Test method for bubbleSort.
   * Tests sorted/unsorted arrays.
   */
  @Test
  public void testBubbleSort() {
    SortableList<Integer> copyRand = copyOf(randList, randList.size());
    copyRand.bubbleSort(intC);
    assertTrue("Random ArrayList not sorted.", isSorted(copyRand, intC));

    SortableList<Integer> shortSortedCopy = copyOf(shortSortedList, shortSortedList.size());
    shortSortedCopy.bubbleSort(intC);
    final double shortTime = shortSortedCopy.getSortTime();
    assertTrue("shortArrayList not sorted.", isSorted(shortSortedCopy, intC));
    assertEquals("Wrong number of comparisons", shortSortedCopy.getNumberOfComparisons(), 
        shortSortedList.size() - 1);
    assertEquals("Wrong number of swaps", shortSortedCopy.getNumberOfSwaps(), 0);

    SortableList<Integer> longSortedCopy = copyOf(longSortedList, longSortedList.size());
    longSortedCopy.bubbleSort(intC);
    final double longTime = longSortedCopy.getSortTime();
    assertTrue("Bad timing", longTime > shortTime);

    SortableList<Integer> veryLongSortedCopy;
    veryLongSortedCopy = copyOf(veryLongSortedList, veryLongSortedList.size());
    veryLongSortedCopy.bubbleSort(intC);
    final double veryLongTime = veryLongSortedCopy.getSortTime();
    assertTrue("Bad timing", veryLongTime > longTime);
  }


  /**
   * Test method for selectionSort.
   * Tests sorted/unsorted arrays.
   */
  @Test
  public void testSelectionSort() {
    SortableList<Integer> copyRand = copyOf(randList, randList.size());
    copyRand.selectionSort(intC);
    assertTrue("Random ArrayList not sorted.", isSorted(copyRand, intC));

    SortableList<Integer> shortSortedCopy = copyOf(shortSortedList, shortSortedList.size());
    shortSortedCopy.selectionSort(intC);
    final double shortTime = shortSortedCopy.getSortTime();
    assertTrue("ArrayList not sorted.", isSorted(shortSortedCopy, intC));
    assertEquals("Wrong number of comparisons", shortSortedCopy.getNumberOfComparisons(), (2 + 1));
    assertEquals("Wrong number of swaps", shortSortedCopy.getNumberOfSwaps(), 0);

    SortableList<Integer> longSortedCopy = copyOf(longSortedList, longSortedList.size());
    longSortedCopy.selectionSort(intC);
    final double longTime = longSortedCopy.getSortTime();
    assertTrue("Bad timing", longTime > shortTime);

    SortableList<Integer> veryLongSortedCopy;
    veryLongSortedCopy = copyOf(veryLongSortedList, veryLongSortedList.size());
    veryLongSortedCopy.selectionSort(intC);
    final double veryLongTime = veryLongSortedCopy.getSortTime();
    System.out.println(veryLongTime + " > " + longTime);
    assertTrue("Bad timing", veryLongTime > longTime);           
  }                                                            

  /**
   * Makes a copy of an ArrayList.
   * 
   * @param original The original ArrayList.
   * @param newLength The length of the ArrayList.
   * @return a copy of ArrayList.
   */
  private SortableList<Integer> copyOf(SortableList<Integer> original, int newLength) {
    SortableList<Integer> copy = new SortableList<Integer>();
    for (int i = 0; i < original.size(); i++) {
      copy.add(i, original.get(i));
    }
    return copy;
  }


  /**
   * Checks if the ArrayList is sorted.
   * 
   * @param data The ArrayList being checked.
   * @param comp A comparator that compares ints.
   * @return boolean which determines if its sorted or not (true if yes, false if no.)
   */
  private boolean isSorted(SortableList<Integer> data, Comparator<Integer> comp) {
    for (int i = 0; i < data.size() - 1; i++) {
      if (comp.compare(data.get(i), data.get(i + 1)) > 0) {
        return false;
      }
    }
    return true;
  }
}
