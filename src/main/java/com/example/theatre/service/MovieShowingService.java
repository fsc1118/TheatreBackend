package com.example.theatre.service;

import com.example.theatre.repository.MovieRepository;
import com.example.theatre.repository.MovieShowingRepository;
import com.example.theatre.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<String> getAllShowingMovies() {
        return this.movieShowingRepository.getAllShowingMovies();
    }

    public List<String> getAllShowingMovies(String date1, String date2) {
        return this.movieShowingRepository.getAllShowingMoviesBetweenDate1AndDate2(parseTimestamp(date1),
                parseTimestamp(date2));
    }

    public List<String> getAllShowingMoviesBeforeDate(String date) {
        return this.movieShowingRepository.getAllShowingMoviesBeforeDate(parseTimestamp(date));
    }

    public List<String> getAllShowingMoviesAfterDate(String date) {
        return this.movieShowingRepository.getAllShowingMoviesAfterDate(parseTimestamp(date));
    }

    public List<Timestamp> getAllShowingsOfMovie(String movie_name) {
        return this.movieShowingRepository.getAllMovieShowingsOfMovie(movie_name);
    }


}
