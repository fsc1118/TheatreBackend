package com.example.theatre.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@ToString
@Getter
@Setter
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Long ticket_id;

    @ManyToOne
    @JoinColumn(name = "user_id",
            foreignKey = @ForeignKey(name = "FK__ticket_user"), insertable = false, updatable = false)
    @JsonBackReference
    private User user;

    @ManyToOne
    @JoinColumn(name = "movie_id",
            foreignKey = @ForeignKey(name = "FK__ticket_movie"), insertable = false, updatable = false)
    @JsonBackReference
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "room_id",
            foreignKey = @ForeignKey(name = "FK__ticket_room"), insertable = false, updatable = false)
    @JsonBackReference
    private Room room;

    @ManyToOne
    @JoinColumns(value = {
            @JoinColumn(name = "room_id", insertable = false, updatable = false),
            @JoinColumn(name = "seat_num", insertable = false, updatable = false),
    },
            foreignKey = @ForeignKey(name = "FK__ticket_seat")
    )
    @JsonBackReference
    private Seat seat;

    @Column(name = "price")
    private Double price;

    @Column(name = "purchase_datetime")
    private Date purchase_datetime;

    @Column(name = "is_used")
    private Boolean is_used;

    @Column(name = "show_datetime")
    private Date show_datetime;

}
