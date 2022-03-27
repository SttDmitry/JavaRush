package com.example.http.hw5.entities;

public class Names {
    private String name;
    private String anotherName;

    public Names() {
    }

    public Names(String name, String anotherName) {
        this.name = name;
        this.anotherName = anotherName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnotherName() {
        return anotherName;
    }

    public void setAnotherName(String anotherName) {
        this.anotherName = anotherName;
    }
}
