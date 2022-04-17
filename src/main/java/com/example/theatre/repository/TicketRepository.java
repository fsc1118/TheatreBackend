package com.example.theatre.repository;

import com.example.theatre.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

//    @Query(value = "SELECT num_avail_seats " +
//            "        FROM movie_showing ms " +
//            "        JOIN movie m ON ms.movie_id = m.movie_id "+
//            "        WHERE ms.room_id = :roomId AND ms.movie_id = :movieId AND ms.show_datetime = :showDatetime", nativeQuery = true)
//    int getNumAvailSeats(@Param("movieId") Long movieId, @Param("roomId") Integer roomId, @Param("showDatetime") String showDatetime);

    @Procedure(procedureName = "sp_buyTicket")
    int addTicket(Long movieId, Integer roomId, String showDatetime, Integer seatNum, Long userId); // success = 0, not success = 1 or 2
}
