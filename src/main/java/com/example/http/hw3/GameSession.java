package com.example.http.hw3;


import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class GameSession {
    private String name;
    private String playerName1, playerName2;
    private List<String> steps = new ArrayList<>();

    public GameSession(){}

    public GameSession(String playerName1, String playerName2) {
        this.name = playerName1 + "vs." + playerName2 + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd kk-mm-ss"));
        this.playerName1 = playerName1;
        this.playerName2 = playerName2;
    }

    public String getName() {
        return name;
    }

    @XmlAttribute
    public void setName(String name) {
        this.name = name;
    }

    public String getPlayerName1() {
        return playerName1;
    }

    @XmlElement
    public void setPlayerName1(String playerName1) {
        this.playerName1 = playerName1;
    }

    public String getPlayerName2() {
        return playerName2;
    }

    @XmlElement
    public void setPlayerName2(String playerName2) {
        this.playerName2 = playerName2;
    }

    public List<String> getSteps() {
        return steps;
    }

    @XmlElementWrapper(name = "steps")
    @XmlElement(name = "step")
    public void setSteps(List<String> steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        return "GameSession{" +
                "name='" + name + '\'' +
                ", playerName1='" + playerName1 + '\'' +
                ", playerName2='" + playerName2 + '\'' +
                ", steps=" + steps +
                '}';
    }
}
