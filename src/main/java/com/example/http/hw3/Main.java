package com.example.http.hw3;

import com.example.http.entities.Cat;
import com.example.http.utils.TicTacToe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Cat cat;
        for (int i = 0; i < 50000; i++) {
            cat = new Cat("cat" + i);
        }
        System.out.println(Cat.getCatsCount());

        Scanner scanner = new Scanner(System.in);

        String choice;

        GameRecord gameRecord = new GameRecord(scanner);

        do {
            System.out.println("Введите \"start\" чтобы начать игру, \"records\" - для просмотра списка записей," +
                    " \"end\" - для выхода из программы");
            choice = scanner.nextLine();
            if (choice.equals("start")) {
                System.out.println("Введите ник первого игрока: ");
                String nickName1 = scanner.nextLine();

                System.out.println("Введите ник второго игрока: ");
                String nickName2 = scanner.nextLine();

                TicTacToe ticTacToe = new TicTacToe(nickName1, nickName2);
            } else if (choice.equals("records")) {
               gameRecord.getRecordsList();
            }
        } while (!choice.equals("end"));
    }
}
