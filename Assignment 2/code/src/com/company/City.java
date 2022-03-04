package com.company;

public class City {

    private int population;
    private int totalBuildings;

    public City(int population, int totalBuildings) {
        setPopulation(population);
        setTotalBuildings(totalBuildings);
    }

    //Setters
    public void setPopulation(int pop) {this.population = pop;}
    public void setTotalBuildings(int buildings) {this.totalBuildings = buildings;}

}
