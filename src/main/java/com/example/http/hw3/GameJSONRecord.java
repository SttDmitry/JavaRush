package com.example.http.hw3;

import com.example.http.utils.TicTacToe;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static com.example.http.utils.Functions.pathToFile;

public class GameJSONRecord implements IParse {

    private Scanner sc;
    private File[] files;
    private ObjectMapper mapper;
    private List<String> listOfFiles;
    private int recordNum;
    private boolean isOnline = false;

    {
        mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public GameJSONRecord(Scanner sc) {
        this.sc = sc;
        listOfFiles = new ArrayList<>();
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

    private void getRecord() throws IllegalArgumentException{
        if (files.length == 0) {
            return;
        }
        int number;
        if (recordNum > 0 && recordNum <= files.length) {
            number = recordNum-1;
        } else if (isOnline) {
            throw new IllegalArgumentException("Index " + recordNum + " out of bounds!");
        }  else {
            number = sc.nextInt()-1;
        }
        readRecord(files[number].getName());
    }

    @Override
    public void readRecord(String name) {
        try {
            File file = Path.of(pathToFile + "\\" + name).toFile();
            GameSession game = mapper.readValue(file, GameSession.class);
            readRecord(game);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> getRecordsList(boolean isOnline) {
        recordNum = -1;
        listOfFiles.clear();
        File recordFolder = pathToFile.toFile();
        FileFilter fileFilter = pathname -> pathname.getName().endsWith(".json");
        files = recordFolder.listFiles(fileFilter);
        for (int i = 0; i < files.length; i++) {
            System.out.println(i+1 + " " + files[i]);
            listOfFiles.add(i+1 + " " + files[i]);
        }
        if (!isOnline) getRecord();
        return listOfFiles;
    }

    public void setRecordNum(int recordNum) {
        this.recordNum = recordNum;
        isOnline = true;
        getRecord();
    }

    @Override
    public void readRecord(GameSession session) {
        new TicTacToe(session, true);
    }
}
