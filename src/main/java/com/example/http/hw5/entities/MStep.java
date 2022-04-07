package com.example.http.hw5.entities;

import com.example.http.utils.AStep;

@AStep
public class MStep {
    private String stepX;
    private String stepY;

    public String getStepX() {
        return stepX;
    }

    public void setStepX(String stepX) {
        this.stepX = stepX;
    }

    public String getStepY() {
        return stepY;
    }

    public void setStepY(String stepY) {
        this.stepY = stepY;
    }

    public MStep() {
    }

    public MStep(String stepX, String stepY) {
        this.stepX = stepX;
        this.stepY = stepY;
    }

    @Override
    public String toString() {
        return "AStep{" +
                "stepX='" + stepX + '\'' +
                ", stepY='" + stepY + '\'' +
                '}';
    }
}
