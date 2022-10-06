package com.cristobalbernal.recyclerview;

import androidx.annotation.NonNull;

public class Country {
    private String code;
    private String country;
    private String capital;
    private String population;

    public Country(String code, String country, String population, String capital) {
        this.code = code;
        this.country = country;
        this.population = population;
        this.capital = capital;
    }

    public Country(String code, String country) {
        this.code = code;
        this.country = country;
    }

    public String getCode() {

        return code;
    }

    public String getCapital() {
        return capital;
    }

    public String getPopulation() {
        return population;
    }

    public String getCountry() {
        return country;
    }

    @NonNull
    @Override
    public String toString() {
        return "Country{" +
                "country='" + country + '\'' +
                '}';
    }
}
