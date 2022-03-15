package com.example.http.hw3;

import jakarta.xml.bind.annotation.*;

public class Step {
    private int num;
    private long playerId;
    private String step;

    public Step() {
    }

    public Step(int num, long playerId, String step) {
        this.num = num;
        this.playerId = playerId;
        this.step = step;
    }

    public int getNum() {
        return num;
    }

    @XmlAttribute
    public void setNum(int num) {
        this.num = num;
    }

    public long getPlayerId() {
        return playerId;
    }

    @XmlAttribute
    public void setPlayerId(long playerId) {
        this.playerId = playerId;
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
