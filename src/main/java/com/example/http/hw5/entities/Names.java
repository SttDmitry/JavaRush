package com.example.http.hw5.entities;

public class Names {
    private String name = "defaultNick1";
    private String anotherName = "defaultNick2";

    public Names() {
    }

    public Names(String name, String anotherName) {
        if (name != null && !name.isEmpty())
        this.name = name;
        if (anotherName != null && !anotherName.isEmpty())
        this.anotherName = anotherName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty())
        this.name = name;
    }

    public String getAnotherName() {
        return anotherName;
    }

    public void setAnotherName(String anotherName) {
        if (anotherName != null && !anotherName.isEmpty())
        this.anotherName = anotherName;
    }
}
