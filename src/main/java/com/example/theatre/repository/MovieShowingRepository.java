package com.example.theatre.repository;

import com.example.theatre.entity.MovieShowing;
import com.example.theatre.composite_keys.MovieShowingPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * Movie showing repository with sql queries to access movie_showing database.
 *
 * @author Min Lu
 */

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

    @Query(value = "SELECT ms.show_datetime FROM movie m " +
                        "JOIN movie_showing ms ON m.movie_id = ms.movie_id " +
                        "WHERE m.name = :movieName",
            nativeQuery = true)
    List<Timestamp> getAllMovieShowingsOfMovie(@Param("movieName") String movie_name);

    @Query(value = "SELECT count(*) FROM movie_showing ms " +
                        "WHERE ms.movie_id = :movieId AND ms.room_id = :roomId AND ms.show_datetime = :datetime",
            nativeQuery = true)
    int checkIfMovieShowingExists(@Param("movieId") Long movie_id, @Param("roomId") Integer room_id, @Param("datetime") Timestamp dt);

    @Query(value = "SELECT m.name FROM movie m " +
                        "JOIN movie_showing ms ON m.movie_id = ms.movie_id " +
                        "WHERE ms.show_datetime > :date",
            nativeQuery = true)
    List<String> getAllShowingMoviesAfterDate(@Param("date") Timestamp date);

    @Query(value = "SELECT m.name FROM movie m " +
            "JOIN movie_showing ms ON m.movie_id = ms.movie_id " +
            "WHERE ms.show_datetime < :date",
            nativeQuery = true)
    List<String> getAllShowingMoviesBeforeDate(@Param("date") Timestamp date);

    @Query(value = "SELECT m.name FROM movie m " +
                        "JOIN movie_showing ms ON m.movie_id = ms.movie_id " +
                        "WHERE ms.show_datetime BETWEEN :firstDate AND :secondDate",
            nativeQuery = true)
    List<String> getAllShowingMoviesBetweenDate1AndDate2(@Param("firstDate") Timestamp date1, @Param("secondDate") Timestamp date2);
}
