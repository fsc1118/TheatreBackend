package com.example.theatre.service;

import com.example.theatre.repository.RoomRepository;
import org.springframework.stereotype.Service;

@Service
/*
 *
 * @author Min lu
 *
 * Operations allowed for rooms' information.
 *
 */
public class RoomService {
    private transient final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

}
