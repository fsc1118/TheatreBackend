package com.example.theatre.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long U_id;
    private String username;
    private String password;
    public User() {}

    public User(String name, String password) {

        this.username = name;
        this.password = password;
    }
    public void setName(String name) {
        this.username = name;
    }
    public String getName() {
        return username;
    }
    public void setPassword(String newPassword) {
        this.password = password;
    }
    public String getPassword() {
        return this.password;
    }
}