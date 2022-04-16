package com.example.theatre.controller.ticket;

import com.example.theatre.entity.Seat;
import com.example.theatre.service.SeatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class SeatController {

    private final SeatService seatService;

    private SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

<<<<<<< HEAD
    @GetMapping
=======
    @GetMapping("/seats")
>>>>>>> master
    public List<Seat> getAllSeats() {
        return seatService.findAll();
    }

<<<<<<< HEAD
    @GetMapping("/seats/all_seats_in_room_{id}")
=======
    @GetMapping("/seats/{id}")
>>>>>>> master
    public List<Integer> getSeatsFromRoom(@PathVariable Integer id) {
        return seatService.getAllSeatsFromRoom(id);
    }

}
