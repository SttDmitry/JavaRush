package com.example.http.hw3;


import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.xml.bind.annotation.*;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Gameplay")
@XmlType(propOrder = { "player", "steps", "gameResult" })
@JsonRootName("Gameplay")
public class GameSession {
    @JsonIgnore
    private String name;
    @JsonProperty("Player")
    private List<Player> player = new ArrayList<>();
    @JsonProperty("Game")
    private List<Step> steps = new ArrayList<>();
    @JsonProperty("GameResult")
    private GameResult gameResult = new GameResult();

    public GameSession(){}

    public GameSession(String playerName1, String playerName2) {
        this.name = playerName1 + "vs." + playerName2 + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd kk-mm-ss"));
        this.player.add(new Player(0, playerName1, "X"));
        this.player.add(new Player(1, playerName2, "O"));
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

    @XmlElement(name="GameResult")
    public void setGameResult(GameResult gameResult) {
        this.gameResult = gameResult;
    }
}
