package com.example.http.entities;

public class Dog extends Animal{
    private int age;
    public Dog (String name) {
        super(name);
    }

    public Dog(String name, int age) {
        super(name);
        this.age = age;
    }
}
