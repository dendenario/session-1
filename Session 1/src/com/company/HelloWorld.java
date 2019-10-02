package com.company;

import java.io.*;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        if(!MakeSetup(args));
        {
            return;
        }
    }
    public static boolean MakeSetup(String[] args)
    {
        if(propertySearch(args))
        {
            return true;
        }
        if(propertySearch(System.getProperties()))
        {
            return true;
        }
        if(propertySearch(System.getenv()))
        {
            return true;
        }
            System.out.println("Настройки не заданы");
            System.out.println();
            System.out.println("Варианты задания настроек:");
            System.out.println("1. Передайте аргументом настройку вида JSCHOOl1_COUNT=XXX, где XXX - желаемое количество выводов сообщения.");
            System.out.println("2. Передайте системную настройку вида JSCHOOl1_COUNT=XXX, где XXX - желаемое количество выводов сообщения.");
            System.out.println("3. Определите переменную окружения вида JSCHOOl1_COUNT=XXX, где XXX - желаемое количество выводов сообщения.");
            System.out.println("4. Определите переменную окружения вида JSCHOOL1_PROPERTIES_FILE=XXX, где XXX это путь к существующему файлу, в котором записано желаемое число выводов.");
        return false;
    }

    public static boolean propertySearch(String[] args)
    {
        boolean isFound = false;
        for (String s : args) {
            if (s.matches("JSCHOOl1_COUNT=\\d*")) {
                int count = Integer.parseInt(s.split("=")[1]);
                for (int i = 0; i < count; i++) {
                    System.out.println("Hello World!");
                }
                isFound = true;
            }
        }
        return isFound;
    }

    public static boolean propertySearch(Properties properties)
    {
        boolean isFound = false;
            if (properties.containsKey("JSCHOOl1_COUNT")) {
                int count = Integer.parseInt(properties.getProperty("JSCHOOl1_COUNT"));
                for (int i = 0; i < count; i++) {
                    System.out.println("Hello World!");
                }
                isFound = true;
            }
        return isFound;
    }

    public static boolean propertySearch(Map<String,String> map) {
        boolean isFound=false;
            if (map.containsKey("JSCHOOl1_COUNT")) {
                int count = Integer.parseInt(map.get("JSCHOOl1_COUNT"));
                for (int i = 0; i < count; i++) {
                    System.out.println("Hello World!");
                }
                isFound = true;
            } else if (System.getenv().containsKey("JSCHOOL1_PROPERTIES_FILE")) {
                String path = System.getenv().get("JSCHOOL1_PROPERTIES_FILE");
                try (FileReader fileReader = new FileReader(path)) {
                    Scanner scanner = new Scanner(fileReader);
                    int count = scanner.nextInt();
                    for (int i = 0; i < count; i++) {
                        System.out.println("Hello World!");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                isFound = true;
            }
        return isFound;
    }

}
