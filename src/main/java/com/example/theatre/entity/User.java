package com.example.theatre.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@ToString
@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long U_id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "city")
    private String city;

    @Column(name = "zip")
    private String zip;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private Set<Ticket> tickets;

    public User() {}

    public User(String username, String encode, String email, String phone, String city, String zip) {
        this.username = username;
        this.password = encode;
        this.email = email;
        this.phone = phone;
        this.city = city;
        this.zip = zip;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}