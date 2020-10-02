package ru.rstqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;


public class PointTest {

  @Test
  public void testDistance() {
    Point p1 = new Point(3.0,5.0);
    Point p2 = new Point(11.0,0.0);
    Assert.assertEquals(p1.distance(p2), 0.0);


  }


}
