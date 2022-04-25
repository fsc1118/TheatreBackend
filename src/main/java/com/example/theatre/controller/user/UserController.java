package com.example.theatre.controller.user;

import com.example.theatre.entity.User;
import com.example.theatre.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Min Lu
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

    @GetMapping(path = "/user/{username}")
    public Long getUserId(@PathVariable String username) {
        return userService.getUserId(username);
    }

    @PutMapping(path = "/user/{user_id}", consumes = {"application/json"})
    public ResponseEntity<User> updateUser(@PathVariable Long user_id,
                                           @RequestBody User userDetails) {
        boolean res = userService.editUser(userDetails);

        if (!res) {
            return new ResponseEntity<>(userDetails, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userDetails, HttpStatus.OK);
    }

    @DeleteMapping("/user/{user_id}")
    public void deleteUser(@PathVariable Long user_id) {
        userService.removeUser(user_id);
    }
}
