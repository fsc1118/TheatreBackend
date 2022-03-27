package com.example.theatre.service;

import com.example.theatre.repository.RoomRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Min Lu
 *
 * Operations allowed for rooms' information.
 *
 */

@Service
public class RoomService {

    private transient final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

}
