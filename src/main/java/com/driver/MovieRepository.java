package com.driver;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.*;

@Repository
public class MovieRepository {
    Map<String,Movie> movies = new HashMap<String,Movie>();
    Map<String,Director> directors = new HashMap<String,Director>();
    Map<String,String> pair = new HashMap<String,String>();

}
