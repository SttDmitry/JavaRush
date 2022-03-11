package com.example.http.hw3;


import jakarta.xml.bind.annotation.*;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Gameplay")
public class GameSession {
    private String name;
    private List<Step> steps = new ArrayList<>();
    private List<Player> player = new ArrayList<>();
    private GameResult gameResult = new GameResult();

    public GameSession(){}

    public GameSession(String playerName1, String playerName2) {
        this.name = playerName1 + "vs." + playerName2 + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd kk-mm-ss"));
        this.player.add(new Player(1, playerName1, "X"));
        this.player.add(new Player(2, playerName2, "O"));
    }

    public String getName() {
        return name;
    }

    @XmlAttribute
    public void setName(String name) {
        this.name = name;
    }


    public List<Player> getPlayer() {
        return player;
    }

    @XmlElement(name = "Player")
    public void setPlayer(List<Player> player) {
        this.player = player;
    }

    public List<Step> getSteps() {
        return steps;
    }

    @XmlElementWrapper(name = "Game")
    @XmlElement(name = "Step")
    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public GameResult getGameResult() {
        return gameResult;
    }

    @XmlElement
    public void setGameResult(GameResult gameResult) {
        this.gameResult = gameResult;
    }
}
