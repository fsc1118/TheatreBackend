package com.example.theatre.repository;

import com.example.theatre.entity.MovieShowing;
import com.example.theatre.composite_keys.MovieShowingPK;
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

//    Select ms.room_id, ms.show_datetime, r.num_avail_seats
//    from movie m
//    join movie_showing ms on m.movie_id = ms.movie_id
//    join room r on ms.room_id = r.room_id
//    where m.name = "Harry Potter and the Chamber of Secrets" and ms.num_avail_seats <> 0;

    @Query(value = "SELECT ms.show_datetime FROM movie m JOIN movie_showing ms ON m.movie_id = ms.movie_id WHERE m.name = :movieName",
            nativeQuery = true)
    List<Date> getAllMovieShowingsOfMovie(@Param("movieName") String movie_name);
}
