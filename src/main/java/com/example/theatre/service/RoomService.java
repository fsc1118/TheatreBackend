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

    public void deleteRoom(Integer room_id) {
        this.roomRepository.deleteById(room_id);
    }

    public List<Room> getAllRooms() {
        return this.roomRepository.findAll();
    }

}
