package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {


    @Autowired
    MovieService movieService;
    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("success",HttpStatus.ACCEPTED);
    }
    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody() Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("success",HttpStatus.ACCEPTED);
    }
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie name") String movieName,@RequestParam("movie name") String directorName){
        if(movieService.addMovieDirectorPair(movieName,directorName)) {
            return new ResponseEntity<>("success",HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathParam("name")String name){
        return new ResponseEntity<>(movieService.getMovieByName(name),HttpStatus.ACCEPTED);
    }
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathParam("name")String name){
        return new ResponseEntity<>(movieService.getDirectorByName(name),HttpStatus.ACCEPTED);
    }
    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathParam("director") String name){
        return new ResponseEntity<>(movieService.getMoviesByDirectorName(name),HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        return new ResponseEntity<>(movieService.findAllMovies(),HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@PathParam("director’s name") String name){
        if(movieService.deleteDirectorByName(name)){
            return new ResponseEntity<>("success",HttpStatus.FOUND);
        }
        return new ResponseEntity<>("fail",HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors() {
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("success", HttpStatus.ACCEPTED);
    }
}