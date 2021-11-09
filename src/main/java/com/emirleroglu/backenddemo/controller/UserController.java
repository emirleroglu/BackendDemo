package com.emirleroglu.backenddemo.controller;

import com.emirleroglu.backenddemo.models.User;
import com.emirleroglu.backenddemo.services.UserService;
import com.emirleroglu.backenddemo.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController {
    @Autowired
    UserService myService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUserList() {
        return new ResponseEntity<>(myService.getUserList(), HttpStatus.OK);
    }
    @PostMapping("/sign-in")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        myService.addUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);

    }
}
