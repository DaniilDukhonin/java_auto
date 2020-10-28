package ru.rstqa.pft.sandbox;


import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

  private static void main(String[] args) {
    //объявлена переменная массива строк
    String[] langs = {"Java", "C#", "Python", "PHP"};

//аналог инициализации массивов при помощи фиг скобок
    List<String> languages = Arrays.asList("Java", "C#", "Python", "PHP");

    for (String l : languages) {
      System.out.println("Я хочу выучить " + l);
    }

    for (int i = 0; i < languages.size(); i++) {
      System.out.println("Я хочу выучить " + languages.get(i));

    }


  }
}
