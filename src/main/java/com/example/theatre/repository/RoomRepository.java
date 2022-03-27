package com.example.theatre.repository;

import com.example.theatre.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
/*
 * @author Min Lu
 *
 * JPA Repository for the Room entity.
 *
 */
public interface RoomRepository extends JpaRepository<Room, Integer> {
    @Query(
            value = "SELECT * FROM room r WHERE r.num_avail_seats <> 0",
            nativeQuery = true)
    List<Room> findAllNonFilledRooms();
}