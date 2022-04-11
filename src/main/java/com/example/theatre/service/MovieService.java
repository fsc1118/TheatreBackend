package com.example.theatre.service;

import com.example.theatre.entity.Movie;
import com.example.theatre.repository.projections.MovieInstance;
import com.example.theatre.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Transactional
    public List<MovieInstance> getAllMovies() {
        return this.movieRepository.getAllMovies();
    }
}
