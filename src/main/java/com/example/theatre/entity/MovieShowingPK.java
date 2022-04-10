package com.example.theatre.entity;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class MovieShowingPK implements Serializable {

    @Column(name = "movie_id")
    @NotNull
    private Long movie_id;

    @Column(name = "room_id")
    @NotNull
    private Integer room_id;

    @Column(name = "show_datetime")
    private Date show_datetime;

    public MovieShowingPK() {
    }

    public MovieShowingPK(Long movie_id, Integer room_id) {
        this.movie_id = movie_id;
        this.room_id = room_id;
    }

    public MovieShowingPK(Long movie_id, Integer room_id, Date show_datetime) {
        this.movie_id = movie_id;
        this.room_id = room_id;
        this.show_datetime = show_datetime;
    }

    public Long getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Long movie_id) {
        this.movie_id = movie_id;
    }

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    public Date getShow_datetime() {
        return show_datetime;
    }

    public void setShow_datetime(Date show_datetime) {
        this.show_datetime = show_datetime;
    }

    @Override
    public String toString() {
        return "MovieShowingPK{" +
                "movie_id=" + movie_id +
                ", room_id=" + room_id +
                ", show_datetime=" + show_datetime +
                '}';
    }
}
