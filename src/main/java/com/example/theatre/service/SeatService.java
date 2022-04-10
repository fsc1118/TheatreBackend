package com.example.theatre.service;

import com.example.theatre.entity.Seat;
import com.example.theatre.entity.SeatPK;
import com.example.theatre.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {
    @Autowired
    private final SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public void insertNewSeat(Integer seat_num, Integer room_id) {
        this.seatRepository.save(new Seat(new SeatPK(seat_num, room_id)));
    }

    public List<Integer> getAllSeatsFromRoom(Integer room_id) {
        return seatRepository.getAllSeats(room_id);
    }

    public List<Seat> findAll() {
        return seatRepository.findAll();
    }
}
