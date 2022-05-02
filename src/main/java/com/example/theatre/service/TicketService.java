package com.example.theatre.service;

import com.example.theatre.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import com.example.theatre.repository.projections.PastPurchasesFilter;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    private final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private Timestamp parseTimestamp(String timestamp) {
        try {
            return new Timestamp(DATE_TIME_FORMAT.parse(timestamp).getTime());
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }

    // Returns 0 with success, return 1 if not successful.
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public int buyTicket(Long movieId, Integer roomId, String showDatetime, Integer seatNum, Long userId) {
        int res = ticketRepository.addTicket(movieId, roomId, showDatetime, seatNum, userId);
        return res;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public List<PastPurchasesFilter>getFilteredPastPurchases(String userID, Double minprice, Double maxprice, String title) {
        return this.ticketRepository.getFilteredPastPurchases(userID, minprice, maxprice, title);
    }
}
