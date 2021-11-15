package com.emirleroglu.backenddemo.services;

import com.emirleroglu.backenddemo.models.User;
import com.emirleroglu.backenddemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository myUserRepository;

    List<User> myList = new ArrayList<>();

    public List<User> getUserList() {
        try {
            List<User> userList = new ArrayList<User>();

            myUserRepository.findAll().forEach(userList::add);


            return userList;
        } catch (Exception e) {
            return null;
        }


    }

    public User addUser(User user) {
        try {

            return myUserRepository.save(new User(user.getEmail(), user.getPassword(), user.getActive()));


        } catch (Exception e) {
            return null;

        }


    }

    public User getUserById(Long id) {
        Optional<User> userData = myUserRepository.findById(id);
        if (userData.isPresent()) {
            return userData.get();
        } else {
            return null;
        }

    }

    public ResponseEntity<User> deleteUserById(Long id) {
        try {
            myUserRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }



    }
}
