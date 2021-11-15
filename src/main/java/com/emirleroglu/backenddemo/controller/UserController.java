package com.emirleroglu.backenddemo.controller;

import com.emirleroglu.backenddemo.models.User;
import com.emirleroglu.backenddemo.services.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "https://fierce-beyond-01272.herokuapp.com/")
@Api(value = "User Api Documentation")
public class UserController {
    @Autowired
    UserService myService;

    @ApiOperation(value = "return all users, ne kadar gerekli bilmiyorum :)")
    @GetMapping("/users")
    public ResponseEntity<List<User>> getUserList() {
        if (myService.getUserList().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        if (myService.getUserList() == null) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(myService.getUserList(), HttpStatus.OK);
    }

    @ApiOperation(value = "return users using id, önemli")
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        if (myService.getUserById(id) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(myService.getUserById(id),HttpStatus.FOUND);
        }
    }

    @ApiOperation(value = "sign-in operation and return registered user")
    @PostMapping("/sign-in")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        if (myService.addUser(user) == null) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(myService.addUser(user), HttpStatus.CREATED);

    }

}
