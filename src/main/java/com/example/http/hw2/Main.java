package com.example.http.hw2;

import com.example.http.entities.Cat;
import com.example.http.utils.Functions;
import com.example.http.utils.TicTacToe;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Cat cat1 = new Cat("cat1");
        Cat cat2 = new Cat("cat2");
        System.out.println(Cat.getCatsCount());
        ArrayList<Integer> values = new ArrayList<>();
        values.add(1);
        values.add(2);
        values.add(3);
        Functions.sortedPrintArray(values);

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String anotherName = scanner.nextLine();
        Functions.namesEqualsCheck(name, anotherName);

        String ageTemp = scanner.nextLine();
        Integer age = 0;
        while (ageTemp.isBlank()) {
            System.out.println("Напишите возраст!");
            ageTemp = scanner.nextLine();
        }
        age = Integer.valueOf(ageTemp);

        if (age < 18) {
            System.out.println("Подрасти");
        } else if (age > 20) {
            System.out.println("И 18-ти достаточно");
        }

        int i = 10;
        while (i != 0) {
            System.out.print(i-- + " ");
        }
        System.out.println();
        while (i != 11) {
            System.out.print(i++ + " ");
        }
        System.out.println();

        while (i != 1) {
            for (int j = 0; j < 10; j++ ) {
                System.out.print("s");
            }
            System.out.println();
            i--;
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j <= 100; j++) {
            if (j%2==0) {
                sb.append(j).append(" ");
            }
        }
        System.out.println(sb);

        System.out.println(new Cat("Cat1").setStrength(1).setWeight(2)
                .fightCat(new Cat("Cat2").setStrength(2).setWeight(3)));

        System.out.println("-----------------------Доп. задание:");

        System.out.println("Введите ник первого игрока: ");
        String nickName1 = scanner.nextLine();

        System.out.println("Введите ник второго игрока: ");
        String nickName2 = scanner.nextLine();

        TicTacToe ticTacToe = new TicTacToe(nickName1, nickName2);


    }
}
