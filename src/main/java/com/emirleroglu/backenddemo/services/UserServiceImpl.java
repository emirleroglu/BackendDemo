package com.emirleroglu.backenddemo.services;

import com.emirleroglu.backenddemo.models.User;
import com.emirleroglu.backenddemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository myUserRepository;

    List<User> myList = new ArrayList<>();

    public List<User> getUserList() {
        try {
            List<User> userList = new ArrayList<User>();

            myUserRepository.findAll().forEach(userList::add);

            if (userList.isEmpty()) {
                return null;
            }

            return userList;
        } catch (Exception e) {
            return null;
        }


    }

    public void addUser(User user) {

        myUserRepository.save(new User(user.getId(), user.getEmail(), user.getPassword(), user.getActive()));


    }


}
