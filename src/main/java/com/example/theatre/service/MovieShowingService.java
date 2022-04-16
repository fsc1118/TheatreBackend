package com.example.theatre.service;

import com.example.theatre.repository.MovieRepository;
import com.example.theatre.repository.MovieShowingRepository;
import com.example.theatre.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

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

    public List<String> getAllShowingMovies() {
        return this.movieShowingRepository.getAllShowingMovies();
    }

    public List<Timestamp> getAllShowingsOfMovie(String movie_name) {
        return this.movieShowingRepository.getAllMovieShowingsOfMovie(movie_name);
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
