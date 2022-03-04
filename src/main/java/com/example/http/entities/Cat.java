package com.example.http.entities;

public class Cat extends Animal{

    private static int catsCount = 0;
    private int strength;
    private int weight;
    public static void addNewCat()
    {
        catsCount++;
    }

    public static void setCatsCount(int catsCounter)
    {
        catsCount = catsCounter;
    }

    public Cat(String name) {
        super(name);
        addNewCat();
    }

    public Cat(String name, int strength) {
        super(name);
        this.strength = strength;
    }

    public Cat(String name, int strength, int weight) {
        super(name);
        this.strength = strength;
        this.weight = weight;
    }

    public static int getCatsCount() {
        return catsCount;
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    public int getStrength() {
        return strength;
    }

    public int getWeight() {
        return weight;
    }

    public Cat setStrength(int strength) {
        this.strength = strength;
        return this;
    }

    public Cat setWeight(int weight) {
        this.weight = weight;
        return this;
    }

    public boolean fightCat(Cat anotherCat) {
        return this.strength * this.weight > anotherCat.getStrength() * anotherCat.getWeight();
    }
}
