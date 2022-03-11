package com.example.http.hw3;

import com.example.http.utils.TicTacToe;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.io.FileFilter;
import java.nio.file.Path;
import java.util.Scanner;

public class GameRecord {

    private final static Path pathToXML = Path.of(".\\src\\main\\resources");
    private Scanner sc;
    private File[] files;

    public GameRecord(Scanner sc) {
        this.sc = sc;
    }

    public void getRecordsList () {
        File recordFolder = pathToXML.toFile();
        FileFilter fileFilter = pathname -> pathname.getName().endsWith(".xml");
        files = recordFolder.listFiles(fileFilter);
        for (int i = 0; i < files.length; i++) {
            System.out.println(i+1 + " " + files[i]);
        }
        getRecord();
    }

    private void getRecord() {
        if (files.length == 0) {
            return;
        }
        int number = sc.nextInt()-1;
        readRecord(files[number].getName());
    }

    private void readRecord (String name) {
        try {
            File file = Path.of(pathToXML + "\\" + name).toFile();
            JAXBContext context = JAXBContext.newInstance(GameSession.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            GameSession game = (GameSession) unmarshaller.unmarshal(file);
            new TicTacToe(game);
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
    }
}
