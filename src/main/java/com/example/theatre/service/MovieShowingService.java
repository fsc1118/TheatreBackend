package com.example.theatre.service;

import com.example.theatre.entity.*;
import com.example.theatre.repository.MovieRepository;
import com.example.theatre.repository.MovieShowingRepository;
import com.example.theatre.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

//    public void insertNewMovieShowing(Long movie_id, Integer room_id) {
//        Optional<Movie> movie = this.movieRepository.findById(movie_id);
//        Optional<Room> room = this.roomRepository.findById(room_id);
//        if (movie.isPresent() && room.isPresent()) {
////            System.out.println("Hello World!");
//            this.movieShowingRepository.save(new MovieShowing(new MovieShowingPK(movie_id, room_id)));
//        }
//    }
}