package com.example.theatre.service;

import com.example.theatre.entity.MovieShowing;
import com.example.theatre.repository.MovieRepository;
import com.example.theatre.repository.MovieShowingRepository;
import com.example.theatre.repository.RoomRepository;
import com.example.theatre.repository.projections.MovieInstance;
import com.example.theatre.repository.projections.MovieShowingInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Movie showing service to retrieve all currently showing movies.
 *
 * @author Min Lu
 */

@Service
public class MovieShowingService {
    @Autowired
    private MovieShowingRepository movieShowingRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private RoomRepository roomRepository;

    public MovieShowingService(MovieShowingRepository movieShowingRepository,
                               MovieRepository movieRepository,
                               RoomRepository roomRepository) {
        this.movieShowingRepository = movieShowingRepository;
        this.movieRepository = movieRepository;
        this.roomRepository = roomRepository;
    }

    private final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private Timestamp parseTimestamp(String timestamp) {
        try {
            return new Timestamp(DATE_TIME_FORMAT.parse(timestamp).getTime());
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public List<MovieInstance> getAllShowingMovies() {
        return this.movieShowingRepository.getAllShowingMovies(null, null);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public List<MovieInstance> getAllShowingMoviesBetweenDates(String date1, String date2) {
        return this.movieShowingRepository.getAllShowingMovies(
                parseTimestamp(date1),
                parseTimestamp(date2)
        );
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public List<MovieInstance> getAllShowingMoviesBeforeDate(String date) {
        return this.movieShowingRepository.getAllShowingMovies(parseTimestamp(date), null);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public List<MovieInstance> getAllShowingMoviesAfterDate(String date) {
        return this.movieShowingRepository.getAllShowingMovies(null, parseTimestamp(date));
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public List<MovieInstance> getAllShowingMoviesWithAvailSeats() {
        return this.movieShowingRepository.getAllShowingMoviesWithAvailableSeats(null, null);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public List<MovieInstance> getAllShowingMoviesWithAvailSeatsBetweenDate(String date1, String date2) {
        return this.movieShowingRepository.getAllShowingMoviesWithAvailableSeats(parseTimestamp(date1),
                parseTimestamp(date2));
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public List<MovieInstance> getAllShowingMoviesWithAvailSeatsBeforeDate(String date) {
        return this.movieShowingRepository.getAllShowingMoviesWithAvailableSeats(parseTimestamp(date), null);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public List<MovieInstance> getAllShowingMoviesWithAvailSeatsAfterDate(String date) {
        return this.movieShowingRepository.getAllShowingMoviesWithAvailableSeats(null, parseTimestamp(date));
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public List<MovieShowingInstance> getAllShowingsOfMovie(Long movieId) {
        return this.movieShowingRepository.getAllMovieShowingsOfMovie(movieId);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public List<MovieShowingInstance> getAllAvailableMovieShowingsOfMovie(Long movieId) {
        return this.movieShowingRepository.getAllAvailableMovieShowingsOfMovie(movieId);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public Double getTicketPrice(Long movieId, Integer roomId, String date) {
        return this.movieShowingRepository.getTicketPrice(movieId, roomId, date);
    }
}
