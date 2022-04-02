package com.example.http.utils;


import com.example.http.hw3.*;
import com.example.http.hw5.entities.Names;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class TicTacToe {
    private boolean isRecord;
    private static final int SIZE = 3;
    public static Scanner sc = new Scanner(System.in);
    private static final String EMPTY_CHAR = "-";
    private static final String[][] grid = new String[3][3];
    private String winnerName;

    public static GameSession getGame() {
        return game;
    }

    private static GameSession game;
    private static int counter = 1;
    private static final IParse parser = ParseFabric.getParserInstance();
    private final static Path path = Path.of(".\\winners.txt");
    private static List<String> list;
    private static List<String> listOfWebPrint = new ArrayList<>();
    private static StringBuilder sb = new StringBuilder();
    private static Random rand = new Random();


    public TicTacToe(String name, String anotherName) {
        winnersList();
        game = new GameSession(name, anotherName);
        gridInitialize();
        gridPrint();
        isRecord = false;
        gameStart();
    }

    public TicTacToe(GameSession gameSession, boolean isOnline) {
        winnersList();
        listOfWebPrint.clear();
        game = gameSession;
        isRecord = true;
        gridInitialize();
        if (!isOnline) gridPrint();
        gameStart();
    }

    public TicTacToe(Names names) {
        winnersList();
        listOfWebPrint.clear();
        game = new GameSession(names.getName(), names.getAnotherName());
        counter = 0;
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
                int winCount = Integer.parseInt(temp);
                winCount++;
                list.set(i, name + " - " + winCount);
            }
        }
        if (count == 0) {
            list.add(name + " - 1");
        }
        try {
            Files.write(path, list, StandardCharsets.UTF_8);
            parser.parse(game);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void gameStart() {
        if (!isRecord) {
            counter = 1;
            while (true) {
                if (gameTurn(game.getPlayer().get(0).getSymbol(), game.getPlayer().get(0).getName(), null)) break;
                if (gameTurn(game.getPlayer().get(1).getSymbol(), game.getPlayer().get(1).getName(), null)) break;
            }
        } else {
            for (counter = 0; counter < game.getGame().getSteps().size(); counter++) {
                if (counter % 2 == 0) {
                    gameTurn(game.getPlayer().get(0).getSymbol(), game.getPlayer().get(0).getName(), null);
                } else {
                    gameTurn(game.getPlayer().get(1).getSymbol(), game.getPlayer().get(1).getName(), null);
                }
            }
        }
        saveGame();
        System.out.println("Игра закончена");
    }

    public void saveGame() {
        if (!isRecord && winnerName != null) {
            winnerWrite(winnerName);
        } else if (!isRecord) {
            parser.parse(game);
        }
    }

    public boolean gameTurnOnline(String stepStr) {
        listOfWebPrint.clear();
        if (counter % 2 == 0) {
            return gameTurn(game.getPlayer().get(0).getSymbol(), game.getPlayer().get(0).getName(), stepStr);
        } else {
            return gameTurn(game.getPlayer().get(1).getSymbol(), game.getPlayer().get(1).getName(), stepStr);
        }
    }

    private boolean gameTurn(String firstChar, String name, String stepStr) {
        turn(firstChar, isRecord, stepStr);
        gridPrint();
        if (checkWin(firstChar)) {
            listOfWebPrint.add("Победил " + name);
            System.out.println("Победил " + name);
            winnerName = name;
            game.getGameResult().setResult("Win!");
            if (winnerName.equals(game.getPlayer().get(0).getName())) {
                game.getGameResult().setPlayer(game.getPlayer().get(0));

            } else {
                game.getGameResult().setPlayer(game.getPlayer().get(1));
            }
            if (stepStr != null) {
                saveGame();
            }
            return true;
        }
        if (isGridFull()) {
            System.out.println("Ничья");
            listOfWebPrint.add("Ничья!");
            game.getGameResult().setResult("Draw!");
            if (stepStr != null) {
                saveGame();
            }
            return true;
        }
        return false;
    }

    private void gridInitialize() {
        System.out.println(gridInitializeResult());
    }


    public String gridInitializeResult() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = EMPTY_CHAR;
            }
        }
        listOfWebPrint.add(0, game.getPlayer().get(0).getName() + ", Ваш ход будет отображаться " + game.getPlayer().get(0).getSymbol() + ",");
        listOfWebPrint.add(1, game.getPlayer().get(1).getName() + "  - " + game.getPlayer().get(1).getSymbol());
        listOfWebPrint.add(2, "Первый ход игрока - " + game.getPlayer().get(0).getName());
        gridPrintResult();
        return (listOfWebPrint.get(0) + "\n" + listOfWebPrint.get(1));
    }

    private void gridPrint() {
        System.out.println(gridPrintResult());
    }

    public String gridPrintResult() {
        sb.setLength(0);
        for (int i = 0; i < 3; i++) {
            sb.append("| ");
            for (int j = 0; j < 3; j++) {
                sb.append(grid[i][j]).append(" | ");
            }
            sb.append(" \n");
        }
        listOfWebPrint.addAll(Arrays.asList(sb.toString().split(" \n")));
        return sb.toString();
    }

    private static boolean checkWin(String c) {
        int w1 = 0;
        int w2 = 0;
        int w3 = 0;
        int w4 = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (Objects.equals(grid[i][j], c)) {
                    w1++;
                } else {
                    w1 = 0;
                }
                if (w1 == SIZE) {
                    return true;
                }

                if (Objects.equals(grid[j][i], c)) {
                    w2++;
                } else {
                    w2 = 0;
                }
                if (w2 == SIZE) {
                    return true;
                }

                if (Objects.equals(grid[i][j], c) && i == j) {
                    w3++;
                } else if (!Objects.equals(grid[i][j], c) && i == j) {
                    w3 = 0;
                }
                if (w3 == SIZE) {
                    return true;
                }

                if (Objects.equals(grid[i][j], c) && i + j == SIZE - 1) {
                    w4++;
                } else if (!Objects.equals(grid[i][j], c) && i + j == SIZE - 1) {
                    w4 = 0;
                }
                if (w4 == SIZE) {
                    return true;
                }
            }
            w1 = 0;
            w2 = 0;

        }
        return false;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        return Objects.equals(grid[y][x], EMPTY_CHAR);
    }

    public static boolean isGridFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (Objects.equals(grid[i][j], EMPTY_CHAR)) return false;
            }
        }
        return true;
    }

    public static void turn(String c, boolean isRecord, String stepStr) {
        int x, y;
        do {
            if (Objects.equals(c, game.getPlayer().get(0).getSymbol())) {
                listOfWebPrint.add("Ход игрока " + game.getPlayer().get(1).getName());
                System.out.println("Ход игрока " + game.getPlayer().get(0).getName() + " (координаты в формате X Y)");
            } else {
                listOfWebPrint.add("Ход игрока " + game.getPlayer().get(0).getName());
                System.out.println("Ход игрока " + game.getPlayer().get(1).getName() + " (координаты в формате X Y)");
            }
            if (!isRecord && stepStr == null) {
                x = sc.nextInt() - 1;
                y = sc.nextInt() - 1;
            } else if (stepStr != null) {
                String[] xy = stepStr.split(" ");
                try {
                    x = Integer.parseInt(xy[0]) - 1;
                    y = Integer.parseInt(xy[1]) - 1;
                } catch (NumberFormatException e) {
                    System.out.println(e.getLocalizedMessage());
                    int[] step = aiTurn();
                    x = step[0];
                    y = step[1];
                }
                if (!(x >= 0 && x < SIZE && y >= 0 && y < SIZE) | !isCellValid(x, y)) {
                  int[] step = aiTurn();
                  x = step[0];
                  y = step[1];
                }
            } else {
                String step = game.getGame().getSteps().get(counter).getStep();
                String[] xy = step.split(" ");
                x = Integer.parseInt(xy[0]);
                y = Integer.parseInt(xy[1]);
            }
        } while (!isCellValid(x, y));

        if (!isRecord) {
            if (counter % 2 == 0) {
                game.getGame().getSteps().add(new Step(counter++,  x + " " + y));
            } else {
                game.getGame().getSteps().add(new Step(counter++,  x + " " + y));
            }

        }
        grid[y][x] = c;
    }

    public static int[] aiTurn() {
        int[] step = new int[2];
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        step[0] = x;
        step[1] = y;
        return step;
    }

    public static List<String> getListOfWebPrint() {
        return listOfWebPrint;
    }

    public static String getGameResult(){
        if (game.getGameResult().getResult() == null) {
            return "No result!";
        }
        if (!game.getGameResult().getResult().equals("Draw!")) {
            return game.getGameResult().getPlayer().getName() + " - " + game.getGameResult().getResult();
        }
        return game.getGameResult().getResult();
    }
}
