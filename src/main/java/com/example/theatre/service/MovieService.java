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

    @Transactional
    public MovieInstance getMovieById(Long movie_id) {
        return this.movieRepository.getMovieById(movie_id).get(0);
    }

    @Transactional
    public List<MovieInstance> getAllMovies() {
        return this.movieRepository.getAllMovies();
    }
}
