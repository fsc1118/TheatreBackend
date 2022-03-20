package com.example.theatre.service;

import com.example.theatre.entity.Room;
import com.example.theatre.repository.RoomRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
/**
 *
 * @author Min lu
 *
 * Operations allowed for rooms' inforamtion.
 *
 */
public class RoomService {
    private transient final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    /**
     * If specified room exists, return that room entity.
     * Otherwise, return null (room doesn't exist in table).
     *
     * @param roomId
     * @return room entity, or else null
     */
    private Room isRoomExist(Long roomId) {
        return roomRepository.findById(roomId).orElse(null);
    }

    public boolean hasEmptySeats(Long roomId) {
        // if true, specified room has available seats. Otherwise, it has no available seats.
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new EntityNotFoundException(roomId.toString()));
        return room.getNumber_available_seats() != 0;
    }

    public boolean insertRoom(Long roomId, Integer num_seats) {
        if (isRoomExist(roomId) != null) {
            return false;
        }
        roomRepository.save(new Room(num_seats));
        return true;
    }

    public boolean deleteRoom(Long roomId) {
        if (isRoomExist(roomId) == null) {
            return false;
        }
        roomRepository.deleteById(roomId);
        return true;
    }

    public void deleteAllRooms() {
        roomRepository.deleteAll();
    }

}
