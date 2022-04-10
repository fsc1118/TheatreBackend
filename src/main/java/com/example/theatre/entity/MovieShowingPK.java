package com.example.theatre.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
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

    @Override
    public String toString() {
        return "MovieShowingPK{" +
                "movie_id=" + movie_id +
                ", room_id=" + room_id +
                ", show_datetime=" + show_datetime +
                '}';
    }
}
