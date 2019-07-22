package com.example.countrybackend.domain;

public class Country {

    private static Integer nextId = 0;

    private Integer id;
    private String name;
    private Integer population;
    private String capital;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public static Country fromName(final String name) {
        final Country country = new Country();
        country.setName(name);
        country.setId(Country.nextId++);
        return country;
    }
}
