package ru.rstqa.pft.sandbox;

public class StarterClass {


  public static void main(String[] args) {
    Point p1 = new Point(2, 4);
    Point p2 = new Point(3, 9);
    System.out.println(p1.dis(p1,p2));
    System.out.println(p2.dis(p1,p2));
  }
}

  class Point {
    public double a;
    public double b;

    public Point(double a1, double b1) {
      this.a = a1;
      this.b = b1;
    }

    public double dis(Point p2) {
      return Math.sqrt((p2.a - this.a) * (p2.a - this.a) + (p2.b - this.b) * (p2.b - this.b));
    }

    public double getA() {
      return a;
    }

    public double getB() {
      return b;
    }

    @Override
    public String toString() {
      return "Point{" +
              "a=" + a +
              ", b=" + b +
              '}';
    }
  }

