package com.driver;

public class Director {
    private String name;
    private int numberOfMovies;
    private double imdbRating;
    public Director (){
    }
    public Director(String name,int numberOfMovies,double imdbRating){
        this.name=name;
        this.numberOfMovies=numberOfMovies;
        this.imdbRating=imdbRating;
    }
   //setters
    public void setName(String name) {
        this.name = name;
    }
    public void setNumberOfMovies(int numberOfMovies) {
        this.numberOfMovies = numberOfMovies;
    }
    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }

    //getters
    public String getName() {
        return this.name;
    }
    public int getNumberOfMovies() {
        return this.numberOfMovies;
    }
    public double getImdbRating() {
        return this.imdbRating;
    }

}
