package com.example.theatre.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * @author Min Lu
 *
 * Room entity.
 */

@Entity
@Table(name = "Rooms")
public class Room implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="room_id")
    private Integer room_id;

    @Column(name="num_seats")
    private Integer number_of_seats;

    @Column(name="num_avail_seats")
    private Integer number_available_seats;

    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Seat> seats;

    public Room() {
    }

    public Room(Integer number_of_seats) {
        this.number_of_seats = number_of_seats;
    }

    public Room(Integer number_of_seats, Integer number_available_seats) {
        this.number_of_seats = number_of_seats;
        this.number_available_seats = number_available_seats;
    }

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    public Integer getNumber_of_seats() {
        return number_of_seats;
    }

    public void setNumber_of_seats(Integer number_of_seats) {
        this.number_of_seats = number_of_seats;
    }

    public Integer getNumber_available_seats() {
        return number_available_seats;
    }

    public void setNumber_available_seats(Integer number_available_seats) {
        this.number_available_seats = number_available_seats;
    }

    public Set<Seat> getSeats() {
        return seats;
    }

    public void setSeats(Set<Seat> seats) {
        this.seats = seats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(room_id, room.room_id) && Objects.equals(number_of_seats, room.number_of_seats) && Objects.equals(number_available_seats, room.number_available_seats) && Objects.equals(seats, room.seats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(room_id, number_of_seats, number_available_seats, seats);
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
