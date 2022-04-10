package com.example.theatre.service;

import com.example.theatre.entity.Movie;
import com.example.theatre.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public MovieService(MovieRepository moviesRepository) {
        this.movieRepository = moviesRepository;
    }

    public void insertNewMovie(String movie_name) {
        Movie newMovies = new Movie(movie_name);
        this.movieRepository.save(newMovies);
    }
}
