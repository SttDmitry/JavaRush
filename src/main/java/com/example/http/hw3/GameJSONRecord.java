package com.example.http.hw3;

import com.example.http.utils.TicTacToe;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Scanner;

import static com.example.http.utils.Functions.pathToFile;

public class GameJSONRecord implements IParse {

    private Scanner sc;
    private File[] files;
    private ObjectMapper mapper;

    {
        mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public GameJSONRecord(Scanner sc) {
        this.sc = sc;
    }

    @Override
    public void parse(GameSession game) {
        try {
            Path jsonPath = Path.of(pathToFile + "\\" + game.getName() + ".json");
            String json = mapper.writeValueAsString(game);
//            JSONObject json2 = new JSONObject(json);
            Files.write(jsonPath, Collections.singleton(json));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getRecord() {
        if (files.length == 0) {
            return;
        }
        int number = sc.nextInt()-1;
        readRecord(files[number].getName());
    }

    @Override
    public void readRecord(String name) {
        try {
            File file = Path.of(pathToFile + "\\" + name).toFile();
            GameSession game = mapper.readValue(file, GameSession.class);
            new TicTacToe(game);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getRecordsList() {
        File recordFolder = pathToFile.toFile();
        FileFilter fileFilter = pathname -> pathname.getName().endsWith(".json");
        files = recordFolder.listFiles(fileFilter);
        for (int i = 0; i < files.length; i++) {
            System.out.println(i+1 + " " + files[i]);
        }
        getRecord();
    }
}
