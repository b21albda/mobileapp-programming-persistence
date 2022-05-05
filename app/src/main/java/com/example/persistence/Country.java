package com.example.persistence;

public class Country {

    private final long id;
    private String name;
    private String capital;
    private int population;

    public Country(long id, String name, String capital, int population) {
        this.id = id;
        this.name = name;
        this.capital = capital;
        this.population = population;
    }

    public long getId() {
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
