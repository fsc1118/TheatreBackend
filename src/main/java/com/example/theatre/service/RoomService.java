package com.example.theatre.service;

import com.example.theatre.entity.Room;
import com.example.theatre.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @author Min Lu
 *
 * Operations allowed for rooms' information.
 *
 */

@Service
@Transactional
public class RoomService {

    @Autowired
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public void insertNewRoom(int num_seats, int num_avail_seats) {
        if (num_seats < num_avail_seats) {
            throw new IllegalArgumentException("New Room Insertion: num_seats must be >= num_avail_seats.");
        }
        this.roomRepository.save(new Room(num_seats, num_avail_seats));
    }

    public void deleteRoom(Integer room_id) {
        this.roomRepository.deleteById(room_id);
    }

    public List<Room> getAllRooms() {
        return this.roomRepository.findAll();
    }

    public List<Room> findAllNonFilledRooms() {
        return this.roomRepository.findAllNonFilledRooms();
    }

    public List<Room> findAllFilledRooms() {
        return this.roomRepository.findAllFilledRooms();
    }

    public void updateNumAvailSeats(Integer room_id, int num_avail_seats) {
        if (this.roomRepository.getNumSeats(room_id) < num_avail_seats) {
            throw new IllegalArgumentException("Room Update: num_seats must be >= new num_avail_seats.");
        }
        this.roomRepository.setNumAvailSeats(room_id, num_avail_seats);
    }

    public void updateInitNumSeats(Integer room_id, int num_seats) {
        if (this.roomRepository.getNumAvailSeats(room_id) > num_seats) {
            throw new IllegalArgumentException("Room Update: new num_seats must be >= num_avail_seats.");
        }
        this.roomRepository.setNumSeats(room_id, num_seats);
    }

}
