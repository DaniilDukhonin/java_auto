package ru.rstqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    //создали переменную somebody и дали ей значение
//    String somebody = "world";
//    System.out.println("Hello, " + somebody + "!");

    hello("user");

    //1 квадрат без создания объекта используем функцию area снизу один параметр
//    double l = 5;
//    System.out.println("Площадь квадрата со стороной " + l + " = " + area(l));

    //2 квадрат - передеать то где вызывается, нужно передать объект типа Square
//    Square s = new Square();
//    s.l = 5;
//    System.out.println("Площадь квадрата со стороной " + s.l + " = " + area(s));

    //3 оптимизация с конструктором в классе Square, заполнять параметрыне нужно
//    Square s = new Square(5);
//    //s.l = 5;
//    System.out.println("Площадь квадрата со стороной " + s.l + " = " + area(s));

    //4 оптимизация
    Square s = new Square(5);
    System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());


    //1 прямоуг без создания объекта используем функцию area снизу два параметра
//    double b = 4;
//    double a = 6;
//    System.out.println("Площадь прямоугольника со стороной" + a + b + "=" + area(a,b));

    //2 прям - передать то где вызывается, нужно передать объект типа Rectangle
//    Rectangle r = new Rectangle();
//    r.a = 4;
//    r.b = 6;
//    System.out.println("Площадь прямоугольника со стороной " + r.a  + " и " + r.b  + " = " + area(r));

    //3 оптимизация с конструктором в классе Rect, заполнять параметрыне нужно
//    Rectangle r = new Rectangle(4,6);
////    r.a = 4;
////    r.b = 6;
//    System.out.println("Площадь прямоугольника со стороной " + r.a  + " и " + r.b  + " = " + area(r));

    //4 оптимизация
    //3 оптимизация с конструктором в классе Rect, заполнять параметрыне нужно
    Rectangle r = new Rectangle(4,6);
    System.out.println("Площадь прямоугольника со стороной " + r.a  + " и " + r.b  + " = " + r.area());


  }


  //ввели функцию hello и написали что она делает
  public static void hello(String somebody) {
    //перемещаем ее отсюда в hello(String somebody)
    System.out.println("Hello, " + somebody + "!");

  }

//  //1 квадрат без создания объекта
//  public static double area(double l) {
//    return l * l;
//  }

  //2 переделываем фнукцию area чтобы она принимала не длину, а объект типа квадрат
//  public static double area(Square s) {
//    return s.l * s.l;
//  }
  //4 переносим функции в класс, удаляем отсюда

  //1 прямоуг без создания объекта
//  public static double area(double a, double b) {
//    return a * b;
//  }

  //2 переделаем для прямоуг
//  public static double area(Rectangle r) {
//    return r.a * r.b;
//  }

  //4 переносим функции внутрь класса, удаляем отсюда



}

