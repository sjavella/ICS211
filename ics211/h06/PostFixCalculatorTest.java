package edu.ics211.h06;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Represents a test of the PostFixCalculator.
 *
 * @author Cam Moore
 *
 */
public class PostFixCalculatorTest {

  /**
   * Test method for {@link edu.ics211.h06.PostFixCalculator#calculate(java.lang.String)}.
   */
  @Test
  public void testCalculate() {
    PostFixCalculator c = PostFixCalculator.getInstance();
    assertNotNull(c);
    try {
      Number ans = c.calculate("1 2 + 3 * 6 + 2 3 + /");
      assertTrue("Should be an Integer", ans instanceof Integer);
      assertEquals("Should be 3", Integer.valueOf(3), ans);
    } catch (InvalidExpressionException iee) {
      fail("Should not throw an exception.");
    }
    try {
      Number ans = c.calculate("2.2 7.0 + 3.0 *");
      assertTrue("Should be an Double", ans instanceof Double);
      assertEquals("Should be 27.6", Double.valueOf(27.6), (Double)ans, 0.0001);
    } catch (InvalidExpressionException iee) {
      fail("Should not throw an exception.");
    }
    try {
      Number ans = c.calculate("1 3 5 + -");
      assertTrue("Should be an Integer", ans instanceof Integer);
      assertEquals("Should be -7", Integer.valueOf(-7), ans);
    } catch (InvalidExpressionException iee) {
      fail("Should not throw an exception.");
    }
    try {
      Number ans = c.calculate("3 4 / 5.0 +");
      assertTrue("Should be an Double", ans instanceof Double);
      assertEquals("Should be 5.0", Double.valueOf(5.0), (Double)ans, 0.0001);
    } catch (InvalidExpressionException iee) {
      fail("Should not throw an exception.");
    }
    try {
      Number ans = c.calculate("3 4.0 / 5.0 +");
      assertTrue("Should be an Double", ans instanceof Double);
      assertEquals("Should be 5.75", Double.valueOf(5.75), (Double)ans, 0.0001);
    } catch (InvalidExpressionException iee) {
      fail("Should not throw an exception.");
    }
  }

}
