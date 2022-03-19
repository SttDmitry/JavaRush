package com.example.http.hw3;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "GameResult")
public class GameResult {
    private String result;
    @JsonProperty("Player")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Player player;

    public GameResult() {
    }

    public GameResult(String result, Player player) {
        this.result = result;
        this.player = player;
    }

    public String getResult() {
        return result;
    }

    @XmlElement
    public void setResult(String result) {
        this.result = result;
    }

    public Player getPlayer() {
        return player;
    }

    @XmlElement(name = "player")
    public void setPlayer(Player player) {
        this.player = player;
    }
}
