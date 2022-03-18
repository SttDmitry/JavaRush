package com.example.http.hw3;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.xml.bind.annotation.*;
@JsonPropertyOrder({ "_num", "_playerId", "__text" })
@XmlType(propOrder = { "num", "playerId", "step" })
public class Step {
    @JsonProperty("_num")
    private int num;
    @JsonProperty("_playerId")
    private long playerId;
    @JsonProperty("__text")
    private String step;

    public Step() {
    }

    public Step(int num, String playerId, String step) {
        this.num = num;
        this.playerId = Long.parseLong(playerId);
        this.step = step;
    }

    public String getNum() {
        return String.valueOf(num);
    }

    @XmlAttribute
    public void setNum(String num) {
        this.num = Integer.parseInt(num);
    }

    public String getPlayerId() {
        return String.valueOf(playerId);
    }

    @XmlAttribute
    public void setPlayerId(String playerId) {
        this.playerId = Long.parseLong(playerId);
    }

    public String getStep() {
        return step;
    }

    @XmlValue
    public void setStep(String step) {
        this.step = step;
    }

    @Override
    public String toString() {
        return "Step{" +
                "num=" + num +
                ", playerId=" + playerId +
                ", step='" + step + '\'' +
                '}';
    }
}
