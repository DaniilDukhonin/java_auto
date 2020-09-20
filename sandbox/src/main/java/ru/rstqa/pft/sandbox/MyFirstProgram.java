package ru.rstqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Danya");

    Square s = new Square(5);
    //s.l = 5;
    //double l = 5;
    System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(4, 6);
//    r.a = 4;
//    r.b = 6;
//    double a = 4;
//    double b = 6;
    System.out.println("Площадь прямоугольника " + r.a + " и " + r.b + " = " + r.area());
  }


  public static void hello(String somebody) {

    System.out.println("Hello, " + somebody + "!");
  }


  public static double area(Rectangle r) {
    return r.a * r.b;
  }
}