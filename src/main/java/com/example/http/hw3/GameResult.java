package com.example.http.hw3;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "GameResult")
public class GameResult {
    private String result;
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

    @XmlAttribute
    public void setResult(String result) {
        this.result = result;
    }

    public Player getPlayer() {
        return player;
    }

    @XmlElement
    public void setPlayer(Player player) {
        this.player = player;
    }
}