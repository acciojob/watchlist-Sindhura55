package com.driver;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class MovieService {

    @Autowired
    MovieRepository movieRepository;
    public void addMovie(Movie movie) {
        movieRepository.storeMovie(movie);
    }
    public  void addDirector(Director director){
        movieRepository.storeDirector(director);
    }
    public void  movieDirectorPair(String movie,String director){
        movieRepository.saveMovieDirectorPair(movie,director);
    }
    public Movie getMovie(String name){
        movieRepository.findMovie(name);
    }
    public Director getDirector(String name){
        movieRepository.findDirector(name);
    }
    public List<String> directorMovies(String name){
        movieRepository.findDirectorMovies(name);
    }
    public Movie findAllMovies(){
        movieRepository.findAllMovies();
    }
    public void deleteDirector(String director){
      movieRepository.deletingDirector(director);
    }
    public void removeAllDirectors(){
        movieRepository.removingAllDirectors();
    }
}
