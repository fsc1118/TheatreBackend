package com.example.theatre.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@ToString
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

    @OneToMany(mappedBy = "seat")
    @JsonManagedReference
    private Set<Ticket> tickets;

    public Seat() {
    }

    public Seat(SeatPK id) {
        this.id = id;
    }
}
