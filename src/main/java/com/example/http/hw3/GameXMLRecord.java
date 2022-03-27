package com.example.http.hw3;

import com.example.http.utils.TicTacToe;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.io.FileFilter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.example.http.utils.Functions.pathToFile;

public class GameXMLRecord implements IParse{

    private Scanner sc;
    private File[] files;
    private List<String> listOfFiles;
    private int recordNum;
    private boolean isOnline = false;

    public GameXMLRecord(Scanner sc) {
        this.sc = sc;
        listOfFiles = new ArrayList<>();
    }

    @Override
    public List<String> getRecordsList (boolean isOnline) {
        recordNum = -1;
        File recordFolder = pathToFile.toFile();
        FileFilter fileFilter = pathname -> pathname.getName().endsWith(".xml");
        files = recordFolder.listFiles(fileFilter);
        for (int i = 0; i < files.length; i++) {
            System.out.println(i+1 + " " + files[i]);
            listOfFiles.add(i+1 + " " + files[i]);
        }
        if (!isOnline) getRecord();
        return listOfFiles;
    }

    private void getRecord() {
        if (files.length == 0) {
            return;
        }
        int number;
        if (recordNum > 0 && recordNum <= files.length) {
            number = recordNum-1;
        } else {
            number = sc.nextInt()-1;
        }
        readRecord(files[number].getName());
    }

    @Override
    public void readRecord(String name) {
        try {
            File file = Path.of(pathToFile + "\\" + name).toFile();
            JAXBContext context = JAXBContext.newInstance(GameSession.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            GameSession game = (GameSession) unmarshaller.unmarshal(file);
            new TicTacToe(game, isOnline);
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void parse(GameSession game) {
        try {
            File xmlFile = Path.of(pathToFile + "\\" + game.getName() + ".xml").toFile();
            JAXBContext context = JAXBContext.newInstance(GameSession.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(game, xmlFile);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void setRecordNum(int recordNum) {
        this.recordNum = recordNum;
        isOnline = true;
        getRecord();
    }
}
