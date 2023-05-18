package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MovieRepository {

    HashMap<String,Movie> movieData=new HashMap<>();
    HashMap<String,Director> directorData=new HashMap<>();
    HashMap<String, List<String>> directorMovieMap=new HashMap<>();
    public void storeMovie(Movie movie){
        movieData.put(movie.getMovieName(),movie);
    }
    public void storeDirector(Director director){
        directorData.put(director.getName(),director);
    }
    public void saveMovieDirectorPair(String movie,String director) {
        if (movieData.containsKey(movie) && directorData.containsKey(director)) {
            List<String> currList = new ArrayList<>();
            if (directorMovieMap.containsKey(director))
                currList = directorMovieMap.get(director);
            currList.add(movie);
            directorMovieMap.put(director, currList);
        }
    }
    public Movie findMovie(String name){
      return movieData.get(name);
    }
    public Director findDirector(String name){
        return directorData.get(name);
    }
    public List<String> findDirectorMovies(String director_name){
        return directorMovieMap.get(director_name);
    }
    public List<String> findAllMovies(){
        return new ArrayList<>(movieData.keySet());

    }
    public void deletingDirector(String director){
        List<String> movies=new ArrayList<>();
        if(directorMovieMap.containsKey(director)){
               movies = directorMovieMap.get(director);
            for(String movie:movies){
                if(movieData.containsKey(movie)){
                    movieData.remove(movie);
                }
            }
            directorMovieMap.remove(director);
        }
        if(directorData.containsKey(director)){
            directorData.remove(director);
        }
    }
    public void removingAllDirectors(){
        HashSet<String> set=new HashSet<>();
        for(String director: directorMovieMap.keySet()){
            for(String movie:directorMovieMap.get(director)){
                set.add(movie);
            }
            directorMovieMap.remove(director);
        }
        for(String movie:set){
            if(movieData.containsKey(movie)) {
                movieData.remove(movie);
            }
        }

    }

}
