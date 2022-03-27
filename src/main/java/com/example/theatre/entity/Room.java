package com.example.theatre.entity;

import javax.persistence.*;

@Entity
@Table(name="room")
public class Room {
    /**
     * @author Min Lu
     *
     * Room entity.
     */

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="room_id")
    private Integer room_id;

    @Column(name="num_seats")
    private Integer number_of_seats;

    @Column(name="num_avail_seats")
    private Integer number_available_seats;

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

    @Override
    public String toString() {
        return "Room{" +
                "room_id=" + room_id +
                ", number_of_seats=" + number_of_seats +
                ", number_available_seats=" + number_available_seats +
                '}';
    }
}
