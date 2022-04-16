package com.example.theatre.composite_keys;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Min Lu
 *
 * MovieShowing Composite Primary Key.
 */

@NoArgsConstructor
@ToString
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
    private Timestamp show_datetime;

    public MovieShowingPK(Long movie_id, Integer room_id) {
        this.movie_id = movie_id;
        this.room_id = room_id;
    }

    public MovieShowingPK(Long movie_id, Integer room_id, Timestamp show_datetime) {
        this.movie_id = movie_id;
        this.room_id = room_id;
        this.show_datetime = show_datetime;
    }
}
