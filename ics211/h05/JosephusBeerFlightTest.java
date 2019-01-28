package edu.ics211.h05;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import edu.ics211.h01.Beer;
import edu.ics211.h01.IBrewery;
import edu.ics211.h01.ManoaBrewing;

import java.util.LinkedList;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

/**
 * Represents a JosephusBeerFlightTest.
 *
 * @author Cam Moore
 *
 */
public class JosephusBeerFlightTest {

  private ManoaBrewing brewery;
  private Beer[] flight = new Beer[7];

  /**
   * @throws Exception if there is a problem.
   */
  @Before
  public void setUp() throws Exception {
    brewery = ManoaBrewing.getInstance();
    for (int i = 0; i < flight.length; i++) {
      flight[i] = brewery.brewBeer("Beer" + i, randomBeerType());
    }
  }



  /**
   * Tests the tasteBeers method.
   */
  @Test
  public void testTastBeers() {
    JosephusBeerFlight beerFlight = new JosephusBeerFlight(flight);
    LinkedList<Beer> tasting = beerFlight.tasteBeers(1, 3, true);
    assertTrue(tasting.size() == flight.length);
    assertEquals(tasting.get(0), flight[2]);
    assertEquals(tasting.get(1), flight[5]);
    assertEquals(tasting.get(2), flight[1]);
    assertEquals(tasting.get(3), flight[6]);
    assertEquals(tasting.get(4), flight[4]);
    assertEquals(tasting.get(5), flight[0]);
    assertEquals(tasting.get(6), flight[3]);
    tasting = beerFlight.tasteBeers(4, 2, false);
    assertTrue(tasting.size() == flight.length);
    assertEquals(tasting.get(0), flight[1]);
    assertEquals(tasting.get(1), flight[6]);
    assertEquals(tasting.get(2), flight[4]);
    assertEquals(tasting.get(3), flight[2]);
    assertEquals(tasting.get(4), flight[5]);
    assertEquals(tasting.get(5), flight[0]);
    assertEquals(tasting.get(6), flight[3]);
    tasting = beerFlight.tasteBeers(1, 1, false);
    assertTrue(tasting.size() == flight.length);
    assertEquals(tasting.get(0), flight[6]);
    assertEquals(tasting.get(1), flight[5]);
    assertEquals(tasting.get(2), flight[4]);
    assertEquals(tasting.get(3), flight[3]);
    assertEquals(tasting.get(4), flight[2]);
    assertEquals(tasting.get(5), flight[1]);
    assertEquals(tasting.get(6), flight[0]);
  }

  /**
   * Returns a random beer type.
   * @return A random beer type.
   */
  private String randomBeerType() {
    Random r = new Random();
    int val = r.nextInt(3);
    switch (val) {
      case 0:
        return IBrewery.PILSNER;
      case 1:
        return IBrewery.BOHEMIAN_PILSNER;
      case 2:
        return IBrewery.INDIA_PALE_ALE;
      default:
        return IBrewery.INDIA_PALE_ALE;
    }
  }

}
