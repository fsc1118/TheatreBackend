package com.example.theatre.repository;

import com.example.theatre.entity.Movie;
import com.example.theatre.entity.MovieShowing;
import com.example.theatre.composite_keys.MovieShowingPK;
import com.example.theatre.repository.projections.MovieInstance;
import com.example.theatre.repository.projections.MovieShowingInstance;
import com.example.theatre.repository.projections.MovieShowingInstanceFilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
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

    @Procedure(procedureName = "sp_getAllShowingMovies")
    List<MovieInstance> getAllShowingMovies(Timestamp beforeDate, Timestamp afterDate);

    @Procedure(procedureName = "sp_getAllShowingMoviesWithAvail")
    List<MovieInstance> getAllShowingMoviesWithAvailableSeats(Timestamp beforeDate, Timestamp afterDate);

    @Procedure(procedureName = "sp_getMovieShowings")
    List<MovieShowingInstance> getAllMovieShowingsOfMovie(Long movieId);

    @Procedure(procedureName = "sp_getMovieShowingsWithAvail")
    List<MovieShowingInstance> getAllAvailableMovieShowingsOfMovie(Long movieId);

    @Procedure(procedureName = "sp_filterShowingMoviesByDateAndTitle")
    List<MovieShowingInstanceFilter> getFilteredMovieShowings(String month1, String month2, String title);

    @Procedure(procedureName = "sp_getMovieShowingPrice")
    Double getTicketPrice(Long movie_id, Integer room_id, String datetime);

    @Query(value = "SELECT count(*) FROM movie_showing ms " +
                        "WHERE ms.movie_id = :movieId AND ms.room_id = :roomId AND ms.show_datetime = :datetime",
            nativeQuery = true)
    int checkIfMovieShowingExists(@Param("movieId") Long movie_id,
                                  @Param("roomId") Integer room_id,
                                  @Param("datetime") Timestamp dt);

}
