package com.example.theatre.repository;

import com.example.theatre.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Procedure(procedureName = "sp_buyTicket")
    int addTicket(Long movieId, Integer roomId, Date showDatetime, Integer seatNum, Long userId); // success = 0, not success = 1
}
