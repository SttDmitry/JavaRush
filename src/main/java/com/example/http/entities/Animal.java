package com.example.http.entities;

public class Animal {
    private String name;
    private Man owner;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return "My name is " + name + "!\n";
    }

    public Man getOwner() {
        return owner;
    }

    public void setOwner(Man owner) {
        this.owner = owner;
    }

    public void setName(String name) {
        this.name = name;
    }
}
