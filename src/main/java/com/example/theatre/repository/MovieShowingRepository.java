package com.example.theatre.repository;

import com.example.theatre.entity.MovieShowing;
import com.example.theatre.entity.MovieShowingPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieShowingRepository extends JpaRepository<MovieShowing, MovieShowingPK> {
}
