package com.example.theatre.repository;

import com.example.theatre.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author Min Lu
 *
 * JPA Repository for the Room entity.
 *
 */

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

    @Query("Select r.number_of_seats From Room r Where r.room_id =:roomId")
    Integer getNumSeats(@Param("roomId") Integer room_id);

    @Modifying(clearAutomatically = true)
    @Query("Update Room r Set r.number_of_seats =:num_seats Where r.room_id =:roomId")
    void setNumSeats(@Param("roomId") Integer room_id, @Param("num_seats") Integer num_seats);

}