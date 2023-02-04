package com.driver;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.*;

@Repository
public class MovieRepository {
    Map<String,Movie> movies;
    Map<String,Director> directors;
    Map<String,List<String>> pair;
    List<String> movieToDirector = new ArrayList<>();
    public MovieRepository(){
        this.movies = new HashMap<String,Movie>();
        this.directors = new HashMap<String,Director>();
        this.pair = new HashMap<String,List<String>>();
    }
    public void addMovie(Movie movie){
        movies.put(movie.getName(),movie);
    }
    public void addDirector(Director director){
        directors.put(director.getName(),director);
    }
    public void addPair(String movieName,String directorName){
        List<String> movieNames = pair.getOrDefault(directorName,new ArrayList<>());
        movieNames.add(movieName);
        pair.put(directorName,movieNames);
        movieToDirector.add(movieName);
    }

    public void deleteAllDirectors() {
        for(String str:movieToDirector){
            movies.remove(str);
        }
        this.directors=null;
        this.movieToDirector=null;
        this.pair=null;
    }
}
