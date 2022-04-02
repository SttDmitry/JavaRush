package com.example.http.hw5.entities;

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
        return "MStep{" +
                "stepX='" + stepX + '\'' +
                ", stepY='" + stepY + '\'' +
                '}';
    }
}
