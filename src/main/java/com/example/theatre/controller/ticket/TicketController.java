package com.example.theatre.controller.ticket;

import com.example.theatre.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * API for buying tickets!
 *
 * @author Min Lu
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping(path = "/ticket/buy", consumes = {"application/json"})
    public ResponseEntity<String> create(@RequestBody Map<String, String> json) {
        Long movieId = Long.parseLong(json.get("movie_id"));
        Integer roomId = Integer.parseInt(json.get("room_id"));
        String datetime = json.get("datetime");
        Integer seatNum = Integer.parseInt(json.get("seat_num"));
        Long userId = Long.parseLong(json.get("user_id"));

        int res = ticketService.buyTicket(movieId, roomId, datetime, seatNum, userId);
        if (res == 1 || res == 2) {
            return new ResponseEntity<>("Seat not available: " + json, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>("Ticket bought successfully!", HttpStatus.OK);
        }
    }
}
