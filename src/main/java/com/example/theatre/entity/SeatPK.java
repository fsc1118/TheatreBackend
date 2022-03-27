package com.example.theatre.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

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

    public Integer getSeat_num() {
        return seat_num;
    }

    public void setSeat_num(Integer seat_num) {
        this.seat_num = seat_num;
    }

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeatPK seatPK = (SeatPK) o;
        return Objects.equals(seat_num, seatPK.seat_num) && Objects.equals(room_id, seatPK.room_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seat_num, room_id);
    }
}
