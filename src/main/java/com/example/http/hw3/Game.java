package com.example.http.hw3;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Game {
    @JsonProperty("Step")
    private List<Step> steps = new ArrayList<>();

    public Game() {
    }

    public Game(List<Step> steps) {
        this.steps = steps;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }
}
