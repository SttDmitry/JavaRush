package com.example.http.hw3;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Player")
public class Player {
    private long id;
    private String name;
    private String symbol;

    public Player() {
    }

    public Player(long id, String name, String symbol) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
    }

    public long getId() {
        return id;
    }

    @XmlAttribute
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @XmlAttribute
    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    @XmlAttribute
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", symbol=" + symbol +
                '}';
    }
}
