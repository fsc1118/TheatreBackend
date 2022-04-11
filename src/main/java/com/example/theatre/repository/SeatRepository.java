package com.example.theatre.repository;
import com.example.theatre.entity.Seat;
import com.example.theatre.composite_keys.SeatPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author Min Lu
 *
 * JPA Repository for the Seat entity.
 *
 */

@Repository
public interface SeatRepository extends JpaRepository<Seat, SeatPK> {

    @Query(value = "Select s.seat_num From seat s Where s.room_id = :roomId", nativeQuery = true)
    List<Integer> getAllSeats(@Param("roomId") Integer room_id);

//    @Query(value = "Select * From room r Where r.num_avail_seats = 0", nativeQuery = true)
//    List<Seat> getAllAvailableSeats();

}