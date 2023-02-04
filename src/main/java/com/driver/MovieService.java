package com.driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public void addMovie(Movie movie){
        movieRepository.addMovie(movie);
    }
    public void addDirector(Director director){
        movieRepository.addDirector(director);
    }
    public void addMovieDirectorPair(String movieName,String directorName){
        movieRepository.addPair(movieName,directorName);
    }
    public Movie getMovieByName(String name){
        return movieRepository.movies.containsKey(name)?movieRepository.movies.get(name):null;
    }
    public Director getDirectorByName(String name){
        return movieRepository.directors.containsKey(name)?movieRepository.directors.get(name):null;
    }
    public List<String> getMoviesByDirectorName(String name){
        return movieRepository.pair.get(name);
    }
    public List<String> findAllMovies(){
        List<String> list = new ArrayList<>();
        for(Map.Entry<String,Movie> itr: movieRepository.movies.entrySet()){
            list.add(itr.getKey());
        }
        return list;
    }
    public void deleteDirectorByName(String name){
        List<String> movieNames = movieRepository.pair.get(name);
        for(String str:movieNames){
            movieRepository.movies.remove(str);
        }
        movieRepository.pair.remove(name);
        movieRepository.directors.remove(name);
    }
    public void deleteAllDirectors(){
        movieRepository.deleteAllDirectors();
    }

}
