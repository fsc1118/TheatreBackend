package com.example.theatre.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long U_id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private String email;
    private String phone;
    private String city;
    private String zip;

    public User(String username, String encode, String email, String phone, String city, String zip) {
        this.username = username;
        this.password = encode;
        this.email = email;
        this.phone = phone;
        this.city = city;
        this.zip = zip;
    }
}