package com.example.theatre.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SeatPK implements Serializable {
    @Column(name = "seat_num")
    private Integer seat_num;

    @Column(name = "room_id")
    private Integer room_id;

    public SeatPK() {
    }

    public SeatPK(Integer seat_num, Integer room_id) {
        this.seat_num = seat_num;
        this.room_id = room_id;
    }
}
