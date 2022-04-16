package com.example.theatre.controller.ticket;

import com.example.theatre.entity.Seat;
import com.example.theatre.service.SeatService;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class SeatController {

    private final SeatService seatService;

    private SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping("/seats")
    public List<Seat> getAllSeats() {
        return seatService.findAll();
    }

    @GetMapping("/seats/{id}")
    public List<Integer> getSeatsFromRoom(@PathVariable Integer id) {
        return seatService.getAllSeatsFromRoom(id);
    }

    @GetMapping("/seats/avail/{movieId}_{id}_{showDatetime}")
    public List<Integer> getAvailableSeatsFromRoom(@PathVariable Long movieId,
                                                   @PathVariable Integer id,
                                                   @PathVariable String showDatetime) throws UnsupportedEncodingException {
        return seatService.getAllAvailableSeatsOfMovieShowing(movieId,
                id,
                URLDecoder.decode(showDatetime, StandardCharsets.UTF_8.toString()));
    }

}
