package com.example.theatre.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class MovieShowing implements Serializable {

    @EmbeddedId
    private MovieShowingPK movieShowingPK;

    @ManyToOne
    @MapsId("movie_id")
    @JoinColumn(name = "movie_id",
            foreignKey = @ForeignKey(name = "FK__movie_room"), insertable = false, updatable = false)
    @JsonBackReference
    Movie movie;

    @ManyToOne
    @MapsId("room_id")
    @JoinColumn(name = "room_id",
            foreignKey = @ForeignKey(name = "FK__room_movie"), insertable = false, updatable = false)
    @JsonBackReference
    Room room;


    @Column(name = "show_length_in_mins")
    private Integer show_length_in_minutes;

    public MovieShowing() {
    }

    public MovieShowing(MovieShowingPK movieShowingPK) {
        this.movieShowingPK = movieShowingPK;
    }

    public MovieShowing(MovieShowingPK movieShowingPK,
                        Integer show_length_in_minutes) {
        this.movieShowingPK = movieShowingPK;
        this.show_length_in_minutes = show_length_in_minutes;
    }

    public MovieShowingPK getMovieShowingPK() {
        return movieShowingPK;
    }

    public void setMovieShowingPK(MovieShowingPK movieShowingPK) {
        this.movieShowingPK = movieShowingPK;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Integer getShow_length_in_minutes() {
        return show_length_in_minutes;
    }

    public void setShow_length_in_minutes(Integer show_length_in_minutes) {
        this.show_length_in_minutes = show_length_in_minutes;
    }

    @Override
    public String toString() {
        return "MovieShowing{" +
                "movieShowingPK=" + movieShowingPK +
                ", show_length_in_minutes=" + show_length_in_minutes +
                '}';
    }
}
