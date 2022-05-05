package com.example.persistence;

public class Country {

    private final int id;
    private String name;
    private String capital;
    private int population;

    public Country(int id, String name, String capital, int population) {
        this.id = id;
        this.name = name;
        this.capital = capital;
        this.population = population;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public int getPopulation() {
        return population;
    }
}
