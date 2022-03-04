package com.example.http.utils;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {
    private static String name;
    private static String anotherName;
    private static final int SIZE = 3;
    public static Scanner sc = new Scanner(System.in);
    private static final char EMPTY_CHAR = '-';
    private static final char FIRST_CHAR = 'X';
    private static final char SECOND_CHAR = 'O';
    private static final char[][] grid = new char [3][3];
    private String winnerName;

    private final static Path path = Path.of(".\\winners.txt");
    private static List<String> list;


    public TicTacToe (String name, String anotherName) {
        winnersList();
        TicTacToe.name = name;
        TicTacToe.anotherName = anotherName;
        gridInitialize();
        gridPrint();
        gameStart();
    }

    private void winnersList() {
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            getWinnersList();
        }
    }

    private void getWinnersList() {
        try {
            list = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void winnerWrite(String name) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains(name)) {
                count++;
                String temp = list.get(i).substring(list.get(i).lastIndexOf("-") + 2);
                System.out.println("Ваши победы: " + temp);
                Integer winCount = Integer.parseInt(temp);
                winCount++;
                list.set(i, name + " - " + winCount);
            }
        }
        if (count == 0) {
            list.add(name + " - 1");
        }
        try {
            Files.write(path, list, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void gameStart() {
        while (true) {
            if (gameTurn(FIRST_CHAR, name)) break;
            if (gameTurn(SECOND_CHAR, anotherName)) break;
        }
        winnerWrite(winnerName);
        System.out.println("Игра закончена");
    }

    private boolean gameTurn(char firstChar, String name) {
        turn(firstChar);
        gridPrint();
        if (checkWin(firstChar)) {
            System.out.println("Победил " + name);
            winnerName = name;
            return true;
        }
        if (isGridFull()) {
            System.out.println("Ничья");
            return true;
        }
        return false;
    }

    private void gridInitialize(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                grid[i][j]= EMPTY_CHAR;
            }
        }
        System.out.println(name + ", Ваш ход будет отображаться " + FIRST_CHAR + ", \n" + anotherName + "  - " + SECOND_CHAR);
    }

    private void gridPrint(){
        for(int i=0;i<3;i++){
            StringBuilder sb = new StringBuilder("| ");
            for(int j=0;j<3;j++){
                sb.append(grid[i][j]).append(" | ");
            }
            System.out.println(sb);
        }
    }

    private static boolean checkWin(char c){
        int w1 = 0;
        int w2 = 0;
        int w3 = 0;
        int w4 = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j]==c) {
                    w1++;
                } else {
                    w1=0;
                }
                if (w1==SIZE) {
                    return true;
                }

                if (grid[j][i]==c) {
                    w2++;
                } else {
                    w2=0;
                }
                if (w2==SIZE) {
                    return true;
                }

                if (grid[i][j]==c && i==j) {
                    w3++;
                } else if (grid[i][j]!=c && i==j) {
                    w3=0;
                }
                if (w3==SIZE) {
                    return true;
                }

                if (grid[i][j]==c && i+j== SIZE -1) {
                    w4++;
                } else if (grid[i][j]!=c && i+j== SIZE -1){
                    w4=0;
                }
                if (w4==SIZE) {
                    return true;
                }
            }
            w1=0;
            w2=0;

        }
        return false;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= 3 || y < 0 || y >= 3) return false;
        return grid[y][x] == EMPTY_CHAR;
    }

    public static boolean isGridFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j] == EMPTY_CHAR) return false;
            }
        }
        return true;
    }

    public static void turn(char c) {
        int x, y;
        do {
            if (c == FIRST_CHAR) {
                System.out.println("Ход игрока " + name + " (координаты в формате X Y)");
            } else {
                System.out.println("Ход игрока " + anotherName + " (координаты в формате X Y)");
            }
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        grid[y][x] = c;
    }


}
