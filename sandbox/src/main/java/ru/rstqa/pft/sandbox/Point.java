package ru.rstqa.pft.sandbox;

public class Point {

  public static double a;
  public static double b;
  public static double c;
  public static double d;

  public static void main(String[] args) {
    Point p1 = new Point();
    Point p2 = new Point();

    p1.a = 1;
    p1.c = 0;
    p2.b = 2;
    p2.d = 4;


    System.out.println("расстояние между точками (" + p1.toString() + ") и (" + p2.toString1() + ") = " + dis(p1, p2));

  }

    public static double dis(Point p1, Point p2) {

      return Math.sqrt((p2.c - p1.a) * (p2.c - p1.a) + (p2.d - p1.b) * (p2.d - p1.b));

    }

    @Override
    public String toString() {
      return this.a + ";" + this.b;
    }

    public String toString1() {
      return this.c + ";" + this.d;

    }
  }

