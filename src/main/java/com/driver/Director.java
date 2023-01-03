package com.driver;

public class Director {
    private String name;
    private int numberOfMovies;
    private double imdbRating;
    public Director(){

    }
    public Director(String name, int numberOfMovies, double imdbRating){
        this.imdbRating=imdbRating;
        this.name=name;
        this.numberOfMovies=numberOfMovies;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfMovies() {
        return numberOfMovies;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfMovies(int numberOfMovies) {
        this.numberOfMovies = numberOfMovies;
    }
}



//    Director.java Class - String name, int numberOfMovies, double imdbRating, no-args constructor, all-args
//    constructor and getters-setters