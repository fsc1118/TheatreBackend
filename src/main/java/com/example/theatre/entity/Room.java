package com.example.theatre.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author Min Lu
 *
 * Room entity.
 */

@Getter
@Setter
@Entity
public class Room implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="room_id")
    private Integer room_id;

    @Column(name="num_seats")
    private Integer number_of_seats;

    @Column(name="num_avail_seats")
    private Integer number_available_seats;

    @OneToMany(targetEntity = Seat.class, mappedBy = "room", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Seat> seats;

    @OneToMany(mappedBy = "room")
    @JsonManagedReference
    Set<MovieShowing> movieShowings;

    public Room() {
    }

    public Room(Integer number_of_seats) {
        this.number_of_seats = number_of_seats;
    }

    public Room(Integer number_of_seats, Integer number_available_seats) {
        this.number_of_seats = number_of_seats;
        this.number_available_seats = number_available_seats;
    }

    @Override
    public String toString() {
        return "Room{" +
                "room_id=" + room_id +
                ", number_of_seats=" + number_of_seats +
                ", number_available_seats=" + number_available_seats +
                '}';
    }
}
