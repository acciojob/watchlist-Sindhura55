package com.driver;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MovieService movieService;
    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
    movieService.addMovie(movie);
    return new ResponseEntity<>("movie is been added",HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("Director has been added",HttpStatus.CREATED);
    }
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String>  addMovieDirectorPair(@RequestParam("movie")String movie,@RequestParam("diector")String director){
        movieService.movieDirectorPair(movie,director);
        return new ResponseEntity<>("Movie-director pair is added successfully",HttpStatus.CREATED);
    }
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie>  getMovieByName(@PathVariable String name){
        Movie movies=movieService.getMovie(name);
        return new ResponseEntity<>(movies,HttpStatus.CREATED);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name){
        Director directors=movieService.getDirector(name);
        return new ResponseEntity<>(directors,HttpStatus.CREATED);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>>  getMoviesByDirectorName(@PathVariable String name){
        List<String> movies=movieService.DirectorMovies(name);
        return new ResponseEntity<>(movies,HttpStatus.OK);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> All_movies=movieService.findAllMovies();
        return new ResponseEntity<>(All_movies,HttpStatus.OK);
    }
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String>  deleteDirectorByName(@RequestParam("director")String director){
        movieService.deleteDirector(director);
        return new ResponseEntity<>(director+"removed successfully",HttpStatus.CREATED);
    }
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        movieService.removeAllDirectors();
        return new ResponseEntity<>("All directors have been removed successfully",HttpStatus.CREATED);
    }





}

