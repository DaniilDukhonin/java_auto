package ru.rstqa.pft.sandbox;

public class Rectangle {
  public double a;
  public double b;

  //3 добавим контсруктор
  public Rectangle(double a, double b) {
    this.a = a;
    this.b = b;
  }

  public double area() {
    return this.a * this.b;
  }

}
