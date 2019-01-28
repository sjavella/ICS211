package edu.ics211.h07;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

/**
 * Represents a CheckoutLanesTest. 
 *
 * @author Simplicio Javellana-Samonte
 *
 */
public class CheckoutLanesTest {

  /**
   * Tests a Checkout Lane with no express lane.
   */
  @Test
  public void testNoExpress() {
    System.out.println("\nTest No Express");
    CheckoutLanes lanes = new CheckoutLanes(0, 1);
    lanes.enterLane(0, new Shopper(5));
    lanes.enterLane(0, new Shopper(10));
    lanes.enterLane(0, new Shopper(15));
    lanes.enterLane(0, new Shopper(4));
    lanes.enterLane(0, new Shopper(69));
    lanes.enterLane(0, new Shopper(10));
    lanes.enterLane(0, new Shopper(52));
    lanes.enterLane(0, new Shopper(12));
    lanes.enterLane(0, new Shopper(11));
    List<Shopper> shoppers = lanes.simulateCheckout();
    assertEquals("Wrong number of shoppers", 9, shoppers.size());
    assertTrue(shoppers.get(0).getNumberOfItems() == 5);
    assertTrue(shoppers.get(1).getNumberOfItems() == 10);
    assertTrue(shoppers.get(2).getNumberOfItems() == 15);
    assertTrue(shoppers.get(3).getNumberOfItems() == 4);
    assertTrue(shoppers.get(4).getNumberOfItems() == 69);
    assertTrue(shoppers.get(5).getNumberOfItems() == 10);
    assertTrue(shoppers.get(6).getNumberOfItems() == 52);
    assertTrue(shoppers.get(7).getNumberOfItems() == 12);
    assertTrue(shoppers.get(8).getNumberOfItems() == 11);
  }

  /**
   * Tests a Checkout Lane with one express lane and one regular lane.
   */
  @Test
  public void testOneExpressLane() {
    System.out.println("\nTest One Express");
    CheckoutLanes lanes = new CheckoutLanes(1, 1);
    lanes.enterLane(0, new Shopper(15));
    lanes.enterLane(0, new Shopper(10));
    lanes.enterLane(0, new Shopper(5));
    lanes.enterLane(1, new Shopper(25));
    lanes.enterLane(0, new Shopper(8));
    lanes.enterLane(0, new Shopper(3));
    lanes.enterLane(1, new Shopper(21));

    List<Shopper> shoppers = lanes.simulateCheckout();
    assertEquals("Wrong number of shoppers", 7, shoppers.size());
    assertTrue(shoppers.get(0).getNumberOfItems() == 25);
    assertTrue(shoppers.get(1).getNumberOfItems() == 10);
    assertTrue(shoppers.get(2).getNumberOfItems() == 21);
    assertTrue(shoppers.get(3).getNumberOfItems() == 5);
    assertTrue(shoppers.get(4).getNumberOfItems() == 15);
    assertTrue(shoppers.get(5).getNumberOfItems() == 8);
    assertTrue(shoppers.get(6).getNumberOfItems() == 3);


    
  }
  
  
  /**
   * Tests a Checkout Lane with one express lane and two regular lanes.
   */
  @Test
  public void testOneTwo() {
    System.out.println("\nTest One Express, Two Regular");
    CheckoutLanes checkout = new CheckoutLanes(1, 2);
    checkout.enterLane(1, new Shopper(15));
    checkout.enterLane(0, new Shopper(3));
    checkout.enterLane(1, new Shopper(20));
    checkout.enterLane(2, new Shopper(17));
    checkout.enterLane(0, new Shopper(12));
    checkout.enterLane(2, new Shopper(30));
    checkout.enterLane(1, new Shopper(23));
    checkout.enterLane(2, new Shopper(11));
    List<Shopper> shoppers = checkout.simulateCheckout();
    assertEquals("Wrong number of shoppers", 8, shoppers.size());
    assertTrue(shoppers.get(0).getNumberOfItems() == 3);
    assertTrue(shoppers.get(1).getNumberOfItems() == 15);
    assertTrue(shoppers.get(2).getNumberOfItems() == 17);
    assertTrue(shoppers.get(3).getNumberOfItems() == 20);
    assertTrue(shoppers.get(4).getNumberOfItems() == 30);
    assertTrue(shoppers.get(5).getNumberOfItems() == 23);
    assertTrue(shoppers.get(6).getNumberOfItems() == 11);
    assertTrue(shoppers.get(7).getNumberOfItems() == 12);
  }

  /**
   * Tests a Checkout Lane with two express lanes and two regular lanes.
   */
  @Test
  public void testTwoTwo() {
    System.out.println("\nTest Two Express, Two Regular");
    CheckoutLanes checkout = new CheckoutLanes(2, 2);
    checkout.enterLane(2, new Shopper(15));
    checkout.enterLane(1, new Shopper(3));
    checkout.enterLane(1, new Shopper(14));
    checkout.enterLane(2, new Shopper(24));
    checkout.enterLane(3, new Shopper(12));
    checkout.enterLane(2, new Shopper(5));
    checkout.enterLane(3, new Shopper(71));
    checkout.enterLane(2, new Shopper(18));
    List<Shopper> shoppers = checkout.simulateCheckout();
    assertEquals("Wrong number of shoppers", 8, shoppers.size());
    assertTrue(shoppers.get(0).getNumberOfItems() == 3);
    assertTrue(shoppers.get(1).getNumberOfItems() == 15);
    assertTrue(shoppers.get(2).getNumberOfItems() == 12);
    assertTrue(shoppers.get(3).getNumberOfItems() == 24);
    assertTrue(shoppers.get(4).getNumberOfItems() == 71);
    assertTrue(shoppers.get(5).getNumberOfItems() == 5);
    assertTrue(shoppers.get(6).getNumberOfItems() == 18);
    assertTrue(shoppers.get(7).getNumberOfItems() == 14
        );
  }
}
