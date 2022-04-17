package com.example.theatre.controller.ticket;

import com.example.theatre.repository.projections.MovieInstance;
import com.example.theatre.service.MovieShowingService;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class MovieShowingController {

    private final MovieShowingService movieShowingService;

    public MovieShowingController(MovieShowingService movieShowingService) {
        this.movieShowingService = movieShowingService;
    }

    @GetMapping("/movieShowings")
    public List<MovieInstance> getAllShowingMovies() {
        return movieShowingService.getAllShowingMovies();
    }

    @GetMapping("/movieShowings_date1={date1}_date2={date2}")
    public List<MovieInstance> getAllShowingMoviesBetweenDates(@PathVariable("date1") String date1,
                                                               @PathVariable("date2") String date2)
            throws UnsupportedEncodingException {
        return movieShowingService
                .getAllShowingMoviesBetweenDates(
                        URLDecoder.decode(date1, StandardCharsets.UTF_8.toString()),
                        URLDecoder.decode(date2, StandardCharsets.UTF_8.toString())
                );
    }

    @GetMapping("/movieShowings_beforeDate={date}")
    public List<MovieInstance> getAllShowingMoviesBeforeDate(@PathVariable("date") String date)
            throws UnsupportedEncodingException {
        return movieShowingService
                .getAllShowingMoviesBeforeDate(
                        URLDecoder.decode(date, StandardCharsets.UTF_8.toString())
                );
    }

    @GetMapping("/movieShowings_afterDate={date}")
    public List<MovieInstance> getAllShowingMoviesAfterDate(@PathVariable("date") String date)
            throws UnsupportedEncodingException {
        return movieShowingService
                .getAllShowingMoviesAfterDate(
                        URLDecoder.decode(date, StandardCharsets.UTF_8.toString())
                );
    }

    @GetMapping("/movieShowings/avail")
    public List<MovieInstance> getAllShowingMoviesWithAvail() {
        return movieShowingService.getAllShowingMoviesWithAvailSeats();
    }

    @GetMapping("/movieShowings/avail/date1={date1}_date2={date2}")
    public List<MovieInstance> getAllShowingMoviesWithAvailBetweenDates(@PathVariable("date1") String date1,
                                                               @PathVariable("date2") String date2)
            throws UnsupportedEncodingException {
        return movieShowingService
                .getAllShowingMoviesWithAvailSeatsBetweenDate(
                        URLDecoder.decode(date1, StandardCharsets.UTF_8.toString()),
                        URLDecoder.decode(date2, StandardCharsets.UTF_8.toString())
                );
    }

    @GetMapping("/movieShowings/avail/beforeDate={date}")
    public List<MovieInstance> getAllShowingMoviesWithAvailBeforeDate(@PathVariable("date") String date)
            throws UnsupportedEncodingException {
        return movieShowingService
                .getAllShowingMoviesWithAvailSeatsBeforeDate(
                        URLDecoder.decode(date, StandardCharsets.UTF_8.toString())
                );
    }

    @GetMapping("/movieShowings/afterDate={date}")
    public List<MovieInstance> getAllShowingMoviesWithAvailAfterDate(@PathVariable("date") String date)
            throws UnsupportedEncodingException {
        return movieShowingService
                .getAllShowingMoviesWithAvailSeatsAfterDate(
                        URLDecoder.decode(date, StandardCharsets.UTF_8.toString())
                );
    }


}
