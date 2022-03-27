package com.example.theatre.service;

import com.example.theatre.repository.RoomRepository;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    /**
     *
     * @author Min Lu
     *
     * Operations allowed for rooms' information.
     *
     */
    private transient final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

}
