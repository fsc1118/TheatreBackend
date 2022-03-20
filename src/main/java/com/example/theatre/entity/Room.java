package com.example.theatre.entity;

import javax.persistence.*;

@Entity
@Table(name="room")
/**
 *
 * @author Min Lu
 *
 * Room entity.
 *
 */
public class Room {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="room_id")
    private Long room_id;

    @Column(name="num_seats")
    private Integer number_of_seats;

    @Column(name="num_avail_seats")
    private Integer number_available_seats;

    public Room() {
    }

    public Room(Integer number_of_seats) {
        this.room_id = room_id;
        this.number_of_seats = number_of_seats;
    }

    public Room(Integer number_of_seats, Integer number_available_seats) {
        this.room_id = room_id;
        this.number_of_seats = number_of_seats;
        this.number_available_seats = number_available_seats;
    }

    public Long getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Long room_id) {
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
}
