package com.example.theatre.controller.user;
import com.example.theatre.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
/**
 *
 * @author Shicheng Fang
 *
 *
 *                           Login API doc
 * _________________________________________________________________________________
 *              URL: /login
 *
 *              (HTTP) Method: Post. Otherwise, return HTTP Bad Request (400)
 *
 *              HTTP Request Type: json
 *
 *              HTTP Request body:
 *              {
 *                  "name": string,
 *                  "password": string,
 *                  ...
 *              }
 *
 *              HTTP Response Type: json
 *
 *              HTTP Response body:
 *              {
 *                  "status": 200 (OK): When corretly executed.
 *                  "success": True when username and password matches.
 *                             False when either username doesn't exist or not matches password
 *              }
 *___________________________________________________________________________
 * */
@RestController
@CrossOrigin(origins = "*") /* remove in production mode*/
@RequestMapping("/api")
public class LoginController {
    private final UserService userService;
    private LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/user/login", consumes = {"application/json"})
    private ResponseEntity login(@RequestBody Map<String, String> json) {
        String username = json.get("name");
        String password = json.get("password");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of(
                "success", userService.isMatch(username, password)));
    }
}
