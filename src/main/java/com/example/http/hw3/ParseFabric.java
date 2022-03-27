package com.example.http.hw3;

import java.util.Scanner;

public class ParseFabric {
    private static IParse parseInstance;
    private static Scanner scanner = new Scanner(System.in);

    public static IParse getParserInstance() {
        if (parseInstance == null) {
            parseInstance = new GameJSONRecord(scanner);
        }
        return parseInstance;
    }
}
