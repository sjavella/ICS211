package edu.ics211.h01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Represents a PilsnerTest.
 *
 * @author Cam Moore
 *
 */
public class PilsnerTest {

  /**
   * Test method for {@link edu.ics211.h01.Pilsner#Pilsner(java.lang.String)}.
   */
  @Test
  public void testPilsnerString() {
    Pilsner pils = new Pilsner("My Best Pils");
    assertNotNull("Should have created a Pilsner", pils);
    assertEquals("Should have the right name", "My Best Pils", pils.getName());
    assertTrue("Should have valid ibu", pils.getIbu() > 24 && pils.getIbu() < 46);
    assertTrue("Should have valid abv", pils.getAbv() >= 4.2 && pils.getAbv() <= 6.0);
  }


  /**
   * Test method for {@link edu.ics211.h01.Pilsner#Pilsner(java.lang.String,
   *  java.lang.Integer, java.lang.Double)}.
   */
  @Test
  public void testPilsnerStringIntegerDouble() {
    Pilsner pils = new Pilsner("My Monday Pils", 35, 5.0);
    assertNotNull("Should have created a Pilsner", pils);
    assertEquals("Should have the right name", "My Monday Pils", pils.getName());
    assertTrue("Should have the right ibu", 35 == pils.getIbu());
    assertEquals("Should have the right name", 5.0, pils.getAbv(), 0.0001);
    try {
      pils = new Pilsner("Bad, Bad, Bad", 100, 5.0);
      fail("Should not create a Pilsner with that IBU");
    } catch (IllegalArgumentException iae) {
      // this should happen.
    }
    try {
      pils = new Pilsner("Bad, Bad, Bad", 35, 10.0);
      fail("Should not create a Pilsner with that ABV");
    } catch (IllegalArgumentException iae) {
      // this should happen.
    }
  }


  /**
   * Test method for {@link edu.ics211.h01.Beer#setName(java.lang.String)}.
   */
  @Test
  public void testSetName() {
    Pilsner pils = new Pilsner("My Poorly Named Pils", 35, 5.0);
    assertEquals("Should have the right name", "My Poorly Named Pils", pils.getName());
    pils.setName("Best Pils");
    assertEquals("Should have the right name", "Best Pils", pils.getName());    
  }


}
