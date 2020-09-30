package ru.rstqa.pft.sandbox;

public class StarterClass {


  public static void main(String[] args) {
    Point p1 = new Point(7, 12);
    Point p2 = new Point(-2, 1);
    System.out.println(p1.distance(p2));
    System.out.println(p2.distance(p1));
  }



}


