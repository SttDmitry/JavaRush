package com.example.http.hw3;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import javax.persistence.*;

@XmlRootElement(name = "GameResult")
@Entity
@Table(name = "results")
public class GameResult {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "resultId")
    private Long id;

    private String result;
    @ManyToOne
    @JoinColumn(name = "id")
    @JsonProperty("Player")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Player player;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "GameResult{" +
                "id=" + id +
                ", result='" + result + '\'' +
                ", player=" + player +
                '}';
    }
}
