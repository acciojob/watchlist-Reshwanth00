package com.driver;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.*;

@Repository
public class MovieRepository {
    Map<String,Movie> movies;
    Map<String,Director> directors;
    Map<String,String> pair;
    public MovieRepository(){
        this.movies = new HashMap<String,Movie>();
        this.directors = new HashMap<String,Director>();
        this.pair = new HashMap<String,String>();
    }
}
