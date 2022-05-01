package com.example.theatre.repository;

import com.example.theatre.entity.Movie;
import com.example.theatre.repository.projections.MovieInstance;
import com.example.theatre.repository.projections.MovieInstanceFilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Procedure(procedureName = "sp_getAllMovies")
    List<MovieInstance> getAllMovies();

    @Procedure(procedureName = "sp_getMovieById")
    List<MovieInstance> getMovieById(Long movie_id);

    @Procedure(procedureName = "sp_getFilteredMovies")
    List<MovieInstanceFilter> getFilteredMovies(String year, String title);


}
