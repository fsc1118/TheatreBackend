package com.example.theatre.controller.ticket;

import com.example.theatre.entity.Seat;
import com.example.theatre.repository.projections.MovieInstance;
import com.example.theatre.service.MovieShowingService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
