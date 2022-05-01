package com.example.theatre.controller.user;

import com.example.theatre.entity.User;
import com.example.theatre.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
/**
 * @author Min Lu, Shicheng
 *
 * User api for updating and deleting user information.
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/user/find/{username}")
    public Map<String, String> getUserInfo(@PathVariable String username) {
           return userService.getUserInfo(username);
    }

    @GetMapping(path = "/user/{username}")
    public long getUserId(@PathVariable String username) {
        return userService.getUserId(username);
    }



    @PostMapping(path = "/user", consumes = {"application/json"})
    public ResponseEntity updateUser(@RequestBody Map<String, String> json) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of(
                        "success", userService.editUser(json)));
    }

    @DeleteMapping("/user/{user_id}")
    public void deleteUser(@PathVariable Long user_id) {
        userService.removeUser(user_id);
    }
}
