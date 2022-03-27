package com.example.theatre.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Seats")
public class Seat implements Serializable {

    @EmbeddedId
    private SeatPK id;

    @MapsId("room_id")
    @ManyToOne
    @JoinColumn(name = "room_id",
            referencedColumnName = "room_id",
            foreignKey = @ForeignKey(name = "FK__seats_rooms"))
    private Room room;

    @Column(name = "is_available")
    private boolean isAvailable;

    public Seat(SeatPK id, Room room, boolean isAvailable) {
        this.id = id;
        this.room = room;
        this.isAvailable = isAvailable;
    }

    //    public Seat(Integer seat_num, Room room, boolean isAvailable) {
//        this.seat_num = seat_num;
//        this.room = room;
//        this.isAvailable = isAvailable;
//    }

    public Seat(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public SeatPK getId() {
        return id;
    }

    public void setId(SeatPK id) {
        this.id = id;
    }

    //    public Integer getSeat_num() {
//        return seat_num;
//    }
//
//    public void setSeat_num(Integer seat_num) {
//        this.seat_num = seat_num;
//    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Seat seat = (Seat) o;
//        return isAvailable == seat.isAvailable && Objects.equals(seat_num, seat.seat_num) && Objects.equals(room, seat.room);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(seat_num, room, isAvailable);
//    }
//
//    @Override
//    public String toString() {
//        return "Seat{" +
//                "seat_num=" + seat_num +
//                ", room=" + room +
//                ", isAvailable=" + isAvailable +
//                '}';
//    }
}
