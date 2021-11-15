package com.emirleroglu.backenddemo.services;

import com.emirleroglu.backenddemo.models.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    public User addUser(User user);

    public List<User> getUserList();

    public User getUserById(Long id);

    public ResponseEntity<User> deleteUserById(Long id);
}

