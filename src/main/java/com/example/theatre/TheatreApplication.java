package com.example.theatre;

import com.example.theatre.repository.projections.MovieInstance;
import com.example.theatre.service.MovieService;
import com.example.theatre.service.MovieShowingService;
import com.example.theatre.service.RoomService;
import com.example.theatre.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
//
//        this.movieService.insertNewMovie("Harry Potter and the Philosopher's Stone");
//        this.movieService.insertNewMovie("Harry Potter and the Chamber of Secrets");
//        this.movieService.insertNewMovie("Harry Potter and the Prisoners of Azkaban");
//        this.movieService.insertNewMovie("Harry Potter and the Goblet of Fire");
//
//        this.roomService.insertNewRoom(300, 200);
//        this.roomService.insertNewRoom(300, 20);
//        this.roomService.insertNewRoom(300, 200);
//        this.roomService.insertNewRoom(300, 0);
//        this.roomService.insertNewRoom(300, 200);
//        this.roomService.insertNewRoom(300, 0);
//        this.roomService.insertNewRoom(300, 12);
//        this.roomService.insertNewRoom(300, 0);
//
//        for (int i = 1; i < 21; i++) {
//            this.seatService.insertNewSeat(i, 1);
//        }
//        for (int i = 1; i < 21; i++) {
//            this.seatService.insertNewSeat(i, 2);
//        }

//        this.movieShowingService.insertNewMovieShowing(1L, 1);
//        this.movieShowingService.insertNewMovieShowing(2L, 2);
//        this.movieShowingService.insertNewMovieShowing(3L, 1);
//        this.movieShowingService.insertNewMovieShowing(4L, 1);

//        List<Room> result1 = this.roomService.findAllFilledRooms();
//        System.out.println(Arrays.toString(result1.toArray()));
//
//        List<Room> result2 = this.roomService.findAllNonFilledRooms();
//        System.out.println(Arrays.toString(result2.toArray()));
//
//        this.roomService.updateInitNumSeats(1, 1000);
//        this.roomService.updateNumAvailSeats(7, 10);
//
//        List<Room> result3 = this.roomService.getAllRooms();
//        for (Room r: result3) {
//            System.out.println(r);
//        }

        List <String> result = this.movieShowingService.getAllShowingMovies();
        System.out.println(Arrays.toString(result.toArray()));

        System.out.println();
        List <Date> result2 = this.movieShowingService.getAllShowingsOfMovie("Harry Potter and the Philosopher's Stone");
        for (Date d: result2) {
            System.out.println(d);
        }

        System.out.println();
        List <MovieInstance> result3 = this.movieService.getAllMovies();
        for (MovieInstance m: result3) {
            System.out.println(m);
        }
    }
}
