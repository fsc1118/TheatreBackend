package com.example.theatre.service;

import com.example.theatre.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public int buyTicket(String movieName, Integer roomId, Date showDatetime, Integer seatNum, Long userId) {
        return ticketRepository.addTicket(movieName, roomId, showDatetime, seatNum, userId);
    }
}
