package com.example.http.hw3;

import java.util.Scanner;

public class ParseFabric {
    private static IParse parseClass;
    private static Scanner scanner = new Scanner(System.in);

    public static IParse getParser() {
        if (parseClass == null) {
            parseClass = new GameJSONRecord(scanner);
            return parseClass;
        }
        return parseClass;
    }
}
