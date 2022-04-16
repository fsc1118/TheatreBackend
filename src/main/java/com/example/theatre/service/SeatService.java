package com.example.theatre.service;

import com.example.theatre.entity.Seat;
import com.example.theatre.composite_keys.SeatPK;
import com.example.theatre.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class SeatService {
    @Autowired
    private final SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
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
        return seatRepository.getAllAvailableSeats(movieId, roomId, parseTimestamp(showDatetime));
    }

    public List<Seat> findAll() {
        return seatRepository.findAll();
    }
}
