package com.example.theatre.repository;

import com.example.theatre.entity.Movie;
import com.example.theatre.entity.MovieShowing;
import com.example.theatre.entity.MovieShowingPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MovieShowingRepository extends JpaRepository<MovieShowing, MovieShowingPK> {

    @Query(value = "SELECT DISTINCT m.name FROM movie m JOIN movie_showing ms ON m.movie_id = ms.movie_id",
            nativeQuery = true)
    List<String> getAllShowingMovies();

    @Query(value = "SELECT ms.show_datetime FROM movie m JOIN movie_showing ms ON m.movie_id = ms.movie_id WHERE m.name = :movieName",
            nativeQuery = true)
    List<Date> getAllMovieShowingsOfMovie(@Param("movieName") String movie_name);
}
