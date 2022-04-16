package com.example.theatre;

import com.example.theatre.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TheatreApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TheatreApplication.class, args);
    }

    @Autowired
    private RoomService roomService;

    @Autowired
    private SeatService seatService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieShowingService movieShowingService;

    @Autowired
    private TicketService ticketService;

    @Override
    public void run(String... args) throws Exception {
        int exit_code = ticketService.buyTicket("Harry Potter and the Chamber of Secrets",
                3, "2022-11-04 20:00:00",
                14, 1L);
        System.out.printf("Must be 0: %d\n", exit_code);
        exit_code = ticketService.buyTicket("Harry Potter and the Chamber of Secrets",
                3, "2022-11-04 20:00:00",
                14, 1L);
        System.out.printf("Must be 1: %d\n", exit_code);
    }
}
