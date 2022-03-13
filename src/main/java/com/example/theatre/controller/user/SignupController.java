package com.example.theatre.controller.user;
import com.example.theatre.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SignupController {
    private final UserService userService;
    SignupController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    ResponseEntity login(@RequestBody Map<String, String> json) {
        String username = json.get("name");
        String password = json.get("password");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of(
                        "success", userService.insertUser(username, password)));
    }
}
