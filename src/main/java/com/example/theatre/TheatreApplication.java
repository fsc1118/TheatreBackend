package com.example.theatre;

import com.example.theatre.controller.ticket.SeatController;
import com.example.theatre.repository.projections.MovieInstance;
import com.example.theatre.service.MovieService;
import com.example.theatre.service.MovieShowingService;
import com.example.theatre.service.RoomService;
import com.example.theatre.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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

    @Override
    public void run(String... args) throws Exception {
        // new statements to test
//        String url = URLDecoder.decode("2022-11-04%2020:00:00", StandardCharsets.UTF_8.toString());
//        System.out.println(url);
//        List<Integer> res1 = seatService.getAllAvailableSeatsOfMovieShowing(1L, 1, "2022-11-04 20:00:00");
//        assert(res1 != null);
//        List<Integer> res2 = seatService.getAllAvailableSeatsOfMovieShowing(1L, 1, "1989-11-04 20:00:00");
//        assert (res2 == null);
//        System.out.println("Both tests passed!");
//
//        List<MovieInstance> m = movieService.getAllMovies();
//        System.out.println(Arrays.toString(m.toArray()));

        List<MovieInstance> ms = movieShowingService.getAllShowingMovies();
        System.out.println(Arrays.toString(ms.toArray()));

        List<MovieInstance> ms2_between = movieShowingService.getAllShowingMoviesBetweenDates("2022-11-04 20:00:00", "2022-11-06 20:00:00");
        System.out.println(Arrays.toString(ms2_between.toArray()));
     }
}
