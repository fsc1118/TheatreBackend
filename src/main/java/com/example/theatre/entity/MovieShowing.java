package com.example.theatre.entity;

import com.example.theatre.composite_keys.MovieShowingPK;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Min Lu
 *
 * MovieShowing entity.
 */

@NoArgsConstructor
@ToString
@Getter
@Setter
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

    @Column(name="num_avail_seats")
    private Integer number_available_seats;

    @Column(name="price")
    private Double price;

    public MovieShowing(MovieShowingPK movieShowingPK) {
        this.movieShowingPK = movieShowingPK;
    }

    public MovieShowing(MovieShowingPK movieShowingPK,
                        Integer show_length_in_minutes,
                        Double price) {
        this.movieShowingPK = movieShowingPK;
        this.show_length_in_minutes = show_length_in_minutes;
        this.price = price;
    }
}
