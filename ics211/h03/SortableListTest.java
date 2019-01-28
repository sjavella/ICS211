package edu.ics211.h03;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

/**
 * Tests the Sortable List in a JUnit test.
 * @author Simplicio Javellana-Samonte
 *
 */
public class SortableListTest {
  /**
   * IntComp which compares the integers using comparator.
   * @author Simplicio Javellana-Samonte
   *
   */
  private class IntComp implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {

      return o1 - o2;
    }
    
  }
  
  @Test
  void testInsertionSort() {
    SortableList<Integer> s = new SortableList<>();
    s.add(9);
    s.add(3);
    s.insertionSort(new IntComp());
    System.out.println(s.get(0));
    assertTrue(3 == s.get(0));
  }


  @Test
  void testBubbleSort() {
    SortableList<Integer> s = new SortableList<>();
    s.add(9);
    s.add(3);
    s.bubbleSort(new IntComp());
    assertTrue(3 == s.get(0));
  }


  @Test
  void testSelectionSort() {
    SortableList<Integer> s = new SortableList<>();
    s.add(9);
    s.add(3);
    s.selectionSort(new IntComp());
    assertTrue(3 == s.get(0));
  }


  @Test
  void testSet() {
    SortableList<Integer> s = new SortableList<>();

    s.add(9);
    s.add(3);
    s.add(7);
    try {
      s.set(-1, 69);
      assertTrue(69 == s.set(-1, 69));
    } catch (IndexOutOfBoundsException j) 
    {
      //expected
    }
    try {
      s.set(s.size() + 1, 69);
      assertTrue(69 == s.set(s.size() + 1, 69));
    } catch (IndexOutOfBoundsException j) 
    {
      //expected
    }
    assertTrue(4 == s.set(0, 4));
  }


  @Test
  void testIndexOf() {
    SortableList<Integer> s = new SortableList<>();
    s.add(2);
    s.add(3);
    s.add(7);
    assertTrue(0 == s.indexOf(2));
  }


  @Test
  void testRemove() {
    SortableList<Integer> s = new SortableList<>();
    s.add(2);
    s.add(3);
    s.add(7);
    try {
      s.set(-1, 69);
      assertTrue(69 == s.remove(-1));
    } catch (IndexOutOfBoundsException j) 
    {
      //expected
    }
    try {
      s.set(s.size() + 1, 69);
      assertTrue(69 == s.remove(s.size() + 1));
    } catch (IndexOutOfBoundsException j) 
    {
      //expected
    }
    assertEquals("Wrong size want 3", s.size(), 3);
    assertTrue(3 == s.remove(1));
    assertEquals("Wrong size want 2", s.size(), 2);
  }

}
