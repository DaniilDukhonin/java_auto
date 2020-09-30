package ru.rstqa.pft.sandbox;
//2 создаем класс с описанием структуры однотипных объектов - класс для описания квадратов
public class Square {
//квадрат описывается длиной его стороны
  public double l;

  //3 добавим контсруктор
  public Square(double l) {
    this.l = l;
  }
//4 перенесены в класс сюда
  public  double area() {
    return this.l * this.l;
  }


}
