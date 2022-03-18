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
@XmlType(propOrder = { "player", "game", "gameResult" })
@JsonRootName("Gameplay")
public class GameSession {
    @JsonIgnore
    private String name;
    @JsonProperty("Player")
    private List<Player> player = new ArrayList<>();
    @JsonProperty("Game")
    private Game game;
    @JsonProperty("GameResult")
    private GameResult gameResult = new GameResult();

    public GameSession(){}

    public GameSession(String playerName1, String playerName2) {
        this.game = new Game();
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

    public Game getGame() {
        return game;
    }


    @XmlElement(name = "Game")
    public void setGame(Game game) {
        this.game = game;
    }

    public GameResult getGameResult() {
        return gameResult;
    }

    @XmlElement(name="GameResult")
    public void setGameResult(GameResult gameResult) {
        this.gameResult = gameResult;
    }
}
