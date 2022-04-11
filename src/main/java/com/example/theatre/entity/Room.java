package com.example.theatre.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author Min Lu
 *
 * Room entity.
 */

@NoArgsConstructor
@ToString
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

    @OneToMany(targetEntity = Seat.class, mappedBy = "room", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Seat> seats;

    @OneToMany(mappedBy = "room")
    @JsonManagedReference
    private Set<MovieShowing> movieShowings;

    @OneToMany(mappedBy = "room")
    @JsonManagedReference
    private Set<Ticket> tickets;

    public Room(Integer number_of_seats) {
        this.number_of_seats = number_of_seats;
    }
}
