package com.example.theatre.controller.movie;

import com.example.theatre.repository.projections.MovieInstance;
import com.example.theatre.repository.projections.MovieInstanceFilter;
import com.example.theatre.repository.projections.MovieShowingInstanceFilter;
import com.example.theatre.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public List<MovieInstance> getAllMovies() {
        return this.movieService.getAllMovies();
    }

    @GetMapping("/movies/{movie_id}")
    public MovieInstance getMovieById(@PathVariable Long movie_id) {
        return this.movieService.getMovieById(movie_id);
    }

    @GetMapping(value = "/movies/filter/year={year}_title={title}")
    public List<MovieInstanceFilter> getFilteredMovieShowings(@PathVariable String year,
                                                              @PathVariable String title) {
        if (year.equals("none")) {
            year = null;
        }
        if (title.equals("none")) {
            title = null;
        }
        return this.movieService.getFilteredMovies(year, title);
    }



}
