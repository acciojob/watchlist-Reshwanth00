package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public void addMovie(Movie movie){
        movieRepository.movies.put(movie.getName(), movie);
    }
    public void addDirector(Director director){
        movieRepository.directors.put(director.getName(), director);
    }
    public boolean addMovieDirectorPair(String movieName,String directorName){
        if(movieRepository.directors.containsKey(directorName) && movieRepository.movies.containsKey(movieName)){
            movieRepository.pair.put(movieName,directorName);
            return true;
        }
        return false;
    }
    public Movie getMovieByName(String name){
        return movieRepository.movies.containsKey(name)?movieRepository.movies.get(name):null;
    }
    public Director getDirectorByName(String name){
        return movieRepository.directors.containsKey(name)?movieRepository.directors.get(name):null;
    }
    public ArrayList<String> getMoviesByDirectorName(String name){
        ArrayList<String> list = new ArrayList<>();
        list.add(movieRepository.pair.get(name));
        return list;
    }
    public ArrayList<String> findAllMovies(){
        ArrayList<String> list = new ArrayList<>();
        for(Map.Entry<String,Movie> itr: movieRepository.movies.entrySet()){
            list.add(itr.getKey());
        }
        return list;
    }
    public boolean deleteDirectorByName(String name){
        for(Map.Entry<String,String> itr:movieRepository.pair.entrySet()){
            if(itr.getValue().equals(name)){
                return true;
            }
        }
        return false;
    }
    public void deleteAllDirectors(){
        for(Map.Entry<String,String> itr:movieRepository.pair.entrySet()){
            if(itr.getValue()!=null){
                movieRepository.pair.remove(itr.getKey());
            }
        }
    }

}
