package com.example.theatre.controller.user;
import com.example.theatre.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


/**
 *
 * @author Shicheng Fang
 *
 *
 *                           Signup API doc
 * _________________________________________________________________________________
 *              URL: /signup
 *              (HTTP) Method: Post. Otherwise, return HTTP Bad Request (400)
 *              HTTP Request Type: json
 *              HTTP Response Type: json
 *              HTTP Request body:
 *              {
 *                  "name": string,
 *                  "password": string,
 *                  ...
 *              }
 *
 *
 *              HTTP Response body:
 *              {
 *                  "status": 200 (OK): When corretly executed.
 *                  "success": True when successfully add the user. False when the given username is used
 *              }
 *_______________________________________________________________________________
 * */
@RestController
public class SignupController {

    /* Dependency injection*/
    private final UserService userService;

    private SignupController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    private ResponseEntity login(@RequestBody Map<String, String> json) {
        String username = json.get("name");
        String password = json.get("password");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of(
                        "success", userService.insertUser(username, password)));
    }
}
