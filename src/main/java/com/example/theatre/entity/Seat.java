package com.example.theatre.entity;

import com.example.theatre.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;

@Entity
@Table(name = "Seats")
public class Seat implements Serializable {

    @Autowired
    private RoomRepository roomRepository;

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

    public Seat() {
    }

    public Seat(SeatPK id, boolean isAvailable) {
        this.id = id;
        this.room = this.roomRepository
                .findById(id.getRoom_id())
                .orElseThrow(() -> new EntityNotFoundException("Missing Room entry: " + id.getRoom_id()));
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
                ", room=" + room +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
