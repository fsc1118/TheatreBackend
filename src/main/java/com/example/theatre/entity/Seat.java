package com.example.theatre.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Seat implements Serializable {

    @EmbeddedId
    private SeatPK id;

    @ManyToOne(optional = false, targetEntity = Room.class)
    @JoinColumn(name = "room_id",
            foreignKey = @ForeignKey(name = "FK__seat_room"), insertable = false, updatable = false)
    private Room room;

    @Column(name = "is_available")
    private boolean isAvailable;

    public Seat() {
    }

    public Seat(SeatPK id, boolean isAvailable) {
        this.id = id;
        this.isAvailable = isAvailable;
    }

    public SeatPK getId() {
        return id;
    }

    public void setId(SeatPK id) {
        this.id = id;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return isAvailable == seat.isAvailable && id.equals(seat.id) && room.equals(seat.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, room, isAvailable);
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
