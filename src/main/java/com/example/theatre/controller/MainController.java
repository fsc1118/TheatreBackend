package com.example.theatre.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
@CrossOrigin
@RestController
public class MainController {
    @GetMapping(value = "/")
    public int generateRandom() {
        return new Random().nextInt();
    }
}