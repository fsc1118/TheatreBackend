package com.example.theatre.repository;

import com.example.theatre.entity.Movie;
import com.example.theatre.repository.projections.MovieInstance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Procedure(procedureName = "sp_getAllMovies")
    List<MovieInstance> getAllMovies();
}
