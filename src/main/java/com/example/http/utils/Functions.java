package com.example.http.utils;

import java.nio.file.Path;
import java.util.ArrayList;

public class Functions {

    public static Path pathToXML = Path.of(".\\src\\main\\resources");

    public static int maxFromArray(ArrayList<Integer> values){
        Integer max = Integer.MIN_VALUE;
        for(int i=0; i<values.size(); i++){
            if (max < values.get(i)) max = values.get(i);
        }
        return max;
    }
    public static void sortedPrintArray(ArrayList<Integer> values) {
        while (values.size() > 0) {
            Integer temp = maxFromArray(values);
            System.out.print(temp + " ");
            values.remove(temp);
        }
        System.out.println("");
    }
    public static void namesEqualsCheck(String name, String anotherName) {
        if (name.equals(anotherName)) {
            System.out.println("Имена одинаковы!");
        } else if (name.length() == anotherName.length()) {
            System.out.println("Длины имен одинаковы!");
        } else {
            System.out.println("Имена различны!");
        }
    }
}
