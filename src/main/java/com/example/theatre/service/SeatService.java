package com.example.theatre.service;

import com.example.theatre.entity.Seat;
import com.example.theatre.composite_keys.SeatPK;
import com.example.theatre.repository.MovieShowingRepository;
import com.example.theatre.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class SeatService {
    @Autowired
    private final SeatRepository seatRepository;

    @Autowired
    private final MovieShowingRepository movieShowingRepository;

    public SeatService(SeatRepository seatRepository, MovieShowingRepository movieShowingRepository) {
        this.seatRepository = seatRepository;
        this.movieShowingRepository = movieShowingRepository;
    }

    private final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private Timestamp parseTimestamp(String timestamp) {
        try {
            return new Timestamp(DATE_TIME_FORMAT.parse(timestamp).getTime());
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public List<Integer> getAllSeatsFromRoom(Integer room_id) {
        return seatRepository.getAllSeats(room_id);
    }

    @Transactional
    public List<Integer> getAllAvailableSeatsOfMovieShowing(Long movieId, Integer roomId, String showDatetime) {
        // check if movieshowing exists
        Timestamp ts = parseTimestamp(showDatetime);
        int exists = movieShowingRepository.checkIfMovieShowingExists(movieId, roomId, ts);
        List<Integer> res = new ArrayList<>();
        if (exists != 0) {
            return seatRepository.getAllAvailableSeats(movieId, roomId, ts);
        } else {
            return res;
        }
    }

    public List<Seat> findAll() {
        return seatRepository.findAll();
    }
}
