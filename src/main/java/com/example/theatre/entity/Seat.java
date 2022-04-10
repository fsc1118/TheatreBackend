package com.example.theatre.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Entity
public class Seat implements Serializable {

    @EmbeddedId
    private SeatPK id;

    @ManyToOne(optional = false, targetEntity = Room.class)
    @JoinColumn(name = "room_id",
            foreignKey = @ForeignKey(name = "FK__seat_room"), insertable = false, updatable = false)
    @JsonBackReference
    private Room room;

    public Seat() {
    }

    public Seat(SeatPK id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return id.equals(seat.id) && room.equals(seat.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, room);
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                '}';
    }
}
