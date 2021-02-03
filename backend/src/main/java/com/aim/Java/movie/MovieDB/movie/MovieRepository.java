package com.aim.Java.movie.MovieDB.movie;

import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Integer> {
    
}
